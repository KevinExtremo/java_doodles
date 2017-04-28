package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.CKlasse;
import Model.CSchueler;
import DAO.LehrerDAO;


public class KlassenDAO {

	private LehrerDAO lehrerDAO=new LehrerDAO();
	private LernbuerogruppeDAO lernbuerogruppeDAO=new LernbuerogruppeDAO();
	
	public CKlasse getKlasse(int id)
	{
		CKlasse k=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM klasse WHERE klassenID=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				k=new CKlasse();
				k.setKlasseID(id);
				k.setSchuljahr(rs.getString("schuljahr"));
				k.setKbez(rs.getString("kbez"));
				k.setLehrerID(lehrerDAO.getLehrer(rs.getInt("lehrerID")));
				k.setLbgruppeID(lernbuerogruppeDAO.getLernbuerogruppe(rs.getInt("lbgruppeID")));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		finally {
			try {
				rs.close();
				statement.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return k;
	}
	
	public void update(CKlasse k, CSchueler s)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="UPDATE Klasse SET klasseID=?, schuljahr=?, kbez=?, lehrerID=? WHERE lernbuerogruppeID=?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(3, s.getKlasse().getKlasseID());
			statement.setString(2, k.getSchuljahr());
			statement.setString(3, k.getKbez());
			statement.setInt(4, k.getLehrerID().getLehrerID());
			statement.setInt(5, k.getLbgruppeID().getLbgruppeID());
			

			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void anlegen(CKlasse k, CSchueler s)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO klasse VALUES (?, ?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, s.getKlasse().getKlasseID());
			statement.setString(2, k.getSchuljahr());
			statement.setString(3, k.getKbez());
			statement.setInt(4, k.getLehrerID().getLehrerID());
			statement.setInt(5, k.getLbgruppeID().getLbgruppeID());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}   
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void delete(int id)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="DELETE FROM klasse WHERE lehrerid= ?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
		}   
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
