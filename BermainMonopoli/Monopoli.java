package mainMonopoli;

import java.util.Scanner;

public class Monopoli {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		char main;
		int Jpemain;
		
		main = Mulai(in);
		System.out.println();
		loadPapan();
		if(main == 'y'|| main == 'Y') {
			Jpemain = JumlahPemain(in);
			
			pemain(pemain, in, Jpemain);
			System.out.println();
			
			for(;;) {
				for(int i = 0; i < 4; i++) {
					if(pemain[i].getStatusBankrut() == false) {
						if(pemain[i].getTahanan() == false) {
							PemainMulai(i);
							PemainBermain(i, in);
						}
						
						else if(pemain[i].getTahanan() == true) {
							PemainMulai(i);
							MainDipenjara(in, i);
						}
					}
					else if(pemain[i].getStatusBankrut() == true){
						cekMenang();
					}
				}
			}
		}
		else {
			System.out.println("Oke");
		}
	}
	
	static Papan mono = new Papan();
	static KartuPilihan Kp = new KartuPilihan();
	
	static int Dadu1;
	static int Dadu2;
	static int Jdadu;
	static int posisi = 0;
	static Boolean cek = false;
	static int ulang = 0;
	
	static Petak str, du1, lib, sud, rol1, jep, kes1, tur, yun, bul, 
	  pen, pol, rus, ukr, vat, spa, du2, lith, lat, est, 
	  bp, nor, swe, fin, kes2, as, rol2, jer, per, ing,
	  peng, kan, amrik, mek, du3, eng, kes3, qat, cin, paj;
	
	public static void loadPapan() {
		du1 = new KartuPilihan();
		du1.setNama_petak("Dana Umum");
		du1.setPosisi(1);
		
		lib = new Negara();
		lib.setNama_petak("Libya");
		lib.setPosisi(2);
		lib.setHarga(50);
		lib.setKomplek("A");
		
		sud = new Negara();
		sud.setNama_petak("Sudan");
		sud.setPosisi(3);
		sud.setHarga(60);
		sud.setKomplek("A");
	
		rol1 = new KartuPilihan();
		rol1.setNama_petak("Kesempatan/DanaUmum");
		rol1.setPosisi(4);
		
		jep = new Stasiun();
		jep.setNama_petak("St.Jepang");
		jep.setHarga(0);
		jep.setPosisi(5);
		jep.setKomplek("Stasiun");
		
		kes1 = new KartuPilihan();
		kes1.setNama_petak("Kesempatan");
		kes1.setPosisi(6);
		
		tur = new Negara();
		tur.setNama_petak("Turki");
		tur.setPosisi(7);
		tur.setHarga(100);
		tur.setKomplek("B");
		
		yun = new Negara();
		yun.setNama_petak("Yunani");
		yun.setPosisi(8);
		yun.setHarga(100);
		yun.setKomplek("B");
		
		bul = new Negara();
		bul.setNama_petak("Bulgaria");
		bul.setPosisi(9);
		bul.setHarga(120);
		bul.setKomplek("B");
		
		pen = new Penjara();
		pen.setNama_petak("Penjara");
		pen.setPosisi(10);
		
		pol = new Negara();
		pol.setNama_petak("Polandia");
		pol.setPosisi(11);
		pol.setHarga(150);
		pol.setKomplek("C");
		
		rus = new Negara();
		rus.setNama_petak("Rusia");
		rus.setPosisi(12);
		rus.setHarga(150);
		rus.setKomplek("C");
		
		ukr = new Negara();
		ukr.setNama_petak("Ukraina");
		ukr.setPosisi(13);
		ukr.setHarga(180);
		ukr.setKomplek("C");
		
		vat = new Negara();
		vat.setNama_petak("Vatikan");
		vat.setPosisi(14);
		vat.setHarga(0);
		vat.setKomplek("D");
		
		spa = new Stasiun();
		spa.setNama_petak("St.Spanol");
		spa.setHarga(50);
		spa.setPosisi(15);
		spa.setKomplek("Stasiun");
		
		du2 = new KartuPilihan();
		du2.setNama_petak("DanaUmum");
		du2.setPosisi(16);
		
		lith = new Negara();
		lith.setNama_petak("Lithuania");
		lith.setPosisi(17);
		lith.setHarga(200);
		lith.setKomplek("E");
		
		lat = new Negara();
		lat.setNama_petak("Latvia");
		lat.setPosisi(18);
		lat.setHarga(200);
		lat.setKomplek("E");
		
		est = new Negara();
		est.setNama_petak("Estonia");
		est.setPosisi(19);
		est.setHarga(220);
		est.setKomplek("E");
		
		bp = new BebasParkir();
		bp.setNama_petak("Bebas Parkir");
		bp.setPosisi(20);
		bp.setHarga(0);
		
		nor = new Negara();
		nor.setNama_petak("Norwegia");
		nor.setPosisi(21);
		nor.setHarga(220);
		nor.setKomplek("F");
		
		swe = new Negara();
		swe.setNama_petak("Swedia");
		swe.setPosisi(22);
		swe.setHarga(220);
		swe.setKomplek("F");
		
		fin = new Negara();
		fin.setNama_petak("Finlandia");
		fin.setPosisi(23);
		fin.setHarga(240);
		fin.setKomplek("F");
		
		kes2 = new KartuPilihan();
		kes2.setNama_petak("Kesempatan");
		kes2.setPosisi(24);
		
		as = new Stasiun();
		as.setNama_petak("St.As");
		as.setPosisi(25);
		as.setHarga(12);
		as.setKomplek("Stasiun");
		
		rol2 = new KartuPilihan();
		rol2.setNama_petak("Kesempatan/Dana Umum");
		rol2.setPosisi(26);
		
		jer = new Negara();
		jer.setNama_petak("Jerman");
		jer.setPosisi(27);
		jer.setHarga(280);
		jer.setKomplek("G");
		
		per = new Negara();
		per.setNama_petak("Perancis");
		per.setPosisi(28);
		per.setHarga(280);
		per.setKomplek("G");
		
		ing = new Negara();
		ing.setNama_petak("Inggris");
		ing.setPosisi(29);
		ing.setHarga(300);
		ing.setKomplek("G");
		
		peng = new MasukPenjara();
		peng.setNama_petak("Masuk Penjara");
		peng.setPosisi(30);
		
		kan = new Negara();
		kan.setNama_petak("Kanada");
		kan.setPosisi(31);
		kan.setHarga(300);
		kan.setKomplek("H");
		
		amrik = new Negara();
		amrik.setNama_petak("Amerika Serikat");
		amrik.setPosisi(32);
		amrik.setHarga(300);
		amrik.setKomplek("H");
		
		mek = new Negara();
		mek.setNama_petak("Meksiko");
		mek.setPosisi(33);
		mek.setHarga(320);
		mek.setKomplek("H");
		
		du3 = new KartuPilihan();
		du3.setNama_petak("Dana Umum");
		du3.setPosisi(34);
		
		eng = new Stasiun();
		eng.setNama_petak("St.Inggris");
		eng.setHarga(50);
		eng.setPosisi(35);
		eng.setKomplek("Stasiun");
		
		kes3 = new KartuPilihan();
		kes3.setNama_petak("Kesempatan");
		kes3.setPosisi(36);
		
		qat = new Negara();
		qat.setNama_petak("Qatar");
		qat.setPosisi(37);
		qat.setHarga(360);
		qat.setKomplek("I");
		
		cin = new Negara();
		cin.setNama_petak("Cina");
		cin.setPosisi(38);
		cin.setHarga(400);
		cin.setKomplek("I");
		
		paj = new PajakJalan();
		paj.setNama_petak("Pajak Jalan");
		paj.setPosisi(39);
		
		str = new Start();
		str.setNama_petak("START");
		str.setPosisi(0);
		
		mono.tambah_petak(str);
		mono.tambah_petak(du1);
		mono.tambah_petak(lib);
		mono.tambah_petak(sud);
		mono.tambah_petak(rol1);
		mono.tambah_petak(jep);
		mono.tambah_petak(kes1);
		mono.tambah_petak(tur);
		mono.tambah_petak(yun);
		mono.tambah_petak(bul);
		mono.tambah_petak(pen);
		mono.tambah_petak(pol);
		mono.tambah_petak(rus);
		mono.tambah_petak(ukr);
		mono.tambah_petak(vat);
		mono.tambah_petak(spa);
		mono.tambah_petak(du2);
		mono.tambah_petak(lith);
		mono.tambah_petak(lat);
		mono.tambah_petak(est);
		mono.tambah_petak(bp);
		mono.tambah_petak(nor);
		mono.tambah_petak(swe);
		mono.tambah_petak(fin);
		mono.tambah_petak(kes2);
		mono.tambah_petak(as);
		mono.tambah_petak(rol2);
		mono.tambah_petak(jer);
		mono.tambah_petak(per);
		mono.tambah_petak(ing);
		mono.tambah_petak(peng);
		mono.tambah_petak(kan);
		mono.tambah_petak(amrik);
		mono.tambah_petak(mek);
		mono.tambah_petak(du3);
		mono.tambah_petak(eng);
		mono.tambah_petak(kes3);
		mono.tambah_petak(qat);
		mono.tambah_petak(cin);
		mono.tambah_petak(paj);
	}
	
	static Pemain[] pemain = new Pemain[5];
	
	static void PemainMulai(int main) {
		System.out.println("=============Giliran=============");
		System.out.println("--> " + pemain[main].getNama());
		System.out.println("=================================");
		System.out.println();
	}
	
	static void PemainBermain(int i, Scanner in) {
		do {
			posisi = pemain[i].getPosisi();
			System.out.println("Nama Pemain   : " + pemain[i].getNama());
			System.out.println("Posisi awal   : " + posisi);
			System.out.println("Uang Pemain   : " + pemain[i].getUang());
			System.out.println("Di Petak      : " + mono.daftar_petak.get(posisi).getNama_petak());
			System.out.println("Gulirkan Dadu");
			System.out.print("Ketik sesuatu ");in.next();
			System.out.println();
			Dadu1 = pemain[i].AngkaDadu1();
			Dadu2 = pemain[i].AngkaDadu2();
			Jdadu = pemain[i].lemparDadu(Dadu1, Dadu2);
			pemain[i].setPosisi(posisi += Jdadu);
			
			System.out.println("Angka dadu 1  : " + Dadu1);
			System.out.println("Angka dadu 2  : " + Dadu2);
			System.out.println("Jumlah Dadu   : " + Jdadu);
			posisi = pemain[i].getPosisi();
			pemain[i].setPosisi(cekPosisi(in, i, posisi));
			posisi = pemain[i].getPosisi();
			
			if (pemain[i].getUang() < 0) {
				System.out.println("Uang anda     : " + pemain[i].getUang());
			}
			System.out.println("Posisi akhir  : " + pemain[i].getPosisi());
			System.out.println("Di Petak      : " + mono.daftar_petak.get(posisi).getNama_petak());
			if(cekTanahBerharga(i) == true)System.out.println("Harga Petak   : " + mono.daftar_petak.get(posisi).getHarga());
			
			cek = pemain[i].cekGanda(Dadu1, Dadu2) == true ? true : false;
			if(cek == true) {System.out.println("Dadu Ganda !!! \nSilahkan main lagi :)\n"); ulang+=1;}
			if(ulang == 3) {
				pemain[i].setPosisi(10);
				posisi = pemain[i].getPosisi();
				pemain[i].setTahanan(true);
				System.out.println("Anda dipenjara !!!");
				cek = false;
			}
			if(cek == false)Pilihan(i, in);
			if(pemain[i].getUang() < 0) {
				System.out.println("Anda bankrut :(");
				pemain[i].setStatusBankrut(true);
			}
		}while(cek == true);
		ulang = 0;
		System.out.println("Uang          : " + pemain[i].getUang());
		System.out.println("Giliran anda selesai");
		System.out.print("Ketik y : ");
		in.next();
		System.out.println();
	}
	
	static void MainDipenjara(Scanner in, int i) {
		System.out.println("Anda berada di Penjara !!!");
		System.out.print("Bayar $500 atau tidak (y/t)? ");
		char bayar = in.next().charAt(0);
		if(bayar == 'y' || bayar == 'Y') {
			pemain[i].setTahanan(false);
			pemain[i].setUang(pemain[i].getUang()-500);
			System.out.println("Anda Bebas :)");
			System.out.println();		
			PemainBermain(i, in);
		}
		else {
			do {
				Dadu1 = pemain[i].AngkaDadu1();
				Dadu2 = pemain[i].AngkaDadu2();
				System.out.println("Silahkan Gulirkan Dadu");
				System.out.println("Bila Ganda anda bebas");
				System.out.print("Ketik sesuatu ");in.next();
				System.out.println();
				cek = pemain[i].cekGanda(Dadu1, Dadu2) == true ? true : false;
				if(cek == true) {
					pemain[i].setTahanan(false);
					System.out.println("Dadu Ganda !!! \nAnda bebas :)");
					PemainBermain(i, in);
				}
				else {
					ulang += 1;
				}
				System.out.println("Dadu 1 : " + Dadu1);
				System.out.println("Dadu 2 : " + Dadu2);
			}while(cek != true && ulang < 4);
			System.out.println();
		}
	}
	
	static Boolean cekTanahBerharga(int i) {
		if(pemain[i].getPosisi() == 0 || 
		   pemain[i].getPosisi() == 1 || 
		   pemain[i].getPosisi() == 4 || 
		   pemain[i].getPosisi() == 6 || 
		   pemain[i].getPosisi() == 10 || 
		   pemain[i].getPosisi() == 16 || 
		   pemain[i].getPosisi() == 20 || 
		   pemain[i].getPosisi() == 24 || 
		   pemain[i].getPosisi() == 26 || 
		   pemain[i].getPosisi() == 30 || 
		   pemain[i].getPosisi() == 34 || 
		   pemain[i].getPosisi() == 36 ||
		   pemain[i].getPosisi() == 39) {
			return false;
		}
		return true;
	}
	
	static void Pilihan(int i, Scanner in) {
		char lagi = 't';
		char akhiri = 't';
		do {
			System.out.println("Pilihan : ");
			if(cekTanahBerharga(i) == true && mono.daftar_petak.get(pemain[i].getPosisi()).getKepemilikan() != true) {
				System.out.println("1. Beli Petak");
			}
			System.out.println("2. Lihat Assets");
			System.out.println("3. Jual Assets");
			System.out.println("4. Akhiri giliran");
			System.out.println("5. Beli Rumah/Hotel");
			System.out.println("6. Jual Rumah/Hotel");
			System.out.print("Masukan pilihan anda : ");
			int pilih = in.nextInt();
			System.out.println();
			switch (pilih) {
			case 1:
				System.out.println("Anda Membeli Petak");
				pemain[i].jualBeli(i, "beli");
				break;
			
			case 2:
				System.out.println("Anda Melihat Petak");
				pemain[i].lihatassets(i);
				break;
			
			case 3:
				System.out.println("Anda Menjual Petak");
				pemain[i].jualBeli(i, "jual");
				break;
			case 4:
				akhiri = 'y';
				break;
			
			case 5:
				pemain[i].beliRatauH(i);
				break;
			
			case 6:
				pemain[i].jualRatauH(i);
				break;
				
			default:
				break;
			}
			
			if(akhiri != 'y') {
				System.out.print("Pilih lagi (y/t)? ");
				lagi = in.next().charAt(0);
				System.out.println();
			}
			else {
				lagi = 't';
			}
		}while(lagi == 'y' || lagi == 'Y');
	}
	
	static void BayarSewa(Scanner in, int i, int posisi) {
		System.out.print("Bayar (y/t) ? ");
		char Bayar = in.next().charAt(0);
		
		if( Bayar == 'y' || Bayar == 'Y' ) {
			if(pemain[i].getUang() < mono.daftar_petak.get(posisi).getHarga() ) {
				System.out.println("Uang anda kurang");
				System.out.print("Ingin menjual kota (y/t) ? ");
				char ingin = in.next().charAt(0);
				
				if (ingin == 'y' || ingin == 'Y') {
					pemain[i].jualBeli(i, "jual");
				}
				else {
					System.out.println("Anda tidak bisa kabur");
					System.out.println("Harus bayar");
					System.out.println("Walaupun ngutang");
					pemain[i].setUang(pemain[i].getUang() - mono.daftar_petak.get(posisi).getHarga() + 50);
					System.out.println("Uang anda : " + pemain[i].getUang());
				}
			}
			else {
				pemain[i].setUang(pemain[i].getUang() - (mono.daftar_petak.get(posisi).getHarga() + 50 ));
				pemain[mono.daftar_petak.get(posisi).getPemilik()].setUang(
						pemain[mono.daftar_petak.get(posisi).getPemilik()].getUang() + 
						(mono.daftar_petak.get(posisi).getHarga() + 50 ));
				System.out.println(pemain[mono.daftar_petak.get(posisi).getPemilik()].getNama() + " mendapat uang $" + 
								  (mono.daftar_petak.get(posisi).getHarga() + 50 ));
				System.out.println("Uang anda : " + pemain[i].getUang());
			}
		}
		else {
			System.out.println("Anda tidak bisa kabur");
			System.out.println("Harus bayar");
			System.out.println("Walaupun ngutang");
			pemain[i].setUang(pemain[i].getUang() - mono.daftar_petak.get(posisi).getHarga() + 50);
			System.out.println("Uang anda : " + pemain[i].getUang());
		}
	}
	
	static int cekPosisi(Scanner in, int i, int posisi) {
		if(posisi >= 40) {
			pemain[i].setPosisi(posisi - 40);
			if(pemain[i].getPosisi() == 0) {
				return posisi = pemain[i].getPosisi();
			}
			
			else {
				pemain[i].setUang(pemain[i].getUang() + 200);
				System.out.println("Anda Melewati START !!!");
				System.out.println("Dapat uang $200");
				System.out.println();
				cekPosisi(in, i, pemain[i].getPosisi());
			}
		}
		else if(posisi == 1) {
			System.out.println();
			System.out.println("Anda mendapat kartu : ");
			Kp.DanaUmum(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(mono.daftar_petak.get(pemain[i].getPosisi()).getKepemilikan() == true) {
			if(pemain[mono.daftar_petak.get(posisi).getPemilik()].getNama() != pemain[i].getNama()) {
				if(pemain[mono.daftar_petak.get(posisi).getPemilik()].getTahanan() != true) {
					System.out.println("Anda berada di  : " + mono.daftar_petak.get(pemain[i].getPosisi()).getNama_petak());
					System.out.println("Petak ini dimiliki oleh " + pemain[mono.daftar_petak.get(posisi).getPemilik()].getNama());
					System.out.println("Bayar Sewa = " + (mono.daftar_petak.get(posisi).getHarga() + 50));
					BayarSewa(in, i, posisi);
				}
			}
		}
		
		else if(posisi == 4) {
			System.out.println();
			System.out.println("Anda mendapat kartu : ");
			Kp.KesDu(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 6) {
			System.out.println();
			System.out.println("Anda mendapat kartu : ");
			Kp.Kesempatan(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 10) {
			System.out.println("Hanya Lewat");
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 16) {
			System.out.println("Anda mendapat kartu : ");
			Kp.DanaUmum(i);
			return posisi = pemain[i].getPosisi();
		}

		else if(posisi == 20) {
			if(bp.getHarga() != 0) {
				System.out.println("Selamat anda mendapat uang : " + bp.getHarga());
				pemain[i].setUang(pemain[i].getUang() + bp.getHarga());
			}
		}
		
		else if(posisi == 24) {
			System.out.println("Anda mendapat kartu : ");
			Kp.Kesempatan(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 26) {
			System.out.println("Anda mendapat kartu : ");
			Kp.KesDu(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 30) {
			System.out.println("Anda disidang");
			System.out.println("Masuk ke Penjara !!!");
			pemain[i].setTahanan(true);
			pemain[i].setPosisi(10);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 34) {
			System.out.println("Anda mendapat kartu : ");
			Kp.DanaUmum(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 36) {
			System.out.println("Anda mendapat kartu : ");
			Kp.Kesempatan(i);
			return posisi = pemain[i].getPosisi();
		}
		
		else if(posisi == 39) {
			System.out.println("Anda menginjak Pajak Jalan");
			System.out.println("Bayar $100");
			pemain[i].setUang(pemain[i].getUang() - 100);
			bp.setHarga(bp.getHarga(), 100);
			return posisi = pemain[i].getPosisi();
		}
		return posisi = pemain[i].getPosisi();
	}
	
	static void cekMenang() {
		if(pemain[1].getStatusBankrut() == true && 
		   pemain[2].getStatusBankrut() == true &&
		   pemain[3].getStatusBankrut() == true &&
		   pemain[4].getStatusBankrut() == true) {
			System.out.println("Selamat " + pemain[0].getNama());
			System.out.println("Anda Menang !!!");
			System.exit(0);
		}
				
		else if(pemain[2].getStatusBankrut() == true && 
				pemain[3].getStatusBankrut() == true &&
				pemain[0].getStatusBankrut() == true &&
				pemain[4].getStatusBankrut() == true) {
			System.out.println("Selamat " + pemain[1].getNama());
			System.out.println("Anda Menang !!!");
			System.exit(0);
		}
				
		else if(pemain[3].getStatusBankrut() == true && 
				pemain[0].getStatusBankrut() == true &&
				pemain[1].getStatusBankrut() == true &&
				pemain[4].getStatusBankrut() == true) {
			System.out.println("Selamat " + pemain[2].getNama());
			System.out.println("Anda Menang !!!");
			System.exit(0);
		}
				
		else if(pemain[0].getStatusBankrut() == true && 
				pemain[1].getStatusBankrut() == true &&
				pemain[2].getStatusBankrut() == true &&
				pemain[4].getStatusBankrut() == true) {
			System.out.println("Selamat " + pemain[3].getNama());
			System.out.println("Anda Menang !!!");
			System.exit(0);
		}
	}
	
	static char Mulai(Scanner in) {
		System.out.println("=================================");
		System.out.println("--------> Main Monopoli <--------");
		System.out.println("=================================");
		System.out.println();
		System.out.print("Mulai Bermain (y/t) ? ");
		char main = in.next().charAt(0);
		return main;
	}
	
	
	static int JumlahPemain(Scanner in) {
		System.out.print("Masukan Jumlah Pemain 2-4 : ");
		int jumlah = in.nextInt();
		
		if(jumlah >= 2 && jumlah <= 4) {
			return jumlah;
		}
		else {
			System.out.println("Jumlah Pemain minimal 2");
			System.out.println("Dan maksimal 4");
			System.out.println();
			JumlahPemain(in);
		}
		return 0;
	}
	
	
	static void pemain(Pemain[] pemain,Scanner in, int jPemain) {
		if(jPemain == 2) {
			pemain[2] = new Pemain(true);
			pemain[3] = new Pemain(true);
			pemain[4] = new Pemain(true);
			pemain[4].setNama("Bank");
			
			for(int a = 0; a < jPemain; a++) {
				System.out.print("Nama Pemain ke " + ( a+1 ) + " : ");
				String nama = in.next();
				
				pemain[a] = new Pemain(nama);
			}
		}
		
		else if(jPemain == 3) {
			pemain[3] = new Pemain(true);
			pemain[4] = new Pemain(true);
			pemain[4].setNama("Bank");
			
			for(int a = 0; a < jPemain; a++) {
				System.out.print("Nama Pemain ke " + ( a+1 ) + " : ");
				String nama = in.next();
				
				pemain[a] = new Pemain(nama);
			}
		}
		
		else {
			pemain[4] = new Pemain(true);
			pemain[4].setNama("Bank");
			
			for(int a = 0; a < pemain.length; a++) {
				System.out.print("Nama Pemain ke " + ( a+1 ) + " : ");
				String nama = in.next();
				
				pemain[a] = new Pemain(nama);
			}
		}
	}

}
