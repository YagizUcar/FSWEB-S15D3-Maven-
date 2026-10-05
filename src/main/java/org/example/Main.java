package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
        employees.add(new Employee(2, "Mehmet", "Demir"));
        employees.add(new Employee(1, "Ahmet", "Yılmaz"));
        employees.add(new Employee(3, "Ayşe", "Kaya"));
        employees.add(new Employee(2, "Mehmet", "Demir"));
        employees.add(new Employee(4, "Fatma", "Çelik"));

        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicates size: " + duplicates.size());
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        if (employees == null) return duplicates;

        Set<Integer> seenIds = new HashSet<>();
        Set<Employee> duplicateSet = new HashSet<>();

        for (Employee emp : employees) {
            if (emp != null) {
                if (!seenIds.add(emp.getId())) {
                    duplicateSet.add(emp);
                }
            }
        }
        duplicates.addAll(duplicateSet);
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        if (employees == null) return uniqueMap;

        for (Employee emp : employees) {
            if (emp != null) {
                uniqueMap.put(emp.getId(), emp);
            }
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> uniqueList = new LinkedList<>();
        if (employees == null) return uniqueList;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee emp : employees) {
            if (emp != null) {
                countMap.put(emp.getId(), countMap.getOrDefault(emp.getId(), 0) + 1);
            }
        }

        Set<Integer> addedIds = new HashSet<>();
        for (Employee emp : employees) {
            if (emp != null) {
                if (countMap.get(emp.getId()) == 1 && addedIds.add(emp.getId())) {
                    uniqueList.add(emp);
                }
            }
        }
        return uniqueList;
    }
}