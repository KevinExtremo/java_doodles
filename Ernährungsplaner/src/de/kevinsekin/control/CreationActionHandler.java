package de.kevinsekin.control;

import de.kevinsekin.model.Action;
import de.kevinsekin.model.ActionType;

public class CreationActionHandler implements Runnable
{
	private ActionQueue ActionQueue;
	public CreationActionHandler(ActionQueue ActionQueue)
	{
		this.ActionQueue = ActionQueue;
	}
	
	@Override
	public void run() 
	{
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int elements = ActionQueue.getActions().size(); elements > 0; elements--)
			{
				Action a = ActionQueue.getActions().get(elements-1);
				if(a.getType() == ActionType.CREATION_ACTION)
				{
					if(a.getName().equals("NahrungsmittelHinzuf�genButtonAction"))
					{
						CreationLogic.getNahrungsmittelLogic().Hinzuf�genButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
						
					}
					if(a.getName().equals("NahrungsmittelBest�tigenButtonAction"))
					{
						CreationLogic.getNahrungsmittelLogic().Best�tigungButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
					if(a.getName().equals("MakrogruppeBest�tigenButtonAction")) 
					{
						CreationLogic.getMakrogruppeCreationLogic().Best�tigungButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
					if(a.getName().equals("MakrogruppeHinzuf�genButtonAction")) 
					{
						CreationLogic.getMakrogruppeCreationLogic().Hinzuf�genButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
				}
			}
		}
	}
}
