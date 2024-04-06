import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(String name, String surname, String address) {
        this.name = name;
        this.surname = surname;
        this.address = address;
    }

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        return age > 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(age);
        } else {
            return null;
        }
    }

    public String getAddress() throws Exception {
        if (hasAddress()) {
            return address;
        } else {
            throw new Exception();
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() throws Exception {
        if (hasAge()) {
            age++;
        } else {
            throw new Exception();
        }
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(surname).setAddress(address).setAge(0);
    }

    @Override
    public String toString() {
        return name + " " +
                surname +
                (hasAge() ? " (возраст " + age : "") +
                (hasAddress() ? ", живет в " + address + ")" : "");
    }
}
