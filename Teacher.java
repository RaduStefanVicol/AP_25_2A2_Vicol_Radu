import java.time.LocalDate;
import java.util.Arrays;

public class Teacher extends Person{
    public Teacher(String name, Project[] projectList ) {
        super(name);
        this.projectList = projectList;
    }

    public Teacher(String name, LocalDate birthdate) {
        super(name, birthdate);
    }

    public Teacher(String name) {
        super(name);
    }

    public Project[] getProjectList() {
        return projectList;
    }

    public void setProjectList(Project[] projectList) {
        this.projectList = projectList;
    }
    public Project getProject(int projectNr){
        Project[] p= this.getProjectList();
        return p[projectNr];
    }
    //list of projects:
    //ArrayList<Project> projectList = new ArrayList<Project>();
    Project[] projectList;

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Teacher other)){
            return false;
        }
        return this.getName().equals(other.getName());
    }

    @Override
    public String toString() {
        return "Teacher " + getName() +
                " with projectList = {" + Arrays.toString(projectList) +
                '}';
    }
}
