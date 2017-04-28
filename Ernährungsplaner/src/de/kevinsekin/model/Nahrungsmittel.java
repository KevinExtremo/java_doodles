package de.kevinsekin.model;
import de.kevinsekin.model.Nährwerte;

public class Nahrungsmittel 
{
	private int DatabaseID;
	private	String Name;
	private Nährwerte Nutrition;
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
	public Nährwerte getNutrition() {
		return Nutrition;
	}
	public void setNutrition(Nährwerte nutrition) {
		Nutrition = nutrition;
	}
	public int getMacrogroupID() {
		return MacrogroupID;
	}
	public void setMacrogroupID(int macrogroupID) {
		MacrogroupID = macrogroupID;
	}
}
