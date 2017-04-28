package Model;


public class CSchueler 
{

	private int schuelerID;
	private String svorname;
	private String sname;
	private CKlasse klasse;
	
	public int getSchuelerID() 
	{
		return schuelerID;
	}
	public void setSchuelerID(int schuelerID) 
	{
		this.schuelerID = schuelerID;
	}
	public String getSvorname() 
	{
		return svorname;
	}
	public void setSvorname(String svorname) 
	{
		this.svorname = svorname;
	}
	public String getSname()
	{
		return sname;
	}
	public void setSname(String sname) 
	{
		this.sname = sname;
	}
	public CKlasse getKlasse() 
	{
		return klasse;
	}
	public void setKlasse(CKlasse klasse) 
	{
		this.klasse = klasse;
	}
}
