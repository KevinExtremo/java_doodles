package de.kevinsekin.control;

import java.awt.Component;
import java.util.ArrayList;

import de.kevinsekin.dao.CLEANUP_EXCEPTION;
import de.kevinsekin.dao.CONNECTION_EXCEPTION;
import de.kevinsekin.dao.CREATE_EXCEPTION;
import de.kevinsekin.dao.MakrogruppeDAO;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.Makrogruppe;
import de.kevinsekin.view.MainApplicationFrame;
import de.kevinsekin.view.MakrogruppeCreation;

public class MakrogruppeCreationLogic 
{
	private MainApplicationFrame UI;
	public MakrogruppeCreationLogic(MainApplicationFrame UI)
	{
		this.UI = UI;
	}
	public void BestätigungButtonLogic(ArrayList<ActionData> DataList)
	{
		for(Component c : UI.getCreationTabs().getComponents())
		{
			if(c instanceof MakrogruppeCreation)
			{
				if(((MakrogruppeCreation) c).getTextArea().getText().isEmpty() || 
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Datenfelder") ||
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Verbindung") ||
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Nahrungsmittel") ||
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Bitte") && 
				   ((MakrogruppeCreation) c).getTextArea().getText().contains("Reihenfolge"))
				{
					((MakrogruppeCreation) c).getTextArea().setText("Bitte beachten Sie die\n Reihenfolge und nutzen zuerst\n Hinzufügen.");
					break;
				}
				else
				{
					Makrogruppe m = new Makrogruppe();
					for(ActionData data : DataList)
					{
						if(data.getIndex().equals("Name")) m.setName(data.getData());
					}
					MakrogruppeDAO mDAO = new MakrogruppeDAO();
					try {
						mDAO.create(m);
					} 
					catch (CONNECTION_EXCEPTION | CLEANUP_EXCEPTION | CREATE_EXCEPTION e) 
					{
						if(e instanceof CONNECTION_EXCEPTION)
						{
							((MakrogruppeCreation) c).getTextArea().setText("Bitte beachten Sie das\n die Verbindung zur\n Datenbank nicht hergestellt\n werden konnte.");
							break;
						}
						if(e instanceof CLEANUP_EXCEPTION)
						{
							((MakrogruppeCreation) c).getTextArea().setText("Bitte beachten Sie das\n die Verbindung zur\n Datenbank nicht geschlossen wurde.");
							break;
						}
						if(e instanceof CREATE_EXCEPTION)
						{
							((MakrogruppeCreation) c).getTextArea().setText("Bitte beachten Sie das\n ihr gewünschtes Nahrungsmittel\n nicht erstellt werden konnte.");
							break;
						}
					}
					((MakrogruppeCreation) c).getTextArea().setText("");
					break;
				}
			}
		}
	}
	public void HinzufügenButtonLogic(ArrayList<ActionData> DataList)
	{
		String Text = "";
		boolean missedData = false;
		for(ActionData data : DataList)
		{
			if(data.getRawData() instanceof String)
				if(data.getData().isEmpty()) missedData = true;
			if(data.getRawData() == null) missedData = true;
			if(missedData) break;
			Text += data.getIndex() + " = " + data.getData() +"\n";
		}
		for(Component c : UI.getCreationTabs().getComponents())
		{
			if(c instanceof MakrogruppeCreation)
			{
				if(missedData)
				{
					((MakrogruppeCreation) c).getTextArea().setText("Bitte trage alle benötigten\n Datenfelder ein!");
					break;
				}
				else
				{
					((MakrogruppeCreation) c).getTextArea().setText(Text);
					break;
				}
			}
		}
	}
}
