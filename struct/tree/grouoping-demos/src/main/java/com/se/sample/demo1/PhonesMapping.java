package com.se.sample.demo1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * базовые операции фильтрации и преобразования
 */
public class PhonesMapping {

    private static final Logger logger = LogManager.getLogger(PhoneGroupApp.class);

    private static final Supplier<Stream<Phone>> phoneStream = () -> Stream.of(new Phone("iPhone X", "Apple", 600),
            new Phone("Pixel 2", "Google", 500),
            new Phone("iPhone 8", "Apple", 450),
            new Phone("Galaxy S9", "Samsung", 440),
            new Phone("Galaxy S8", "Samsung", 340));

    public static void main(String[] args) {
       // demoFiltersPhoneByCost(5000);
       // demoMapping();
       // demoFlatMap();

        Comparator<Phone> comparator = (h1, h2) -> h1.getPrice() -(h2.getPrice());
        phoneStream.get().sorted(comparator.reversed()).forEach(i-> System.out.println(i));

        phoneStream.get().sorted(comparator).forEach(i-> System.out.println(i));
    }

    public static void demoFiltersPhoneByCost(int cost ){
        // фильтруем по цене
        phoneStream.get().filter(p->p.getPrice()<cost)
                .forEach(i-> logger.info(i.toString()));

        List<Phone> collect = phoneStream.get().filter(p -> p.getPrice() < cost).collect(Collectors.toList());
        logger.info("-------------------------------------");

        collect.stream().forEach(i-> logger.info(i.toString()));
        logger.info("-------------------------------------");

        collect.stream().forEachOrdered(i -> System.out.println(i));
    }

    //преобразования одного объекта в другой
    public static void demoMapping(){

        phoneStream.get()
                .map(p-> p.getName()) // помещаем в поток только названия телефонов
                .forEach(s->System.out.println(s));

        List<String> collect = phoneStream.get()
                .map(p -> p.getName()).collect(Collectors.toList());

        List<String> collect1 = phoneStream.get()
                .map(p -> "название: " + p.getName() + " ,цена: " + p.getPrice()).collect(Collectors.toList());

    }

    // плоское преобразование
    public static void demoFlatMap(){

        //из одного элемента нужно получить несколько
        phoneStream.get()
                .flatMap(p->Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int)(p.getPrice()*0.1))
                ))
                .forEach(s->System.out.println(s));


        List<String> collect = phoneStream.get()
                .flatMap(p -> Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int) (p.getPrice() * 0.1))
                )).collect(Collectors.toList());
    }
}
