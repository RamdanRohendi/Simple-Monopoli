package mainMonopoli;

import java.util.Random;
import java.util.*;
import java.util.ArrayList;

public class Pemain {
	private int uang = 150;
	private ArrayList<Integer> AssetsKu = new ArrayList<Integer>();
	private int posisi;
	private String Nama;
	private Boolean tahanan = false;
	private Boolean statusBankrut = false;
	private int rumah = 0;
	private int hotel = 0;
	Dadu dd = new Dadu();
	Random r = new Random();
	
	Pemain(String nama){
		this.Nama = nama;
	}
	
	Pemain(Boolean status){
		this.setStatusBankrut(status);
	}
	
	public void jualBeli(int i, String pilihan) {
		if(pilihan == "beli") {
			if(Monopoli.pemain[i].getUang() < Monopoli.mono.daftar_petak.get(Monopoli.pemain[i].getPosisi()).getHarga()) {
				System.out.println("Maaf uang anda kurang");
			}
			else {
				Monopoli.mono.daftar_petak.get(Monopoli.pemain[i].getPosisi()).setPemilik(i);
				Monopoli.mono.daftar_petak.get(Monopoli.pemain[i].getPosisi()).setKepemilikan(true);
				AssetsKu.add(Monopoli.mono.daftar_petak.get(Monopoli.pemain[i].getPosisi()).getPosisi());
				Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() - Monopoli.mono.daftar_petak.get(Monopoli.pemain[i].getPosisi()).getHarga());
			}
		}
		else if(pilihan == "jual") {
			Scanner in = new Scanner(System.in);
			int banyak = AssetsKu.size();
			
			if (banyak == 0) {
				System.out.println("Anda tidak punya Assets");
			}
			else {
				System.out.println("Assets anda");
				System.out.println("0. Tidak jadi jual");
				for(int a = 0; a < banyak; a++) {
					System.out.println((a+1) + ". " + Monopoli.mono.daftar_petak.get(AssetsKu.get(a)).getNama_petak());
					System.out.println("   Harga = " + Monopoli.mono.daftar_petak.get(AssetsKu.get(a)).getHarga());
				}
				System.out.println();
				System.out.print("Pilih Asset yang dijual : ");
				int pilih = in.nextInt();
				if(pilih == 0) {
					System.out.println("Okelah");
				}
				else {
					Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() + Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getHarga());
					Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setPemilik(4);
					Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setKepemilikan(false);
					System.out.println("Asset anda terjual");
					AssetsKu.remove(pilih-1);
				}
			}
		}
	}
	
	public void lihatassets(int i) {
		int banyak = AssetsKu.size();
		
		if (banyak == 0) {
			System.out.println("Anda tidak punya Assets");
		}
		else {
			for(int a = 0; a < banyak; a++) {
				System.out.println("- " + Monopoli.mono.daftar_petak.get(AssetsKu.get(a)).getNama_petak());
			}
		}
	}

	public void beliRatauH(int i) {
		Scanner in = new Scanner(System.in);
		Komplek komp = new Komplek();
		int jKomplek = 0;
		int banyak = AssetsKu.size();
		Boolean pKomplek;
		
		if (banyak == 0) {
			System.out.println("Anda tidak punya Assets");
		}
		else {
			for(int a = 0; a < banyak; a++) {
				System.out.println((a+1) + ". " + Monopoli.mono.daftar_petak.get(AssetsKu.get(a)).getNama_petak());
			}
			System.out.println("Harga Rumah : $100");
			System.out.println("Harga Hotel : $300");
			System.out.print("Pilih Assets yang ingin dibuat R atau H : ");
			int pilih = in.nextInt();
			for (int j = 0; j < 40; j++) {
				if(Monopoli.mono.daftar_petak.get(j).getKepemilikan() == true) {
					if(Monopoli.pemain[Monopoli.mono.daftar_petak.get(j).getPemilik()].getNama() == Monopoli.pemain[i].getNama()) {
						if(Monopoli.mono.daftar_petak.get(j).getKomplek() == Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getKomplek()) {
							jKomplek += 1;
						}
						else {
							jKomplek = 0;
						}
					}
				}
			}
			if(jKomplek == 0) {
				System.out.println("Assets itu tidak bisa dibangun rumah");
				System.out.println("Mohon lengkapi kompleknya ( Komplek " + Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getKomplek() + " )");
				System.out.println("Agar bisa dibangun rumah");
				System.out.println();
			}
			else {
				if(rumah == 4 && hotel == 1) {
					System.out.println("Maaf anda tidak bisa membangun rumah/hotel");
					System.out.println("Karena sudah maksimum");
				}
				else if(rumah <= 4) {
					if(Monopoli.pemain[i].getUang() < 100) {
						System.out.println("Maaf uang anda kurang");
					}
					else {
						Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() - 100);
						rumah += 1;
						Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setHarga(Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getHarga() + 100);
						System.out.println("Selamat anda telah membangun rumah");
						System.out.println("Harga Assets ini naik $100");
					}
				}
				else if(rumah == 4) {
					if(Monopoli.pemain[i].getUang() < 300) {
						System.out.println("Maaf uang anda kurang");
					}
					else {
						hotel += 1;
						Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setHarga(Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getHarga() + 300);
						Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() - 300);
						System.out.println("Selamat anda telah membangun hotel");
					}
				}
			}
		}
	}
	
	public void jualRatauH(int i) {
		Scanner in = new Scanner(System.in);
		int banyak = AssetsKu.size();
		
		if (banyak == 0) {
			System.out.println("Anda tidak punya Assets");
		}
		else {
			for(int a = 0; a < banyak; a++) {
				System.out.println((a+1) + ". " + Monopoli.mono.daftar_petak.get(AssetsKu.get(a)).getNama_petak());
			}
			System.out.println("Harga Rumah : $100");
			System.out.println("Harga Hotel : $300");
			System.out.print("Pilih Assets yang R/H nya ingin dijual : ");
			int pilih = in.nextInt();
			if(rumah == 0 && hotel == 0) {
				System.out.println("Maaf tidak ada R/H di Assets itu");
			}
			else if(hotel == 1){
				Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() + 300);
				hotel -= 1;
				Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setHarga(Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getHarga() - 300);
				System.out.println("Hotel anda terjual");
			}
			else {
				Monopoli.pemain[i].setUang(Monopoli.pemain[i].getUang() + 100);
				rumah -= 1;
				Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).setHarga(Monopoli.mono.daftar_petak.get(AssetsKu.get(pilih-1)).getHarga() - 100);
				System.out.println("Rumah anda terjual");
			}
		}
	}
	
	public int getUang() {
		return uang;
	}

	public void setUang(int uang) {
		this.uang = uang;
	}

	public int getPosisi() {
		return posisi;
	}

	public void setPosisi(int posisi) {
		this.posisi = posisi;
	}

	public String getNama() {
		return Nama;
	}

	public void setNama(String Nama) {
		this.Nama = Nama;
	}
	
	public int AngkaDadu1() {
		dd.setAngka1(r.nextInt(6)+1);
		
		return dd.getAngka1();
	}
	
	public int AngkaDadu2() {
		dd.setAngka2(r.nextInt(6)+1);
		
		return dd.getAngka2();
	}

	public int lemparDadu(int dadu1, int dadu2) {
		return dadu1 + dadu2;
	}
	
	public Boolean cekGanda(int dadu1, int dadu2) {
		if(dadu1 == dadu2) {
			return true;
		}
		return false;
	}

	public Boolean getTahanan() {
		return tahanan;
	}

	public void setTahanan(Boolean tahanan) {
		this.tahanan = tahanan;
	}

	public Boolean getStatusBankrut() {
		return statusBankrut;
	}

	public void setStatusBankrut(Boolean statusBankrut) {
		this.statusBankrut = statusBankrut;
	}
	
}
