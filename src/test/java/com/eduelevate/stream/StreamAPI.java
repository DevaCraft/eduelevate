package com.eduelevate.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPI {

    @Test
    void findEvenNumber(){
        List<Integer> list = Arrays.asList(10,15,8,49,25,98,32);

    }
    @Test
    void findNumbeStartingWith1(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,32);
        List<Integer> result = numbers.stream().map(String::valueOf).filter(num -> num.startsWith("1")).map(Integer::parseInt).collect(Collectors.toList());
        System.out.println(result);
    }

    @Test
    void findDuplicates(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,98,32,15);
       // numbers.stream().collect()

    }

    @Test
    void findFirstElementIfPresent(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,98,32,15);


    }
    @Test
    void findTotalCount(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,98,32,15);

    }
    @Test
    void findMaxValue(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,98,32,15);

    }
    @Test
    void findFirstNonRepeatedCharecter(){
        String input = "Java articles are Awesome";

    }


    @Test
    void SortValues(){
        List<Integer> numbers = Arrays.asList(10,15,8,49,25,98,98,32,15);
    }

    @Test
    void testReverseString(){
        String inputStr = "123456";

    }


}
