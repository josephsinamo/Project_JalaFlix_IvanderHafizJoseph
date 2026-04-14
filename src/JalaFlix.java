import java.util.*;

public class JalaFlix {

    public static List<Film> filmList = new ArrayList<>();
    public static List<Pelanggan> pelangganList = new ArrayList<>();

    public static void main(String[] args) {
        try {
            filmList.add(new Film("Jala Saga", Genre.Action, 2026, "Misi penyelamatan dunia", 9.5, "Jala Studio", "Budi", 17, true));
            filmList.add(new Film("Tawa Desa", Genre.Comedy, 2024, "Kisah lucu di desa", 8.0, "Maju Film", "Siti", 13, false));
            filmList.add(new Film("Ruang Hampa", Genre.SciFi, 2023, "Eksplorasi luar angkasa", 8.7, "Cosmic", "Andi", 13, false));
            filmList.add(new Film("Kenangan", Genre.Romance, 2010, "Kisah cinta lama", 7.5, "Classic Pic", "Rudi", 13, false));
            filmList.add(new Film("Hutan Tua", Genre.Horror, 2015, "Misteri hutan berhantu", 6.8, "Scary Ent", "Eko", 17, false));

            pelangganList.add(new PelangganPlatinum("P01", "Andi", 25, "0811"));
            pelangganList.add(new PelangganGold("G02", "Deni", 28, "0814"));
            pelangganList.add(new PelangganReguler("R01", "Fani", 19, "0816"));
        } catch (Exception e) {
            System.out.println("Sistem Error: " + e.getMessage());
        }

        System.out.println("=== SIMULASI TRANSAKSI JALAFLIX ===\n");

        for (Pelanggan p : pelangganList) {
            p.info();
            System.out.println("AKTIVITAS USER:");
            
            if (p instanceof PelangganPlatinum) {
                p.putarFilm(filmList.get(0));
                p.putarFilm(filmList.get(4));
            } else if (p instanceof PelangganGold) {
                p.putarFilm(filmList.get(0));
                p.putarFilm(filmList.get(1));
            } else {
                p.putarFilm(filmList.get(3));
                p.putarFilm(filmList.get(0));
            }
            
            p.getHistory();
            System.out.println();
        }

        System.out.println("=== VALIDASI INPUT SISTEM ===");
        try {
            new PelangganReguler("R99", "Bocil", -5, "0000");
        } catch (UmurNegatifException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        try {
            new Film("Film Purba", Genre.Drama, 1750, "-", 0, "-", "-", 0, false);
        } catch (TahunTooOldException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
