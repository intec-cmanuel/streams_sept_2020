package be.intecbrussel.demo1;

import java.util.OptionalDouble;
import java.util.stream.Stream;

public class StreamsIntro {
    public static void main(String[] args) {
        //method1();
        //method2();
        method3();
    }

    private static void method3() {
        SomewhatMammal[] arr = new SomewhatMammal[5];
        arr[0] = new Bird("Birb", 2, 10);
        arr[1] = new JellyFish("Patrick", 5, 1);
//        arr[2] = new Bird("Squidward", 99, 98);
//        arr[3] = new JellyFish("Srawberry", 11, 50);
//        arr[4] = new JellyFish("*t", 3, 40);

        // FORLOOP
        double sum = 0;
        int count = 0;
        for (int i =0; i< arr.length; i++){
            if (arr[i] != null) {
                sum += arr[i].getWeight();
                count++;
            }
        }

        if (count > 0) {
            double avg = sum / count;
            System.out.println("Average weight is " + avg);
        }

        // STREAMS
        OptionalDouble averageWeight = Stream.of(arr)
                .filter(mammal -> mammal != null)
                .mapToDouble(mammal -> mammal.getWeight())
                .average();

        if (averageWeight.isPresent()) {
            System.out.println("Average weight is " + averageWeight.getAsDouble());
        }
    }

    private static void method2() {
        Integer[] intArr = new Integer[]{2,8,96,74,4,6,5,48,6,84,6,6};

        // Print de 3 eerste even getallen groter dans 4
        int count = 0;
        for (int i = 0; i < intArr.length; i++) {
            if (intArr[i] % 2 == 0 && count < 3 && intArr[i] > 4){
                System.out.println(intArr[i]);
                count++;
            }
        }
        System.out.println();

        Stream.of(intArr).filter(number -> number % 2 == 0)
                         .filter(number -> number > 4)
                         .limit(3)
                         .forEach(number -> System.out.print(number + " "));

        System.out.println();
    }

    public static void method1() {
        Integer[] intArr = new Integer[]{2,8,96,74,4,6,5,48,6,84,6,6};

        for (Integer integer : intArr) {
            System.out.print(integer + " ");
        }
        System.out.println();

        Stream.of(intArr).forEach(number -> System.out.print(number + " "));
        System.out.println();
    }
}
