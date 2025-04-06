import java.util.Scanner;

public class CinemaSystem {

    static String[] filmAdlari = new String[10];
    static int[] filmSureleri = new int[10];
    static String[] filmTurleri = new String[10];
    static int toplamFilm = 0;

    static String[] musteriIsimleri = new String[20];
    static String[] musteriEpostalar = new String[20];
    static int toplamMusteri = 0;

    static int[][] biletKayitlari = new int[20][10]; // hangi musteri hangi filme bilet almis

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int secim;

        do {
            anaMenuGoster();
            secim = scanner.nextInt();
            scanner.nextLine(); // satir sonunu temizlemek icin

            switch (secim) {
                case 1:
                    filmEklemeIslemi();
                    break;
                case 2:
                    musteriKaydiAl();
                    break;
                case 3:
                    biletKaydiYap();
                    break;
                case 4:
                    filmleriGoster();
                    break;
                case 5:
                    musterileriGoster();
                    break;
                case 6:
                    biletleriGoster();
                    break;
                case 0:
                    System.out.println("Sistemden cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim, tekrar deneyin.");
            }
        } while (secim != 0);

        scanner.close();
    }

    static void anaMenuGoster() {
        System.out.println("\n--- Elif'in Sinema Bilet Sistemi ---");
        System.out.println("1. Film Ekle");
        System.out.println("2. Musteri Ekle");
        System.out.println("3. Bilet Ekle");
        System.out.println("4. Filmleri Listele");
        System.out.println("5. Musterileri Listele");
        System.out.println("6. Biletleri Listele");
        System.out.println("0. Cikis");
        System.out.print("Seciminiz: ");
    }

    static void filmEklemeIslemi() {
        if (toplamFilm >= 10) {
            System.out.println("Film kapasitesi doldu.");
            return;
        }

        // film bilgileri alma
        System.out.print("Film adi: ");
        filmAdlari[toplamFilm] = scanner.nextLine();

        System.out.print("Sure (dakika): ");
        filmSureleri[toplamFilm] = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Tur: ");
        filmTurleri[toplamFilm] = scanner.nextLine();

        toplamFilm++;
    }

    static void musteriKaydiAl() {
        if (toplamMusteri >= 20) {
            System.out.println("Musteri kapasitesi doldu.");
            return;
        }

        System.out.print("Musteri adi: ");
        musteriIsimleri[toplamMusteri] = scanner.nextLine();

        System.out.print("Email adresi: ");
        musteriEpostalar[toplamMusteri] = scanner.nextLine();

        toplamMusteri++;
    }

    static void biletKaydiYap() {
        // musteri ve film listeleri
        musterileriGoster();
        System.out.print("Musteri numarasi (0-" + (toplamMusteri - 1) + "): ");
        int mid = scanner.nextInt();

        filmleriGoster();
        System.out.print("Film numarasi (0-" + (toplamFilm - 1) + "): ");
        int fid = scanner.nextInt();

        // bilet kaydi
        if (mid < toplamMusteri && fid < toplamFilm) {
            biletKayitlari[mid][fid] = 1;
            System.out.println("Bilet kaydedildi.");
        } else {
            System.out.println("Hatalı secim.");
        }
    }

    static void filmleriGoster() {
        System.out.println("--- Filmler ---");
        for (int i = 0; i < toplamFilm; i++) {
            System.out.println(i + " - " + filmAdlari[i] + " | Süre: " + filmSureleri[i] + " dk | Tür: " + filmTurleri[i]);
        }
    }

    static void musterileriGoster() {
        System.out.println("--- Musteriler ---");
        for (int i = 0; i < toplamMusteri; i++) {
            System.out.println(i + " - " + musteriIsimleri[i] + " | Email: " + musteriEpostalar[i]);
        }
    }

    static void biletleriGoster() {
        System.out.println("--- Musteri Biletleri ---");

        for (int i = 0; i < toplamMusteri; i++) {
            System.out.print(musteriIsimleri[i] + ": ");
            for (int j = 0; j < toplamFilm; j++) {
                if (biletKayitlari[i][j] == 1) {
                    System.out.print(filmAdlari[j] + " | ");
                }
            }
            System.out.println();
        }
    }
}
