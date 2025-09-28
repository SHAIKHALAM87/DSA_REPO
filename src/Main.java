import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    // constructor, getters, toString
}
public class Main {
    public static void main(String[] args) {

        List<Contact> contacts = new ArrayList<>();

        contacts.add(new Contact("Alice", "123456", "dalice@mail.com"));
        contacts.add(new Contact("Bob", "654321", "bob@mail.com"));

        contacts.stream().filter((x)->x.getName().startsWith("B"))
                .forEach(System.out::println);

        contacts.sort((c1,c2)-> c1.getEmail().compareTo(c2.getEmail()));
        contacts.forEach(System.out::println);

        List<String> names = Arrays.asList("Zack", "John", "Anastasia");

        names.sort((s1,s2)-> Comparator.comparingInt(String::length).reversed().compare(s1,s2));
        names.forEach(System.out::println);
        Stream<String>  stream = Stream.of("Geeks", "for", "Geeks");
        List<Object> setStr =  stream.distinct().collect(Collectors.toList());
        setStr.forEach(System.out::println);
    }
}