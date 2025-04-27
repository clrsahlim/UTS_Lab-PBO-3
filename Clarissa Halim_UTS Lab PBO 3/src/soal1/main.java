package soal1;

import java.util.List;
import java.util.Scanner;

public class main {
    private static Scanner scanner = new Scanner(System.in);
    private static Perusahaan perusahaan = new Perusahaan("PT Clarissa Jaya");

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            tampilkanMenu();
            System.out.print("Masukkan pilihan: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tambahKaryawan();
                    break;
                case "2":
                    hapusKaryawan();
                    break;
                case "3":
                    ubahPosisi();
                    break;
                case "4":
                    ubahGaji();
                    break;
                case "5":
                    menuCariKaryawanByTahunBergabung();
                    break;
                case "6":
                    menuCariKaryawanByDivisi();
                    break;
                case "7":
                    tampilkanSemuaKaryawan();
                    break;
                case "8":
                    menuHitungMasaKerja();
                    break;
                case "9":
                    menuPindahDivisi();
                    break;
                case "10":
                    running = false;
                    System.out.println("Program selesai. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
        scanner.close();
    }

    private static void tampilkanMenu() {
        System.out.println("\n=== SISTEM MANAJEMEN KARYAWAN ===");
        System.out.println("1. Tambah Karyawan");
        System.out.println("2. Hapus Karyawan");
        System.out.println("3. Ubah Posisi");
        System.out.println("4. Ubah Gaji");
        System.out.println("5. Cari Karyawan Berdasarkan Tahun Bergabung");
        System.out.println("6. Cari Karyawan Berdasarkan Divisi");
        System.out.println("7. Tampilkan Semua Karyawan");
        System.out.println("8. Hitung Masa Kerja Karyawan");
        System.out.println("9. Pindahkan Karyawan ke Divisi Lain");
        System.out.println("10. Keluar");
    }

    private static void tambahKaryawan() {
        System.out.print("Masukkan ID: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Posisi: ");
        String posisi = scanner.nextLine();
        System.out.print("Masukkan Gaji: ");
        double gaji = Double.parseDouble(scanner.nextLine());
        System.out.print("Masukkan Tanggal Bergabung (dd/MM/yyyy): ");
        String tanggalBergabung = scanner.nextLine();
        System.out.print("Masukkan Divisi: ");
        String divisi = scanner.nextLine();

        karyawan karyawanBaru = new karyawan(id, nama, posisi, gaji, tanggalBergabung, divisi);

        if (perusahaan.menambahKaryawan(karyawanBaru)) {
            System.out.println("Karyawan berhasil ditambahkan.");
        } else {
            System.out.println("Karyawan dengan ID tersebut sudah ada.");
        }
    }

    private static void hapusKaryawan() {
        System.out.print("Masukkan ID karyawan yang akan dihapus: ");
        String id = scanner.nextLine();

        if (perusahaan.menghapusKaryawan(id)) {
            System.out.println("Karyawan berhasil dihapus.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void ubahPosisi() {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan posisi baru: ");
        String posisiBaru = scanner.nextLine();

        if (perusahaan.ubahPosisiKaryawan(id, posisiBaru)) {
            System.out.println("Posisi berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }

    private static void ubahGaji() {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan gaji baru: ");
        double gajiBaru = Double.parseDouble(scanner.nextLine());

        if (perusahaan.ubahGajiKaryawan(id, gajiBaru)) {
            System.out.println("Gaji berhasil diubah.");
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan atau gaji tidak valid.");
        }
    }

    private static void tampilkanSemuaKaryawan() {
        List<karyawan> daftarKaryawan = perusahaan.tampilkanKaryawan();
        if (daftarKaryawan.isEmpty()) {
            System.out.println("Tidak ada karyawan yang terdaftar.");
            return;
        }

        for (karyawan k : daftarKaryawan) {
            System.out.println(k);
        }
    }

    private static void menuCariKaryawanByDivisi() {
        System.out.print("Masukkan nama divisi: ");
        String divisi = scanner.nextLine();

        List<karyawan> hasilPencarian = perusahaan.cariKaryawanByDivisi(divisi);
        
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ada karyawan di divisi " + divisi);
            return;
        }

        System.out.println("\nDaftar Karyawan di Divisi " + divisi + ":");
        for (karyawan k : hasilPencarian) {
            System.out.println(k);
        }
    }

    private static void menuCariKaryawanByTahunBergabung() {
        System.out.print("Masukkan tahun bergabung: ");
        int tahunBergabung = Integer.parseInt(scanner.nextLine()); // Fixed: parse string to int
        
        List<karyawan> hasilPencarian = perusahaan.cariKaryawanByTahunBergabung(tahunBergabung);
        
        if (hasilPencarian.isEmpty()) {
            System.out.println("Tidak ada karyawan yang bergabung pada tahun " + tahunBergabung); // Fixed: reference tahunBergabung instead of divisi
            return;
        }
        
        System.out.println("\nDaftar Karyawan yang bergabung pada tahun " + tahunBergabung + ":"); // Fixed: reference tahunBergabung
        for (karyawan k : hasilPencarian) { 
            System.out.println(k);
        }
    }

    private static void menuHitungMasaKerja() {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();

        String masaKerja = perusahaan.hitungMasaKerja(id);
        if (masaKerja == null) {
            System.out.println("Karyawan tidak ditemukan atau tanggal bergabung belum diisi.");
        } else {
            karyawan k = perusahaan.cariKaryawanbyID(id);
            System.out.println("Karyawan " + k.getNama() + " telah bekerja selama " + masaKerja);
        }
    }

    private static void menuPindahDivisi() {
        System.out.print("Masukkan ID karyawan: ");
        String id = scanner.nextLine();
        System.out.print("Masukkan divisi tujuan: ");
        String divisiTujuan = scanner.nextLine();

        if (perusahaan.pindahDivisi(id, divisiTujuan)) {
            System.out.println("Karyawan berhasil dipindahkan ke divisi " + divisiTujuan);
        } else {
            System.out.println("Karyawan dengan ID tersebut tidak ditemukan.");
        }
    }
}