import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;
import java.awt.event.InputEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class editori extends JFrame {

	private JPanel contentPane;
	private JEditorPane editorPane;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editori frame = new editori();
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
	public editori() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTiedosto = new JMenu("Tiedosto");
		menuBar.add(mnTiedosto);

		JMenuItem mntmAvaa = new JMenuItem("Avaa");

		mntmAvaa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showOpenDialog(null);
				String rivi = "";
				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				try {
					Scanner lukija = null;
					File tiedosto = new File(uusiTiedosto);

					lukija = new Scanner(tiedosto);

					while (lukija.hasNextLine()) {
						rivi += lukija.nextLine() + "\n";
						System.out.println(rivi);

					}

				} catch (FileNotFoundException p) {
					System.out.println("Tiedostoa ei löydy.");
				}
				editorPane.setText(rivi);
			}

		});

		mntmAvaa.setIcon(
				new ImageIcon(editori.class.getResource("/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif")));
		mntmAvaa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmAvaa);

		JMenuItem mntmTallenna = new JMenuItem("Tallenna");
		mntmTallenna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);

				try {
					PrintWriter writer = new PrintWriter(uusiTiedosto);
					String sisältö = editorPane.getText();

					writer.println(sisältö);

					writer.flush();
					writer.close();
				} catch (Exception e1) {
					System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
					e1.printStackTrace();
				}
			}
		});
		mntmTallenna.setIcon(
				new ImageIcon(editori.class.getResource("/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif")));
		mntmTallenna.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmTallenna);

		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane varmistus = new JOptionPane();
				int kysymys = varmistus.showOptionDialog(null, "Haluatko lopettaa tallentamatta?", "Lopetus", JOptionPane.YES_NO_OPTION, 
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				
				if (kysymys == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});

		mntmLopeta.setIcon(new ImageIcon(editori.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmLopeta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmLopeta);

		JMenuItem mntmSulje = new JMenuItem("Sulje");
		mntmSulje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmSulje.setIcon(
				new ImageIcon(editori.class.getResource("/com/sun/java/swing/plaf/motif/icons/TreeClosed.gif")));
		mntmSulje.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnTiedosto.add(mntmSulje);

		JMenu mnMuokkaa = new JMenu("Muokkaa");
		menuBar.add(mnMuokkaa);

		JMenuItem mntmEtsi = new JMenuItem("Etsi");
		mntmEtsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sisalto = editorPane.getText();
				sisalto = sisalto.toLowerCase();

				String haettava = "auto";
				int indeksi = sisalto.indexOf(haettava);
				System.out.println("indeksi: " + indeksi);

				editorPane.setSelectionColor(Color.YELLOW);
				editorPane.setSelectionStart(indeksi);
				editorPane.setSelectionEnd(indeksi + haettava.length());
			}
		});
		mnMuokkaa.add(mntmEtsi);

		JMenuItem mntmKorvaa = new JMenuItem("Korvaa");
		/*
		 * mntmKorvaa.addActionListener(new ActionListener() {
		 * 
		 * public void actionPerformed(ActionEvent e) {
		 * 
		 * String sisalto = editorPane.getText(); sisalto = sisalto.toLowerCase();
		 * 
		 * String haettava = "kissa"; String korvaaja = haettava.replaceAll("kissa",
		 * "koira");
		 * 
		 * 
		 * } });
		 */
		mnMuokkaa.add(mntmKorvaa);

		JMenu mnTietoja = new JMenu("Tietoja");
		menuBar.add(mnTietoja);

		JMenuItem mntmTietojaOhjelmasta = new JMenuItem("Tietoja ohjelmasta");
		mntmTietojaOhjelmasta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JOptionPane tiedot = new JOptionPane();
				tiedot.showMessageDialog(null, "Outi Lindfors \n Tekstieditori 1.0");

			}
		});
		mnTietoja.add(mntmTietojaOhjelmasta);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String empty = editorPane.getText();
				empty = "";

				editorPane.setText(empty);

			}
		});
		btnNewButton
				.setIcon(new ImageIcon(editori.class.getResource("/com/sun/java/swing/plaf/windows/icons/File.gif")));
		toolBar.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser valintaikkuna = new JFileChooser();
				valintaikkuna.showSaveDialog(null);

				String uusiTiedosto = valintaikkuna.getSelectedFile().getAbsolutePath();

				System.out.println("Kirjoitettava tiedosto: " + uusiTiedosto);

				try {
					PrintWriter writer = new PrintWriter(uusiTiedosto);
					String sisältö = editorPane.getText();

					writer.println(sisältö);

					writer.flush();
					writer.close();
				} catch (Exception e1) {
					System.out.println("Tiedoston tallennuksessa tapahtui virhe!");
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1
				.setIcon(new ImageIcon(editori.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		toolBar.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2
				.setIcon(new ImageIcon(editori.class.getResource("/com/sun/javafx/scene/web/skin/Cut_16x16_JFX.png")));
		toolBar.add(btnNewButton_2);

		editorPane = new JEditorPane();
		editorPane.setPreferredSize(new Dimension(106, 180));
		editorPane.setEditable(true);
		contentPane.add(editorPane, BorderLayout.SOUTH);
	}

	public JEditorPane getEditorPane() {
		return editorPane;
	}
}
