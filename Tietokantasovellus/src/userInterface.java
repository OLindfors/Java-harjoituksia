
import java.awt.*;
import java.sql.*;

import javax.swing.table.*;

import javax.swing.*;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class userInterface extends JFrame {

	private static final long serialVersionUID = 1l;
	private DefaultTableModel malli;
	public JTable table_1;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface frame = new userInterface();
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

	public userInterface() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setTitle("Elokuvakirjasto");
		getContentPane().setLayout(new BorderLayout(0, 0));

		JButton btnNewButton = new JButton("KLIKKAA T\u00C4ST\u00C4 elokuvat esille");
		btnNewButton.setMaximumSize(new Dimension(80, 25));
		btnNewButton.setBackground(Color.MAGENTA);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					JFrame uusi = new TaulukkoGUI();
					uusi.setSize(650, 400);
					uusi.setVisible(true);

				} catch (Exception eb) {
					eb.printStackTrace();
				}
			}
		});
		getContentPane().add(btnNewButton, BorderLayout.NORTH);

		JButton btnNewButton_1 = new JButton("KLIKKAA T\u00C4ST\u00C4 uuden elokuvan tallennukseen");
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					JFrame uusi = new TallennusGUI();
					uusi.setSize(800, 400);
					uusi.setVisible(true);

				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		});
		getContentPane().add(btnNewButton_1, BorderLayout.SOUTH);

	}

	public void lataaElokuvat() {

		Connection conn = null;
		Statement stmt = null;

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(0, 0, 200, 0));
		getContentPane().add(scrollPane, BorderLayout.CENTER);

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

		table_1.getColumnModel().getColumn(2).setPreferredWidth(35);
		scrollPane.setViewportView(table_1);
	}
}
