package com.example.java_lib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyClass {

    public static void main(String[] args){

        List<String> list = new ArrayList<>();
        list.add("One");
        list.add("aaaaaaa");
        list.add("B");

        Comparator<String> comparator = (String a, String b) -> {return a.compareTo(b);};

//        Collections.sort(list, comparator);
        Collections.sort(list, comparator.reversed());

        //System.out.println(list);

//        //The call to the map() method of the Stream interface is a non-terminal operation.
//        // It merely sets a lambda expression on the stream which converts each element to lowercase.
//        //The call to the count() method is a terminal operation. This call starts the iteration internally,
//        //which will result in each element being converted to lowercase and then counted.
//        long count = list.stream()
//                .map( (val) -> val.toLowerCase() )    //map converts an element to another object
//                .count();
//
//        System.out.println(list);


//        //FILTERs - If the element is to be included in the resulting Stream, the Predicate should return true.
//        List<String> s = list.stream()
//                .filter( val -> val.length() >2 )   //exclude small strings below 3 length
//                .collect(Collectors.toList());      //collect the output and convert streams to a List
//        System.out.println(s);


        //FlatMaps - maps a single element into multiple elements
        // example that flatmaps a List of strings to the words in each string
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return (Stream<String>) Arrays.asList(split).stream();
        })
                .forEach((value) -> System.out.println(value))
        ;



    }
}
