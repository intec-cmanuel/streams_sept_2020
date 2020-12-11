package be.intecbrussel.demo2;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SecondStreamDemo {
    public static void main(String[] args) {
        //method1();
        //method2();
        //method3();
        //method4();
        //method5();
        //method6();
        //method7();
        method8();

//        Random rng1 = new Random(7777);
//        Random rng2 = new Random(4984);
//        Random rng3 = new Random(7777);
//
//        System.out.println(rng1.nextInt(10));
//        System.out.println(rng1.nextInt(10));
//        System.out.println(rng1.nextInt(10));
//        System.out.println(rng2.nextInt(10));
//        System.out.println(rng2.nextInt(10));
//        System.out.println(rng2.nextInt(10));
//        System.out.println(rng3.nextInt(10));
//        System.out.println(rng3.nextInt(10));
//        System.out.println(rng3.nextInt(10));
    }

    private static void method8() {
        IntStream stream = IntStream.range(0, 30);
        stream = stream.filter(e -> e % 2 == 0);

        int[] arr = stream.peek(e -> System.out.println(e + " "))
                .toArray();



        Arrays.stream(arr).forEach(e -> System.out.println("DDT"));
    }

    private static void method7() {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, 100)
                .peek(e -> list.add(e))
                .forEach(e -> System.out.print(e + " "));
    }

    private static void method6() {
        IntStream.generate(() -> yes())
                .limit(10)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static Integer yes() {
        Random rng = new Random();

        int x = rng.nextInt(20);
        while (x < 11) {
            x = rng.nextInt(20);
        }
        return x;
    }


    private static void method5() {
        IntStream.range(0, 1000)
                .filter(number -> number % 3 == 0 && number % 4 == 0 && number % 8 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        IntStream.range(0, 1000)
                .filter(number -> number % 3 == 0)
                .filter(number -> number % 4 == 0)
                .filter(number -> number % 8 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        IntStream.range(0, 1000)
                .filter(number -> number % 24 == 0)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        int[] numbersDividableBy24 = IntStream.range(0, 1000)
                .filter(number -> number % 24 == 0)
                .toArray();

        Arrays.stream(numbersDividableBy24).forEach(e -> System.out.print(e + " "));
        System.out.println();


        List<Integer> numbersList = IntStream.range(0, 1000)
                .filter(number -> number % 24 == 0)
                .mapToObj(number -> number)
                .collect(Collectors.toCollection(ArrayList::new));

        numbersList.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    private static void method4() {
//        System.out.println(IntStream.range(0, 30).min().getAsInt());
//        System.out.println(IntStream.range(0, 30).max().getAsInt());
//        System.out.println(IntStream.range(0, 30).average().getAsDouble());
//        System.out.println(IntStream.range(0, 30).sum());

        System.out.println(IntStream.range(1, 5).reduce(1, (carry, e) -> carry * e));

        String[] combatants = {"Shelbatra", "Matteo", "Mert", "Salai"};
        String title = Stream.of(combatants)
                .reduce("The battle of tonight: ", (acc, el) -> acc + el + " VS ");
        System.out.println(title.substring(0, title.length() - 3));
    }

    private static void method3() {
        Stream.generate(() -> "Anthony is sus >:]")
                .forEach(e -> System.out.println(e));
    }

    private static void method2() {
        IntStream.iterate(10, i -> i + 500)
                .limit(100)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    public static void method1() {
        IntStream.range(0, 10)
                .forEach(number -> System.out.print(number + " "));
        System.out.println();

        IntStream.rangeClosed(0, 10)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();
    }
}
