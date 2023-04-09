import javax.annotation.processing.Filer;
import java.sql.SQLOutput;
import java.util.Optional;
import java.util.Scanner;
import java.io.*;

class GenelÜyelereMail extends TümÜyelereMail { //Kalıtımla genel üyelere  mail atıyoruz
    public GenelÜyelereMail(String bilgi) {
        super(bilgi);
    }
    @Override
    public void mailGönder() {
        System.out.println("Genel üyelere mail gönderildi : " + getBilgi());
    }

}
class TümÜyelereMail {  //  tüm üyelere mail atmak için oluşturuldu , bu class ana class olacak
    private String bilgi;    //bilgi değişkeni kulllanıcıdan alınıp mail olarak atılacak
    public String getBilgi() {    //getter ve setterı alındı
        return bilgi;
    }
    public void setBilgi(String bilgi) {
        this.bilgi = bilgi;
    }

    public TümÜyelereMail(String bilgi) {   //constu yazıldı
        this.bilgi = bilgi;
    }

    public void mailGönder() {         // bir adet metod yazıldı
        System.out.println("Tüm üyelere mail gönderildi :" + getBilgi());
    }

}

class ElitÜyelereMail extends TümÜyelereMail { //elit üyelere mail atılıyor
    public ElitÜyelereMail(String bilgi) {
        super(bilgi);
    }

    @Override
    public void mailGönder() {
        System.out.println("Elit üyelere  mail gönderildi  :" + getBilgi());
    }

}

class BaseÜyeEkleme {    // üye eklemek için bir class yazıldı , bu class ana class olacak .
    private String isim;      // ana class a isim soyisim ve email değişkenleri eklendi
    private String soyisim;
    private String eMail;

    public BaseÜyeEkleme(String isim, String soyisim, String eMail) {  //const oluşturuldu
        this.isim = isim;
        this.eMail = eMail;
        this.soyisim = soyisim;

    }
    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

}

class GenelÜyeEkleme extends BaseÜyeEkleme {   /*kalıtımla base üye ekleme ana class ındaki değişkenleri alıp
                                              içine değerler koyup genel üye ekliyoruz */
    public GenelÜyeEkleme(String isim, String soyisim, String eMail) {
        super(isim, soyisim, eMail);
    }

    public void bilgiGöster() {
        System.out.println("genel üyenin ismi " + getIsim());
        System.out.println("genel üyenin soyismi " + getSoyisim());
        System.out.println("genel üyenin emaili " + geteMail());
    }

}

class ElitÜyeEkleme extends BaseÜyeEkleme {   /*kalıtımla base üye ekleme ana class ındaki değişkenleri alıp
                                              içine değerler koyup genel üye ekliyoruz*/
    public ElitÜyeEkleme(String isim, String soyisim, String eMail) {
        super(isim, soyisim, eMail);

    }
    public void bilgiGöster() {
        System.out.println("elit üyenin ismi " + getIsim());
        System.out.println("elit üyenin soyismi " + getSoyisim());
        System.out.println("elit üyenin emaili " + geteMail());
    }
}

class DosyaBirleştirme {      /* ELİT ÜYE.txt si ile GENEL ÜYE.txt sini bu metod ile alt alta ekleyip
                               yeni bir BÜTÜN KULLANICILAR.txt oluşturuyoruz*/
    public void birleştir() throws IOException {
        PrintWriter printWriter = new PrintWriter("BÜTÜN KULLANICILAR.txt"); // içine yazmaya başlıyoruz
        BufferedReader bufferedReader = new BufferedReader(new FileReader("ELİT ÜYE.txt"));
        String deneme = bufferedReader.readLine();
                //İlk olarak elit üye txt sindeki her şey okunup bütün kullanıcılara ekleniyor
        while (deneme != null) {
            printWriter.println(deneme);
            deneme = bufferedReader.readLine();

        }
        bufferedReader = new BufferedReader(new FileReader("GENEL ÜYE.txt"));
        deneme = bufferedReader.readLine();
           /* burada ise eklenen verilerin altına genel üye txt sindeki veriler ekleniyor ve
          bütün kullanıcılar txt si oluşuyor*/
        while (deneme != null) {
            printWriter.println(deneme);
            deneme = bufferedReader.readLine();
        }
        bufferedReader.close();
        printWriter.flush();
        printWriter.close();


    }

}
public class Main {
    public static void main(String[] args) throws IOException {
        DosyaBirleştirme dosyaBirleştirme = new DosyaBirleştirme();
        File file = new File("ELİT ÜYE.txt");   //elit üye txtsi oluşturuldu
        if (!file.exists()) {
            file.createNewFile();
        }
        File file1 = new File("BÜTÜN KULLANICILAR.txt");  //bütün kullanıcılar txt si oluşturuldu
        if (!file.exists()) {
            file1.createNewFile();
        }
        File file2 = new File("GENEL ÜYE.txt");  //genel üye txtsi oluşturuldu
        if (!file2.exists()) {
            file2.createNewFile();

        }
        // elit üye ,genel üye ve bütün kullanıcılar  txt si için gerekli fonksiyonlar yazıldı
        FileWriter fileWriter = new FileWriter(file, false);
        FileWriter fileWriter2 = new FileWriter(file2, false);
        FileWriter fileWriter1=new FileWriter(file1,false);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);

        int sayac1 = 0;
        int sayac2 = 0;

