
package aplikasi_berbasis_CLI;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class aplikasiPointOfSale {
    public static void main(String[] args) {
        ArrayList<Barang> tabeldariFile = readTabelBarangFromFile("FileDataBarang.txt");
        ArrayList<Barang> tabelBarang = new ArrayList<>();
        if(tabeldariFile != null){
            tabelBarang = tabeldariFile;
        }
        ArrayList<Transaksi> tabelTransaksiFromFile = readTabelTransaksiFromFile("TabelTransaksi.txt");
        ArrayList<Transaksi> tabelTransaksi = new ArrayList<>();
        if(tabelTransaksiFromFile != null){
            tabelTransaksi = tabelTransaksiFromFile;
        }
        Scanner sc = new Scanner (System.in);
        
        System.out.println("+--------------------------------------------------------------+");
        System.out.println("+           SELAMAT  DATANG  DI KASIR TOKO ANUGRAH             +");
        System.out.println("+--------------------------------------------------------------+");
        
        boolean run = true;
        int Id = 0;
        while(run){
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("+  MENU :                                                      +");
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("+  [a]. View Data Barang                                       +");
            System.out.println("+  [b]. Tambah Data Barang                                     +");
            System.out.println("+  [c]. Remove Data Barang                                     +");
            System.out.println("+  [d]. Penjualan                                              +");
            System.out.println("+  [e]. Save Data Barang                                       +");
            System.out.println("+  [f]. Exit                                                   +");
            System.out.println("+--------------------------------------------------------------+");
            System.out.print(" >>Pilih menu\t: ");
            String menu = sc.nextLine();
            // MENU A
            if(menu.equalsIgnoreCase("a")){
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+ Id\tNama Barang\tStock\tHarga\t\tTerjual       +");
                System.out.println("+--------------------------------------------------------------+");
                for(Barang Read : tabelBarang){
                System.out.println(Read);
                } 
            }
            //MENU B
            else if(menu.equalsIgnoreCase("b")){
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+                     TAMBAH DATA BARANG                       +");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println("+  [i]  Tambah Barang                                          +");
                System.out.println("+  [ii] Tambah Stock Barang                                    +");
                System.out.println("+--------------------------------------------------------------+");
                System.out.println(" >>Masukkan Pilihan anda\t: ");
                String pilhan_b = sc.nextLine();
                if(pilhan_b.equalsIgnoreCase("i")){
                    System.out.print(" >>Apakah anda ingin melanjutkan y/t \t: ");
                    String lanjut = sc.nextLine();
                    if(lanjut.equalsIgnoreCase("y")){
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println("+                          TAMBAH BARANG                       +");
                        System.out.println("+--------------------------------------------------------------+");
                        Id++;
                        System.out.println(" >>Masukkan Nama Barang\t: ");
                        String Nama_Barang = sc.nextLine();
                        System.out.println(" >>Masukkan Stock Barang\t: ");
                        String strstock = sc.nextLine();
                        int Stock = Integer.parseInt(strstock);
                        System.out.println(" >>Masukkan harga barang\t: ");
                        String strharga = sc.nextLine();
                        double Harga = Integer.parseInt(strharga);
                        Barang barang = new Barang(Id, Nama_Barang, Stock, Harga);
                        tabelBarang.add(barang);
                    }else if (lanjut.equalsIgnoreCase("t")){
                        break;
                    }else{
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println("+              PILIHAN ANDA TIDAK TESEDIA                      +");
                        System.out.println("+                     ANDA BUTUH AQUA?                         +");
                        System.out.println("+--------------------------------------------------------------+");
                    }
                }if(pilhan_b.equalsIgnoreCase("ii")){
                    System.out.print(" >>Apakah anda ingin melanjutkan y/t \t: ");
                    String lanjut = sc.nextLine();
                    if(lanjut.equalsIgnoreCase("y")){
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println("+                    TAMBAH  STOCK BARANG                      +");
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println(" >> Masukkan ID Barang\t:");
                        String kodeID = sc.nextLine();
                        int idID = Integer.parseInt(kodeID);
                        Barang barang = tabelBarang.get(idID-1);
                        System.out.print(" >> Masukkan Stock barang terbaru\t: ");
                        String updateStock = sc.nextLine();
                        int update = Integer.parseInt(updateStock);
                        barang.Stock = update;
                    }else if(lanjut.equalsIgnoreCase("t")){
                        break;
                    }else{
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println("+              PILIHAN ANDA TIDAK TESEDIA                      +");
                        System.out.println("+                     ANDA BUTUH AQUA?                         +");
                        System.out.println("+--------------------------------------------------------------+");
                    }
                }
                //Menu c
            }else if (menu.equalsIgnoreCase("c")){
                System.out.println(" >> Apakah anda ingin menghapus data barang y/t\t: ");
                String hapus =  sc.nextLine();
                if (hapus.equalsIgnoreCase("y")){
                    System.out.println(" >> Masukkan ID barang yang ingin dihapus\t:");
                    String removeID = sc.nextLine();
                    int Idremove = Integer.parseInt(removeID);
                    Barang barang = tabelBarang.remove(Idremove-1);
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+              HAPUS DATA BARANG BERHASIL                      +");
                    System.out.println("+--------------------------------------------------------------+");    
                }
            }  //MENU F
            else if(menu.equalsIgnoreCase("f")){
                System.out.println(" >> Apakah anda ingin keluar y/t\t: ");
                String out = sc.nextLine();
                if(out.equalsIgnoreCase("y")){
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+             PROSES INPUTAN TELAH BERAKHIR                    +");
                    System.out.println("+                      TERIMAKASIH                             +");
                    System.out.println("+--------------------------------------------------------------+");
                    run = false;
                }else if(out.equalsIgnoreCase("t")){
                    break;
                }else{
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+              PILIHAN ANDA TIDAK TESEDIA                      +");
                    System.out.println("+                     ANDA BUTUH AQUA?                         +");
                    System.out.println("+--------------------------------------------------------------+");
                }
            //MENU E
            }else if(menu.equalsIgnoreCase("e")){
                System.out.println(" >> Apakah anda ingin menyimpan file y/t\t: ");
                String Save = sc.nextLine();
                if(Save.equalsIgnoreCase("y")){
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+           DATA BERHASIL DISIMPAN KEDALAM FILE                +");
                    System.out.println("+--------------------------------------------------------------+");
                    saveTabelBarangToFile(tabelBarang, "FileDataBarang.txt");
                }else if(Save.equalsIgnoreCase("t")){
                    break;
                }else{
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+              PILIHAN ANDA TIDAK TESEDIA                      +");
                    System.out.println("+                     ANDA BUTUH AQUA?                         +");
                    System.out.println("+--------------------------------------------------------------+");
                }
            }
            //menu d
            else if(menu.equalsIgnoreCase("d")){
                System.out.print(" >> Apakah anda ingin melanjutkan transaksi? y/t\t: ");
                String jual = sc.nextLine();
                if(jual.equalsIgnoreCase("y")){
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println("+           DATA PENJUALAN BARANG                +");
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.print(" >> Masukkan ID barang yang dijual\t: ");
                    String brng_jual = sc.nextLine();
                    int Id_Barang = Integer.parseInt(brng_jual);
                    System.out.print(" >> Masukkan jumlah barang yang dijual\t: ");
                    String n_jual = sc.nextLine();
                    int jml_jual = Integer.parseInt(n_jual);
                    Barang barang = tabelBarang.get(Id_Barang - 1);
                    
                    System.out.println("+ Detail Barang ");
                    System.out.println("+ Nama Barang : "+ tabelBarang.get(Id_Barang - 1).Nama_Barang);
                    System.out.println("+ Jumlah barang : "+ jml_jual);
                    System.out.println("+ Harga barang : "+ tabelBarang.get(Id_Barang - 1).Harga);
                    System.out.println("+ =============================================================");
                    System.out.println("+ Jumlah Bayar : "+ (jml_jual * tabelBarang.get(Id_Barang - 1).Harga));
                    System.out.println("+--------------------------------------------------------------+");
                    System.out.println(" >> Lanjutkan Transaksi y/t\t: ");
                    String lanjut_TR = sc.nextLine();
                    if(lanjut_TR.equalsIgnoreCase("y")){
                        String Nama_Barang = tabelBarang.get(Id_Barang - 1).Nama_Barang;
                        int jumlah = jml_jual;
                        double Harga = tabelBarang.get(Id_Barang - 1).Harga;
                        double Total_Bayar  = (jml_jual * tabelBarang.get(Id_Barang - 1).Harga);
                        Transaksi transaksi = new Transaksi(Nama_Barang,jumlah,Harga, Total_Bayar);
                        tabelTransaksi.add(transaksi);
                        saveTabelBarangToFile(tabelBarang, "TabelTransaksi.txt");
                        System.out.println("+--------------------------------------------------------------+");
                        System.out.println("+---------------TRANSAKSI BERHASIL DILAKUKAN-------------------+");
                        System.out.println("+--------------------------------------------------------------+");
                    }
                    
                }   
            }
        }
    }
    
    //METHOD UNTUK MENYIMPAN DATA KEDALAM FILE
    public static boolean saveTabelBarangToFile(ArrayList<Barang> tabelBarang, String url){
        boolean result = false;
        try{
            if(tabelBarang != null && !tabelBarang.isEmpty() && url!=null){
                FileWriter fw = new FileWriter (url);
                BufferedWriter bw = new BufferedWriter(fw);
                for(Barang data : tabelBarang){
                    bw.append(data.toString());
                    bw.append("\n");
                }
                bw.close();
                fw.close();
                result = true;
            }      
        }catch(IOException e ){
            System.err.println("PROSES MENYIMPAN DATA KEDALAM FILE GAGAL!");
            e.printStackTrace();
        }
        return result;
    }
    
    //METHOD UNTUK MEMBACA DATA DARI FILE
    public static ArrayList<Barang> readTabelBarangFromFile(String url){
        ArrayList<Barang> dataFile = null;
        try{
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            dataFile = new ArrayList<>();
            String Baris;
            while((Baris = br.readLine()) != null){
                String[] elemen = Baris.split("\t");
                String strId = elemen[0];
                int Id = Integer.parseInt(strId);
                String Nama_Barang = elemen[1];
                String strstock = elemen[2];
                int Stock = Integer.parseInt(strstock);
                String strharga = elemen[3];
                double Harga = Double.parseDouble(strharga);
                String strjual = elemen[4];
                int Terjual = Integer.parseInt(strjual);
                Barang datadifile = new Barang(Id,Nama_Barang, Stock,Harga, Terjual);
                dataFile.add(datadifile);
               
            }
            br.close();
            fr.close();
            
            
        }catch (IOException e){
            System.err.println("PROSES MEMBACA DARI FILE GAGAL!");
            e.printStackTrace();
        }
        return dataFile;
    }
    
    public static boolean saveTabelTransaksiToFile (ArrayList<Transaksi> tabelTransaksi, String url){
        boolean result2 = false;
        try{
            if(tabelTransaksi != null && !tabelTransaksi.isEmpty() && url!=null){
                FileWriter fw = new FileWriter (url);
                BufferedWriter bw = new BufferedWriter(fw);
                for(Transaksi transaksi : tabelTransaksi){
                    bw.append(transaksi.toString());
                    bw.append("\n");
                }
                bw.close();
                fw.close();
                result2 = true;
            } 
            
        }catch (IOException e){
            System.err.println("PROSES MEMBACA DARI FILE GAGAL!");
            e.printStackTrace();
        }
        return result2;
    }
    public static ArrayList<Transaksi> readTabelTransaksiFromFile(String url){
        ArrayList<Transaksi> transaksi_diFile = null;
        try{
            FileReader fr = new FileReader(url);
            BufferedReader br = new BufferedReader(fr);
            transaksi_diFile = new ArrayList<>();
            String Baris;
            while((Baris = br.readLine()) != null){
                String[] element = Baris.split("\t");
                String Nama_Barang = element[0];
                String strjumlah = element[1];
                int jumlah = Integer.parseInt(strjumlah);
                String strharga = element[2];
                double Harga = Double.parseDouble(strharga);
                String strbayar = element[3];
                double Total_Bayar = Double.parseDouble(strbayar);
                Transaksi transaksi = new Transaksi(Nama_Barang,jumlah,Harga, Total_Bayar);
                transaksi_diFile.add(transaksi); 
            }
            br.close();
            fr.close();

        }catch (IOException e){
            System.err.println("PROSES MEMBACA DARI FILE GAGAL!");
            e.printStackTrace();
        }
        return transaksi_diFile;
    }
}
