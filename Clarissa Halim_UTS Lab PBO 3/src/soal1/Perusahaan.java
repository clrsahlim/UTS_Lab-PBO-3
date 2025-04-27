package soal1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Perusahaan {
    private String Nama;
    private List<karyawan> DaftarKaryawan;

    public Perusahaan(String Nama) {
        this.Nama = Nama;
        this.DaftarKaryawan = new ArrayList<>(); 
    }

    public Perusahaan() {
        this("Perusahaan Default");
    }

    public String getNama() {
        return Nama;
    }

    public boolean menambahKaryawan (karyawan Karyawan){
        if (cariKaryawanbyID(Karyawan.getID()) != null){
            return false;
        }
        DaftarKaryawan.add (Karyawan);
        return true;
    }

    public boolean menghapusKaryawan (String ID){
        karyawan Karyawan = cariKaryawanbyID(ID);
        if (Karyawan == null){
            return false;
        }
        DaftarKaryawan.remove(Karyawan);
        return true;
    }

    public karyawan cariKaryawanbyID (String ID){
        for (karyawan k : DaftarKaryawan){
            if (k.getID().equals(ID)){
                return k;
            }
        }
        return null;
    }

    public boolean ubahPosisiKaryawan(String ID, String posisiBaru) {
        karyawan Karyawan = cariKaryawanbyID(ID);
        if (Karyawan == null) {
            return false; // Employee not found
        }
        Karyawan.setPosisi(posisiBaru);
        return true;
    }

    public boolean ubahGajiKaryawan(String ID, double gajiBaru) {
        if (gajiBaru < 0) {
            return false; // Invalid salary
        }
        
        karyawan Karyawan = cariKaryawanbyID(ID);
        if (Karyawan == null) {
            return false; // Employee not found
        }
        Karyawan.setGaji(gajiBaru);
        return true;
    }

    public List<karyawan> tampilkanKaryawan (){
        return new ArrayList<>(DaftarKaryawan);
    }

    public String hitungMasaKerja(String ID) {
        karyawan Karyawan = cariKaryawanbyID(ID);
        if (Karyawan == null || Karyawan.getTanggalBergabung() == null) {
            return null;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date tanggalBergabung = sdf.parse(Karyawan.getTanggalBergabung());
            Date tanggalSekarang = new Date();
            
            Calendar calBergabung = Calendar.getInstance();
            calBergabung.setTime(tanggalBergabung);
            
            Calendar calSekarang = Calendar.getInstance();
            calSekarang.setTime(tanggalSekarang);
            
            int tahun = calSekarang.get(Calendar.YEAR) - calBergabung.get(Calendar.YEAR);
            int bulan = calSekarang.get(Calendar.MONTH) - calBergabung.get(Calendar.MONTH);
            
            if (bulan < 0) {
                tahun--;
                bulan += 12;
            }
            
            return tahun + " tahun " + bulan + " bulan";
        } catch (ParseException e) {
            return "Format tanggal tidak valid";
        }
    }

    public List<karyawan> cariKaryawanByDivisi(String divisi) {
        List<karyawan> hasil = new ArrayList<>();
        for (karyawan k : DaftarKaryawan) {
            if (k.getDivisi() != null && k.getDivisi().equalsIgnoreCase(divisi)) {
                hasil.add(k);
            }
        }
        return hasil;
    }

    public List<karyawan> cariKaryawanByTahunBergabung(int tahun) {
        List<karyawan> hasil = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        for (karyawan k : DaftarKaryawan) {
            if (k.getTanggalBergabung() != null) {
                try {
                    Date tanggalBergabung = sdf.parse(k.getTanggalBergabung());
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(tanggalBergabung);
                    
                    if (cal.get(Calendar.YEAR) == tahun) {
                        hasil.add(k);
                    }
                } catch (ParseException e) {
                }
            }
        }
        return hasil;
    }

    public boolean pindahDivisi(String idKaryawan, String divisiTujuan) {
        karyawan karyawan = cariKaryawanbyID(idKaryawan);
        if (karyawan == null) {
            return false;
        }
        
        String divisiLama = karyawan.getDivisi();
        karyawan.setDivisi(divisiTujuan);
        
        System.out.println("Karyawan " + karyawan.getNama() + " dipindahkan dari divisi " + 
                           (divisiLama != null ? divisiLama : "belum ditentukan") + 
                           " ke divisi " + divisiTujuan);
        return true;
    }
    
}
