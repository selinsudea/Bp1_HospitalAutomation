
/*
 *@file Hastaneotomasyon 
 *@ Bir hastane otomasyonu hazırladım.Çeşitli kontroller yaparak randevu alabiliyorum.
 *@assignment Proje2
 *@18.01.2022-22.01.2022
 * @author Selin Sude ATALI - selinsude.atali@stu.fsm.edu.tr
 */
public class Doktor extends Hastane {

    private String uzmanlıkderecesi;
    private String alani;
    private Arraylist doktorrandevulistesi;
    private Arraylist doktorgelecekrandevulistesi;
  
    private Arraylist doktoreskirandevulistesi;

    public Doktor() {
    }

    public Doktor(String uzmanlıkderecesi, String alani, String ad, String il, String ilce) {
        super(ad, il, ilce);
        this.uzmanlıkderecesi = uzmanlıkderecesi;
        this.alani = alani;
        doktorrandevulistesi = new Arraylist();
        doktoreskirandevulistesi = new Arraylist();
        doktorgelecekrandevulistesi = new Arraylist();
      
    }

   
   
    public Arraylist getDoktoreskirandevulistesi() {
        return doktoreskirandevulistesi;
    }

    public void setDoktoreskirandevulistesi(Arraylist doktoreskirandevulistesi) {
        this.doktoreskirandevulistesi = doktoreskirandevulistesi;
    }

    public Arraylist getDoktorgelecekrandevulistesi() {
        return doktorgelecekrandevulistesi;
    }

    public void setDoktorgelecekrandevulistesi(Arraylist doktorgelecekrandevulistesi) {
        this.doktorgelecekrandevulistesi = doktorgelecekrandevulistesi;
    }

   
    public Arraylist getDoktorrandevulistesi() {
        return doktorrandevulistesi;
    }

    public void setDoktorrandevulistesi(Arraylist doktorrandevulistesi) {
        this.doktorrandevulistesi = doktorrandevulistesi;
    }

    public String getUzmanlıkderecesi() {
        return uzmanlıkderecesi;
    }

    public void setUzmanlıkderecesi(String uzmanlıkderecesi) {
        this.uzmanlıkderecesi = uzmanlıkderecesi;
    }

    public String getAlani() {
        return alani;
    }

    public void setAlani(String alani) {
        this.alani = alani;
    }

    public void doktorbilgileriyazdir() {
        System.out.println("Doktorun adı:" + getAd() + "alanı:" + getAlani() + "uzmanlık derecesi:" + getUzmanlıkderecesi());
    }

}
