import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        homework();
    }
    static void compulsory(){
        Student student1 = new Student();
        student1.setName("Student 1");
        student1.setBirthdate(LocalDate.of(1999, 12, 31));
        student1.setRegNumber(123_456_789L);
        System.out.println(student1.getName());
        Student student2 = new Student("Student 2");
        System.out.println(student2); //toString is invoked
        Student student3 = new Student("Student 1");
        System.out.println(student1 == student3);
        System.out.println(student1.equals(student3));
        System.out.println();
        Project p1 = new Project(Project.ClientType.THEORETICAL);
        p1.setProjectType(Project.ClientType.THEORETICAL);
        System.out.println(p1);
        student2.setName("Jph"); student2.setBirthdate(LocalDate.of(1,1,1));
        System.out.println(student2);
        Teacher teacher1 = new Teacher("T.John", (LocalDate.of(1979,2,7)));
        Project[] projectList = new Project[10];
        Project project1 = new Project(); 
        project1.setProjectType(Project.ClientType.THEORETICAL);
        projectList[0]=project1;
        teacher1.setProjectList(projectList);
    }
    static void homework(){
        Problem pb = new Problem(3,2); //3 students, 2 teachers
        //...create projects, teachers, students
        System.out.println(pb);
        // Create projects
        Project project1 = new Project();
        Project project2 = new Project();
        Project project3 = new Project();
        Project project4 = new Project();

        project1.setProjectType(Project.ClientType.THEORETICAL);
        project2.setProjectType(Project.ClientType.PRACTICAL);
        project3.setProjectType(Project.ClientType.PRACTICAL);
        project4.setProjectType(Project.ClientType.THEORETICAL);

        // Assign projects to teachers
        Project[] projectListTeacher1 = {project1, project2};
        Project[] projectListTeacher2 = {project3, project4};

        // Create teachers and students
        Person[] persons = new Person[5];
        persons[0] = new Student("Student1", new Project[]{project1, project2});
        persons[1] = new Teacher("Teacher1", projectListTeacher1);
        persons[2] = new Student("Student2", new Project[]{project3});
        persons[3] = new Student("Student3", new Project[]{project4, project1});
        persons[4] = new Teacher("Teacher2", projectListTeacher2);

        for (Person p : persons) { // Parcurgem persoanele
            if (p instanceof Student) { // Check if p Student
                pb.addStudent((Student) p);
            }
            if (p instanceof Teacher) { // Check if Teacher
                pb.addTeacher((Teacher) p);
            }
        }
        System.out.println(pb);
        Solution.solveGreedy(pb); // Call the solver AFTER adding all persons
    }
}