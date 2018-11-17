/**
 * Created by Ada.Sarca
 * Date: 11/14/2018
 */
package datastructure;

import java.util.Date;
import java.util.Objects;

public class Resource implements Comparable<Resource> {

    private int id;
    private String name;
    private int price;
    private Date date;

    public Resource(int id, String name) {
        this(id, name, 0, new Date());
    }

    public Resource(int id, String name, int price, Date date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Resource [id [%d], name [%s], price [%d], date [%s]]",
                this.id, this.name, this.price, this.date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;

        Resource resource = (Resource) o;
        return this.id == resource.id &&
                Objects.equals(this.name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name);
    }

    @Override
    public int compareTo(Resource o) {
        return this.id - o.id;
    }
}
