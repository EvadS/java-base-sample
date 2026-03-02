package com.se.sample.employee;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // Group By with Function, Supplier and Collector


        // Group By with Function
        System.out.println("-----------------------------------------------");
        System.out.println("\t Group By with Function");
        System.out.println("-----------------------------------------------");
        groupEmployee();

        System.out.println("-----------------------------------------------");
        System.out.println("\t Group By with Function and Collector");
        System.out.println("-----------------------------------------------");
        groupByWithFunctionAndCollector();

        System.out.println("-----------------------------------------------");
        System.out.println("\t Group Custom Objects");
        System.out.println("-----------------------------------------------");
        groupCustomObjects();

        System.out.println("-----------------------------------------------");
        System.out.println("\t  group the employee names by their age");
        System.out.println("-----------------------------------------------");
        groupEmployeeNamesByTheirAge();

        System.out.println("-----------------------------------------------");
        System.out.println("\t  group the employee names by their age");
        System.out.println("-----------------------------------------------");
        groupByWithFunctionSupplierAndCollector();

    }

    private static void groupByWithFunctionSupplierAndCollector() {

        List<Item> items = getItemsList();

        // групируем по стоимости, используем set чтобы убрать дубликаты
        Map<BigDecimal, Set<String>> result = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        result.forEach((key, value) -> System.out.println(key + ":" + value));


        Map<BigDecimal, Set<String>> sortedItemsByPrice = items.stream()
                .collect(
                        Collectors.groupingBy(
                                Item::getPrice,
                                TreeMap::new,
                                Collectors.mapping(Item::getName, Collectors.toSet())
                        )
                );

        System.out.println("sorted by price");
        sortedItemsByPrice.forEach((key, value) -> System.out.println(key + ":" + value));
    }


    private static void groupEmployeeNamesByTheirAge() {

        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        Map<Integer, List<String>> employeeNamesByAge = employees.stream()
                .collect(Collectors.groupingBy(
                                Employee::getAge,
                                Collectors.mapping(Employee::getName, Collectors.toList())
                        )
                );

        employeeNamesByAge.forEach((key, value) -> System.out.println(key + ":" + value));

    }


    /**
     * групируем с одним параметром
     */
    private static void groupEmployee() {
        Employee e1 = new Employee("John", 38);
        Employee e2 = new Employee("Tim", 33);
        Employee e3 = new Employee("Andrew", 33);
        Employee e4 = new Employee("Peter", 38);
        Employee e5 = new Employee("Nathan", 22);
        Employee e6 = new Employee("George", 23);
        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6);

        //group these employee objects by age
        Map<Integer, List<Employee>> employeesByAge = employees.stream()
                .collect(Collectors.groupingBy(Employee::getAge));

        employeesByAge.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    /**
     * групируем с двумя параметром
     */
    private static void groupByWithFunctionAndCollector() {
        // список фруктов
        List<String> fruitNames = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");

        // Traditional approach:
        Map<String, Integer> fruitMap = new HashMap<>();
        for (String f : fruitNames) {
            if (fruitMap.containsKey(f)) fruitMap.put(f, fruitMap.get(f) + 1);
            else fruitMap.put(f, 1);
        }

        // Streams GroupingBy approach
        // Function.identity() — represents the item in the [Function]
        // Collectors.counting() — counts the elements [Collector]
        Map<String, Long> result = fruitNames.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    /**
     * item names grouped by the quantity.
     */
    private static void groupCustomObjects() {
        List<Item> items = getItemsList();

        // need the item names grouped by the quantity.
        Map<String, Integer> result = items.stream()
                .collect(Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));

        result.forEach((key, value) -> System.out.println(key + ":" + value));
    }

    private static List<Item> getItemsList() {
        return Arrays.asList(
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 20, new BigDecimal("19.99")),
                new Item("orange", 10, new BigDecimal("29.99")),
                new Item("watermelon", 10, new BigDecimal("29.99")),
                new Item("papaya", 20, new BigDecimal("9.99")),
                new Item("apple", 10, new BigDecimal("9.99")),
                new Item("banana", 10, new BigDecimal("19.99")),
                new Item("apple", 20, new BigDecimal("9.99"))
        );
    }
}
