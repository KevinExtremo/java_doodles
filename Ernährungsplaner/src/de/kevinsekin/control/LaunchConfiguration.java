package de.kevinsekin.control;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JOptionPane;

import de.kevinsekin.dao.DatabaseProvider;

public class LaunchConfiguration 
{
	private static final LaunchConfiguration Init = new LaunchConfiguration();
	private static boolean success=false;
	private LaunchConfiguration(){}
	public static LaunchConfiguration getInstance()
	{
		if(!success)
		{
			Connection con = null;
			InputStream in = null;
			Statement st = null;
			Scanner s = null;
			try
			{
				con = DatabaseProvider.getDatabaseHandle().getConnection();
				in = new FileInputStream("database.sql");
				s = new Scanner(in);
				s.useDelimiter("(;(\r)?\n)|((\r)?\n)?(--)?.*(--(\r)?\n)");
			    st = con.createStatement();
			    while (s.hasNext())
			    {
			        String line = s.next();
			        if (line.startsWith("/*!") && line.endsWith("*/"))
			        {
			            int i = line.indexOf(' ');
			            line = line.substring(i + 1, line.length() - " */".length());
			        }
			        if (line.trim().length() > 0)
			        {
			            st.execute(line);
			        }
			    }
			} catch(Exception e)
			{
				int rs = JOptionPane.showOptionDialog(null, "We detected an error loading your launch configuration. Please fix the issue and restart the application.", "Launch Configuration Failed", JOptionPane.PLAIN_MESSAGE, JOptionPane.ERROR_MESSAGE, null, null, null);
				if(rs>=0)
				{
					System.exit(0);
				}
			}
			finally
		    {
				try
				{
					st.close();
					s.close();
					in.close();
					success=true;
				} catch(Exception e) {}
		    }
			try
		    {
		    	in = new FileInputStream("data.sql");
				s = new Scanner(in);
				s.useDelimiter("(;(\r)?\n)|((\r)?\n)?(--)?.*(--(\r)?\n)");
			    st = con.createStatement();
			    while (s.hasNext())
			    {
			        String line = s.next();
			        if (line.startsWith("/*!") && line.endsWith("*/"))
			        {
			            int i = line.indexOf(' ');
			            line = line.substring(i + 1, line.length() - " */".length());
			        }
			        if (line.trim().length() > 0)
			        {
			            st.execute(line);
			        }
			    }
		    } catch(Exception e)
		    {
		    	// we dont care, this is just extra functionality ;)
		    }
			finally
		    {
				try
				{
					st.close();
					s.close();
					in.close();
					con.close();
				} catch(Exception e) {}
		    }
		}
		return Init;
	}
}
