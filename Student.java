import java.time.LocalDate;

public class Student extends Person{
    public Project[] getWantedProjects() {
        return wantedProjects;
    }

    private Project[] wantedProjects;

    public Project getChosenProject() {
        return chosenProject;
    }

    private Project chosenProject;

    public void setChosenProject(Project chosenProject) {
        this.chosenProject = chosenProject;
    }

    public Student(String name, Project[] wantedProjects) {
        this.name=name;
        this.wantedProjects=wantedProjects;
    }
    public Student(String name, LocalDate birthdate) {
        super(name,birthdate);
    }
    public Student(String name){
        super(name);
    }
    public Student(){
        setName("???");
        setBirthdate(LocalDate.of(1,1,1));
    }
    private String name;

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

    private Long regNumber;

    public Long getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(Long regNumber) {
        this.regNumber = regNumber;
    }
    @Override
    public String toString(){
        String nameString="?"; String dateString="?"; String regString="?";
        if (this.getName()==null) nameString = "?";
        else nameString = this.getName().toString();
        if (this.getBirthdate()==null) nameString = "?";
        else dateString = this.getBirthdate().toString();
        if (this.getRegNumber()==null) nameString = "?";
        else regString = this.getRegNumber().toString();

        return "Student " + nameString + ", born on " + dateString + ", having regnr:" + regString;

    }
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Student)) {
            return false;
        }
        Student other = (Student) obj;
        return regNumber.equals(other.regNumber);

    }
}

