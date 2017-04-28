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
					if(a.getName().equals("NahrungsmittelHinzufügenButtonAction"))
					{
						CreationLogic.getNahrungsmittelLogic().HinzufügenButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
						
					}
					if(a.getName().equals("NahrungsmittelBestätigenButtonAction"))
					{
						CreationLogic.getNahrungsmittelLogic().BestätigungButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
					if(a.getName().equals("MakrogruppeBestätigenButtonAction")) 
					{
						CreationLogic.getMakrogruppeCreationLogic().BestätigungButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
					if(a.getName().equals("MakrogruppeHinzufügenButtonAction")) 
					{
						CreationLogic.getMakrogruppeCreationLogic().HinzufügenButtonLogic(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
				}
			}
		}
	}
}
