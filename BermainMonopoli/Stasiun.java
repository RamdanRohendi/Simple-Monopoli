package mainMonopoli;

public class Stasiun extends Petak implements PetakBerharga {
	public void setPemilik(int pemilik) {
		super.setPemilik(pemilik);
	}
	
	public void setKepemilikan(Boolean kepemilikan) {
		super.setKepemilikan(kepemilikan);
	}

	public void setHarga(int harga) {
		super.setHarga(harga);
	}

	public void setNama_petak(String nama_petak) {
		super.setNama_petak(nama_petak);
	}

	public void setPosisi(int posisi) {
		super.setPosisi(posisi);
	}

}