
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Hasta {

    private String ad;
    private String il;
    private int hastasayma;
    private String rahatsizlik;
    private Tarih tarih;
    private Doktor doktor;
    private Arraylist randevulistesi;
    private Arraylist hastanintoplamrandevulistesi;
    private Arraylist hastanintoplamrandevulistesisayisal;
    private Arraylist eskirandevular;
    private Arraylist gelecekrandevular;
    private Arraylist iptalrandevulistesi;

    public Hasta() {
    }

    public Hasta(String ad, String il, String rahatsizlik) {
        this.ad = ad;
        this.il = il;
        this.rahatsizlik = rahatsizlik;
        randevulistesi = new Arraylist();
        hastanintoplamrandevulistesi = new Arraylist();
        hastanintoplamrandevulistesisayisal = new Arraylist();
        eskirandevular = new Arraylist();
        gelecekrandevular = new Arraylist();
        iptalrandevulistesi = new Arraylist();

    }

    public Arraylist getHastanintoplamrandevulistesisayisal() {
        return hastanintoplamrandevulistesisayisal;
    }

    public void setHastanintoplamrandevulistesisayisal(Arraylist hastanintoplamrandevulistesisayisal) {
        this.hastanintoplamrandevulistesisayisal = hastanintoplamrandevulistesisayisal;
    }

    public Arraylist getIptalrandevulistesi() {
        return iptalrandevulistesi;
    }

    public void setIptalrandevulistesi(Arraylist iptalrandevulistesi) {
        this.iptalrandevulistesi = iptalrandevulistesi;
    }

    public Arraylist getEskirandevular() {
        return eskirandevular;
    }

    public void setEskirandevular(Arraylist eskirandevular) {
        this.eskirandevular = eskirandevular;
    }

    public Arraylist getGelecekrandevular() {
        return gelecekrandevular;
    }

    public void setGelecekrandevular(Arraylist gelecekrandevular) {
        this.gelecekrandevular = gelecekrandevular;
    }

    public int getHastasayma() {
        return hastasayma;
    }

    public void setHastasayma(int hastasayma) {
        this.hastasayma = hastasayma;
    }

    public Arraylist getRandevulistesi() {
        return randevulistesi;
    }

    public void setRandevulistesi(Arraylist randevulistesi) {
        this.randevulistesi = randevulistesi;
    }

    public Doktor getDoktor() {
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public Arraylist getHastanintoplamrandevulistesi() {
        return hastanintoplamrandevulistesi;
    }

    public void setHastanintoplamrandevulistesi(Arraylist hastanintoplamrandevulistesi) {
        this.hastanintoplamrandevulistesi = hastanintoplamrandevulistesi;
    }

    public Tarih getTarih() {
        return tarih;
    }

    public void setTarih(Tarih tarih) {
        this.tarih = tarih;
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

    public String getRahatsizlik() {
        return rahatsizlik;
    }

    public void setRahatsizlik(String rahatsizlik) {
        this.rahatsizlik = rahatsizlik;
    }

}
