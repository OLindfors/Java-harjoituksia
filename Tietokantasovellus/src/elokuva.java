
public class elokuva {

	private String ekuvaNimi;
	private String ohjaaja;
	private int vuosi;
	private String laji;

	public elokuva(String ekuvaNimi, String ohjaaja, int vuosi, String laji) {
		this.ekuvaNimi = ekuvaNimi;
		this.ohjaaja = ohjaaja;
		this.vuosi = vuosi;
		this.laji = laji;
	}

	public elokuva() {
		this.ekuvaNimi = "ei m‰‰ritelty";
		this.ohjaaja = "ei m‰‰ritelty";
		this.vuosi = 0;
		this.laji = "ei m‰‰ritelty";
	}

	public String getEkuvaNimi() {
		return ekuvaNimi;
	}

	public void setEkuvaNimi(String ekuvaNimi) {
		this.ekuvaNimi = ekuvaNimi;
	}

	public String getOhjaaja() {
		return ohjaaja;
	}

	public void setOhjaaja(String ohjaaja) {
		this.ohjaaja = ohjaaja;
	}

	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}

	public String getLaji() {
		return laji;
	}

	public void setLaji(String laji) {
		this.laji = laji;
	}

}
