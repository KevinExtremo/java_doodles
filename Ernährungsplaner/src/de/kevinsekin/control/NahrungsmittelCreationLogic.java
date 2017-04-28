package de.kevinsekin.control;

import java.awt.Component;
import java.util.ArrayList;

import de.kevinsekin.dao.CLEANUP_EXCEPTION;
import de.kevinsekin.dao.CONNECTION_EXCEPTION;
import de.kevinsekin.dao.CREATE_EXCEPTION;
import de.kevinsekin.dao.GET_EXCEPTION;
import de.kevinsekin.dao.MakrogruppeDAO;
import de.kevinsekin.dao.NahrungsmittelDAO;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.Makrogruppe;
import de.kevinsekin.model.Nahrungsmittel;
import de.kevinsekin.model.Nährwerte;
import de.kevinsekin.view.MainApplicationFrame;
import de.kevinsekin.view.NahrungsmittelCreation;

public class NahrungsmittelCreationLogic 
{
	private MainApplicationFrame UI;
	public NahrungsmittelCreationLogic(MainApplicationFrame UI)
	{
		this.UI = UI;
		try
		{
			MakrogruppeDAO mDAO = new MakrogruppeDAO();
			ArrayList<Makrogruppe> mList = mDAO.getAll();
			Component[] cList = UI.getCreationTabs().getComponents();
			for(Component c : cList)
			{
				if(c instanceof NahrungsmittelCreation)
				{
					for(Makrogruppe m : mList)
					{
						((NahrungsmittelCreation) c).getComboBox().addItem(m);
					}
					break;
				}
			}
			
		}
		catch(Exception | CONNECTION_EXCEPTION | GET_EXCEPTION | CLEANUP_EXCEPTION e){}
	}
	public void BestätigungButtonLogic(ArrayList<ActionData> DataList)
	{
		for(Component c : UI.getCreationTabs().getComponents())
		{
			if(c instanceof NahrungsmittelCreation)
			{
				if(((NahrungsmittelCreation) c).getTextArea().getText().isEmpty() || 
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Datenfelder") ||
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Verbindung") ||
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Bitte") &&
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Nahrungsmittel") ||
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Bitte") && 
				   ((NahrungsmittelCreation) c).getTextArea().getText().contains("Reihenfolge"))
				{
					((NahrungsmittelCreation) c).getTextArea().setText("Bitte beachten Sie die\n Reihenfolge und nutzen zuerst\n Hinzufügen.");
					break;
				}
				else
				{
					Nahrungsmittel n = new Nahrungsmittel();
					Nährwerte nt = new Nährwerte();
					for(ActionData data : DataList)
					{
						if(data.getIndex().equals("Name")) n.setName(data.getData());
						if(data.getIndex().equals("Makrogruppe")) n.setMacrogroupID(((Makrogruppe) data.getRawData()).getDatabaseID());
						if(data.getIndex().equals("Kcal")) nt.setKcal(Float.parseFloat(data.getData()));
						if(data.getIndex().equals("Kohlenhydrate")) nt.setKohlenhydrate(Float.parseFloat(data.getData()));
						if(data.getIndex().equals("Proteine")) nt.setProteine(Float.parseFloat(data.getData()));
						if(data.getIndex().equals("Fette")) nt.setFette(Float.parseFloat(data.getData()));
					}
					n.setNutrition(nt);
					NahrungsmittelDAO nDAO = new NahrungsmittelDAO();
					try {
						nDAO.create(n);
					} 
					catch (CONNECTION_EXCEPTION | CLEANUP_EXCEPTION | CREATE_EXCEPTION e) 
					{
						if(e instanceof CONNECTION_EXCEPTION)
						{
							((NahrungsmittelCreation) c).getTextArea().setText("Bitte beachten Sie das\n die Verbindung zur\n Datenbank nicht hergestellt\n werden konnte.");
							break;
						}
						if(e instanceof CLEANUP_EXCEPTION)
						{
							((NahrungsmittelCreation) c).getTextArea().setText("Bitte beachten Sie das\n die Verbindung zur\n Datenbank nicht geschlossen wurde.");
							break;
						}
						if(e instanceof CREATE_EXCEPTION)
						{
							((NahrungsmittelCreation) c).getTextArea().setText("Bitte beachten Sie das\n ihr gewünschtes Nahrungsmittel\n nicht erstellt werden konnte.");
							break;
						}
					}
					((NahrungsmittelCreation) c).getTextArea().setText("");
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
			if(c instanceof NahrungsmittelCreation)
			{
				if(missedData)
				{
					((NahrungsmittelCreation) c).getTextArea().setText("Bitte trage alle benötigten\n Datenfelder ein!");
					break;
				}
				else
				{
					((NahrungsmittelCreation) c).getTextArea().setText(Text);
					break;
				}
			}
		}
	}
}
