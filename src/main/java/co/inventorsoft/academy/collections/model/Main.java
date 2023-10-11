package co.inventorsoft.academy.collections.model;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Range<Integer> minMax = Range.of(Integer.MIN_VALUE + 1, Integer.MAX_VALUE - 1);
        // minMax.forEach(System.out::println);

        Range<Integer> intRange = Range.of(-10, 10);
        System.out.println("The range: ");
        intRange.forEach(r -> System.out.print(r + " "));

        int beforeInt = -11;
        int afterInt = 11;
        int betweenInt = 5;

        System.out.println("\nIs " + beforeInt + " before the range? : " + intRange.isBefore(beforeInt));
        System.out.println("Is " + beforeInt + " after the range? : " + intRange.isAfter(beforeInt));

        System.out.println("Is " + afterInt + " after the range? : " + intRange.isAfter(afterInt));
        System.out.println("Is " + afterInt + " before the range? : " + intRange.isBefore(afterInt));

        System.out.println("Is " + betweenInt + " between the range? : " + intRange.isBetween(betweenInt));
        System.out.println("Are " + beforeInt + " and " + afterInt + " between the range? : "
                + intRange.isBetween(beforeInt) + " | " + intRange.isBetween(afterInt));

        System.out.println("Range size: " + intRange.size());

        System.out.println("The range toArray 1: ");
        Object[] rangeArr = intRange.toArray();

        for (Object r : rangeArr) {
            System.out.print(r + " ");
        }

        System.out.println("\nThe range toArray 2: ");
        rangeArr = intRange.toArray(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        for (Object r : rangeArr) {
            System.out.print(r + " ");
        }

        int element1 = 6;
        int element2 = -15;
        int element3 = 15;

        System.out.println("\nWas " + element1 + " added? : " + intRange.add(element1));
        System.out.println("Was " + element2 + " added? : " + intRange.add(element2));
        System.out.println("Was " + element3 + " added? : " + intRange.add(element3));

        System.out.println("\nWas " + element1 + " removed? : " + intRange.remove(element1));
        System.out.println("Was " + element2 + " removed? : " + intRange.remove(element2));
        System.out.println("Was " + element3 + " removed? : " + intRange.remove(element3));
        System.out.println("The range after remove: ");
        intRange.forEach(e -> System.out.print(e + " "));

        //intRange.add(element1);
        System.out.println("\nDoes the range contain all? : " + intRange
                .containsAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        System.out.println("The elements can be added? : " + intRange
                .addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));

        //intRange.add(element1);
        System.out.println("Were all elements retained? :" + intRange.retainAll(Arrays.asList(3, 4, 5, 6)));
        intRange.forEach(e -> System.out.print(e + " "));

        System.out.println("\nWere all elements removed? :" + intRange.removeAll(Arrays.asList(3, 4, 5, 6)));
        intRange.forEach(e -> System.out.print(e + " "));


    }
}
