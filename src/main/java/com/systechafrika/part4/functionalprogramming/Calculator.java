package com.systechafrika.part4.functionalprogramming;

@FunctionalInterface
public interface Calculator {

    //NB:all methods defined in an interface are abstract
    //in a functional interface we can also have default and static methods which are implemented
    //abstract int calculate(int a,int b);
    abstract int calculate(int a, int b,int...numbers);

    default int sum(int a,int b){
        return a+b;
    }
    static String printInfo(){

        return "Functional Programming";
    }






}
