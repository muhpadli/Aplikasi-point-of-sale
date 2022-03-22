
package aplikasi_berbasis_CLI;

public class Transaksi {
    String Nama_Barang;
    int jumlah;
    double Harga;
    double Total_Bayar;
    
    //construktor untuk menginput dan membaca data file

    public Transaksi(String Nama_Barang, int jumlah, double Harga, double Total_Bayar) {
        this.Nama_Barang = Nama_Barang;
        this.jumlah = jumlah;
        this.Harga = Harga;
        this.Total_Bayar = Total_Bayar;
    }
    public String toString(){
        String tampil = "\t"+Nama_Barang+"\t"+jumlah+"\t"+Harga+"\t"+Total_Bayar;
        return tampil;
    }
}
