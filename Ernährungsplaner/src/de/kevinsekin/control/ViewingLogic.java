package de.kevinsekin.control;

import de.kevinsekin.view.MainApplicationFrame;

public class ViewingLogic
{
	private static NahrungsmittelListViewingLogic NahrungsmittelListLogic;
	public ViewingLogic(MainApplicationFrame UI, ActionQueue ActionQueue)
	{
		NahrungsmittelListLogic = new NahrungsmittelListViewingLogic(UI);
		Thread t = new Thread(new CreationActionHandler(ActionQueue));
		t.setDaemon(true);
		t.start();		
	}
	public static NahrungsmittelListViewingLogic getNahrungsmittelListLogic() { return NahrungsmittelListLogic; }
	
	
}
