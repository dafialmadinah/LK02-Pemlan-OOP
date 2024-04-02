
import java.util.*;

//MUHAMMAD RIZQULLAH ALMADINAH 235150707111041 TI-D

class kendaraan{
    public int jmlPenumpang;
    public String platNomor;
    public int kapasitasMax;
    public String nama;

    private Driver driver;
    penumpang [] penumpangs;
   
    kendaraan(int jmlPenumpang, String platNomor, int kapasitasMax){
        this.jmlPenumpang = jmlPenumpang;
        this.platNomor = platNomor;
        this.kapasitasMax = kapasitasMax;
        this.penumpangs = new penumpang[kapasitasMax];
    }
    void cekPenumpang(){
        System.out.println("penumpang saat ini ada " + this.jmlPenumpang);
    }
    void cekPenumpang(int kapasitasMax) {
        this.kapasitasMax = kapasitasMax;
        System.out.println("Penumpang saat ini ada " + this.jmlPenumpang + " dari " + this.kapasitasMax + " kapasitas maksimum");
    }
    void nambahPenumpang(int penumpangNaik){
        
        if (this.jmlPenumpang + penumpangNaik > kapasitasMax) {
            System.out.println("penumpang sudah penuh");
            cekPenumpang();
        }else this.jmlPenumpang+=penumpangNaik;
            System.out.println("penumpang berhasil bertambah");
            
            cekPenumpang();
            cekPenumpang(this.kapasitasMax);
        }
    void nambahPenumpang(String nama){

        if(this.jmlPenumpang < kapasitasMax){
            this.penumpangs [this.jmlPenumpang] = new penumpang(nama);
            this.jmlPenumpang++;
            System.out.println("penumpang bernama " + nama + " sudah naik");
        }else System.out.println("penumpang sudah penuh");

        cekPenumpang();
        cekPenumpang(this.kapasitasMax);
        }
    void penumpangTurun(int penumpangTurun){
       this.jmlPenumpang = this.jmlPenumpang - penumpangTurun;
       System.out.println("penumpang berhasil turun ");
       cekPenumpang();
    }
    void tambahDriver(Driver driver){
        this.driver = driver;
    }
    Driver getDriver(){
        return driver;
    }
}

class truk extends kendaraan{

    double muatan;
    truk(int jmlPenumpang, String platNomor, int kapasitasMax, double muatan){
        super(jmlPenumpang, platNomor, kapasitasMax);
        this.muatan = muatan;
    }
    void cekMuatan(){
        System.out.println("Berat muatan truknya " + this.muatan + " ton");
    }
    

}

class bus extends kendaraan{

    int cekToilet;
    bus(int jmlPenumpang, String platNomor, int kapasitasMax, int cekToilet){
        super(jmlPenumpang, platNomor, kapasitasMax);
        this.cekToilet = cekToilet;
    }
    void cekToilet(){
        
        if(this.cekToilet == 1){
            System.out.println("di dalam masih ada orang, silahkan tunggu");
        }else System.out.println("di dalam tidak ada orang, silahkan masuk");
    }
   
}

class penumpang {

    String nama;
    
    penumpang(String nama){
        this.nama = nama;
    }

}

class Driver {

    private String nama;

    Driver(String nama) {
        this.nama = nama;
    }

    String getNama() {
        return nama;
    }
}

public class Lk02Dafi {
    public static void main(String[] args) {

        kendaraan mobil = new kendaraan(0, "B 123 JOS", 7);
        Driver driver1 = new Driver("dafi");
        mobil.tambahDriver(driver1);
        
        bus trans7 = new bus(0, "KT 123 EI", 30, 1);
        Driver driver2 = new Driver("jaki");
        trans7.tambahDriver(driver2);

        truk sampah = new truk(0, "AB 123 CD", 4, 100);
        Driver driver3 = new Driver("eloh");
        sampah.tambahDriver(driver3);
        
        
        Scanner input = new Scanner (System.in);
        int pilih = 0;
       
        System.out.println("Masukkan kendaraan yang ingin dinaiki");
        String pilihKendaraan = input.nextLine();

        if(pilihKendaraan.equalsIgnoreCase("mobil")){
            
        while(pilih !=5){
            System.out.println("1. Naik");
            System.out.println("2. Turun");
            System.out.println("3. Cek penumpang");
            System.out.println("4. Lihat pengemudi mobil");
            System.out.println("5. selesai");

            System.out.println("pilih nomor yang tersedia");
            pilih = input.nextInt();

            switch (pilih) {
                case 1: 
                System.out.println("masukkan nama");
                mobil.nambahPenumpang(input.next());
                    break;

                case 2:
                    System.out.println("berapa orang yg turun ?");
                    int turun = input.nextInt();
                    mobil.penumpangTurun(turun);
                    break;
            
                case 3:
                mobil.cekPenumpang();
                break;

                case 4:
                System.out.println("Nama supir : " + mobil.getDriver().getNama());
                break;

                case 5:
                System.out.println("Terima Kasih");
                break;
            }
        }
    }else if (pilihKendaraan.equalsIgnoreCase("bus")){
        while(pilih !=6){
            System.out.println("1. Naik");
            System.out.println("2. Turun");
            System.out.println("3. Cek penumpang");
            System.out.println("4. Cek toilet");
            System.out.println("5. Lihat supir bus");
            System.out.println("6. selesai");

            System.out.println("pilih nomor yang tersedia");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                System.out.println("masukkan nama");
                trans7.nambahPenumpang(input.next());
                break;

                case 2:
                System.out.println("berapa orang yg turun ?");
                int turun = input.nextInt();
                trans7.penumpangTurun(turun);
                break;
            
                case 3:
                trans7.cekPenumpang();
                break;

                case 4:
                trans7.cekToilet();
                break;

                case 5:
                System.out.println("Nama supir : " + trans7.getDriver().getNama());
                break;

                case 6:
                System.out.println("Terima Kasih");
                break;
            }
        }
    }else if (pilihKendaraan.equalsIgnoreCase("truk")){
        while(pilih !=6){
            System.out.println("1. Naik");
            System.out.println("2. Turun");
            System.out.println("3. Cek penumpang");
            System.out.println("4. Cek muatan");
            System.out.println("5. Lihat supir truk");
            System.out.println("6. selesai");

            System.out.println("pilih nomor yang tersedia");
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                System.out.println("masukkan nama");
                sampah.nambahPenumpang(input.next());
                    break;

                case 2:
                    System.out.println("berapa orang yg turun ?");
                    int turun = input.nextInt();
                    sampah.penumpangTurun(turun);
            
                case 3:
                sampah.cekPenumpang();
                break;

                case 4:
                sampah.cekMuatan();
                break;

                case 5:
                System.out.println("Nama supir : " + mobil.getDriver().getNama());
                break;

                case 6:
                System.out.println("Terima Kasih");
                break;
                }
            }
        }       
        input.close();
    }
}

