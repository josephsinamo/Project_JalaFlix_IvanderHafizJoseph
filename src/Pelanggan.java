public abstract class Pelanggan implements FilmAccess,HistoryAction{
    protected String kodePelanggan,nama,nomorTelepon,statusKeanggotaan;
    protected HistoryTontonan history  = new HistoryTontonan();
    protected int umur;

    public Pelanggan(String kodePelanggan, String nama, int umur, String nomorTelepon) {
        if (umur < 0){
            throw new UmurNegatifException(umur);
        }

        this.umur = umur;
        this.kodePelanggan = kodePelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
        this.statusKeanggotaan = "aktif";
    }
    
    abstract void info ();

    public void setStatusKeanggotaan(String status) {
        this.statusKeanggotaan = status;
    }

    @Override
    public void getHistory(){
        history.tampilkanHistory();
    }

    @Override
    public void updateHistory(Film film){
        history.addHistory(film);
    }

}

class PelangganPlatinum extends Pelanggan {

    Kategori hakAkses [] = {Kategori.Reguler, Kategori.New, Kategori.Original};

    public PelangganPlatinum(String kode, String nama, int umur, String telp) {
        super(kode, nama, umur, telp);
    }

    @Override
    public void info() {
    System.out.println("========== JALAFLIX PREMIUM INFO ==========");
    System.out.println("ID Pelanggan : " + this.kodePelanggan);
    System.out.println("Nama User    : " + this.nama);
    System.out.println("Telepon      : " + this.nomorTelepon);
    System.out.println("Status       : " + this.statusKeanggotaan.toUpperCase());
    System.out.println("Tipe Akun    : PLATINUM");
    System.out.print("Akses Konten : ");
    
    // Menampilkan isi array hakAkses
    for (int i = 0; i < hakAkses.length; i++) {
        System.out.print(hakAkses[i] + (i < hakAkses.length - 1 ? ", " : ""));
    }
    
    System.out.println("\n-------------------------------------------");
    System.out.println("Nikmati tontonan tanpa iklan dan kualitas UHD!");
    System.out.println("===========================================");
    }

    //Film
    @Override
    public void putarFilm(Film film) {
        System.out.println("[Platinum] Memutar: " + film.getJudul());
    }

}

class PelangganGold extends Pelanggan {

    Kategori hakAkses [] = {Kategori.Reguler, Kategori.New};

    public PelangganGold(String kode, String nama, int umur, String telp) {
        super(kode, nama, umur, telp);
    }

    @Override
    public void info() {
    System.out.println("========== JALAFLIX PREMIUM INFO ==========");
    System.out.println("ID Pelanggan : " + this.kodePelanggan);
    System.out.println("Nama User    : " + this.nama);
    System.out.println("Telepon      : " + this.nomorTelepon);
    System.out.println("Status       : " + this.statusKeanggotaan.toUpperCase());
    System.out.println("Tipe Akun    : GOLD");
    System.out.print("Akses Konten : ");
    
    // Menampilkan isi array hakAkses
    for (int i = 0; i < hakAkses.length; i++) {
        System.out.print(hakAkses[i] + (i < hakAkses.length - 1 ? ", " : ""));
    }
    
    System.out.println("\n-------------------------------------------");
    System.out.println("Nikmati tontonan tanpa iklan ");
    System.out.println("===========================================");
    }

    //Film
    @Override
    public void putarFilm(Film film) {
        Kategori katFilm = film.getKategori();
        if (katFilm == hakAkses[0] || katFilm == hakAkses[1]) {
            System.out.println("[Gold] Memutar: " + film.getJudul());
        } else {
            System.out.println("Akun Gold tidak mencukupi untuk menonton film " + film.getJudul());
        }
    }

}

class PelangganReguler extends Pelanggan {

    Kategori hakAkses = Kategori.Reguler;

    public PelangganReguler(String kode, String nama, int umur, String telp) {
        super(kode, nama, umur, telp);
        super.setStatusKeanggotaan("tidak Aktif");
    }

    @Override
    public void info() {
    System.out.println("========== JALAFLIX PREMIUM INFO ==========");
    System.out.println("ID Pelanggan : " + this.kodePelanggan);
    System.out.println("Nama User    : " + this.nama);
    System.out.println("Telepon      : " + this.nomorTelepon);
    System.out.println("Status       : " + this.statusKeanggotaan.toUpperCase());
    System.out.println("Tipe Akun    : PLATINUM");
    System.out.print("Akses Konten : ");
    System.out.print(hakAkses);

    System.out.println("\n-------------------------------------------");
    System.out.println("Selamat Menonton!");
    System.out.println("===========================================");
    }

    //Film
    @Override
    public void putarFilm(Film film) {
        Kategori katFilm = film.getKategori();
        if (katFilm == hakAkses) {
                System.out.println("[Reguler] Memutar: " + film.getJudul());
        } else {
            System.out.println("Akun Reguler hanya boleh menonton film kategori Reguler.");
        }
    }

}
