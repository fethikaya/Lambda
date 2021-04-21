package streamOrnekler;

import fonksiyonal.Lambda01Kurallar;

import java.util.ArrayList;
import java.util.List;

public class Stream01_Integer {

    public static void main(String[] args) {


        List<Integer> rakamlar = new ArrayList<>();
        rakamlar.add(5);
        rakamlar.add(5);
        rakamlar.add(7);
        rakamlar.add(7);
        rakamlar.add(9);
        rakamlar.add(-1);
        rakamlar.add(2);
        rakamlar.add(4);
        rakamlar.add(-1000);
        rakamlar.add(4);

        System.out.println("==== TEK SAYILAR ======");
        rakamlar.stream().filter(t -> t%2 != 0).forEach(x ->System.out.print(x));

        System.out.println("\n==== ÇİFT SAYILAR ======");
        rakamlar.stream().filter(t -> t%2 == 0).forEach(Stream01_Integer::yazdır);

        System.out.println("\n==== TEK SAYILAR =====");
        rakamlar.stream().filter(Stream01_Integer::tekMi).forEach(Stream01_Integer::yazdır);

        System.out.println("\n==== ÇİFT SAYILAR(METHOD) =====");
        çiftleriYazdır(rakamlar);
    }

    public static void çiftleriYazdır(List <Integer> liste){
//      liste.stream().filter(x->x%2==0).forEach(x-> System.out.print(x + " "));
        liste.stream().filter(Stream01_Integer::çiftMi).forEach(Stream01_Integer::yazdır);
    }

    public static boolean tekMi(int x){
        return x % 2 != 0;
    }

    public static boolean çiftMi(int x){
        return x%2==0;
    }

    public static void yazdır(int x){
        System.out.print( x + " ");
    }


}