        continue1: // do while continue ile geri dönüş sağlandı
        do {
            Scanner input1 = new Scanner(System.in);   // farklı girişler ile farklı değişkenler (int,char,string) alındı
            Scanner input2 = new Scanner(System.in);
            Scanner input3 = new Scanner(System.in);
            System.out.println("Elit üye eklemek için lütfen 1'e basınız");
            System.out.println("Genel üye eklemek için lütfen 2'ye basınız");
            System.out.println("Mail göndermek için lütfen 3'e basınız");
            System.out.println("Programdan çıkmak için lütfen 4'e basınız");
            int x = input1.nextInt();
            switch (x) {
                case 1: {

                    System.out.println("Lütfen elit üyenin ismini giriniz");
                    String elitisim = input2.nextLine();
                    System.out.println("Lütfen elit üyenin soyismini giriniz");
                    String elitsoyisim = input2.nextLine();
                    System.out.println("Lütfen elit üyenin emailini giriniz");
                    String elitemail = input2.nextLine();
                    System.out.println("Elit üye bilgisi :");
                    ElitÜyeEkleme elit = new ElitÜyeEkleme(elitisim, elitsoyisim, elitemail);
                    elit.bilgiGöster();

                    if (sayac1 == 0) {   // Bir kez elit üye başlığının yazılması için sayaç eklendi
                        int satir = 0;
                        String string = "---ELİT ÜYE---\n";
                        for (int i = 0; i < satir; i++) {

                            bufferedWriter.newLine();
                        }
                        bufferedWriter.write(string); // başlık eklendi
                     // başlığın altına girilen veriler eklendi
                        bufferedWriter.write(elitisim+"\t"+elitsoyisim+"\t"+elitemail+"\n");
                        bufferedWriter.flush();
                    } else if (sayac1 != 0) {
                        // başlığın altına girilen verilerin eklenmesine devam edildi
                        bufferedWriter.write(elitisim+"\t"+elitsoyisim+"\t"+elitemail+"\n");
                        bufferedWriter.flush();
                    }

                    sayac1++;
                    bufferedWriter.flush(); //bütün writelerın eklenmesini sağlıyor
                    dosyaBirleştirme.birleştir();  //dosyalar birleştirildi

                    System.out.println("Ana menüye dönmek için e ye programdan çıkmak için h ye basiniz");
                    char y = input3.next().charAt(0);

                    if (y == 'e') {
                        continue continue1;

                    } else if (y == 'h') {
                        System.out.println("programdan çıktınız");
                        return;

                    } else {
                        System.out.println("yanlış tuşlama ,programdan çıkarıldınız");
                        return;
                    }

                }
                case 2: {
                    System.out.println("Lütfen genel üyenin ismini giriniz");
                    String genelisim = input2.nextLine();
                    System.out.println("Lütfen genel üyenin soyismini giriniz");
                    String genelsoyisim = input2.nextLine();
                    System.out.println("Lütfen genel üyenin e mailini giriniz");
                    String genelemail = input2.nextLine();
                    System.out.println("Genel üye bilgisi :");
                    GenelÜyeEkleme genel = new GenelÜyeEkleme(genelisim, genelsoyisim, genelemail);
                    genel.bilgiGöster();
                    if (sayac2 == 0) {  // bir kez genel üye başlığının eklenmesi için sayaç eklendi
                        int satir = 0;
                        String string = "---GENEL ÜYE---\n";
                        for (int i = 0; i < satir; i++) {

                            bufferedWriter2.newLine();
                        }
                        bufferedWriter2.write(string); //başlık eklendi
                        // başlığın altına girilen veriler yazıldı

                        bufferedWriter2.write(genelisim+"\t"+genelsoyisim+"\t"+genelemail+"\n");

                        bufferedWriter2.flush();
                    } else if (sayac2 != 0) {
                        // veriler eklenmeye devam etti

                        bufferedWriter2.write(genelisim+"\t"+genelsoyisim+"\t"+genelemail+"\n");
                        bufferedWriter2.flush();

                    }
                    sayac2++;
                    bufferedWriter2.flush();   //bütün writerların eklenmesini sağlıyor
                    dosyaBirleştirme.birleştir(); //dosyalar birleştirildi

                    System.out.println("Ana menüye dönmek için e ye programdan çıkmak için h ye basiniz");
                    char z = input3.next().charAt(0);
                    if (z == 'e') {
                        continue continue1;
                    }
                    else if (z == 'h') {
                        System.out.println("programdan çıktınız");
                        return;
                    } else {
                        System.out.println("yanlış tuşlama,programdan çıkarıldınız.");
                        return;
                    }

                }
                case 3: {
                    System.out.println("Elit üyelere mail atmak için lütfen  1'e basınız");
                    System.out.println("Genel üyelere mail atmak için lütfen 2'ye basınız");
                    System.out.println("Tüm üyelere mail atmak için lütfen 3'e basınız");
                    int a = input1.nextInt();
                    if (a == 1) {
                        System.out.println("Lütfen elit üyelere atcağınız mesajı yazınız");
                        String mesajelit = input2.nextLine();
                        ElitÜyelereMail elitÜyelereMail = new ElitÜyelereMail(mesajelit);
                        elitÜyelereMail.mailGönder();

                        return;

                    } else if (a == 2) {
                        System.out.println("Lütfen genel üyelere atacağınız mesajı yazınız");
                        String mesajgenel = input2.nextLine();
                        GenelÜyelereMail genelÜyelereMail = new GenelÜyelereMail(mesajgenel);
                        genelÜyelereMail.mailGönder();

                        return;
                    } else if (a == 3) {
                        System.out.println("Lütfen tüm üyelere atcağınız mesajı yazınız");
                        String mesajtümüne = input2.nextLine();
                        TümÜyelereMail tümÜyelereMail = new TümÜyelereMail(mesajtümüne);
                        tümÜyelereMail.mailGönder();

                        return;
                    }
                }
                case 4: {
                    System.out.println("Programdan çıktınız");
                    return;
                }
            }
        } while (true);
    }
}

