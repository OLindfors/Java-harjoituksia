import java.awt.*;

import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui extends JFrame {

	private static final long serialVersionUID = 1l;
	private JPanel contentPane;
	

	juomaAutomaatti machine = new juomaAutomaatti();
	
	String input1;
	String input2;
	String input3;
	JLabel lblKahvidata = new JLabel();
	JLabel lblTeedata = new JLabel();
	JLabel lblKaakaodata = new JLabel();
	
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui frame = new gui();
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
	public gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(400, 650);
		setTitle("Juoma-automaatti GUI 1.0");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnYllpito = new JMenu("Yll\u00E4pito");
		menuBar.add(mnYllpito);
		
		JMenuItem mntmAsetaKahvinMr = new JMenuItem("Aseta kahvin m\u00E4\u00E4r\u00E4");
		mntmAsetaKahvinMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane kahviLataus = new JOptionPane();
				String input1 = kahviLataus.showInputDialog(null, "Anna uusi arvo:");
				int uusiKahvilataus = Integer.parseInt(input1);
				machine.setKahvia(uusiKahvilataus);
				lblKahvidata.setText("Kahvia: " + machine.getKahvia());
				if (uusiKahvilataus > 20) {
					lblKahvidata.setForeground(Color.BLACK);
				} else {
					lblKahvidata.setForeground(Color.RED);
				}
			}
		});
		mnYllpito.add(mntmAsetaKahvinMr);
		
		JMenuItem mntmAsetaTeenMr = new JMenuItem("Aseta teen m\u00E4\u00E4r\u00E4");
		mntmAsetaTeenMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane teeLataus = new JOptionPane();
				String input2 = teeLataus.showInputDialog(null, "Anna uusi arvo:");
				int uusiTeelataus = Integer.parseInt(input2);
				machine.setTeetä(uusiTeelataus);
				lblTeedata.setText("Teetä: " + machine.getTeetä());
				if (uusiTeelataus > 20) {
					lblTeedata.setForeground(Color.BLACK);
				} else {
					lblTeedata.setForeground(Color.RED);
				}
				}
		});
		mnYllpito.add(mntmAsetaTeenMr);
		
		JMenuItem mntmAsetaKaakaonMr = new JMenuItem("Aseta Kaakaon m\u00E4\u00E4r\u00E4");
		mntmAsetaKaakaonMr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane kaakaoLataus = new JOptionPane();
				String input3 = kaakaoLataus.showInputDialog(null, "Anna uusi arvo:");
				int uusiKaakaolataus = Integer.parseInt(input3);
				machine.setKaakaota(uusiKaakaolataus);
				lblKaakaodata.setText("Kaakaota: " + machine.getKaakaota());
				if (uusiKaakaolataus > 20) {
					lblKaakaodata.setForeground(Color.BLACK);
				} else {
					lblKaakaodata.setForeground(Color.RED);
				}
			}
		});
		mnYllpito.add(mntmAsetaKaakaonMr);
		
		JMenuItem mntmTallennaAutomaatinTila = new JMenuItem("Tallenna automaatin tila");
		mntmTallennaAutomaatinTila.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Sarjallistamista2.kirjoitaTiedostoon(machine);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnYllpito.add(mntmTallennaAutomaatinTila);
		
		JMenuItem mntmLataaAutomaatti = new JMenuItem("Lataa automaatti");
		mntmLataaAutomaatti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					juomaAutomaatti machine2 = Sarjallistamista2.lueTiedostosta();
					
					int kahvia = machine2.getKahvia();
					int teetä = machine2.getTeetä();
					int kaakaota = machine2.getKaakaota();
					
					machine.setKahvia(kahvia);
					machine.setTeetä(teetä);
					machine.setKaakaota(kaakaota);
					
					lblKahvidata.setText("Kahvia: " + machine.getKahvia());
					
					
					if (kahvia > 20) {
						lblKahvidata.setForeground(Color.BLACK);
					} else {
						lblKahvidata.setForeground(Color.RED);
					}
					
					lblTeedata.setText("Teetä: " + machine.getTeetä());
					
					if (teetä > 20) {
						lblTeedata.setForeground(Color.BLACK);
					} else {
						lblTeedata.setForeground(Color.RED);
					}
					
					lblKaakaodata.setText("Kaakaota: " + machine.getKaakaota());
					
					if (kaakaota > 20) {
						lblKaakaodata.setForeground(Color.BLACK);
					} else {
						lblKaakaodata.setForeground(Color.RED);
					}
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		mnYllpito.add(mntmLataaAutomaatti);
		
		JMenuItem mntmLopeta = new JMenuItem("Lopeta");
		mntmLopeta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnYllpito.add(mntmLopeta);
		
		JMenu mnTietojaOhjelmasta = new JMenu("Tietoja ohjelmasta");
		menuBar.add(mnTietojaOhjelmasta);
		
		JMenuItem mntmVersiotiedot = new JMenuItem("Versiotiedot");
		mntmVersiotiedot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new versiotiedot();
			}
		});
		mnTietojaOhjelmasta.add(mntmVersiotiedot);
		
		JMenuItem mntmOhje = new JMenuItem("Ohje");
		mnTietojaOhjelmasta.add(mntmOhje);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {0, 0, 0, 0, 176, 2};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 6};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton Coffeeicon = new JButton("");
		Coffeeicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine.valmistaKahvi();
				int uusiKahvi = machine.getKahvia();
				lblKahvidata.setText("Kahvia: " + uusiKahvi);
				if (uusiKahvi <= 20) {
					lblKahvidata.setForeground(Color.RED);
				}
			}
		});
		Coffeeicon.setIcon(new ImageIcon("C:\\Users\\K\u00E4ytt\u00E4j\u00E4\\Documents\\Outi\\MyProjects\\Olio java\\Juomaautomaatti\\img\\coffee.jpg"));
		GridBagConstraints gbc_Coffeeicon = new GridBagConstraints();
		gbc_Coffeeicon.insets = new Insets(0, 0, 5, 5);
		gbc_Coffeeicon.gridx = 1;
		gbc_Coffeeicon.gridy = 1;
		contentPane.add(Coffeeicon, gbc_Coffeeicon);
		
		lblKahvidata.setText("Kahvia: " + machine.getKahvia());
		lblKahvidata.setHorizontalAlignment(SwingConstants.LEFT);
		lblKahvidata.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_lblKahvidata = new GridBagConstraints();
		gbc_lblKahvidata.anchor = GridBagConstraints.WEST;
		gbc_lblKahvidata.insets = new Insets(0, 0, 5, 0);
		gbc_lblKahvidata.gridx = 4;
		gbc_lblKahvidata.gridy = 1;
		contentPane.add(lblKahvidata, gbc_lblKahvidata);
		
		JLabel lblKahvi = new JLabel("Kahvi");
		lblKahvi.setFont(new Font("Courier New", Font.BOLD, 13));
		GridBagConstraints gbc_lblKahvi = new GridBagConstraints();
		gbc_lblKahvi.insets = new Insets(0, 0, 5, 5);
		gbc_lblKahvi.gridx = 1;
		gbc_lblKahvi.gridy = 2;
		contentPane.add(lblKahvi, gbc_lblKahvi);
		
		JButton Teeicon = new JButton("");
		Teeicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				machine.valmistaTee();
				int uusiTee = machine.getTeetä();
				lblTeedata.setText("Teetä: " + uusiTee);
				if (uusiTee <= 20) {
					lblTeedata.setForeground(Color.RED);
				}
			}
		});
		Teeicon.setIcon(new ImageIcon("C:\\Users\\K\u00E4ytt\u00E4j\u00E4\\Documents\\Outi\\MyProjects\\Olio java\\Juomaautomaatti\\img\\tea.jpg"));
		GridBagConstraints gbc_Teeicon = new GridBagConstraints();
		gbc_Teeicon.insets = new Insets(0, 0, 5, 5);
		gbc_Teeicon.gridx = 1;
		gbc_Teeicon.gridy = 4;
		contentPane.add(Teeicon, gbc_Teeicon);
		

		lblTeedata.setText("Teet\u00E4: " + machine.getTeetä());
		lblTeedata.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_lblTeedata = new GridBagConstraints();
		gbc_lblTeedata.anchor = GridBagConstraints.WEST;
		gbc_lblTeedata.insets = new Insets(0, 0, 5, 0);
		gbc_lblTeedata.gridx = 4;
		gbc_lblTeedata.gridy = 4;
		contentPane.add(lblTeedata, gbc_lblTeedata);
		
		JLabel lblTee = new JLabel("Tee");
		lblTee.setFont(new Font("Courier New", Font.BOLD, 13));
		GridBagConstraints gbc_lblTee = new GridBagConstraints();
		gbc_lblTee.insets = new Insets(0, 0, 5, 5);
		gbc_lblTee.gridx = 1;
		gbc_lblTee.gridy = 5;
		contentPane.add(lblTee, gbc_lblTee);
		
		JButton Cocoaicon = new JButton("");
		Cocoaicon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				machine.valmistaKaakao();
				int uusiKaakao = machine.getKaakaota();
				lblKaakaodata.setText("Kaakaota: " + uusiKaakao);
				if (uusiKaakao <= 20) {
					lblKaakaodata.setForeground(Color.RED);
				}
			}
		});
		Cocoaicon.setIcon(new ImageIcon("C:\\Users\\K\u00E4ytt\u00E4j\u00E4\\Documents\\Outi\\MyProjects\\Olio java\\Juomaautomaatti\\img\\cocoa.jpg"));
		GridBagConstraints gbc_Cocoaicon = new GridBagConstraints();
		gbc_Cocoaicon.insets = new Insets(0, 0, 5, 5);
		gbc_Cocoaicon.gridx = 1;
		gbc_Cocoaicon.gridy = 7;
		contentPane.add(Cocoaicon, gbc_Cocoaicon);
		

		lblKaakaodata.setText("Kaakaota: " + machine.getKaakaota());
		lblKaakaodata.setFont(new Font("Courier New", Font.BOLD, 18));
		GridBagConstraints gbc_lblKaakaodata = new GridBagConstraints();
		gbc_lblKaakaodata.anchor = GridBagConstraints.WEST;
		gbc_lblKaakaodata.insets = new Insets(0, 0, 5, 0);
		gbc_lblKaakaodata.gridx = 4;
		gbc_lblKaakaodata.gridy = 7;
		contentPane.add(lblKaakaodata, gbc_lblKaakaodata);
		
		JLabel lblKaakao = new JLabel("Kaakao");
		lblKaakao.setFont(new Font("Courier New", Font.BOLD, 13));
		GridBagConstraints gbc_lblKaakao = new GridBagConstraints();
		gbc_lblKaakao.insets = new Insets(0, 0, 0, 5);
		gbc_lblKaakao.gridx = 1;
		gbc_lblKaakao.gridy = 8;
		contentPane.add(lblKaakao, gbc_lblKaakao);
		
	}

}
