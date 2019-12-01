
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class db {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String URL = "jdbc:mysql://remotemysql.com:3306/z6Pn05QVw8";
	static final String USERID = "z6Pn05QVw8";
	static final String PASSWORD = "D5Yh1aQjhp";

	public static void tallennatElokuvan(elokuva uusiElokuva) {

		String ekuvaNimi = uusiElokuva.getEkuvaNimi();
		String ohjaaja = uusiElokuva.getOhjaaja();
		int vuosi = uusiElokuva.getVuosi();
		String laji = uusiElokuva.getLaji();

		Connection conn = null;
		Statement stmt = null;
		try {

			System.out.println("Connecting to database...");

			// Tietokantayhteys
			conn = DriverManager.getConnection(URL, USERID, PASSWORD);

			String sql = "INSERT INTO elokuvasto (nimi,ohjaaja,vuosi,genre) values (?,?,?,?)";

			// SQL-lauseen puuttuvat muuttujat
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, ekuvaNimi);
			preparedStmt.setString(2, ohjaaja);
			preparedStmt.setInt(3, vuosi);
			preparedStmt.setString(4, laji);

			preparedStmt.execute();

			System.out.println("Saving data...");

		} catch (SQLException se) {
			// Käsitellän tietokantavirheet
			se.printStackTrace();
		} catch (Exception e) {
			// Muut virheet
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		}

	}

}
