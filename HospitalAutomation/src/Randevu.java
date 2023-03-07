
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Randevu {

    private Arraylist randevulistesi;
    private Klinik klinik;

    private Doktor doktor;

    public Randevu() {
    }

    public Randevu(Klinik klinik) {

        randevulistesi = new Arraylist();

        this.klinik = klinik;

    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Klinik getKlinik() {
        return klinik;
    }

    public void setKlinik(Klinik klinik) {
        this.klinik = klinik;
    }

    public void alinabilecekrandevular(Klinik klinik, Doktor doktor) {
        for (int i = 0; i < klinik.getKliniklistesi().size(); i++) {

            System.out.println(klinik.getKliniklistesi().getElement(i));
            System.out.println("Doktor adı:" + doktor.getAd() + "alanı:" + doktor.getAlani() + "uzmanlık derecesi:" + doktor.getUzmanlıkderecesi());

        }

    }

}
