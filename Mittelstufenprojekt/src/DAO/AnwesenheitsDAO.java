package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.cAnwesenheit;
public class AnwesenheitsDAO {


	
	private LernbueroDAO lernbueroDAO=new LernbueroDAO();
	private SchuelerDAO schuelerDAO=new SchuelerDAO();
	
	public cAnwesenheit getAnwesenheit(int id)
	{
		cAnwesenheit a=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM anwesenheit WHERE anwesenheitid=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				a=new cAnwesenheit();
				a.setAnwesenheitID(id);
				a.setKw(rs.getInt("kw"));
				a.setAschuljahr(rs.getString("aschuljahr"));
				a.setSchuelerID(schuelerDAO.get(rs.getInt("schuelerID")));
				a.setLbid(lernbueroDAO.getLernbuero(rs.getInt("lbid")));
				a.setWochentag(rs.getInt("wochentag"));
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
		return a;
	}
	
	public void update(cAnwesenheit a)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="UPDATE anwesenheit SET aschuljahr=?, kw=?, wochentag=?, schuelerID=?, lbid=? WHERE anwesenheitid=?";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, a.getAschuljahr());
			statement.setInt(2, a.getKw());
			statement.setInt(3, a.getWochentag());
			statement.setInt(4, a.getSchuelerID().getSchuelerID());
			statement.setInt(5, a.getLbid().getLbID());
			statement.setInt(6, a.getAnwesenheitID());

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

	public void anlegen(cAnwesenheit a)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO Anwesenheit VALUES (?, ?, ?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, a.getAnwesenheitID());
			statement.setString(2, a.getAschuljahr());
			statement.setInt(3, a.getKw());
			statement.setInt(4, a.getWochentag());
			statement.setInt(5, a.getSchuelerID().getSchuelerID());
			statement.setInt(6, a.getLbid().getLbID());

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
		Connection conn= ConnectionProvider.getConnection();
		String sql="DELETE FROM anwesenheit WHERE anwesenheitid= ?";
		
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

