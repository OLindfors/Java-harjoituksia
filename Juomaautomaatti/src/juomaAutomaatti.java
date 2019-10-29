
public class juomaAutomaatti {
	
	private int kahvia;
	private int teet�;
	private int kaakaota;
	
	public juomaAutomaatti() {
		this.kahvia = 50;
		this.teet� = 50;
		this.kaakaota = 50;
	}
	
	public juomaAutomaatti(int kahvi, int tee, int kaakao) {
		this.kahvia = kahvi;
		this.teet� = tee;
		this.kaakaota = kaakao;
	}
	
	public void valmistaKahvi() {	
		
		if (this.kahvia - 10 >= 0) {
			this.kahvia -= 10;
		
		System.out.print("Odota hetki, kahvisi valmistuu. ");
		System.out.println("Kahvia j�ljell� " + this.kahvia + " yksikk��.");
		}

		else
			System.out.println("Kahviyksik�it� liian v�h�n. S�ili� t�ytett�v� ensiksi.");	
	}
	public void valmistaTee() {
		
		if (this.teet� - 10 >= 0) {
			this.teet� -= 10;
		
		System.out.print("Odota hetki, teesi valmistuu. ");
		System.out.println("Teet� j�ljell� " + this.teet� + " yksikk��.");
		}

		else
			System.out.println("Teeyksik�it� liian v�h�n. S�ili� t�ytett�v� ensiksi.");
	}
	
	
	public void valmistaKaakao() {
		
		if (this.kaakaota - 10 >= 0) {
			this.kaakaota -= 10;
		
		System.out.print("Odota hetki, kaakaosi valmistuu. ");
		System.out.println("Kaakaota j�ljell� " + this.kaakaota + " yksikk��.");
		}

		else 
			System.out.println("Kaakaoyksik�it� liian v�h�n. S�ili� t�ytett�v� ensiksi.");	
	}

	public void valitseKahvi() {
		this.kahvia -= 10;
		
		System.out.println("Kahvia j�ljell�: " + this.kahvia + " Teet� j�ljell�: " + this.teet� + " Kaakaota j�ljell�: " + this.kaakaota +"\n");
	}
	
	
	public void valitseTee() {
		this.teet� -= 10;
		
		System.out.println("Kahvia j�ljell�: " + this.kahvia + " Teet� j�ljell�: " + this.teet� + " Kaakaota j�ljell�: " + this.kaakaota +"\n");
	}
	
	public void valitseKaakao() {
		this.kaakaota -= 10;
		
		System.out.println("Kahvia j�ljell�: " + this.kahvia + " Teet� j�ljell�: " + this.teet� + " Kaakaota j�ljell�: " + this.kaakaota +"\n");
	}
	
	public boolean onnistuuko() {
		boolean testi;
		int arpa = (int)(Math.random() * 100+1);
		//System.out.println(arpa);
		
		if (arpa > 25) {
			testi = true; 
		}
		else testi = false;
		
		return testi; 

	}
	
	public int getKahvia() {
		return kahvia;
	}

	public void setKahvia(int kahvia) {
		this.kahvia = kahvia;
	}
	
	public int getTeet�() {
		return teet�;
	}

	public void setTeet�(int teet�) {
		this.teet� = teet�;
	}

	public int getKaakaota() {
		return kaakaota;
	}

	public void setKaakaota(int kaakaota) {
		this.kaakaota = kaakaota;
	}

	@Override
	public String toString() {
		String juomaAutomaatti = "kahvia=" + kahvia + ", teet�=" + teet� + ", kaakaota=" + kaakaota;
		return juomaAutomaatti; 
	}

	
}
