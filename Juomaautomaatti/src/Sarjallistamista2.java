import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Sarjallistamista2 {

	// Otetaan vastaan juoma-automaatti-olio ja kirjoitetaan se XML-muotoisena
	// tiedostoon
	public static void kirjoitaTiedostoon(juomaAutomaatti machine) throws IOException {

		// XML:n kirjoittamista varten

		FileOutputStream tiedosto = new FileOutputStream("Automaatti.xml");
		XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(tiedosto));

		// Kirjoitetaan olio XML-muotoiseen tiedostoon
		enc.writeObject(machine);

		// Lopputoimet tiedostoille
		enc.close();
		tiedosto.close();
	}

	public static juomaAutomaatti lueTiedostosta() throws FileNotFoundException {

		XMLDecoder dec = null;
		FileInputStream tiedosto = new FileInputStream("Automaatti.xml");
		dec = new XMLDecoder(new BufferedInputStream(tiedosto));
		juomaAutomaatti luettu = (juomaAutomaatti) dec.readObject();
		System.out.println(luettu);

		// Lopputoimet
		dec.close();

		// Palautetaan tiedostosta luettu automaatti
		return luettu;
	

	}

}