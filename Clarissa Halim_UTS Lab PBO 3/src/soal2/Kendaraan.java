package soal2;

public class Kendaraan {
    private String jenisKendaraan;
    private int lamaParkir;
    private double biayaParkir;

    public Kendaraan(String jenisKendaraan, int lamaParkir) {
        this.jenisKendaraan = jenisKendaraan;
        this.lamaParkir = lamaParkir;
        hitungBiayaParkir();
    }

    public double hitungBiayaParkir(){
        double tarif = 0;

        if (jenisKendaraan.equalsIgnoreCase("Motor")){
            tarif = 2000;
        }
        else if (jenisKendaraan.equalsIgnoreCase("Mobil")){
            tarif = 5000;
        }
        else if (jenisKendaraan.equalsIgnoreCase("Truk")){
            tarif = 10000;
        }

        biayaParkir = tarif * lamaParkir;

        if (lamaParkir > 5){
            biayaParkir *= 0.9;
        }

        return biayaParkir;
    }

    public double hitungBiayaParkir (int jamMasuk, int jamKeluar){
        if (jamKeluar >= jamMasuk) {
            this.lamaParkir = jamKeluar - jamMasuk;
        } else {
            this.lamaParkir = (24 - jamMasuk) + jamKeluar;
        }

        return hitungBiayaParkir();
    }

    public void tampilkanRingkasan() {
        System.out.println("\n----- PARKING SUMMARY -----");
        System.out.printf("Vehicle Type\t: %s\n", jenisKendaraan);
        System.out.printf("Parking Time\t: %d hour(s)\n", lamaParkir);
        System.out.printf("Total Fee\t: Rp%.1f\n", biayaParkir);
        System.out.println();
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }
    
    public int getLamaParkir() {
        return lamaParkir;
    }
    
    public double getbiayaParkir() {
        return biayaParkir;
    }

}
