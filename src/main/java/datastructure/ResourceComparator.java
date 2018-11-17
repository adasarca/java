/**
 * Created by Ada.Sarca
 * getDate(): 11/15/2018
 */
package datastructure;

import java.util.Comparator;

public class ResourceComparator implements Comparator<Resource> {

    @Override
    public int compare(Resource o1, Resource o2) {
        //name
        int cmp = 0;
        if (o1.getName() != null) {
            cmp = o1.getName().compareTo(o2.getName());
        } else if (o2.getName() != null) {
            cmp = 1;
        }
        if (cmp != 0) return cmp;

        //price
        cmp = o1.getPrice() - o2.getPrice();
        if (cmp != 0) return cmp;

        //date
        if (o1.getDate() != null) {
            if (o2.getDate() != null) {
                cmp = o1.getDate().compareTo(o2.getDate());
            } else {
                cmp = -1;
            }
        } else if (o2.getDate() != null) {
            cmp = 1;
        }

        return cmp;
    }
}
