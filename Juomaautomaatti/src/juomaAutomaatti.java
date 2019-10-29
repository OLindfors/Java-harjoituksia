
public class juomaAutomaatti {
	
	private int kahvia;
	private int teetä;
	private int kaakaota;
	
	public juomaAutomaatti() {
		this.kahvia = 50;
		this.teetä = 50;
		this.kaakaota = 50;
	}
	
	public juomaAutomaatti(int kahvi, int tee, int kaakao) {
		this.kahvia = kahvi;
		this.teetä = tee;
		this.kaakaota = kaakao;
	}
	
	public void valmistaKahvi() {	
		
		if (this.kahvia - 10 >= 0) {
			this.kahvia -= 10;
		
		System.out.print("Odota hetki, kahvisi valmistuu. ");
		System.out.println("Kahvia jäljellä " + this.kahvia + " yksikköä.");
		}

		else
			System.out.println("Kahviyksiköitä liian vähän. Säiliö täytettävä ensiksi.");	
	}
	public void valmistaTee() {
		
		if (this.teetä - 10 >= 0) {
			this.teetä -= 10;
		
		System.out.print("Odota hetki, teesi valmistuu. ");
		System.out.println("Teetä jäljellä " + this.teetä + " yksikköä.");
		}

		else
			System.out.println("Teeyksiköitä liian vähän. Säiliö täytettävä ensiksi.");
	}
	
	
	public void valmistaKaakao() {
		
		if (this.kaakaota - 10 >= 0) {
			this.kaakaota -= 10;
		
		System.out.print("Odota hetki, kaakaosi valmistuu. ");
		System.out.println("Kaakaota jäljellä " + this.kaakaota + " yksikköä.");
		}

		else 
			System.out.println("Kaakaoyksiköitä liian vähän. Säiliö täytettävä ensiksi.");	
	}

	public void valitseKahvi() {
		this.kahvia -= 10;
		
		System.out.println("Kahvia jäljellä: " + this.kahvia + " Teetä jäljellä: " + this.teetä + " Kaakaota jäljellä: " + this.kaakaota +"\n");
	}
	
	
	public void valitseTee() {
		this.teetä -= 10;
		
		System.out.println("Kahvia jäljellä: " + this.kahvia + " Teetä jäljellä: " + this.teetä + " Kaakaota jäljellä: " + this.kaakaota +"\n");
	}
	
	public void valitseKaakao() {
		this.kaakaota -= 10;
		
		System.out.println("Kahvia jäljellä: " + this.kahvia + " Teetä jäljellä: " + this.teetä + " Kaakaota jäljellä: " + this.kaakaota +"\n");
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
	
	public int getTeetä() {
		return teetä;
	}

	public void setTeetä(int teetä) {
		this.teetä = teetä;
	}

	public int getKaakaota() {
		return kaakaota;
	}

	public void setKaakaota(int kaakaota) {
		this.kaakaota = kaakaota;
	}

	@Override
	public String toString() {
		String juomaAutomaatti = "kahvia=" + kahvia + ", teetä=" + teetä + ", kaakaota=" + kaakaota;
		return juomaAutomaatti; 
	}

	
}
