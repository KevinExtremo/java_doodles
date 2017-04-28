package de.kevinsekin.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import de.kevinsekin.model.Makrogruppe;

public class MakrogruppeDAO 
{
	public Makrogruppe get(int DatabaseID) throws CONNECTION_EXCEPTION, GET_EXCEPTION, CLEANUP_EXCEPTION
	{
		Makrogruppe m = null;
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
			rs = stmt.executeQuery("SELECT name FROM Makrogruppe WHERE id="+DatabaseID);
			if(rs.next())
			{
				m = new Makrogruppe();
				m.setDatabaseID(DatabaseID);
				m.setName(rs.getString("name"));
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
		return m;
	}
	public ArrayList<Makrogruppe> getAll() throws CONNECTION_EXCEPTION, GET_EXCEPTION, CLEANUP_EXCEPTION
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Makrogruppe> mList = new ArrayList<Makrogruppe>();
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
			rs = stmt.executeQuery("SELECT id,name FROM Makrogruppe");
			while(rs.next())
			{
				Makrogruppe m = new Makrogruppe();
				m.setDatabaseID(rs.getInt("id"));
				m.setName(rs.getString("name"));
				mList.add(m);				
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
		return null;
	}
	public void update(Makrogruppe m) throws CONNECTION_EXCEPTION, UPDATE_EXCEPTION, CLEANUP_EXCEPTION
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
			stmt = con.prepareStatement("UPDATE Makrogruppe SET name=? WHERE id=?");
			stmt.setString(1, m.getName());
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
	public void create(Makrogruppe m) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, CREATE_EXCEPTION
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
			stmt = con.prepareStatement("INSERT INTO Makrogruppe (name) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, m.getName());
			int rows = stmt.executeUpdate();
			if(rows>0)
			{
				try
				{
					ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next()){
						m.setDatabaseID(rs.getInt(1));
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
	public void delete(Makrogruppe m) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, DELETE_EXCEPTION
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
			stmt = con.prepareStatement("DELETE FROM Makrogruppe WHERE id=?");
			stmt.setInt(1, m.getDatabaseID());
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
