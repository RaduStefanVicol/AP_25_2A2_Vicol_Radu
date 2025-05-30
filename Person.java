import java.time.LocalDate;

public class Person {
    private String name;

    public Person() {
        setName("???");
        setBirthdate(LocalDate.of(1,1,1));
    }

    public Person(String name) {
        setBirthdate(LocalDate.of(1,1,1));
        this.name=name;
    }

    public Person(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private LocalDate birthdate;
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

}
