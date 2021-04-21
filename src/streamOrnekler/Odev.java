package streamOrnekler;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Odev {

    public static void main(String[] args) {

        List<Integer> rakamlar = new ArrayList<>();

        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-10);
        rakamlar.add(4);

        elemanCarp(rakamlar);

        max1 (rakamlar);
        max2 (rakamlar);
        max3 (rakamlar);
        max4 (rakamlar);

        ondanKucukEnBuyuk (rakamlar);

    }

    // Listdeki tüm elamanların çarpımını ekrana yazdırın.

    // Lambda Expression ile
    public static void elemanCarp (List <Integer> rakamlar){
        int carpma = rakamlar.stream().filter(t-> t%2==0).reduce(1, (x,y)->x*y);
        System.out.println(carpma);
    }

    // Method Referans ile
    public static void elemanCarp2 (List <Integer> rakamlar){
        Optional<Integer> carpma = rakamlar.stream().filter(t-> t%2==0).reduce(Math::multiplyExact);
        System.out.println(carpma);
    }


    // Listdeki elamanların en büyüğünü 4 farklı yol ile bulunuz

    //1. yol
    public static void max1 (List <Integer> rakamlar){
     Optional<Integer> max = rakamlar.stream().reduce(Math::max);
        System.out.println(max);
    }

    //2. yol
    public static void max2 (List <Integer> rakamlar){
        Optional<Integer> max = rakamlar.stream().reduce(Integer::max);
        System.out.println(max);
    }

    //3. yol

    public static int maxBul (int x, int y){
    return x>y ? x:y;
    }

    public static void max3 (List <Integer> rakamlar){
        Optional<Integer> max = rakamlar.stream().reduce(Odev::maxBul);
        System.out.println(max);
    }

    // 4.yol
    public static void max4 (List <Integer> rakamlar){
        int max = rakamlar.stream().reduce(Integer.MIN_VALUE, (x, y) -> x > y ? x : y);
        System.out.println(max);
    }

    // Lesteki elemanlardan 10 küçük en büyük sayı

    public static void ondanKucukEnBuyuk (List <Integer> rakamlar){
        Optional<Integer> ondanKucuk = rakamlar.stream().filter(t-> t<10).reduce(Math::max);
        System.out.println(ondanKucuk);
    }

}
