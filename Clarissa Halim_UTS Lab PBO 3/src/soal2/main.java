package soal2;

import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
        boolean lanjut = true;
        
        System.out.println("======== Welcome to ParkingChan ========\n");
        
        while (lanjut) {
            System.out.print("Enter vehicle type (Motor/Mobil/Truk) : ");
            String jenisKendaraan = scanner.next();
            
            System.out.print("Enter Duration (Manual/Time): ");
            String metodeDurasi = scanner.next();
            
            Kendaraan kendaraan;
            
            if (metodeDurasi.equalsIgnoreCase("Manual")) {
                System.out.print("Enter Duration (in hour): ");
                int lamaParkir = scanner.nextInt();

                kendaraan = new Kendaraan(jenisKendaraan, lamaParkir);
            } else {
                System.out.print("Enter entry time  : ");
                int jamMasuk = scanner.nextInt();
                System.out.print("Enter exit time   : ");
                int jamKeluar = scanner.nextInt();
                
                kendaraan = new Kendaraan(jenisKendaraan, 0); // Initial duration 0
                kendaraan.hitungBiayaParkir(jamMasuk, jamKeluar);
            }

            kendaraan.tampilkanRingkasan();
            
            daftarKendaraan.add(kendaraan);
            
            System.out.print("Add another vehicle? (y/n): ");
            String jawaban = scanner.next();
            lanjut = jawaban.equalsIgnoreCase("y");
            System.out.println();
        }

        double totalBiaya = 0;
        for (Kendaraan k : daftarKendaraan) {
            totalBiaya += k.getbiayaParkir();
        }
        
        System.out.println("======== FINAL REPORT ========");
        System.out.printf("Total Vehicle Final\t: %d\n", daftarKendaraan.size());        
        System.out.printf("Total Parking Fees Final\t: %.1f\n", totalBiaya);
        System.out.println("Thank You.....");
        
        scanner.close();
    }
}