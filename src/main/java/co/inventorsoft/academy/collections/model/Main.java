package co.inventorsoft.academy.collections.model;

import java.text.DecimalFormat;
import java.util.Iterator;

public class Main {
    public static void main(String[]args) {
      Range<Double> rangeDouble = new Range<Double>();
        System.out.println("Start size: " + rangeDouble.size());
        rangeDouble.add(45.678888);
        rangeDouble.add(45.678888);
        rangeDouble.add(14.67);
        rangeDouble.add(56.78);
        System.out.println("Size after adding: " + rangeDouble.size());

        String pattern = "###.#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);

      Iterator iterator = rangeDouble.iterator();

        while (iterator.hasNext()) {
            System.out.println(decimalFormat.format(iterator.next()));
        }

        rangeDouble.remove(14.67f);
        System.out.println("After deleting: " + rangeDouble.size());
        rangeDouble.clear();
        System.out.println("After clearing: " + rangeDouble.size());

    }
}