package de.kevinsekin.control;

import de.kevinsekin.model.Action;
import de.kevinsekin.model.ActionType;

public class ViewingActionHandler implements Runnable
{
	private ActionQueue ActionQueue;
	public ViewingActionHandler(ActionQueue ActionQueue)
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
				if(a.getType() == ActionType.VIEWING_ACTION)
				{
					if(a.getName().equals("LoadNahrungsmittelViewing"))
					{
						ViewingLogic.getNahrungsmittelListLogic().LoadNahrungsmittel(a.getDataList());
						ActionQueue.getActions().remove(a);
					}
				}
			}
		}
	}
}
