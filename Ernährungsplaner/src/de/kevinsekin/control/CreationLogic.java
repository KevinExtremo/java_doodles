package de.kevinsekin.control;

import de.kevinsekin.view.MainApplicationFrame;

public class CreationLogic
{
	private static NahrungsmittelCreationLogic NahrungsmittelLogic;
	private static MakrogruppeCreationLogic MakrogruppeLogic;
	public CreationLogic(MainApplicationFrame UI, ActionQueue ActionQueue)
	{
		NahrungsmittelLogic = new NahrungsmittelCreationLogic(UI);
		MakrogruppeLogic = new MakrogruppeCreationLogic(UI);
		Thread t = new Thread(new CreationActionHandler(ActionQueue));
		t.setDaemon(true);
		t.start();		
	}
	public static NahrungsmittelCreationLogic getNahrungsmittelLogic() { return NahrungsmittelLogic; }
	public static MakrogruppeCreationLogic getMakrogruppeCreationLogic() { return MakrogruppeLogic; }
	
	
}
