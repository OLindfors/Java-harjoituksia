import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class TaulukkoGUI extends JFrame {

	private static final long serialVersionUID = 1l;
	private JPanel contentPane;
	private JTable table_1;
	private DefaultTableModel malli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TaulukkoGUI frame = new TaulukkoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TaulukkoGUI() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		Connection conn = null;
		Statement stmt = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(0, 0, 200, 0));
		contentPane.add(scrollPane);

		malli = new DefaultTableModel();
		malli.addColumn("ELokuvan nimi");
		malli.addColumn("Ohjaaja");
		malli.addColumn("Vuosi");
		malli.addColumn("Laji");

		table_1 = new JTable(malli);

		try {
			// String JDBC_DRIVER = "com.mysql.jdbc.Driver";
			String URL = "jdbc:mysql://remotemysql.com:3306/z6Pn05QVw8";
			String USERID = "z6Pn05QVw8";
			String PASSWORD = "D5Yh1aQjhp";

			conn = DriverManager.getConnection(URL, USERID, PASSWORD);
			stmt = conn.createStatement();

			System.out.println("Yhteys tietokantaan on luotu.");

			// Suoritetaan kysely ja otetaan tulokset talteen
			ResultSet rs = stmt.executeQuery("SELECT * FROM elokuvasto");

			while (rs.next()) {

				malli.addRow(new Object[] { rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4) });
				System.out.println(
						rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + " " + rs.getString(4));
			}

			rs.last();
			System.out.println("Tuloksia palautui: " + rs.getRow() + " riviä.");

			// Suljetaan yhteys
			conn.close();

		} catch (SQLException e) {
			System.out.println("Virhe tietokannan käytössä!");
			System.out.println(e);
		}

		scrollPane.setViewportView(table_1);
	}

	// }

}
