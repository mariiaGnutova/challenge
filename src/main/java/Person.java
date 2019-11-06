
import java.util.Comparator;

public class Person {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName(){
        return name;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address=" + address.toString() +
                '}';
    }

    /*Comparator for sorting the arraylist by Person Name*/
    public static Comparator<Person> NameComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().toUpperCase().compareTo(o2.getName().toUpperCase());
        }
    };

    /*Comparator for sorting the arraylist by Person Address*/
    public static Comparator<Person> AddressComparator = (o1, o2) -> {
        String str1 = o1.getAddress().toString().toUpperCase();
        String str2 = o2.getAddress().toString().toUpperCase();
        return str1.compareTo(str2);
    };

}
