package streamOrnekler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;


public class Stream06Files {

    public static void main(String[] args) throws IOException { // ya dosyayı bulmazsam, hatasına karşılık bunu yazdık


        // ==== NOT==
        // Her seferinde path yazmamak için, bir dexişkene tanımlayabiliriz.

        String path = "src/streamOrnekler/fethi";

        Stream<String> siir = Files.lines(Path.of("src/streamOrnekler/fethi"));
        // Dosya yolunu tanımladık. hata verdi. ya bulamazsam diye uyarı geldi. throws IOException ile çözdük

       siir.forEach(System.out::println);  // Fethi file daki tüm satırları okuduk

        System.out.println("=================================");


    // Tüm satırları büyük harfe çevirin

        Files.lines(Path.of("src/streamOrnekler/fethi")).
                    map(t->t.toUpperCase()).
                    forEach(System.out::println);

        System.out.println("==========================");

/*
        // Dosya'dan sadece ilk satırı alıp büyük harfe çevirerek okuyunuz.
        Files.lines(Path.of("src/streamOrnekler/fethi")).
              findFirst().
                map(t->t.toUpperCase()).
               forEach(System.out::println);

        System.out.println("==============================");

 */

        // Sadece 3 ve 4. satırı yazdırın

        Files.lines(Path.of("src/streamOrnekler/fethi")).
                map(String::toUpperCase).skip(3).limit(2). // İlk 3 satırı atla. sonra iki satırı al.
                forEach(System.out::println);


        System.out.println("==========================");

        // Dosya'da kaç tane Diyarbakır kelimesi geçtinini bulunuz.
        // Küçük büyük harf uyumuna duyarlı bir şekildi
        System.out.println(Files.lines(Path.of("src/streamOrnekler/fethi")).
                    map(String::toLowerCase).
                    filter(t -> t.contains("diyarbakır")).
                    count());


        System.out.println("=====Tüm Kelimeler =========");

        //Dosyadaki tüm farklı kelimelri alt alta yazdıralım.
        Files.lines(Path.of("src/streamOrnekler/fethi")).
                map(t->t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                distinct().
                forEach(System.out::println);



        System.out.println("=====Kelime içinde m harfler =========");

        //Kaç kelime içinde m harfi var.

      long mAdeti =  Files.lines(Path.of("src/streamOrnekler/fethi")).
                map(t->t.toLowerCase().split(" ")).
                flatMap(Arrays::stream).
                filter(t->t.contains("m")).
                count();
        System.out.println("M harfinin adeti : " + mAdeti);



        System.out.println("=====Kaç karekter=========");

        //Boşluk ve noktalama işaretleri hariç kaç tane karekter kullanmıştır.
        System.out.println(Files.lines(Path.of("src/streamOrnekler/fethi")).
                map(t->t.replace("_","").replaceAll("\\W","").split("")).
                flatMap(Arrays::stream).
                count());





    }



}
