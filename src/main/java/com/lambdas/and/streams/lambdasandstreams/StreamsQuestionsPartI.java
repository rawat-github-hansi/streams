package com.lambdas.and.streams.lambdasandstreams;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsQuestionsPartI {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Question 1:  fins sum of all elements in a list using streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("1. Sum of all the numbers : " + sum);

        // Question 2: find out maximum element
        int max = numbers.stream().max(Integer::compare).get();
        int maxComp = numbers.stream().max(Comparator.naturalOrder()).get();
        System.out.println("2. Max number : " + max + " <==> " + maxComp);

        // Question 3: Given a list of string count the number of strings that start with specific character
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange", "Watermelon", "Kiwi", "Strawberry", "blackberry");
        long fruitsCount = fruits.stream().map(String::toUpperCase).filter((fruit) -> fruit.startsWith("B")).count();
        System.out.println("3. Fruit Count : " + fruitsCount);

        // Question 4: Convert a list of Strings to uppercase and printout each element
        System.out.println("4. <<<List of fruits>>> ");
        fruits.stream().map(String::toUpperCase).forEach(System.out::println);

        // Question 5: Filter out even numbers using streams
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 9, 10, 1, 1, 6, 3, 8, 4, 5, 5, 4, 4, 5, 3, 5, 2, 7, 8, 9, 10);
        List<Integer> even = numbers2.stream().filter((n) -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("5. Even number : " + even);
        //printing for each
        numbers2.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        //print the count of even numbers
        System.out.println(numbers2.stream().filter(num -> num % 2 == 0).count());
        //print the count of odd numbers
        System.out.println(numbers2.stream().filter(num -> num % 2 != 0).count());

        // Question 6: Find average of list of floating-point numbers using streams
        List<Double> numbers3 = Arrays.asList(9.5, 8.2, 3.6, 7.4, 45.5, 66.1, 7.3, 8.6, 99.8, 10.2);
        double avg = numbers3.stream().mapToDouble(Double::doubleValue).average().getAsDouble();
        System.out.println("6. Avg of float numbers : " + avg);

        // Question 7: Concatenate all the strings using streams
        String fruitsString = fruits.stream().collect(Collectors.joining("::"));
        System.out.println("7. Fruit String ==>> " + fruitsString);


        // Question 8:Remove duplicate elements from a list
        List<Integer> newList = numbers2.stream().distinct().collect(Collectors.toList());
        System.out.println("8. New List : " + newList);

        numbers2.stream().sorted().distinct().forEach(System.out::println);

        //Question 9: Sort an object based on an attribute
        List<Person> people = Arrays.asList(
                new Person("Alice", 21),
                new Person("Banny", 43),
                new Person("Trisha", 19),
                new Person("Kally", 25),
                new Person("Charlie", 34),
                new Person("Zack", 51),
                new Person("Peter", 65)
        );

        //without stream
        Collections.sort(people, Comparator.comparing(Person::getName));
        System.out.println("9. Sort by name without stream : " + people);

        //with stream
        List<Person> listPeople = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
        System.out.println("11. Sort by name with stream : " + listPeople);

        // Question 10: Check if all elements in a list satisfy a given condition using streams
        //allmatch() and anymatch()
        boolean isEven = numbers2.stream().allMatch(num -> num % 2 == 0);
        System.out.println("12. All even numbers allMatch : " + isEven);

        boolean isEven2 = numbers2.stream().anyMatch(num -> num % 2 == 0);
        System.out.println("13. All even numbers if any : " + isEven2);
    }
}
