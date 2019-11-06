import java.util.ArrayList;
import java.util.Collections;

public class AssignAddresToPerson {
    public static void main(String[] args) {
        Address Strasse1 = new Address("Strasse", "1");
        Address Strasse2 = new Address("Strasse", "2");
        Address Strasse3 = new Address("Strasse", "3");

        Person Person1 = new Person("PersonA", Strasse1);
        Person Person2 = new Person("PersonB", Strasse3);
        Person Person3 = new Person("PersonC", Strasse2);

        ArrayList<Person> toManagerPerson = new ArrayList<>();
        toManagerPerson.add(Person1);
        toManagerPerson.add(Person2);
        toManagerPerson.add(Person3);


        Collections.sort(toManagerPerson, Person.NameComparator);
        System.out.println("=============Sorted by Name==============");
        print(toManagerPerson);
        System.out.println("============Sorted by Address============");
        Collections.sort(toManagerPerson, Person.AddressComparator);
        print(toManagerPerson);

    }

    public static void print (ArrayList<Person> toManagerPerson){
        for(Person person: toManagerPerson){
            System.out.println(person.toString());
        }}
}
