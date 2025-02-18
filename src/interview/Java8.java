package interview;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class Java8 {

    public static void main(String[] args) {
	separateOddAndEven();
//		findStartingNumOne();
//		findDuplicateIntElement();
//		findFirstElement();
//		totalNumberOfElementAndMax();
//		findFirstNonRepeatingChar();
//		findFrequencyOfEachCharacterAndList();
//		sortDecimalInReverseOrder();
//		joiningTheString();
//		printNumWhichMultiplesBy5();
//		findMaxAndMin();
//		twoUnsortedToSortedAndWithoutDuplicate();
//		getThreeMaxAndThreeMin();
//		getLastElementOfAnArray();
//		firstFirstTenOddNumbers();
//      upperCaseFirstLetter();
//		flatMap();
//      addEvenNumbers();
//      findFirstRepeatedValue();
//		findRepetitiveString();
//		sortAscDescAndPrintZipZac();
//      anagramsValidate();
//		summingList();
        testMethod();
    }

    public static void testMethod() {


    }

    private static void summingList() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //Logic 1
        int result = numbers.stream().reduce(0, Integer::sum);
        System.out.println(result);
        //Logic 2
        int result2 = numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(result2);
        //Logic 3
        int result3 = numbers.stream().collect(summingInt(n -> n)); //Using boxed because, it's in IntStream converting to Stream<Integer> then we can use collect and collectors
        System.out.println(result3);
    }

    private static void anagramsValidate() {
        String value = "listen/silent";

        String[] values = value.split("/");
        String str1, str2;
        if (values.length == 2 && values[0].length() == values[1].length()) {
            str1 = values[0];
            str2 = values[1];
            System.out.println(
                    Arrays.stream(str1.split("")).sorted().collect(joining())
                            .equals(Arrays.stream(str2.split("")).sorted().collect(Collectors.joining())));
        } else
            System.out.println(false);
    }


    private static void sortAscDescAndPrintZipZac() {
        System.out.println("Sort Even numbers as Ascending and Odd numbers as Descending and print zip zac");
        List<Integer> numebrs = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 88, 45, 36, 33, 23, 99, 76);

        List<Integer> even = numebrs.stream().filter(num -> num % 2 == 0).sorted().toList();
        List<Integer> odd = numebrs.stream().filter(num -> num % 2 != 0).sorted(Comparator.reverseOrder()).toList();

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < even.size() || j < odd.size()) {
            if (i < even.size()) {
                result.add(even.get(i));
                i++;
            }
            if (j < odd.size()) {
                result.add(odd.get(j));
                j++;
            }
        }
        result.forEach(System.out::println);
    }


    private static void findRepetitiveString() {

        class Employee {
            private int id;
            private String name;
            private int salary;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getSalary() {
                return salary;
            }

            public void setSalary(int salary) {
                this.salary = salary;
            }

            public Employee(int id, String name, int salary) {
                this.id = id;
                this.name = name;
                this.salary = salary;
            }

            public Employee() {
            }
        }

        Employee employee1 = new Employee(1, "mani", 5000);
        Employee employee2 = new Employee(2, "karthick", 5000);
        Employee employee3 = new Employee(3, "Sanjay", 1000);
        Employee employee4 = new Employee(4, "Zuber", 2000);

        List<Employee> employees = new ArrayList<>();

        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);

        Set<Integer> set = new HashSet<>();

        Integer dupSalary = employees.stream().map(Employee::getSalary).filter(sal -> !set.add(sal)).map(s -> s).findFirst().get(); //Find duplicate salary first
        employees.stream().filter(emp -> emp.salary == dupSalary).map(emp -> emp.getName() + "-" + emp.getId()).forEach(System.out::println);

    }

    private static void findFirstRepeatedValue() {
        System.out.println("");
        String input = "Java Articles are Awesome";


        Arrays.stream(input.split(""))
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))
                .entrySet().stream().filter(e -> e.getValue() >= 2).findFirst().ifPresent(e -> System.out.println(e.getKey()));
    }


    private static void addEvenNumbers() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("Add Even Numbers");
        //step1
        int result1 = Arrays.stream(arr).filter(num -> num % 2 == 0).sum();
        System.out.println("Step1: " + result1);

        //step2
        int result2 = Arrays.stream(arr).filter(num -> num % 2 == 0).reduce(0, (num1, num2) -> num1 + num2); //or Integer::sum
        System.out.println("Step2: " + result2);

        //step3
        int[] temp = {0};
        Arrays.stream(arr).filter(num -> num % 2 == 0).forEach(res -> temp[0] += res);
        int sum = temp[0];
        System.out.println("Step3: " + sum);

        //step4
        int result4 = Arrays.stream(arr).filter(num -> num % 2 == 0).boxed().collect(summingInt(n -> n)); //Using boxed because, it's in IntStream converting to Stream<Integer> then we can use collect and collectors
        System.out.println("Step4: " + result4);

        //step5
        AtomicInteger atomicInteger = new AtomicInteger();
        Arrays.stream(arr).filter(num -> num % 2 == 0).forEach(atomicInteger::addAndGet); //or res -> atomicInteger.addAndGet(res)
        System.out.println("Step5: " + atomicInteger.get());

    }

    private static void flatMap() {
        List<List<String>> listListAdd1 = new ArrayList<>();
        List<String> listAdd1 = new ArrayList<>();
        List<String> listAdd2 = new ArrayList<>();

        listAdd1.add("Name");
        listAdd1.add("age");
        listAdd1.add("employee");
        listAdd1.add("company");

        listAdd2.add("Name1");
        listAdd2.add("age1");
        listAdd2.add("employee1");
        listAdd2.add("company1");

        listListAdd1.add(listAdd1);
        listListAdd1.add(listAdd2);

        listListAdd1.stream().flatMap(List::stream).forEach(System.out::println);//list -> list.stream


    }

    private static void upperCaseFirstLetter() {
        System.out.println("Upper Case First Letter of the word, eg: The Employee");
        String line = "the employee";
        StringBuilder stringBuilder = new StringBuilder();

        String[] arrInput = line.split(" ");
        for (String arr : arrInput) {
            for (int i = 0; i < arr.length(); i++) {
                if (i == 0) {
                    stringBuilder.append(String.valueOf(arr.charAt(i)).toUpperCase());
                } else {
                    stringBuilder.append(String.valueOf(arr.charAt(i)));
                }
            }
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);


        //Java8
        System.out.println("Using java 8");
        String output = Arrays.stream(line.split(" "))
                .map(word -> word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase()).collect(joining(" "));
        System.out.println(output);
    }


    private static void firstFirstTenOddNumbers() {
        System.out.println("\nFirst 10 odd numbers");
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89, 33, 45, 55, 76, 89, 34, 89, 75, 77, 11, 17, 34, 44);
        listOfIntegers.stream().filter(i -> i % 2 != 0).distinct().limit(10).forEach(System.out::println);
    }

    private static void getLastElementOfAnArray() {
        List<String> listOfStrings = Arrays.asList("One", "Two", "Three", "Four", "Five", "Six");

        System.out.println("\nHow do you get last element of an array?");
        String lastElement = String.valueOf(listOfStrings.stream().skip(listOfStrings.size() - 1).findFirst());
        System.out.println(lastElement);

    }

    private static void getThreeMaxAndThreeMin() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);


        System.out.println("\nHow do you get three maximum numbers and three minimum numbers from the given list of integers?");
        System.out.println("Three max numbers");
        List<Integer> result = listOfIntegers.stream().sorted(Comparator.reverseOrder()).limit(3).collect(toList());
        System.out.println(result);

        System.out.println("Three min numbers");
        List<Integer> result1 = listOfIntegers.stream().sorted(Comparator.naturalOrder()).limit(3).collect(toList());
        System.out.println(result1);
    }

    private static void twoUnsortedToSortedAndWithoutDuplicate() {

        int[] a = new int[]{4, 2, 7, 1, 2, 4};
        int[] b = new int[]{8, 3, 9, 5, 7, 3};

        System.out.println("\nHow do you merge two unsorted arrays into single sorted array and without duplicate using Java 8 streams?");
        IntStream.concat(Arrays.stream(a), Arrays.stream(b)).sorted().distinct().forEach(System.out::println);

    }

    private static void findMaxAndMin() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println("\nGiven a list of integers, find maximum and minimum of those numbers?");
        System.out.println("Find Max");
        listOfIntegers.stream().max(Comparator.naturalOrder()).ifPresent(System.out::println);

        System.out.println("Find Min");
        listOfIntegers.stream().min(Integer::compareTo).ifPresent(System.out::println);

    }

    private static void printNumWhichMultiplesBy5() {
        List<Integer> listOfIntegers = Arrays.asList(45, 12, 56, 15, 24, 75, 31, 89);

        System.out.println("\nFrom the given list of integers, print the numbers which are multiples of 5?");

        listOfIntegers.stream().filter(i -> i % 5 == 0).forEach(System.out::println);

    }

    private static void joiningTheString() {
        System.out.println("\nGiven a list of strings, join the strings with ‘[‘ as prefix, ‘]’ as suffix and ‘,’ as delimiter?");
        List<String> listOfStrings = Arrays.asList("Facebook", "Twitter", "YouTube", "WhatsApp", "LinkedIn");

        System.out.println("Method1");
        String result = listOfStrings.stream().collect(joining(",", "[", "]"));
        System.out.println(result);

        System.out.println("Method2");
        String result1 = "[" + String.join(",", listOfStrings) + "]";
        System.out.println(result1);

    }

    private static void sortDecimalInReverseOrder() {
        System.out.println("\nHow do you sort the given list of decimals in reverse order?");

        List<Double> decimalList = Arrays.asList(12.45, 23.58, 17.13, 42.89, 33.78, 71.85, 56.98, 21.12);
        System.out.println("Method1");
        decimalList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("Method2");
        List<Double> sortedDescending = decimalList.stream()
                .sorted()                              // Sort in natural order
                .collect(toList());         // Collect to a list

        Collections.reverse(sortedDescending);     // Reverse to get descending order

        sortedDescending.forEach(System.out::println);
    }

    private static void findFrequencyOfEachCharacterAndList() {
        System.out.println("\nHow do you find frequency of each character in a string and list using Java 8 streams?");

        String inputString = "Java Concept Of The Day";
        System.out.println("Method1");
        Map<String, Long> map = Arrays.stream(inputString.split("")).collect(groupingBy(Function.identity(), counting()));
        System.out.println(map);

        System.out.println("Method2");
        Map<Character, Long> map1 = inputString.chars().mapToObj(c -> (char) c).collect(groupingBy(Function.identity(), counting()));
        System.out.println(map1);

        System.out.println("Method1 using list");
        List<String> stationeryList = Arrays.asList("Pen", "Eraser", "Note Book", "Pen", "Pencil", "Stapler", "Note Book", "Pencil");
        Map<String, Long> map2 = stationeryList.stream().sorted().collect(groupingBy(fun -> fun, counting()));
        System.out.println(map2);
    }

    private static void findFirstNonRepeatingChar() {
        System.out.println("\nGiven a String, find the first non-repeated character in it using Stream functions?");
        String input = "Java articles are Awesome";

        //Using Core Java
        System.out.println("Method1 Using Core Java");
        Map<Character, Integer> charCount = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (char c : input.toCharArray()) {
            if (charCount.get(c) == 1) {
                System.out.println(c);
                break;
            }
        }

        //Method2 Using stream API
        System.out.println("Using Stream Api");
        char result = input.chars().mapToObj(c -> (char) c)
                .collect(groupingBy(Function.identity(), LinkedHashMap::new, counting()))// We have used LinkedHasMap to preserve the insertion order
                .entrySet().stream().filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey).findFirst().get();// or entry -> entry.getKey() instead of Map.Entry::getKey
        System.out.println(result);
    }

    private static void totalNumberOfElementAndMax() {
        System.out.println("\nGiven a list of integers, find the total number of elements present in the list using Stream functions?");
        //Using java 8
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        AtomicInteger counts = new AtomicInteger();
        Set<AtomicInteger> result = myList.stream().map(num -> {

            counts.getAndIncrement();
            return counts;
        }).collect(toSet());
        System.out.println("My Own Program: " + result);

        System.out.println("Find total Element");
        long count = myList.stream().count();
        System.out.println(count);

        System.out.println("Find Max Element");
        long count1 = myList.stream().max(Integer::compareTo).orElse(null);
        System.out.println(count1);
        //or
        System.out.println("Find Max Element type 2");
        long count2 = myList.stream().max((a, b) -> a.compareTo(b)).orElse(null);
        System.out.println(count2);
    }

    private static void findFirstElement() {
        System.out.println("\nGiven the list of integers, find the first element of the list using Stream functions?");
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);

        Integer optionalI = myList.stream().findFirst().orElse(-1);
        System.out.println(optionalI);
    }

    private static void findDuplicateIntElement() {
        System.out.println("\nHow to find duplicate elements in a given integers list in java using Stream functions?");
        //Using Java 8
        System.out.println("Method1");
        List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();

        myList.stream()
                .filter(n -> !set.add(n))
                .forEach(System.out::println);

        System.out.println("Method2");
        myList.stream().distinct().forEach(System.out::println);

        System.out.println("Method3 using arrays");
        Integer[] arr = {0, 15, 8, 49, 25, 98, 98, 32, 15};
        Arrays.stream(arr).distinct().forEach(System.out::println);

    }

    private static void findStartingNumOne() {
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        //Using Core java
        System.out.println("\nGiven a list of Integers, find out all the numbers starting with 1 using stream functions");
        for (Integer i : listOfIntegers) {
            String value = i.toString();
            if (value.startsWith("1")) {
                System.out.println(value);
            }

        }

        //Using java 8
        Set<Integer> result = listOfIntegers.stream().filter(num -> {
            String value = num.toString();
            if (value.startsWith("1"))
                return true;
            else
                return false;
        }).collect(toSet());
        System.out.println(result);
    }

    private static void separateOddAndEven() {
        System.out.println("\nGiven a list of integers, find out all the even numbers that exist in the list using Stream functions?");
        List<Integer> listOfIntegers = Arrays.asList(71, 18, 42, 21, 67, 32, 95, 14, 56, 87);

        //Using Core java
        System.out.println("Using Core Java");
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();
        for (Integer listInt : listOfIntegers) {
            if (listInt % 2 == 0) {
                even.add(listInt);
            } else {
                odd.add(listInt);
            }
        }
        System.out.println("Odd Numbers " + odd);
        System.out.println("Even Numbers " + even);

        //Using Java 8
        System.out.println("Using Java 8");
        Map<Boolean, List<Integer>> a = listOfIntegers.stream().collect(partitioningBy(i -> i % 2 == 0));
        System.out.println(a);

        //1
        List<Integer> evenNum = listOfIntegers.stream().filter(i -> i % 2 == 0).toList();
        List<Integer> oddNum = listOfIntegers.stream().filter(i -> i % 2 != 0).toList();
        System.out.println(oddNum);
        System.out.println(evenNum);
        //2
        Map<Boolean, List<Integer>> oddEven = listOfIntegers.stream().collect(partitioningBy(i -> i % 2 == 0));
        System.out.println(oddEven);
        //3
        for (Map.Entry<Boolean, List<Integer>> s : oddEven.entrySet()) {
            boolean key = s.getKey();
            List<Integer> list = s.getValue();
            if (key) {
                System.out.println(list);
            } else {
                System.out.println(list);
            }
        }
        //4
        listOfIntegers.stream().collect(groupingBy(i -> i % 2 == 0 ? "Even" : "Odd")).forEach((key, value) ->
                System.out.println(key + " " + value));


    }


}
