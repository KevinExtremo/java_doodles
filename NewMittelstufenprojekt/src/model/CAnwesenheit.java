package model;

import java.sql.Date;

public class CAnwesenheit 
{
	private long ID;
	private Date Datum;
	private boolean Anwesend;
	
	public long getID() 
	{
		return ID;
	}
	public void setID(long iD) 
	{
		ID = iD;
	}
	public Date getDatum() 
	{
		return Datum;
	}
	public void setDatum(Date datum) 
	{
		Datum = datum;
	}
	public boolean isAnwesend() 
	{
		return Anwesend;
	}
	public void setAnwesend(boolean anwesend) 
	{
		Anwesend = anwesend;
	}

	
}
