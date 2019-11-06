public class Address {
    String street;
    String number;

    public Address(String street, String number) {
        this.street = street;
        this.number = number;
    }

    @Override
    public String toString() {
        return street + " " + number;
    }

}
