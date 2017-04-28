package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import Model.CLernbuerogruppe;

public class LernbuerogruppeDAO {
	
	public CLernbuerogruppe getLernbuerogruppe(int id) {
		
		CLernbuerogruppe g =null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM lernbuerogruppe WHERE lbgruppeID=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				g=new CLernbuerogruppe();
				g.setLbgruppeID(id);
				g.setLernbgbez(rs.getString("lernbgbez"));
				
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
		return g;
	}
	
	public void update(CLernbuerogruppe g)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="UPDATE lernbuerogruppe SET lname=?, lvorname=?, passwort=?, superuser=?, lbid=? WHERE lbgruppeID=?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, g.getLernbgbez());
			statement.setInt(2, g.getLbgruppeID());
			

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

	public void anlegen(CLernbuerogruppe g)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO lernbuerogruppe VALUES (?, ?, ?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, g.getLbgruppeID());
			statement.setString(2, g.getLernbgbez());
			

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
		String sql="DELETE FROM lernbuerogruppe WHERE lbgruppeID= ?";
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


