package de.kevinsekin.model;
import de.kevinsekin.model.N�hrwerte;

public class Nahrungsmittel 
{
	private int DatabaseID;
	private	String Name;
	private N�hrwerte Nutrition;
	private int MacrogroupID;
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
	public N�hrwerte getNutrition() {
		return Nutrition;
	}
	public void setNutrition(N�hrwerte nutrition) {
		Nutrition = nutrition;
	}
	public int getMacrogroupID() {
		return MacrogroupID;
	}
	public void setMacrogroupID(int macrogroupID) {
		MacrogroupID = macrogroupID;
	}
}
