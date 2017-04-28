package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CLehrerDAO 
{
	public void anlegen(model.CLehrer l)
	{
		Connection conn=ConnectionProvider.getConnection();
		String sql="INSERT INTO Lehrer VALUES (?, ?, ?, ?, ?)";
        try {
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setLong(1, l.getID());
			statement.setString(2, l.getVorname());
			statement.setString(3, l.getNachname());
			statement.setString(4, l.getPasswort());
			statement.setInt(5, l.isAdmin()?1:0);

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
