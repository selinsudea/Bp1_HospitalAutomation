
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Test {

    public static void main(String[] args) {
        Hastane h1 = new Hastane("Acıbadem hastanesi", "İstanbul", "Sarıyer");
        Hastane h2 = new Hastane("Liv hastanesi", "İstanbul", "Beşiktaş");
        Tarih t1 = new Tarih(17, 2, 2022, 12);
        Tarih t2 = new Tarih(1, 1, 2022, 4);
        Tarih t3 = new Tarih(4, 2, 2022, 15);
        Tarih t4 = new Tarih(19, 10, 2022, 7);
        Tarih t5 = new Tarih(12, 12, 2022, 0);
        Tarih t6 = new Tarih(4, 2, 2022, 9);

        Klinik k1 = new Klinik(h1, "Yetişkin");
        Klinik k2 = new Klinik(h1, "Çocuk");
        Klinik k3 = new Klinik(h2, "Acil");
        Klinik k4 = new Klinik(h2, "Genel");
        Doktor d1 = new Doktor("Profesör", "Göz", "Melek ", "İstanbul", "Sarıyer");
        Doktor d2 = new Doktor("Doçent", "Cildiye", "Levent", "İstanbul", "Beşiktaş");
        Doktor d3 = new Doktor("Uzman doktor", "Kardiyoloji", "Ela", "İstanbul", "Kadıköy");
        Doktor d4 = new Doktor("Profesör", "Kardiyoloji", "Suat", "İstanbul", "Ümraniye");
        Doktor d5 = new Doktor("Doçent", "Nefroloji", "Haldun", "İstanbul", "Beylikdüzü");
        Hasta hasta1 = new Hasta("Bülent", "İstanbul", "Miyop");
        Hasta hasta2 = new Hasta("Batuhan", "İstanbul", "Böbrek yetmezliği");
        Hasta hasta3 = new Hasta("Sibel", "İstanbul", "Alerji");
        Hasta hasta4 = new Hasta("Lamia", "İstanbul", "kalp");
        Randevu r1 = new Randevu(k1);
        Randevu r2 = new Randevu(k2);

        try {
            int saat = t1.saatException(t1.getSaat());
            System.out.println(t1.toString());
        } catch (ArithmeticException tarih) {
            System.out.println("Lütfen geçerli bir saat giriniz.Zaman diliminde hata vardır.");
        }
        k1.getKliniklistesi().addElement(k1);

        k1.klinikdoktorekle(d3);
        k1.klinikdoktorekle(d4);
        k2.klinikdoktorekle(d1);
        k3.klinikdoktorekle(d2);
        k4.klinikdoktorekle(d5);
        h1.klinikekle(k1);
        h1.klinikekle(k2);
        h2.klinikekle(k3);
        h2.klinikekle(k4);
        h1.doktorekle(d3);
        h1.doktorekle(d1);
        h1.doktorekle(d4);
        h2.doktorekle(d2);
        h2.doktorekle(d5);
        h1.randevuekle(d3, t1, k1, hasta4);
        h1.randevuekle(d1, t5, k1, hasta1);
        h1.randevuekle(d4, t4, k4, hasta4);
        h1.randevuekle(d1, t2, k1, hasta2);
        h1.randevuekle(d5, t6, k1, hasta4);
        h2.randevuekle(d2, t3, k4, hasta2);
        k1.klinikhastaekle(hasta4);
        k1.klinikhastaekle(hasta1);
        k1.klinikhastaekle(hasta2);
        k4.klinikhastaekle(hasta4);
        System.out.println("*******");
        h1.randevusil(hasta1, d1, t5, t4, k1);
        h1.randevuekle(d2, t5, k3, hasta3);
        k3.klinikhastaekle(hasta3);
        h1.doktorsil(d5, k4, t5, hasta4);
        h1.kliniksil(k1);
        h1.kliniksil(k2);
        h1.randevuekle(d4, t5, k2, hasta4);
        h1.isimara("Bel", k3);
        h1.minmaxrandevuhesapla(k4);
        h1.randevulistele(hasta2);
        h1.minmaxrandevuhesapla(k1);

    }
}
