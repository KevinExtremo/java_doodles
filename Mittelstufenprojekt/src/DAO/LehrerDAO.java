package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.ConnectionProvider;
import Model.CLehrer;
import DAO.LernbueroDAO;

public class LehrerDAO {
	
private LernbueroDAO lernbueroDAO=new LernbueroDAO();
	
	public CLehrer getLehrer(int id)
	{
		CLehrer l=null;
		Connection conn=ConnectionProvider.getConnection();
		PreparedStatement statement=null;
		ResultSet rs=null;
		String sql="SELECT * FROM lehrer WHERE lehrerid=?";
        try {
			statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			rs=statement.executeQuery();
			
			if (rs.next())
			{
				l=new CLehrer();
				l.setLehrerID(id);
				l.setLname(rs.getString("lname"));
				l.setLvorname(rs.getString("lvorname"));
				l.setPasswort(rs.getString("passwort"));
				l.setIstSuperUser(rs.getInt("superuser")==0?false:true);
				l.setLbid(lernbueroDAO.getLernbuero(rs.getInt("lbid")));
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
		return l;
	}
	
	public void update(CLehrer l)
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
	public CLehrer find(String p_sName[])
	{
		Connection conn=ConnectionProvider.getConnection();
		p_sName[0].replaceAll("'", " ");
		p_sName[1].replaceAll("'", " ");
		String sql="SELECT lehrerid FROM Lehrer WHERE lname= ? AND lvorname= ?";
		try
		{
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, p_sName[0]);
			statement.setString(2, p_sName[1]);
			ResultSet rs = null;
			rs = statement.executeQuery();
			if(rs.next())
			{
				conn.close();
				return getLehrer(rs.getInt(1));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
				return null;
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return null;
	}

}
