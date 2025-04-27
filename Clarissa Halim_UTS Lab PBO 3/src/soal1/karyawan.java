package soal1;

import java.text.NumberFormat;
import java.util.Locale;

public class karyawan {
    private String ID;
    private String Nama;
    private String Posisi;
    private double Gaji;
    private String Tanggal_Bergabung;
    private String Divisi;


    public karyawan(String ID, String Nama, String Posisi, double Gaji, String Tanggal_Bergabung, String Divisi) {
        this.ID = ID;
        this.Nama = Nama;
        this.Posisi = Posisi;
        this.Gaji = Gaji;
        this.Tanggal_Bergabung = Tanggal_Bergabung;
        this.Divisi = Divisi;
    }

    public String getID(){
        return ID;
    }

    public String getNama(){
        return Nama;
    }

    public String getPosisi(){
        return Posisi;
    }

    public double getGaji (){
        return Gaji;
    }

    public String getTanggalBergabung (){
        return Tanggal_Bergabung;
    }

    public String getDivisi (){
        return Divisi;
    }

    public void setGaji (double Gaji){
        if (Gaji < 0) {
            System.out.println("Gaji tidak boleh negatif");
            return;
        }
        this.Gaji = Gaji;
    }

    public void setPosisi (String Posisi){
        this.Posisi = Posisi;
    }

    public void setTanggalBergabung(String Tanggal_Bergabung) {
        this.Tanggal_Bergabung = Tanggal_Bergabung;
    }

    public void setDivisi(String Divisi) {
        this.Divisi = Divisi;
    }

    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getNumberInstance(new Locale("id", "ID"));
        nf.setMaximumFractionDigits(1);
        
        return "ID: " + ID + ", Nama: " + Nama + ", Posisi: " + Posisi + 
            ", Gaji: Rp " + nf.format(Gaji) + ", Divisi: " + Divisi;
    }

}


