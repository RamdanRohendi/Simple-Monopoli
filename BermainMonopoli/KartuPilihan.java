package mainMonopoli;

import java.util.Random;

public class KartuPilihan extends Petak {
	
	public void setNama_petak(String nama_petak) {
		super.setNama_petak(nama_petak);
	}

	public void setPosisi(int posisi) {
		super.setPosisi(posisi);
	}
	
	Random r = new Random();
	
	public void Kesempatan(int i) {
		int pilih = r.nextInt(3)+1;
		switch (pilih) {
		case 1:
			System.out.println("Anda Mendapatkan Hadiah $75");
			Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() + 75);
			break;
			
		case 2:
			System.out.println("Pergi ke Vatikan");
			Monopoli.pemain[i].setPosisi(14);
			break;
			
		case 3:
			System.out.println("Maju ke START");
			Monopoli.pemain[i].setPosisi(0);
			break;

		default:
			break;
		}
	}
	
	public void DanaUmum(int i) {
		int pilih = r.nextInt(3)+1;
		switch (pilih) {
		case 1:
			System.out.println("Mabuk di muka umum bayar $75");
			Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() - 75);
			break;
			
		case 2:
			System.out.println("Bayar uang sekolah $125");
			Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() - 125);
			break;
			
		case 3:
			System.out.println("Dapat Hadiah $150");
			Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() + 150);
			break;

		default:
			break;
		}
	}
	
	public void KesDu(int i) {
		int pilih = r.nextInt(2)+1;
		switch (pilih) {
		case 1:
			Kesempatan(i);
			break;

		case 2:
			DanaUmum(i);
			break;
			
		default:
			break;
		}
	}
}
