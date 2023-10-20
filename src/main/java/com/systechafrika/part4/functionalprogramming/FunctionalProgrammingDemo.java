package com.systechafrika.part4.functionalprogramming;

import java.util.List;
import java.util.stream.Stream;

public class FunctionalProgrammingDemo {
    public static void main(String[] args) {
        FunctionalProgrammingDemo a = new FunctionalProgrammingDemo();
        //a.functions();
        //a.lambdaInFunction();
        //a.filterAndMap();
        a.filterAndMapChaining();
    }
    public void filterAndMapChaining(){
        List<Integer>numbers= List.of(1,2,3,4,5);
        numbers.stream()
                .filter(number->number%2==0)
                .map(number->number*number)
                .forEach(number-> System.out.println(number));
    }

    public void filterAndMap(){
        List<Integer>numbers= List.of(1,2,3,4,5);
        //create a stream
        Stream<Integer>stream=numbers.stream();
        //filter a stream=>creates a new stream
        Stream<Integer> filterdStream = stream.filter(number-> number% 2 == 0);
        //Mmap->transformation
        Stream<Integer> integerStream1 = filterdStream.map(number -> number * number);
        //display final product
        integerStream1.forEach(number-> System.out.println(number));

    }

    public void lambdaInFunction(){
        List<Integer>integers=List.of(1,2,3,4,5);
        /*for (int number:integers) {
            System.out.println(number);

        }*/
        //instead of using the above foreach,we can also use ths
        integers.forEach(number-> System.out.println(number));

    }


    public void functions() {

        //Calculator calc= (int a, int b)->{return a+b;};
        //the above code can be the same as this
        //Calculator calc=(a,b)->a+b;
        Calculator cal2=(a, b,numbers)->{
            int sum=a+b;
            for (int number:numbers) {

                sum +=number;
            }
            return sum;
        };
        System.out.println(cal2.calculate(10,5));
        System.out.println(cal2.calculate(10,5,5,9,7,23,76));
    }
    /* Calculator calc= new Calculator() {
            @Override
            public int calculate(int a, int b) {
                return 0;
            }
        };

     */
}
