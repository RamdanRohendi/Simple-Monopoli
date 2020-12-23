package mainMonopoli;

public class Petak {
	private String nama_petak;
	private int posisi;
	private int harga;
	private Boolean kepemilikan = false;
	private int pemilik = 4;
	private String komplek;
	
	public void setNama_petak(String nama_petak) {
		this.nama_petak = nama_petak;
	}
	
	public String getNama_petak() {
		return nama_petak;
	}
	
	public void setPosisi(int posisi) {
		this.posisi = posisi;
	}
	
	public int getPosisi() {
		return posisi;
	}

	public int getHarga() {
		return harga;
	}

	public void setHarga(int harga) {
		this.harga = harga;
	}
	
	public void setHarga(int harga, int pajak) {
		this.harga = harga + pajak;
	}

	public Boolean getKepemilikan() {
		return kepemilikan;
	}

	public void setKepemilikan(Boolean kepemilikan) {
		this.kepemilikan = kepemilikan;
	}

	public int getPemilik() {
		return pemilik;
	}

	public void setPemilik(int pemilik) {
		this.pemilik = pemilik;
	}

	public String getKomplek() {
		return komplek;
	}

	public void setKomplek(String komplek) {
		this.komplek = komplek;
	}
}
