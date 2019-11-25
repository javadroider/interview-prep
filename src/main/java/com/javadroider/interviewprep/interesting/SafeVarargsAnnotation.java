package com.javadroider.interviewprep.interesting;

import java.util.ArrayList;
import java.util.List;

public class SafeVarargsAnnotation {

    public static void main(String[] args) {

        // Scenario 1 -
        // Prior to Java 7, usage of code without @SafeVarargs
        withoutSafeVarargsAnnotation();

        // Scenario 2 -
        // After Java 7, usage of code with @SafeVarargs
        withSafeVarargsAnnotation();

    }

    private static void withoutSafeVarargsAnnotation() {

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);

        List<Float> listOfFloats = new ArrayList<>();
        listOfFloats.add(3.0f);
        listOfFloats.add(1.0f);
        listOfFloats.add(2.0f);
        listOfFloats.add(3.2f);

        // Calling of a method that takes in a generic type of
        // variable arguments without usage of @SafeVarargs
        // It generates a warning for the developer for the type safety as
        // Type safety: A generic array of List< ? extends Number&Comparable< ? > >
        // is created for a varargs parameter
        displaywithoutSafeVarargs(listOfIntegers, listOfFloats);

    }

    // Also throws a warning for
    // Type safety: Potential heap pollution via varargs parameter lists
    private static <T> void displaywithoutSafeVarargs(T... lists) {

        for (T element : lists) {

            System.out.println("Display of elements without @SafeVarargs Annotation");
            System.out.println(element.getClass().getName() + ": " + element);

        }

    }


    private static void withSafeVarargsAnnotation() {

        List<Integer> listOfIntegers = new ArrayList<>();
        listOfIntegers.add(1);
        listOfIntegers.add(2);
        listOfIntegers.add(3);
        listOfIntegers.add(4);

        List<Float> listOfFloats = new ArrayList<>();
        listOfFloats.add(3.0f);
        listOfFloats.add(1.0f);
        listOfFloats.add(2.0f);
        listOfFloats.add(3.2f);

        displaywithSafeVarargs(listOfIntegers, listOfFloats);

    }

    // With usage of @SafeVarargs the Type Safety warning has been
    // supressed
    @SafeVarargs
    private static <T> void displaywithSafeVarargs(T... lists) {

        System.out.println();
        for (T element : lists) {

            System.out.println("Display of elements with @SafeVarargs Annotation");
            System.out.println(element.getClass().getName() + ": " + element);

        }

    }

}