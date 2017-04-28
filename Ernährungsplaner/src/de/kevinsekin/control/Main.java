package de.kevinsekin.control;

import de.kevinsekin.view.MainApplicationFrame;

public class Main {

	
	public static void main(String[] args) 
	{
		//LaunchConfiguration l = LaunchConfiguration.getInstance();
		ActionQueue ActionQueue = new ActionQueue();
		MainApplicationFrame UI = new MainApplicationFrame(ActionQueue);
		new CreationLogic(UI,ActionQueue);
		UI.CreationUIStart();
		//UI.ViewingUIStart();
	}

}
