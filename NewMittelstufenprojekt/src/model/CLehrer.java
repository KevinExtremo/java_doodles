package model;

public class CLehrer 
{
	private long ID;
	private String Vorname;
	private String Nachname;
	private String Passwort;
	private boolean Admin;
	
	public long getID() 
	{
		return ID;
	}
	public void setID(long iD) 
	{
		ID = iD;
	}
	public String getPasswort() 
	{
		return Passwort;
	}
	public void setPasswort(String passwort) 
	{
		Passwort = passwort;
	}
	public boolean isAdmin() 
	{
		return Admin;
	}
	public void setAdmin(boolean admin) 
	{
		Admin = admin;
	}
	public String getVorname() 
	{
		return Vorname;
	}
	public void setVorname(String vorname) 
	{
		Vorname = vorname;
	}
	public String getNachname() 
	{
		return Nachname;
	}
	public void setNachname(String nachname) 
	{
		Nachname = nachname;
	}
	
	
	
}
