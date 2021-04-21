package streamOrnekler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Steam04String {

    public static void main(String[] args) {

        List<String> liste = new ArrayList<>();
        liste.add("Ali");
        liste.add("Mark");
        liste.add("Jackson");
        liste.add("Amanda");
        liste.add("Mariano");
        liste.add("Alberto");
        liste.add("Tucker");
        liste.add("alfanso");
        liste.add("Christ");

        aIleBaslayanlar(liste);
        System.out.println("===========");
        buyukHarfeCevir(liste);
        System.out.println("===========");
        uzunlugaGoreYazdir(liste, 3);
        System.out.println("TÜM ELEMANLAR BELİRTİLEN DEĞERDEN KÜÇÜK:" + uzunlukKucukMu(liste, 7));
        System.out.println("=======");
        System.out.println("Bu harfla başlayan yok mu? : " + baslamayanHarf(liste, "B"));
        System.out.println("======================");
        System.out.println("Son Harfi bu harf ile bitiyor :" + sonHarfiKontrolEt(liste, "r"));
        System.out.println("==================");
        aileBaslaOileBiten(liste);
        System.out.println("============");
        elmanUzunlukSirala(liste);
        System.out.println("====================");
        buyukKucukHarf(liste);



    }

    //********************************************************************************************
    // ORNEK16: Listedeki baş harfi A ile başlayan isimleri yazdıran metodu tanımlayalım..
    //********************************************************************************************
    public static void aIleBaslayanlar(List<String> liste) {
        liste.stream().filter(h -> h.startsWith("A")).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK17: Listedeki tüm isimleri büyük harfe çeviren metodu tanımlayalım..
    //********************************************************************************************
    public static void buyukHarfeCevir(List<String> liste) {
        liste.stream().map(h -> h.toUpperCase()).forEach(System.out::println);
    }

    //********************************************************************************************
    // ORNEK18: Listedeki tüm elemanların uzunlukları belirtilen uzunluktan fazla ise bunları yazdıran
    // metodu tanımlayalım..
    //********************************************************************************************
    public static void uzunlugaGoreYazdir(List<String> liste, int uzunluk) {
        liste.stream().filter(t -> t.length() > uzunluk).forEach(System.out::println);
    }

    //*****************************************************************************************
    /*
    allMatch  methodu Belirtilen şartları tüm elamanları sağlıyorsa true döndürür.
    Yoksa false döndürür.
      */

    // ÖRNEK20: Listedeki TÜM elemanların uzunlukları belirtilen uzunluktan KÜÇÜK mü
    // diye kontrol eden metodu yazınız.
    //*****************************************************************************************
    public static boolean uzunlukKucukMu(List<String> liste, int uzunluk) {
        return liste.stream().allMatch(t -> t.length() < uzunluk);
    }

    //****************************************************************************************************
    /*
    noneMatcah () methodu, belitilen şartları tüm elemanlar sağlamıyorsa ture döndür.
    sağlıyorsa false döndürü.
     */
    // ÖRNEK21: Listedeki TÜM elemanların belirtilen harfi ile başlamadığını kontrol eden metodu yazınız.
    //****************************************************************************************************
    public static boolean baslamayanHarf(List<String> liste, String harf) {
        return liste.stream().noneMatch(t -> t.startsWith(harf));
    }
    //****************************************************************************************************
    /*
    anyMatcah () methodu, belitilen şartları tüm elemanlar sağlamıyorsa ture döndür.
    sağlıyorsa false döndürü.
     */
    // ÖRNEK22: Listedeki hernhgi bir belirtilen bir harf ile bitiyor mu diye kontrol eden methodu yazınız. .
    //****************************************************************************************************

    public static boolean sonHarfiKontrolEt(List<String> liste, String harf) {
        return liste.stream().anyMatch(t -> t.endsWith(harf));

    }

    //****************************************************************************************************
    // ÖRNEK23: Listedeki a ile başlayıp o ile biten elamanların yazdıran methodu tanımlaynız
    //****************************************************************************************************
    public static void aileBaslaOileBiten(List<String> liste) {
        liste.stream().
                filter(t -> t.startsWith("A") && t.endsWith("o")).
                forEach(System.out::println);
    }

    //****************************************************************************************************
    // ÖRNEK24: Aşağıdaki formata göree listedeki her bir elamanı uzunluğunu yazdıran method
    //  Ali: 3      Mark:4      Amanda:6 vb
    //****************************************************************************************************

    public static void elmanUzunlukSirala(List<String> liste) {
        liste.stream().
                sorted(Comparator.comparing(t -> t.length())).
                map(t -> t + " : " + t.length()).
                forEach(System.out::println);

    }

    //****************************************************************************************************
    // ÖRNEK25: Büyük harf ve küçük harf duyarsız olsun
    //****************************************************************************************************
    public static void buyukKucukHarf(List<String> liste) {
        liste.stream().
                map(String::toLowerCase).
                filter(t -> t.startsWith("a")).
                forEach(System.out::println);
    }










}