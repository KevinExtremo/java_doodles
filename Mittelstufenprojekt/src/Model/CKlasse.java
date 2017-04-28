package Model;

public class CKlasse 
{

	private int klasseID;
	private String schuljahr;
	private String kbez;
	private CLehrer lehrerID;
	private CLernbuerogruppe lbgruppeID;
	
	
	public int getKlasseID() 
	{
		return klasseID;
	}
	public void setKlasseID(int klasseID) 
	{
		this.klasseID = klasseID;
	}
	public String getSchuljahr() 
	{
		return schuljahr;
	}
	public void setSchuljahr(String schuljahr) 
	{
		this.schuljahr = schuljahr;
	}
	public String getKbez() 
	{
		return kbez;
	}
	public void setKbez(String kbez) 
	{
		this.kbez = kbez;
	}
	public CLehrer getLehrerID() 
	{
		return lehrerID;
	}
	public void setLehrerID(CLehrer lehrerID) 
	{
		this.lehrerID = lehrerID;
	}
	public CLernbuerogruppe getLbgruppeID() 
	{
		return lbgruppeID;
	}
	public void setLbgruppeID(CLernbuerogruppe lbgruppeID) 
	{
		this.lbgruppeID = lbgruppeID;
	}
}
