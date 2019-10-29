import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class versiotiedot extends JFrame {
	

	static JTextField teksti1 = new JTextField("JUOMA-AUTOMAATTI Tekijä: O. Lindfors");
	static Font font = new Font("Calibri", Font.BOLD,16);
	
	public versiotiedot() {
		
		JFrame ikkuna = new JFrame();
		ikkuna.setSize(500, 200);
		ikkuna.setTitle("Juoma-automaatti versiotiedot");
		ikkuna.getContentPane().setLayout(new BorderLayout());
		
		teksti1.setFont(font);
		teksti1.setHorizontalAlignment(JTextField.CENTER);
		ikkuna.add(teksti1, BorderLayout.CENTER);
		
		teksti1.setEditable(false);
		
		ikkuna.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ikkuna.setVisible(true);
	}
	
	
}