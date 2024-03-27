package streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


// https://blog.devgenius.io/java-8-coding-and-programming-interview-questions-and-answers-62512c44f062

public class Main {

//    Given a list of integers, find out all the even numbers that exist in the list using Stream functions?

    public static List<Integer> getEvenNumber(List<Integer> numbers) {

        System.out.println("Even Numbers");

        if (numbers != null && !numbers.isEmpty()) {
            return numbers
                    .stream()
                    .filter(number -> number % 2 == 0)
                    .collect(Collectors.toList());
        }

        return numbers;
    }

    //    Given a list of integers, find out all the numbers starting with 1 using Stream functions?
    public static void getNumberStartWithOne(List<Integer> numbers) {

        System.out.println("Number starts with 1");

        numbers
                .stream()
                .filter(number -> String.valueOf(number).startsWith("1"))
                .forEach(System.out::println);

    }

//    How to find duplicate elements in a given integers list in java using Stream functions?

    public static void findDuplicate(List<Integer> numbers) {

        System.out.println("Duplicate Items");

        Set<Integer> uniqueList = new HashSet<>();

        numbers
                .stream()
                .filter(item -> !uniqueList.add(item))
                .forEach(System.out::println);

        //numbers.stream().allMatch(Collectors.groupingBy())

    }

    //    Given the list of integers, find the first element of the list using Stream functions?
    public static void findFirstElement(List<Integer> numbers) {

        System.out.println("find First Element using limit");

        numbers
                .stream()
                .limit(1)
                .forEach(System.out::println);

        System.out.println("find First Element using findFirst");

        numbers
                .stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    // Given a list of integers, find the total number of elements present in the list using Stream functions?

    public static void countElements(List<Integer> numbers) {

        long count = numbers.stream().count();

        System.out.printf("Elements count %s \n", count);
    }

    // 6. Given a list of integers, find the maximum value element present in it using Stream functions?

    public static void maxValue(List<Integer> numbers) {

        System.out.println("Max value");

        numbers
                .stream().max(Comparator.naturalOrder())
                .ifPresent(System.out::println);

        numbers
                .stream().max(Integer::compare)
                .ifPresent(element -> System.out.printf("Max value Element %s \n", element));

        ;

    }

    public static void firstNonRepeatingCharacter(String text) {

        System.out.println("First non repeating character");

        Optional<Character> result = text.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1L)
                .map(Map.Entry::getKey)
                .findFirst();

        result.ifPresentOrElse(System.out::println, ()-> System.out.println("No non repeating character available"));

    }

    // Given a String, find the first repeated character in it using Stream functions?

    public static void firstRepeatingCharacter(String text) {

        System.out.println("First repeating character");

        Optional<Character> result = text.chars()
                .mapToObj(c -> Character.toLowerCase((char) c))
                .collect(Collectors.groupingBy(c->c, LinkedHashMap::new, Collectors.counting())) //Store the chars in map with count
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1L)
                .map(Map.Entry::getKey)
                .findFirst();

        result.ifPresentOrElse(System.out::println, ()-> System.out.println("No repeating character available"));

    }

    // Given a list of integers, sort all the values present in it using Stream functions?
    public static void sortIntegers(List<Integer> numbers) {
        System.out.println("Sorted list");
        numbers.stream().sorted().forEach(System.out::println);
    }

    // Given a list of integers, sort all the values present in it in descending order using Stream functions?

    public static void sortIntegersDescOrder(List<Integer> numbers) {
        System.out.println("Descending Sorted list");
        numbers.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    public static boolean containsDuplicate(int[] nums) {
        List<Integer> list = Arrays.stream(nums)
                .boxed()
                .toList();
        Set<Integer> set = new HashSet<>(list);
        return set.size() != list.size();
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 15, 8, 49, 25, 98, 32, 10, 32);

        getEvenNumber(numbers).forEach(System.out::println);

        getNumberStartWithOne(numbers);

        findDuplicate(numbers);

        findFirstElement(numbers);

        countElements(numbers);

        maxValue(numbers);

        sortIntegers(numbers);
        sortIntegersDescOrder(numbers);

        String input = "Java articles are Awesome";

        firstNonRepeatingCharacter(input);
        firstRepeatingCharacter(input);

        int[] nums = new int[]{1,2,3,1};

        System.out.println("Contain duplicates " + containsDuplicate(nums));;

        nums = new int[]{1,2,3,4};

        System.out.println("Contain duplicates " + containsDuplicate(nums));;


    }
}
