package Model;

public class CLehrer 
{
	
	private int lehrerID;
	private String lvorname;
	private String lname;
	private String passwort;
	private boolean superuser;
	private CLernbuero lbID;

	
	
	
	public int getLehrerID() 
	{
		return lehrerID;
	}
	public void setLehrerID(int lehrerID) 
	{
		this.lehrerID = lehrerID;
	}
	public String getLvorname() 
	{
		return lvorname;
	}
	public void setLvorname(String lvorname) 
	{
		this.lvorname = lvorname;
	}
	public String getLname() 
	{
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	public String getPasswort() 
	{
		return passwort;
	}
	public void setPasswort(String passwort) 
	{
		this.passwort = passwort;
	}
	public boolean superuser() 
	{
		return superuser;
	}
	public boolean setIstSuperUser(boolean superuser) 
	{
		this.superuser = superuser;
		return (this.superuser) ? true : false;
	}
	public CLernbuero getLbid() 
	{
		return lbID;
	}
	public void setLbid(CLernbuero lbid) 
	{
		this.lbID = lbid;
	}
	
}