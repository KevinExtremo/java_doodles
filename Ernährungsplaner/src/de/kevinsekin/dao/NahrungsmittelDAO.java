package de.kevinsekin.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import de.kevinsekin.model.Makrogruppe;
import de.kevinsekin.model.Nahrungsmittel;

public class NahrungsmittelDAO 
{
	public Nahrungsmittel get(int DatabaseID) throws CONNECTION_EXCEPTION, GET_EXCEPTION, CLEANUP_EXCEPTION
	{
		Nahrungsmittel n = null;
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
			rs = stmt.executeQuery("SELECT name,macroid FROM Nahrungsmittel WHERE id="+DatabaseID);
			if(rs.next())
			{
				n = new Nahrungsmittel();
				n.setDatabaseID(DatabaseID);
				n.setName(rs.getString("name"));
				n.setNutrition(new NährwerteDAO().get(DatabaseID));
				n.setMacrogroupID(rs.getInt("macroid"));
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
	public ArrayList<Nahrungsmittel> getList(Makrogruppe m) throws CONNECTION_EXCEPTION, GET_EXCEPTION, CLEANUP_EXCEPTION
	{
		ArrayList<Nahrungsmittel> nList = null;
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
			rs = stmt.executeQuery("SELECT id,name,macroid FROM Nahrungsmittel WHERE macroid="+m.getDatabaseID());
			while(rs.next())
			{
				if(nList == null) nList = new ArrayList<Nahrungsmittel>();
				Nahrungsmittel n = new Nahrungsmittel();
				n.setDatabaseID(rs.getInt("id"));
				n.setName(rs.getString("name"));
				n.setNutrition(new NährwerteDAO().get(rs.getInt("id")));
				n.setMacrogroupID(rs.getInt("macroid"));
				nList.add(n);
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
		return nList;
	}
	public void update(Nahrungsmittel n) throws CONNECTION_EXCEPTION, UPDATE_EXCEPTION, CLEANUP_EXCEPTION
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
			stmt = con.prepareStatement("UPDATE Nahrungsmittel SET name=?, macroid=? WHERE id=?");
			stmt.setString(1, n.getName());
			stmt.setInt(2, n.getMacrogroupID());
			stmt.setInt(3, n.getDatabaseID());
			stmt.executeUpdate();
			NährwerteDAO nt = new NährwerteDAO();
			nt.update(n.getNutrition());
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
	public void create(Nahrungsmittel n) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, CREATE_EXCEPTION
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
			stmt = con.prepareStatement("INSERT INTO Nahrungsmittel (name,macroid) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, n.getName());
			stmt.setInt(2, n.getMacrogroupID());
			int rows = stmt.executeUpdate();
			if(rows>0)
			{
				try
				{
					ResultSet rs = stmt.getGeneratedKeys();
					if(rs.next()){
						n.setDatabaseID(rs.getInt(1));
						NährwerteDAO nt = new NährwerteDAO();
						nt.create(n.getNutrition());
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
	public void delete(Nahrungsmittel n) throws CONNECTION_EXCEPTION, CLEANUP_EXCEPTION, DELETE_EXCEPTION
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
			stmt = con.prepareStatement("DELETE FROM Nahrungsmittel WHERE id=?");
			stmt.setInt(1, n.getDatabaseID());
			NährwerteDAO nt = new NährwerteDAO();
			nt.delete(n.getNutrition());
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
