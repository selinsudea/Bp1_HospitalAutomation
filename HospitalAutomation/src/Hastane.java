
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Hastane {

    private String ad;
    private String il;
    private String ilce;
    private Arraylist kliniklistesi;

    private Arraylist doktorlistesi;
    private Arraylist silinenklinikler;

    public Hastane() {
    }

    public Hastane(String ad, String il, String ilce) {
        this.ad = ad;
        this.il = il;
        this.ilce = ilce;
        doktorlistesi = new Arraylist();
        kliniklistesi = new Arraylist();
        silinenklinikler = new Arraylist();

    }

    public Arraylist getSilinenklinikler() {
        return silinenklinikler;
    }

    public void setSilinenklinikler(Arraylist silinenklinikler) {
        this.silinenklinikler = silinenklinikler;
    }

    public Arraylist getKliniklistesi() {
        return kliniklistesi;
    }

    public void setKliniklistesi(Arraylist kliniklistesi) {
        this.kliniklistesi = kliniklistesi;
    }

    public Arraylist getDoktorlistesi() {
        return doktorlistesi;
    }

    public void setDoktorlistesi(Arraylist doktorlistesi) {
        this.doktorlistesi = doktorlistesi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }

    public void klinikekle(Klinik klinik) {

        kliniklistesi.addElement(klinik.getIsim());

    }

    public void klinikyazdir() {
        for (int i = 0; i < kliniklistesi.size(); i++) {
            if (kliniklistesi.getElement(i) != null) {
                System.out.println(kliniklistesi.getElement(i));
            }
        }
    }

    public void doktorekle(Doktor doktor) {
        doktorlistesi.addElement(doktor);

    }

    public void doktorlistesiyazdir() {
        for (int i = 0; i < doktorlistesi.size(); i++) {
            if (doktorlistesi.getElement(i) != null) {
                System.out.println(doktorlistesi.getElement(i));
            }

        }
    }

    public void genelkontrol(Klinik klinik) {
        klinik.getHastasayma();

    }

    public void kliniksil(Klinik klinik) {
        boolean klinikkontrol = false;
        if (klinik.getKlinikrandevulist().size() != 0) {
            for (int i = 0; i < klinik.getKlinikrandevulist().size(); i++) {
                if (klinik.getKlinikrandevulist().getElement(i) == null) {
                    klinikkontrol = true;
                } else if (klinik.getKlinikrandevulist().getElement(i) != null) {
                    klinikkontrol = false;
                    break;
                }
            }
        } else {
            klinikkontrol = true;
        }
        if (klinikkontrol == false) {
            System.out.println("Bu klinikte aktif randevusu olan hasta vardır,silinemez.");
        } else if (klinikkontrol == true) {
            for (int i = 0; i < kliniklistesi.size(); i++) {
                if (kliniklistesi.getElement(i) == klinik.getIsim()) {
                    silinenklinikler.addElement(klinik.getIsim());
                    System.out.println(kliniklistesi.getElement(i) + " " + i + ". kliniği silindi");
                    kliniklistesi.remove(i);

                }

            }
        }
    }

    public boolean iptalkontrol(Klinik klinik) {
        boolean varmi = false;
        if (silinenklinikler.size() != 0) {
            for (int i = 0; i < silinenklinikler.size(); i++) {
                if (silinenklinikler.getElement(i) == (klinik.getIsim())) {
                    varmi = false;
                    break;
                } else {
                    varmi = true;
                }
            }
        } else {
            varmi = true;
        }
        return varmi;
    }

    public boolean doktorkontrolet(Doktor doktor) {
        boolean kontrol = true;
        if (doktor.getDoktorgelecekrandevulistesi().size() != 0) {
            for (int i = 0; i < doktor.getDoktorgelecekrandevulistesi().size(); i++) {
                for (int j = 0; j < doktor.getDoktorgelecekrandevulistesi().size(); j++) {
                    if (doktor.getDoktorgelecekrandevulistesi().getElement(i) == doktor.getDoktorgelecekrandevulistesi().getElement(j)) {
                        kontrol = true;
                        System.out.println("Bu doktorun aktif randevusu vardır.");
                        break;
                    } else {
                        kontrol = false;

                    }

                }

            }
        } else {
            System.out.println("Bu doktorun aktif randevusu yoktur.");
        }
        return kontrol;

    }

    public boolean randevuvarmi(Doktor doktor, Tarih tarih) {
        boolean varmi = false;
        long s = tarih.sayiyacevirme();
        if (doktor.getDoktorrandevulistesi().getElement(0) == null) {
            doktor.getDoktorrandevulistesi().addElement(0, tarih);

        } else {
            for (int i = 0; i < doktor.getDoktorrandevulistesi().size(); i++) {
                if (doktor.getDoktorrandevulistesi().getElement(i).equals(tarih)) {
                    varmi = true;
                    break;
                } else {
                    varmi = false;
                }
            }

        }

        return varmi;
    }

    public void randevuekle(Doktor doktor, Tarih tarih, Klinik klinik, Hasta hasta) {
        boolean iptal = iptal(klinik);
        boolean dogruluk = randevuvarmi(doktor, tarih);
        long s = tarih.sayiyacevirme();
        String x = tarih.saatsizhal();
        if (iptal == false) {
            if (dogruluk == true) {
                System.out.println("Bu tarihte " + doktor.getAd() + " adlı doktorun zaten bir randevusu vardır.");

            } else if (dogruluk == false) {
                doktor.getDoktorrandevulistesi().addElement(tarih);
                if (tarih.getYil() == tarih.getSABITYIL()) {
                    if (tarih.getAy() == tarih.getSABITAY()) {
                        if (tarih.getGun() < tarih.getSABITGUN()) {
                            hasta.getEskirandevular().addElement(tarih);
                            System.out.println(tarih.toString() + "  tarihine geçmiş randevu olarak eklendi");

                        } else {
                            hasta.getGelecekrandevular().addElement(tarih);

                            doktor.getDoktorgelecekrandevulistesi().addElement(tarih);
                            klinik.getKlinikrandevulist().addElement(tarih.saatsizhal());
                        }
                    } else if (tarih.getAy() < tarih.getSABITAY()) {
                        hasta.getEskirandevular().addElement(tarih);

                    } else if (tarih.getAy() > tarih.getSABITAY()) {
                        hasta.getGelecekrandevular().addElement(tarih);
                        klinik.getKlinikrandevulist().addElement(tarih.saatsizhal());

                        doktor.getDoktorgelecekrandevulistesi().addElement(tarih);

                    }
                } else if (tarih.getYil() < tarih.getSABITYIL()) {
                    hasta.getEskirandevular().addElement(tarih);

                } else if (tarih.getYil() > tarih.getSABITYIL()) {
                    hasta.getGelecekrandevular().addElement(tarih);

                    doktor.getDoktorgelecekrandevulistesi().addElement(tarih);
                    klinik.getKlinikrandevulist().addElement(tarih.saatsizhal());
                }

                hasta.getHastanintoplamrandevulistesi().addElement(tarih);
                hasta.getHastanintoplamrandevulistesisayisal().addElement(s);

                System.out.println(tarih.toString() + " tarihine randevu eklendi");

            }
        } else {
            System.out.println("Maalesef bu klinikten randevu alamazsınız.Klinik silinmiş.");
        }
    }

    public void randevulistele(Hasta hasta) {
        for (int i = 0; i < hasta.getHastanintoplamrandevulistesi().size(); i++) {
            if (hasta.getGelecekrandevular().getElement(i) != null) {
                System.out.println("Gelecek randevular:" + hasta.getGelecekrandevular().getElement(i));
                if (hasta.getEskirandevular().getElement(i) != null) {
                    System.out.println("Geçmiş randevular:" + hasta.getEskirandevular().getElement(i));
                }

            }
            System.out.println("Hastanın randevu sayısı toplam: " + hasta.getHastanintoplamrandevulistesi().size());
        }

    }

    public void randevusil(Hasta hasta, Doktor doktor, Tarih tarih, Tarih guncellenmekistenen, Klinik klinik) {
        for (int i = 0; i < hasta.getGelecekrandevular().size(); i++) {
            if (hasta.getGelecekrandevular().getElement(i).equals(tarih)) {
                if (tarih.getAy() == tarih.getSABITAY()) {
                    if (tarih.getGun() == ((tarih.getSABITGUN()) + 1)) {
                        System.out.println("Maalesef bu randevu silinemez.");
                    } else if (tarih.getGun() > ((tarih.getSABITGUN()) + 1)) {
                        hasta.getIptalrandevulistesi().addElement(tarih);
                        hasta.getGelecekrandevular().remove(i);

                        doktor.getDoktorrandevulistesi().remove(i);
                        doktor.getDoktorgelecekrandevulistesi().remove(i);
                        klinik.getKlinikrandevulist().remove(i);
                    }
                } else if ((tarih.getAy() > tarih.getSABITAY() + 1) && ((tarih.getGun() == 1) && (tarih.getSABITGUN() == 30))) {
                    System.out.println("Maalesef bu randevu silinemez.");
                } else {
                    hasta.getIptalrandevulistesi().addElement(tarih);
                    hasta.getGelecekrandevular().remove(i);

                    doktor.getDoktorrandevulistesi().remove(i);
                    doktor.getDoktorgelecekrandevulistesi().remove(i);
                    klinik.getKlinikrandevulist().remove(i);
                    System.out.println(hasta.getIptalrandevulistesi().getElement(i) + " Bu tarihteki randevu silindi.");
                }

                boolean istek = randevuguncelle(doktor, guncellenmekistenen);
                if (istek == true) {
                    hasta.getHastanintoplamrandevulistesi().addElement(tarih);
                    hasta.getHastanintoplamrandevulistesisayisal().addElement(tarih);
                    doktor.getDoktorrandevulistesi().addElement(tarih);
                    klinik.getKlinikrandevulist().addElement(tarih.saatsizhal());
                    doktor.getDoktorgelecekrandevulistesi().addElement(i);

                    System.out.println("Randevu Eklenmiştir");

                } else if (istek == false) {
                    System.out.println("Maalesef doktor doludur.");
                    break;
                }

            }

        }
    }

    public boolean randevuguncelle(Doktor doktor, Tarih guncellenmekistenen) {
        boolean guncellemeistegi = true;
        for (int i = 0; i < doktor.getDoktorrandevulistesi().size(); i++) {
            if (doktor.getDoktorrandevulistesi().getElement(i).equals(guncellenmekistenen)) {
                guncellemeistegi = false;
                System.out.println("Maalesef bu tarihe randevuyu güncelleyemezsiniz.");
                break;
            } else {

                guncellemeistegi = true;

            }
        }
        if (guncellemeistegi == true) {
            System.out.println("İstediğiniz tarihte doktorun randevusu yoktur.Randevu güncellenebilir.");
        } else {
            System.out.println("Maalesef bu tarihe randevuyu güncelleyemezsiniz.");
        }

        return guncellemeistegi;
    }

    public boolean iptal(Klinik klinik) {
        boolean iptalmi = false;
        for (int i = 0; i < silinenklinikler.size(); i++) {
            if (silinenklinikler.getElement(i).equals(klinik.getIsim())) {
                System.out.println("Bu klinikten randevu alınamaz.");
                iptalmi = true;
                break;

            } else {
                iptalmi = false;
            }
        }
        if (iptalmi == false) {
            System.out.println("Randevu alabilirsiniz");
        } else {
            System.out.println("Bu klinikten randevu alamazsınız.");
        }
        return iptalmi;
    }

    public void doktorsil(Doktor doktor, Klinik klinik, Tarih tarih, Hasta hasta) {
        int rastgele = (int) (Math.random() * doktor.getDoktorgelecekrandevulistesi().size());
        if (doktor.getDoktorgelecekrandevulistesi().size() != 0) {
            for (int i = 0; i <= doktor.getDoktorgelecekrandevulistesi().size(); i++) {
                Doktor d1 = (Doktor) doktorlistesi.getElement(i);
                Tarih t1 = (Tarih) doktor.getDoktorgelecekrandevulistesi().getElement(i);
                this.doktorlistesi.doktorgetir(rastgele).randevuekle(d1, t1, klinik, hasta);

                doktor.getDoktoreskirandevulistesi().addElement(doktor.getDoktorgelecekrandevulistesi().getElement(i));
                doktor.getDoktorgelecekrandevulistesi().remove(i);
                System.out.println(doktor.getAd() + " " + klinik.getIsim() + " adlı klinikten silindi");
            }
        }
        for (int i = 0; i < doktorlistesi.size(); i++) {
            if (doktorlistesi.getElement(i) == doktor) {
                doktorlistesi.remove(i);
            }
        }
    }

    public void isimara(String aranmakistenenkelime, Klinik klinik) {
        String aranacakKelime = aranmakistenenkelime.toLowerCase();

        String x = "";

        for (int j = 0; j < klinik.getKlinikhastalistesi().size(); j++) {
            for (int i = 0; i < klinik.getHastaninadi().stringgetir(j).length(); i++) {
                for (int k = 0; k < aranacakKelime.length(); k++) {
                    if ((i + k) != klinik.getHastaninadi().stringgetir(j).length()) {
                        x += klinik.getHastaninadi().stringgetir(j).charAt(i + k);

                    } else {
                        break;
                    }
                }
                String kucukharf = x.toLowerCase();
                if (aranacakKelime.equals(kucukharf)) {
                    x = "";
                    System.out.println(klinik.getKlinikhastalistesi().getElement(j));

                    break;
                } else {

                    x = "";
                    kucukharf = "";
                }

            }

        }

    }

    public void klinikbazıkontrol(Klinik klinik) {
        int x = 0;
        int y = 0;
        for (int i = 0; i < klinik.getKlinikrandevulist().size(); i++) {
            for (int j = 0; j < klinik.getKlinikrandevulist().size(); j++) {
                if (i != j) {
                    if (klinik.getKlinikrandevulist().stringgetir(i).equals(klinik.getKlinikrandevulist().stringgetir(j))) {
                        x++;
                    }

                }
            }
            klinik.getHklinikrandevusayisi().addElement(x + 1);
            x = 0;

        }
    }

    public void minmaxrandevuhesapla(Klinik klinik) {
        klinikbazıkontrol(klinik);
        int max = 0;
        int min = 9;
        int toplam = 0;
        double ortalamarandevusayisi = 0;
        int toplamrandevusayisi = klinik.getHklinikrandevusayisi().size();

        for (int i = 0; i < klinik.getKlinikrandevulist().size(); i++) {
            if (klinik.getHklinikrandevusayisi().randevugetir(i) > max) {
                max = klinik.getHklinikrandevusayisi().randevugetir(i);
            } else if (klinik.getHklinikrandevusayisi().randevugetir(i) < min) {
                min = klinik.getHklinikrandevusayisi().randevugetir(i);

            }
            toplam += klinik.getHklinikrandevusayisi().randevugetir(i);

        }

        ortalamarandevusayisi = toplam / toplamrandevusayisi;
        System.out.println(ad + "nde " + klinik.getIsim() + " için " + " max:" + max + " min:" + min + " ortalama:" + ortalamarandevusayisi + " randevu sayısı şudur.");

    }

}
