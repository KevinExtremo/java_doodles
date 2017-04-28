package de.kevinsekin.control;

import java.awt.Component;
import java.util.ArrayList;

import de.kevinsekin.dao.CLEANUP_EXCEPTION;
import de.kevinsekin.dao.CONNECTION_EXCEPTION;
import de.kevinsekin.dao.GET_EXCEPTION;
import de.kevinsekin.dao.MakrogruppeDAO;
import de.kevinsekin.dao.NahrungsmittelDAO;
import de.kevinsekin.model.ActionData;
import de.kevinsekin.model.Makrogruppe;
import de.kevinsekin.view.MainApplicationFrame;
import de.kevinsekin.view.NahrungsmittelListViewing;

public class NahrungsmittelListViewingLogic 
{
	private MainApplicationFrame UI;
	public NahrungsmittelListViewingLogic(MainApplicationFrame UI)
	{
		this.UI=UI;
		try
		{
			MakrogruppeDAO mDAO = new MakrogruppeDAO();
			ArrayList<Makrogruppe> mList = mDAO.getAll();
			Component[] cList = UI.getCreationTabs().getComponents();
			for(Component c : cList)
			{
				if(c instanceof NahrungsmittelListViewing)
				{
					for(Makrogruppe m : mList)
					{
						((NahrungsmittelListViewing) c).getComboBox().addItem(m);
					}
					break;
				}
			}
			
		}
		catch(Exception | CONNECTION_EXCEPTION | GET_EXCEPTION | CLEANUP_EXCEPTION e){}
	}
	public void LoadNahrungsmittel(ArrayList<ActionData> DataList)
	{
		for(ActionData d : DataList)
		{
			if(d.getIndex().equals("SelectedItem"))
			{
				if(d.getRawData() instanceof Makrogruppe)
				{
					for(Component c : UI.getComponents())
					{
						if(c instanceof NahrungsmittelListViewing)
						{
							try 
							{
								((NahrungsmittelListViewing) c).CreateAndFillList(new NahrungsmittelDAO().getList((Makrogruppe)d.getRawData()));
							} catch (CONNECTION_EXCEPTION | GET_EXCEPTION | CLEANUP_EXCEPTION e) {}
						}
					}
				}
				break;
			}
		}
	}
}
