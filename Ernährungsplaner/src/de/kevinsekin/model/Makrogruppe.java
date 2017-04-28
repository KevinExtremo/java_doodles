package de.kevinsekin.model;

public class Makrogruppe 
{
	private int DatabaseID;
	private String Name;
	public int getDatabaseID() {
		return DatabaseID;
	}
	public void setDatabaseID(int databaseID) {
		DatabaseID = databaseID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Override
	public String toString() {
		return Name;
	}
}
