package de.kevinsekin.model;

import java.util.ArrayList;

public class Action 
{
	private String Name;
	private ArrayList<ActionData> DataList;
	private int Type;
	public Action(String Name, ArrayList<ActionData> DataList, int Type)
	{
		this.Name = Name;
		this.DataList = DataList;
		this.Type = Type;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public ArrayList<ActionData> getDataList() {
		return DataList;
	}
	public void setDataList(ArrayList<ActionData> dataList) {
		DataList = dataList;
	}
	public int getType() {
		return Type;
	}
	public void setType(int type) {
		Type = type;
	}
}
