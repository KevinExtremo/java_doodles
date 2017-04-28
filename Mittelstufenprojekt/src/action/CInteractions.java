package action;

import DAO.SchuelerDAO;
import Model.CKlasse;
import Model.CLehrer;
import Model.CSchueler;

public class CInteractions 
{
	public boolean LehrerLogin(CLehrer p_cLehrer, String p_sPasswort)
	{
		return (p_cLehrer.getPasswort() == p_sPasswort) ? true : false;
	}
	public CSchueler SchuelerAnlegen(String p_sVorname, String p_sName)
	{
		CSchueler CSchueler = new CSchueler();
		CSchueler.setSvorname(p_sVorname);
		CSchueler.setSname(p_sName);
		return CSchueler;
	}
	public boolean SchuelerLoeschen(CSchueler p_CSchueler)
	{
		SchuelerDAO cSchuelerDAO = new SchuelerDAO();
		return (cSchuelerDAO.delete(p_CSchueler.getKlasse().getKlasseID())) ? true : false;
	}
	public CKlasse KlasseAnlegen(String p_sSchuljahr, String p_sBezeichnung)
	{
		CKlasse CKlasse = new CKlasse();
		CKlasse.setSchuljahr(p_sSchuljahr);
		CKlasse.setKbez(p_sBezeichnung);
		return CKlasse;
	}
	public CLehrer LehrerAnlegen(String p_sVorname, String p_sName, String p_sPasswort)
	{
		CLehrer CLehrer = new CLehrer();
		CLehrer.setLname(p_sName);
		CLehrer.setLvorname(p_sVorname);
		CLehrer.setPasswort(p_sPasswort);
		return CLehrer;
	}
	public boolean LehrerOp(CLehrer p_CLehrer)
	{
		return (p_CLehrer.setIstSuperUser(true)) ? true : false;
	}
	public boolean LehrerDeop(CLehrer p_CLehrer)
	{
		return (p_CLehrer.setIstSuperUser(false)) ? false : true;
	}
	public void SchuelerInKlasse(CSchueler p_CSchueler, CKlasse p_cKlasse)
	{
		p_CSchueler.setKlasse(p_cKlasse);
	}
	public void SchuelerAusKlasse(CSchueler p_CSchueler)
	{
		p_CSchueler = null;
	}
	public void GarbageCollector()
	{
		System.gc();
	}
}
