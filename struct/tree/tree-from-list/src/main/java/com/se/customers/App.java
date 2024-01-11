package com.se.customers;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static List<Customers> getHierarchicalList(final List<Customers> originalList) {
        final List<Customers> copyList = new ArrayList<>(originalList);

        copyList.forEach(element -> {
            originalList
                    .stream()
                    .filter(parent -> parent.getId() == element.getParentId())
                    .findAny()
                    .ifPresent(parent -> {
                        if (parent.getChilds() == null) {
                            parent.setChilds(new ArrayList<>());
                        }
                        parent.getChilds().add(element);
                        originalList.remove(element);
                    });
        });
        return originalList;
    }

    public static void main(String[] args) {
        List<Customers> customersList = new ArrayList<>();

        //Input List
        Customers customer = new Customers(1, "Hel", 0);
        Customers customerChild1 = new Customers(2, "Hel-Child1", 1);
        Customers customerChild2 = new Customers(5, "Hel-Child2", 1);
        Customers customerInnerChild1 = new Customers(3, "Hel-InnerChild1", 2);
        Customers customerInnerChild2 = new Customers(6, "Hel-InnerChild2", 0);

        List<Customers> customers = new ArrayList();
        customers.add(customerInnerChild1);
        customers.add(customerInnerChild2);
        customers.add(customer);
        customers.add(customerChild1);
        customers.add(customerChild2);

        List<Customers> customersList1 = getHierarchicalList(customers);
        int aa = 0;
    }

}
