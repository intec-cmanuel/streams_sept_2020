package be.intecbrussel.oefening;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        int[] intArr = new int[]{12,54,98,4,12,3,5,48,94,6};
        String[] strArr = new String[]{"Hello", "2", "Potato", "99", "Scuzi"};

        // Maak een stream die elke integer gaat vermenigvuldigen met 5 en die dan afprinten als de integer groter is dan 50
//        IntStream.of(intArr).map(number -> number * 5)
//                .filter(number -> number>50)
//                .forEach(number -> System.out.print(number + " "));

//        IntStream.of(intArr)
//                .map(i -> i * 5)
//                .filter(i -> i > 50)
//                .forEach(i -> System.out.print(i + " "));
//        System.out.println(" ");
//
//        IntStream.of(intArr).map(n -> n * 5)
//                .filter(n -> n > 50)
//                .forEach(System.out::println);
//
//        Arrays.stream(intArr)
//                .filter(number-> number*5>50)
//                .forEach(number-> System.out.println(number*5));
//
//        IntStream.of(intArr)
//                .map(integer -> integer * 5)
//                .filter(integer -> integer > 50)
//                .forEach(i -> System.out.print(i + " "));

        // Maak een stream die elke integer in de array gaat delen door 2 en vang de nieuwe stream op in een nieuwe array

//        double[] doubles = IntStream.of(intArr).mapToDouble(number -> 1.0 * number/2)
//                .toArray();
//        DoubleStream.of(doubles).forEach(number -> System.out.print(number + " "));
//
//        int[] intArr2 = IntStream.of(intArr)
//                .map(i -> i /= 2)
//                .toArray();
//        Arrays.stream(intArr2).forEach(e -> System.out.print(e + " "));
//
//        double[] doubleArray = IntStream.of(intArr).mapToDouble(n -> n/2d)
//                .toArray();
//        Arrays.stream(doubleArray).forEach(e -> System.out.print(e + " "));
//
//        Integer[] numbers = {3, 9, 5, 0, 13, 7, 11, 4, 8, 6};
//        Integer[] newList = Stream.of(numbers).map(n -> n / 2).toArray(size -> new Integer[size]);
//
//        int[] iArray2 = IntStream.of(intArr).map(i -> i/=2)
//                .toArray();
//
//        BigInteger[] bigArr;
//        Stream.iterate(BigInteger.ONE, x -> x.divide(BigInteger.valueOf(2)))
////                .toArray(BigInteger[]::new);
//                  .sorted()
//                  .forEach(e -> System.out.print(e+ " "));

        // Maak een stream die de eerste twee strings in hoofdletter gaat plaatsen en dan de 2 strings gaat combineren naar 1 strings.

//        String text = Stream.of(strArr)
//                .limit(2)
//                .map(String::toUpperCase)
//                .reduce("", (acc, el) -> acc + el + " ");
//        System.out.print(text);
//
//        String str = Stream.of(strArr)
//                .map(String::toUpperCase)
//                .limit(2)
//                .reduce("", (s, s2) -> s + s2);
//        System.out.println(str);
//
//        Optional<String> singleString = Stream.of(strArr)
//                .limit(2)
//                .map(String::toUpperCase)
//                .reduce((acc, el) -> acc + el);
//        if (singleString.isPresent()) {
//            System.out.println("singleString = " + singleString.get());
//        }

//        String newString = Stream.of(strArr).limit(2)
//                .map(String::toUpperCase)
//                .reduce((accumulator, strr) -> accumulator + strr).toString();

        // Maak een stream die de som gaat bereken van alle integer in de array, behalve de eerste 2 integers.
//        int sum = IntStream.of(intArr)
//                .skip(2)
//                .sum();
//        System.out.println(sum);
//
//        int oneLinerSum = IntStream.of(intArr).skip(2).sum();
//        System.out.println(oneLinerSum);
        // #oneLiner

//         int[] bigBrainArray = IntStream
//                .rangeClosed(1, intArr.length)
//                .map(i -> intArr[intArr.length - i])
//                .toArray();
//
//        int result = Arrays.stream(bigBrainArray)
//                .limit(intArr.length - 2)
//                .sum();
//        System.out.println(result);
//
//        IntStream.of(intArr)
//                .skip(2)
//                .sum();

        // Maak een Stream die alle strings die kunnen omgezet worden naar integers, gaat omzetten naar integers.
        // (Tip: Gebruik een hulpmethode om een exception op te vangen)

        Stream.of(strArr).filter(num -> convertableToInt(num))
                .mapToInt(number -> Integer.valueOf(number))
                .forEach(number -> System.out.print(number + " "));


//        Stream<String> stringToIntStream = Stream.of(strArr);
//        stringToIntStream.mapToInt(String::hashCode)
//                .peek(i -> {
//                    try {
//                        checkSize(i);
//                    } catch (TooBigTooHandleException e) {
//                        e.getMessage();
//                    }
//                })
//                .forEach(i -> System.out.print(i + " "));


//        try {
//            Stream.of(strArr)
//                    .mapToInt(String::hashCode)
//                    .forEach(App::checkSize2);
//        } catch (TooBigForIntegerException e) {
//            e.printStackTrace();
//        }
//
//        IntStream intStream = Stream.of(strArr).mapToInt(Integer::parseInt);
//        System.out.println("Stream created, before foreach");
//        intStream.forEach(e -> System.out.println());
//        System.out.println("After foreach");
//
//        int[] numbers = Stream.of(strArr)
//                .mapToInt(value -> Integer.parseInt(value))
//                .toArray();
    }


    private static boolean convertableToInt(String number){
        try {
            Integer.valueOf(number);
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private static void checkSize(int i) throws TooBigTooHandleException {
        if (!(i < Integer.MAX_VALUE)) {
            throw new TooBigTooHandleException("this value is bigger than the max value of an integer.");
        }
    }

    private static void checkSize2(int i) throws TooBigForIntegerException{
        if (i > Integer.MAX_VALUE){
            throw new TooBigForIntegerException();
        }
    }

    private static void method5(String[] strNumbers) {
        int[] numbers = Stream.of(strNumbers)
                .filter(s -> s!=null)
                .mapToInt(value -> convertStringToInt(value))
                .toArray();
        Arrays.stream(numbers).forEach(n -> System.out.print(n + " "));
    }
    private static int convertStringToInt(String value) {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException nfe) {
            nfe.printStackTrace();
        }

        return result;
    }
}
