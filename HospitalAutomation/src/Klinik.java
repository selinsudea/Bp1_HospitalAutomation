
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Klinik extends Hastane {

    private String isim;
    private Doktor doktor;
    private Hasta hasta;
    private Arraylist kliniklistesi;
    private Arraylist klinikdoktorlistesi;
    private Arraylist klinikhastalistesi;
    private Arraylist hastasayma;
    private Arraylist hastaninrandevusayisi;
    private Arraylist klinikrandevulist;
    private Arraylist doktorlarınlistesi;
    private Arraylist klinikrandevusayisi;
    private Arraylist hastaninadi;
    private Arraylist hklinikrandevusayisi;

    public Klinik() {

    }

    public Klinik(Hastane hastane, String isim) {
        this.isim = isim;
        kliniklistesi = new Arraylist();
        klinikdoktorlistesi = new Arraylist();
        klinikhastalistesi = new Arraylist();
        hastasayma = new Arraylist();
        hastaninrandevusayisi = new Arraylist();
        doktorlarınlistesi = new Arraylist();
        klinikrandevusayisi = new Arraylist();
        hastaninadi = new Arraylist();
        klinikrandevulist = new Arraylist();
        hklinikrandevusayisi = new Arraylist();

    }

    public Arraylist getKlinikdoktorlistesi() {
        return klinikdoktorlistesi;
    }

    public void setKlinikdoktorlistesi(Arraylist klinikdoktorlistesi) {
        this.klinikdoktorlistesi = klinikdoktorlistesi;
    }

    public Arraylist getKlinikhastalistesi() {
        return klinikhastalistesi;
    }

    public void setKlinikhastalistesi(Arraylist klinikhastalistesi) {
        this.klinikhastalistesi = klinikhastalistesi;
    }

    public Arraylist getHklinikrandevusayisi() {
        return hklinikrandevusayisi;
    }

    public void setHklinikrandevusayisi(Arraylist hklinikrandevusayisi) {
        this.hklinikrandevusayisi = hklinikrandevusayisi;
    }

    public Arraylist getKlinikrandevusayisi() {
        return klinikrandevusayisi;
    }

    public void setKlinikrandevusayisi(Arraylist klinikrandevusayisi) {
        this.klinikrandevusayisi = klinikrandevusayisi;
    }

    public Hasta getHasta() {
        return hasta;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public Arraylist getHastaninadi() {
        return hastaninadi;
    }

    public void setHastaninadi(Arraylist hastaninadi) {
        this.hastaninadi = hastaninadi;
    }

    public Arraylist getKlinikrandevulist() {
        return klinikrandevulist;
    }

    public void setKlinikrandevulist(Arraylist klinikrandevulist) {
        this.klinikrandevulist = klinikrandevulist;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public Arraylist getHastaninrandevusayisi() {
        return hastaninrandevusayisi;
    }

    public void setHastaninrandevusayisi(Arraylist hastaninrandevusayisi) {
        this.hastaninrandevusayisi = hastaninrandevusayisi;
    }

    public Arraylist getDoktorlarınlistesi() {
        return doktorlarınlistesi;
    }

    public void setDoktorlarınlistesi(Arraylist doktorlarınlistesi) {
        this.doktorlarınlistesi = doktorlarınlistesi;
    }

    public Arraylist getHastasayma() {
        return hastasayma;
    }

    public void setHastasayma(Arraylist hastasayma) {
        this.hastasayma = hastasayma;
    }

    public Arraylist getKliniklistesi() {
        return kliniklistesi;
    }

    public void setKliniklistesi(Arraylist kliniklistesi) {
        this.kliniklistesi = kliniklistesi;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public void klinikdoktorekle(Doktor doktor) {
        klinikdoktorlistesi.addElement(doktor.getAd() + doktor.getAlani());
        doktorlarınlistesi.addElement(doktor);

    }

    public void klinikdoktoryazdir() {
        for (int i = 0; i < klinikdoktorlistesi.size(); i++) {
            System.out.println(klinikdoktorlistesi.getElement(i));
        }

    }

    public void klinikhastaekle(Hasta hasta) {
        klinikhastalistesi.addElement(hasta.getAd() + " " + hasta.getRahatsizlik() + "." + hasta.getIl() + " ." + hasta.getHastanintoplamrandevulistesi().size());
        hastaninadi.addElement(hasta.getAd());
        int x = 0;
        x = hasta.getHastanintoplamrandevulistesi().size();
        hastaninrandevusayisi.addElement(x);

    }

    public void maxhastarandevusayisi() {
        int max = 0;
        int index = 0;
        int[] randevulisteleme = new int[klinikhastalistesi.size()];
        for (int i = 0; i < randevulisteleme.length; i++) {
            randevulisteleme[i] = hastaninrandevusayisi.randevugetir(i);
            System.out.println(randevulisteleme[i]);
        }
        for (int j = 0; j < randevulisteleme.length; j++) {

            if (randevulisteleme[j] > max) {
                max = randevulisteleme[j];
                index = j;
            }
        }
        System.out.println(klinikhastalistesi.getElement(index));
    }

}
