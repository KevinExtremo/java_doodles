package Model;


public class cAnwesenheit 
{
	private int anwesenheitID;
	private String aschuljahr;
	private int kw;
	private int wochentag;
	private CSchueler schuelerID;
	private CLernbuero lbID;



	public int getAnwesenheitID() 
	{
		return anwesenheitID;
	}
	public void setAnwesenheitID(int anwesenheitID) 
	{
		this.anwesenheitID = anwesenheitID;
	}
	public String getAschuljahr() 
	{
		return aschuljahr;
	}
	public void setAschuljahr(String aschuljahr) 
	{
		this.aschuljahr = aschuljahr;
	}
	public int getKw() 
	{
		return kw;
	}
	public void setKw(int kw) 
	{
		this.kw = kw;
	}
	public int getWochentag() 
	{
		return wochentag;
	}
	public void setWochentag(int wochentag) 
	{
		this.wochentag = wochentag;
	}
	public CSchueler getSchuelerID() 
	{
		return schuelerID;
	}
	public void setSchuelerID(CSchueler schuelerID) 
	{
		this.schuelerID = schuelerID;
	}
	public CLernbuero getLbid() 
	{
		return lbID;
	}
	public void setLbid(CLernbuero lbID) 
	{
		this.lbID = lbID;
	}

}


