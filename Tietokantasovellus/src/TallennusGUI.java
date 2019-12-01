
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TallennusGUI extends JFrame {

	private static final long serialVersionUID = 1l;

	private JTextField nimiKentta;
	private JTextField ohjaajaKentta;
	private JTextField julkaisuKentta;
	private JTextField lajiKentta;

	/**
	 * Create the panel.
	 *
	 */
	public TallennusGUI() throws ParseException {
		setTitle("Elokuvan tallennus");
		getContentPane().setLayout(null);

		JLabel lblElokuva = new JLabel("Elokuvat");
		lblElokuva.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblElokuva.setBounds(34, 27, 195, 20);
		getContentPane().add(lblElokuva);

		JLabel lblElokuvanNimi = new JLabel("Elokuvan nimi:");
		lblElokuvanNimi.setBounds(34, 94, 111, 20);
		getContentPane().add(lblElokuvanNimi);

		JLabel lblOhjaaja = new JLabel("Ohjaaja");
		lblOhjaaja.setBounds(34, 139, 111, 20);
		getContentPane().add(lblOhjaaja);

		JLabel lblVuosi = new JLabel("Vuosi");
		lblVuosi.setBounds(34, 189, 111, 20);
		getContentPane().add(lblVuosi);

		JLabel lblLaji = new JLabel("Laji");
		lblLaji.setBounds(34, 239, 111, 20);
		getContentPane().add(lblLaji);

		nimiKentta = new JTextField();
		nimiKentta.setColumns(10);
		nimiKentta.setBounds(148, 91, 250, 26);
		getContentPane().add(nimiKentta);

		ohjaajaKentta = new JTextField();
		ohjaajaKentta.setColumns(10);
		ohjaajaKentta.setBounds(148, 136, 250, 26);
		getContentPane().add(ohjaajaKentta);

		julkaisuKentta = new JTextField();
		julkaisuKentta.setColumns(10);
		julkaisuKentta.setBounds(148, 186, 146, 26);
		getContentPane().add(julkaisuKentta);

		lajiKentta = new JTextField();
		lajiKentta.setColumns(10);
		lajiKentta.setBounds(148, 236, 146, 26);
		getContentPane().add(lajiKentta);

		JButton lisaaNappi = new JButton("Tallenna elokuva");
		lisaaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				tallennaElokuva();
			}
		});
		lisaaNappi.setBounds(34, 280, 200, 29);
		getContentPane().add(lisaaNappi);

		JButton tyhjennaNappi = new JButton("Tyhjenn\u00E4");
		tyhjennaNappi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nimiKentta.setText("");
				ohjaajaKentta.setText("");
				julkaisuKentta.setText("");
				lajiKentta.setText("");
			}
		});
		tyhjennaNappi.setBounds(250, 280, 115, 29);
		getContentPane().add(tyhjennaNappi);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(
				new ImageIcon("C:\\Users\\Käyttäjä\\Documents\\Outi\\MyProjects\\Olio java\\Elokuvasto\\kuva.jpg"));
		lblNewLabel.setBounds(472, 78, 200, 181);
		getContentPane().add(lblNewLabel);

	}
	

	protected void tallennaElokuva() {

		String ekuvaNimi = nimiKentta.getText();
		String ohjaaja = ohjaajaKentta.getText();
		String vuosi = julkaisuKentta.getText();
		String laji = lajiKentta.getText();

		elokuva uusiElokuva = new elokuva(ekuvaNimi, ohjaaja, Integer.parseInt(vuosi), laji);

		db.tallennatElokuvan(uusiElokuva);
		JOptionPane.showMessageDialog(this, "Tallennettu");

	}

	public static void main(String[] args) {

		try {
			JFrame uusi = new TallennusGUI();
			uusi.setSize(800, 400);
			uusi.setVisible(true);

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
