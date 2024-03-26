package com.se.sample.demo1;

import com.se.sample.demo2.NestedLoop;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PhoneGroupApp {

    private static final Logger logger = LogManager.getLogger(PhoneGroupApp.class);

    // fix for stream no closed exception
    private static final Supplier<Stream<Phone>> phoneStream = () -> Stream.of(new Phone("iPhone X", "Apple", 600),
            new Phone("Pixel 2", "Google", 500),
            new Phone("iPhone 8", "Apple", 450),
            new Phone("Galaxy S9", "Samsung", 440),
            new Phone("Galaxy S8", "Samsung", 340));

    public static void main(String[] args) {

        // группируем по ключу
        Map<String, List<Phone>> phonesByCompany = phoneStream
                .get().collect(Collectors.groupingBy(Phone::getCompany));

        printMap(phonesByCompany);
        //----------------------------------------------------------------
        //делит элементы на группы по принципу, соответствует ли элемент определенному условию.
        Map<Boolean, List<Phone>> phonesByCompanyPart = phoneStream.get().collect(
                Collectors.partitioningBy(p -> p.getCompany() == "Apple"));

        printMapBool(phonesByCompanyPart);

        // для вычисления количества элементов в каждой группе:
        Map<String, Long> phonesByCompanyCounting = phoneStream.get().collect(
                Collectors.groupingBy(Phone::getCompany, Collectors.counting()));

        for (Map.Entry<String, Long> item : phonesByCompanyCounting.entrySet()) {
            System.out.println(item.getKey() + " - " + item.getValue());
        }

        phonesByCompanyCounting.entrySet().stream()
                .forEach(i -> System.out.println(i.getKey() + "-" + i.getValue()));
        //----------------------------------------------------------------
        // подсчета стоимости всех смартфонов по компаниям
        Map<String, IntSummaryStatistics> priceSummary = phoneStream.get().collect(
                Collectors.groupingBy(Phone::getCompany,
                        Collectors.summarizingInt(Phone::getPrice)));

        priceSummary.entrySet().stream()
                .forEach(i -> System.out.println(i.getKey() + "-" + i.getValue()));

    }

    private static void printMap(Map<String, List<Phone>> inputMap) {
        for (Map.Entry<String, List<Phone>> item : inputMap.entrySet()) {

            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {

                System.out.println(phone.getName());
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        //phonesByCompany.forEach((k, v) -> System.out.println(k + " " + v));
    }


    private static void printMapBool(Map<Boolean, List<Phone>> inputMap) {
        for (Map.Entry<Boolean, List<Phone>> item : inputMap.entrySet()) {

            System.out.println(item.getKey());
            for (Phone phone : item.getValue()) {

                System.out.println(phone.getName());
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        //phonesByCompany.forEach((k, v) -> System.out.println(k + " " + v));
    }


}
