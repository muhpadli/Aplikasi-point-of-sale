package aplikasi_berbasis_CLI;

public class Barang {
    int Id;
    String Nama_Barang;
    int Stock;
    double Harga;
    int Terjual;
    
    boolean penjualan(int n_jual){
        boolean status = false;
        if(n_jual<= Stock){
            status = true;
            Stock = Stock - n_jual;
            Terjual = Terjual + n_jual;
        }
        return status;
    }
    
    public Barang(int Id, String Nama_Barang, int Stock, double Harga) {
        this.Id = Id;
        this.Nama_Barang = Nama_Barang;
        this.Stock = Stock;
        this.Harga = Harga;
    }

    public Barang(int Id, String Nama_Barang, int Stock, double Harga, int Terjual) {
        this.Id = Id;
        this.Nama_Barang = Nama_Barang;
        this.Stock = Stock;
        this.Harga = Harga;
        this.Terjual = Terjual;
    }
    
    public String toString(){
        String tampil = Id+"\t"+Nama_Barang+"\t\t"+Stock+"\t"+Harga+"\t\t"+ Terjual;
        return tampil;
    }
}
