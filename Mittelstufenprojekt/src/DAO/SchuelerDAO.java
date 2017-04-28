package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.CSchueler;
import DAO.SchuelerDAO;
import DAO.ConnectionProvider;
import DAO.KlassenDAO;

public class SchuelerDAO {

private KlassenDAO klassenDAO=new KlassenDAO();
	
	public CSchueler get(int id)
	{
		CSchueler s=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM schueler WHERE schuelerID=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				s=new CSchueler();
				s.setSchuelerID(id);
				s.setSname(rs.getString("sname"));
				s.setSvorname(rs.getString("svorname"));
				s.setKlasse(klassenDAO.getKlasse(rs.getInt("klasseID")));
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
		return s;
	}
	
	public void update(CSchueler s)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="UPDATE Schueler SET sname=?, svorname=?, klassenID=? WHERE schuelerID=?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, s.getSname());
			statement.setString(2, s.getSvorname());
			statement.setInt(3, s.getKlasse().getKlasseID());
			statement.setInt(4, s.getSchuelerID());

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

	public void anlegen(CSchueler s)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO Schueler VALUES (?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, s.getSchuelerID());
			statement.setString(2, s.getSvorname());
			statement.setString(3, s.getSname());
			statement.setInt(4, s.getKlasse().getKlasseID());

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
	
	public boolean delete(int id)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="DELETE FROM Schueler WHERE schuelerID= ?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
        } catch (SQLException e) {
			e.printStackTrace();
			return false;
		}   
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
        return true;
	}
	

}
