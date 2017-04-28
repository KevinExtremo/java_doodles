package de.kevinsekin.model;

public class Nährwerte 
{
	private int DatabaseID;
	private int ParentID;
	private float Kcal;
	private float Kohlenhydrate;
	private float Proteine;
	private float Fette;
	public float getKcal() {
		return Kcal;
	}
	public void setKcal(float kcal) {
		Kcal = kcal;
	}
	public float getKohlenhydrate() {
		return Kohlenhydrate;
	}
	public void setKohlenhydrate(float kohlenhydrate) {
		Kohlenhydrate = kohlenhydrate;
	}
	public float getProteine() {
		return Proteine;
	}
	public void setProteine(float proteine) {
		Proteine = proteine;
	}
	public float getFette() {
		return Fette;
	}
	public void setFette(float fette) {
		Fette = fette;
	}
	public int getDatabaseID() {
		return DatabaseID;
	}
	public void setDatabaseID(int databaseID) {
		DatabaseID = databaseID;
	}
	public int getParentID() {
		return ParentID;
	}
	public void setParentID(int parentID) {
		ParentID = parentID;
	}
}
