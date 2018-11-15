/**
 * Created by Ada.Sarca
 * Date: 11/15/2018
 */
package datastructures;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ComparatorExample {

    public static void main(String[] args) {
        ComparatorExample example = new ComparatorExample();
        System.out.println("Initial list:");
        List<Resource> list = example.buildResourceList();
        example.print(list);

        //using comparable
        System.out.println("Sort by natural order:");
        Collections.sort(list);
        example.print(list);

        //using comparator
        System.out.println("Sort by name, price and date:");
        list = example.buildResourceList();
        list.sort(new ResourceComparator());
        example.print(list);

        //using lambda comparator
        System.out.println("Sort by price:");
        list = example.buildResourceList();
        list.sort(Comparator.comparing(Resource::getPrice));
        example.print(list);

        //using lambda comparator with null check and multiple fields
        System.out.println("Sort by price and date:");
        list = example.buildResourceList();
        Comparator<Date> dateComparator = Comparator.nullsLast(Comparator.naturalOrder());
        list.sort(
                Comparator.comparing(Resource::getPrice)
                .thenComparing(Resource::getDate, dateComparator)
        );
        example.print(list);

        //using reversed
        System.out.println("Sort by ID reversed:");
        list = example.buildResourceList();
        list.sort(Comparator.comparing(Resource::getId).reversed());
        example.print(list);
    }

    public List<Resource> buildResourceList() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");

        List<Resource> list = new LinkedList<>();
        try {
            list.add(new Resource(5, "Portocale", 27, dateFormat.parse("10-05-2018")));
            list.add(new Resource(7, "Banane", 21, dateFormat.parse("09-07-2018")));
            list.add(new Resource(12, "Mere", 15, dateFormat.parse("11-13-2018")));
            list.add(new Resource(4, "Kiwi", 13, dateFormat.parse("10-03-2018")));
            list.add(new Resource(11, "Mango", 20, dateFormat.parse("11-12-2018")));
            list.add(new Resource(3, "Ananas", 30, dateFormat.parse("09-05-2018")));
            list.add(new Resource(8, "Lamai", 25, dateFormat.parse("11-20-2018")));
            list.add(new Resource(10, "Pomelo", 10, dateFormat.parse("10-01-2018")));
            list.add(new Resource(6, null, 22, dateFormat.parse("10-17-2018")));
            list.add(new Resource(9, "Pere", 17, null));
            list.add(new Resource(2, null, 11, dateFormat.parse("11-01-2018")));
            list.add(new Resource(14, "Portocale", 25, dateFormat.parse("10-05-2018")));
            list.add(new Resource(18, "Banane", 17, dateFormat.parse("09-07-2018")));
            list.add(new Resource(1, "Mere", 13, dateFormat.parse("11-13-2018")));
            list.add(new Resource(17, "Kiwi", 10, dateFormat.parse("10-03-2018")));
            list.add(new Resource(13, "Portocale", 20, dateFormat.parse("11-12-2018")));
            list.add(new Resource(16, "Ananas", 25, dateFormat.parse("09-05-2018")));
            list.add(new Resource(19, "Mere", 13, dateFormat.parse("11-20-2018")));
            list.add(new Resource(15, "Pere", 17, dateFormat.parse("09-01-2018")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void print(List<Resource> list) {
        for (Resource resource : list) {
            System.out.println(resource);
        }
        System.out.println();
    }
}
