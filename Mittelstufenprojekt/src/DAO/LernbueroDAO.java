package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.CLehrer;
import Model.CLernbuero;





public class LernbueroDAO {
	

private LernbuerogruppeDAO lernbuerogruppeDAO=new LernbuerogruppeDAO();
	
	public CLernbuero getLernbuero(int id)
	{
		CLernbuero lb=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM lernburo WHERE lbid=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				lb=new CLernbuero ();
				lb.setLbID(rs.getInt("id"));
				lb.setLernbbez(rs.getString("lernbbez"));
				lb.setLbgruppeID(lernbuerogruppeDAO.getLernbuerogruppe(rs.getInt("lbgruppeID")));
				
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
		return lb;
	}
	
	public void update(CLernbuero lb, CLehrer l )
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="UPDATE Lehrer SET lname=?, lvorname=?, passwort=?, superuser=?, lbid=? WHERE lehrerid=?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, l.getLname());
			statement.setString(2, l.getLvorname());
			statement.setString(3, l.getPasswort());
			statement.setInt(4, l.superuser()?1:0);
			statement.setInt(5, l.getLbid().getLbID());
			statement.setInt(6, l.getLehrerID());

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

	public void anlegen(CLehrer l)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO Lehrer VALUES (?, ?, ?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, l.getLehrerID());
			statement.setString(2, l.getLvorname());
			statement.setString(3, l.getLname());
			statement.setString(4, l.getPasswort());
			statement.setInt(5, l.superuser()?1:0);
			statement.setInt(6, l.getLbid().getLbID());

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
		String sql="DELETE FROM Lehrer WHERE lehrerid= ?";
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
