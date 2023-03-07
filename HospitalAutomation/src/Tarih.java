
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Tarih {

    private int ay;
    private int yil;
    private int gun;
    private String gunceltarih;
    private String girilentarih;
    private int saat;
    private final int SABITGUN = 24;
    private final int SABITAY = 1;
    private final int SABITYIL = 2022;
    private final int SABITSAAT = 14;

    public Tarih() {
       

    }

    public Tarih(int gun, int ay, int yil, int saat) {
        this.ay = ay;
        this.yil = yil;
        this.gun = gun;
        this.saat = saat;

    }

    public int getSABITGUN() {
        return SABITGUN;
    }

    public int getSABITAY() {
        return SABITAY;
    }

    public int getSABITYIL() {
        return SABITYIL;
    }

    public int getSABITSAAT() {
        return SABITSAAT;
    }

    public int getSaat() {
        return saat;
    }

    public void setSaat(int saat) {
        this.saat = saat;
    }

    public String getGirilentarih() {
        return girilentarih;
    }

    public void setGirilentarih(String girilentarih) {
        this.girilentarih = girilentarih;
    }

    public int getAy() {
        return ay;
    }

    public void setAy(int ay) {
        this.ay = ay;
    }

    public int getYil() {
        return yil;
    }

    public void setYil(int yil) {
        this.yil = yil;
    }

    public int getGun() {
        return gun;
    }

    public void setGun(int gun) {
        this.gun = gun;
    }

    public int saatException(int saat) {
        if (saat < 0 || saat > 24) {
            throw new ArithmeticException("Lütfen geçerli bir saat diliminde giriniz.");
        }
        return saat;
    }

    @Override
    public String toString() {
        String x = this.gun + "." + this.ay + "." + this.yil + " saat:" + this.saat;
        return x;
    }

    public String getGunceltarih() {
        this.gun = 24;
        this.ay = 1;
        this.yil = 2022;
        this.saat = 12;
        //this.gunceltarih = this.gun + "." + this.ay + "." + this.yil + "." + this.saat;
        this.gunceltarih = this.yil + "." + this.ay + "." + this.gun + this.saat;
        return gunceltarih;
    }

    public void setGunceltarih(String gunceltarih) {
        this.gunceltarih = gunceltarih;
    }

    public boolean tarihkontrol() {
        boolean tarihkontrol = false;

        if ((gun < 00 && gun > 30) && (ay < 00 && ay > 12) && (yil < 2022) && (saat <= 24) && (saat > 0)) {
            System.out.println("Girdiğiniz tarih geçersizdir.Geçerli bir tarih giriniz.");

        } else if ((gun > 00 && gun < 31) && (ay > 00 && ay < 13) && (yil > 2021)) {

            girilentarih = this.gun + "." + this.ay + "." + this.yil + ":" + this.saat;
            tarihkontrol = true;

        }

        return tarihkontrol;
    }

    public String duzgunformacevirme() {

        String duzelenmetin = "";
        boolean dogrumu = tarihkontrol();
        if (dogrumu == true) {
            for (int i = 0; i < girilentarih.length(); i++) {
                if (girilentarih.charAt(i) != '.' && girilentarih.charAt(i) != ':' && girilentarih.charAt(i) != '-') {
                    duzelenmetin += girilentarih.charAt(i);
                } else if (girilentarih.charAt(i) == ':') {
                    break;
                }
            }
        }

        return duzelenmetin;

    }

    public long sayiyacevirme() {
        long sayi = Long.parseLong(duzgunformacevirme());
        return sayi;
    }

    public long gunceltarihissayiyacevirme() {
        String y = "";
        for (int i = 0; i < this.getGunceltarih().length(); i++) {
            if (this.getGunceltarih().charAt(i) != '.' && (this.getGunceltarih().charAt(i)) != ':') {
                y += this.getGunceltarih().charAt(i);
            }

        }
        long x = Long.parseLong(y);
        return x;
    }

    public String saatsizhal() {

        String saatsiz = "";

        boolean dogrumu = tarihkontrol();
        if (dogrumu == true) {
            for (int i = 0; i < girilentarih.length(); i++) {
                if (girilentarih.charAt(i) != ':' && girilentarih.charAt(i) != '-') {
                    saatsiz += girilentarih.charAt(i);
                } else if (girilentarih.charAt(i) == ':') {
                    break;
                }
            }
        }
        return saatsiz;
    }

    public long saatsizsayiyacevirme() {
        long sayisaatsiz = Long.parseLong(saatsizhal());
        return sayisaatsiz;
    }
  

}
