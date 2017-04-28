package de.kevinsekin.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import de.kevinsekin.model.Nährwerte;

public class NährwerteDAO 
{
	public Nährwerte get(int DatabaseID) throws CONNECTION_EXCEPTION, GET_EXCEPTION, CLEANUP_EXCEPTION
	{
		Nährwerte n = null;
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			con = DatabaseProvider.getDatabaseHandle().getConnection();
		} catch(Exception e)
		{
			throw new CONNECTION_EXCEPTION();
		}
		try
		{
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT kcal,kohlenhydrate,proteine,fette,id FROM Nährwerte WHERE nahrungsmittel_id="+DatabaseID);
			if(rs.next())
			{
				n = new Nährwerte();
				n.setDatabaseID(rs.getInt("id"));
				n.setParentID(DatabaseID);
				n.setKcal(rs.getFloat("kcal"));
				n.setKohlenhydrate(rs.getFloat("kohlenhydrate"));
				n.setProteine(rs.getFloat("proteine"));
				n.setFette(rs.getFloat("fette"));
			}
			else
			{
				throw new GET_EXCEPTION();
			}
		} catch(Exception e)
		{
			throw new GET_EXCEPTION();
		}
		finally
		{
			try
			{
				rs.close();
				stmt.close();
				con.close();
			}catch(Exception e)
			{
				throw new CLEANUP_EXCEPTION();
			}
		}
		return n;
	}
	public void update(Nährwerte n) throws CONNECTION_EXCEPTION, UPDATE_EXCEPTION, CLEANUP_EXCEPTION
	{
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DatabaseProvider.getDatabaseHandle().getConnection();
		} catch(Exception e)
		{
			throw new CONNECTION_EXCEPTION();
		}
		try
		{
			stmt = con.prepareStatement("UPDATE Nährwerte SET kcal=?,kohlenhydrate=?,proteine=?,fette=? WHERE nahrungsmittel_id=?");
			stmt.setFloat(1, n.getKcal());
			stmt.setFloat(2, n.getKohlenhydrate());
			stmt.setFloat(3, n.getProteine());
			stmt.setFloat(4, n.getFette());
			stmt.setInt(5, n.getParentID());
			stmt.executeUpdate();
		} catch(Exception e)
		{
			throw new UPDATE_EXCEPTION();
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			} catch(Exception e)
			{
				throw new CLEANUP_EXCEPTION();
			}
		}
	}
	public void create(Nährwerte n) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, CREATE_EXCEPTION
	{
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DatabaseProvider.getDatabaseHandle().getConnection();
		} catch(Exception e)
		{
			throw new CONNECTION_EXCEPTION();
		}
		try
		{
			stmt = con.prepareStatement("INSERT INTO Nährwerte (kcal,kohlenhydrate,proteine,fette,nahrungsmittel_id) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setFloat(1, n.getKcal());
			stmt.setFloat(2,n.getKohlenhydrate());
			stmt.setFloat(3, n.getProteine());
			stmt.setFloat(4, n.getFette());
			stmt.setInt(5, n.getParentID());
			int rows = stmt.executeUpdate();
			if(rows>0)
			{
				try
				{
					ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next()){
						n.setDatabaseID(rs.getInt(1));
					}
				} catch(Exception e)
				{
					throw new CREATE_EXCEPTION();
				}
			} 
			else
			{
				throw new CREATE_EXCEPTION();
			}
		} catch(Exception e)
		{
			throw new CREATE_EXCEPTION();
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			} catch(Exception e)
			{
				throw new CLEANUP_EXCEPTION();
			}
		}
	}
	public void delete(Nährwerte n) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, DELETE_EXCEPTION
	{
		Connection con = null;
		PreparedStatement stmt = null;
		try
		{
			con = DatabaseProvider.getDatabaseHandle().getConnection();
		} catch(Exception e)
		{
			throw new CONNECTION_EXCEPTION();
		}
		try
		{
			stmt = con.prepareStatement("DELETE FROM Nährwerte WHERE id=?");
			stmt.setInt(1, n.getDatabaseID());
			stmt.executeUpdate();
		} catch(Exception e)
		{
			throw new DELETE_EXCEPTION();
		}
		finally
		{
			try
			{
				stmt.close();
				con.close();
			} catch(Exception e)
			{
				throw new CLEANUP_EXCEPTION();
			}
		}
			
	}
}
