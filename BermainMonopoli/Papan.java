package mainMonopoli;

import java.util.ArrayList;

public class Papan {
	static ArrayList<Petak> daftar_petak;
	
	public Papan() {
		daftar_petak = new ArrayList<Petak>();
	}
	
	public void tambah_petak(Petak petak) {
		daftar_petak.add(petak);
	}
}
