package de.kevinsekin.control;

import java.util.ArrayList;

import de.kevinsekin.model.Action;

public class ActionQueue 
{
	private ArrayList<Action> Actions = new ArrayList<Action>();
	public ArrayList<Action> getActions() {
		return Actions;
	}
	public void push(Action a)
	{
		Actions.add(a);
	}
}
