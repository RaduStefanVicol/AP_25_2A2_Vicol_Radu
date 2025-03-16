public class Problem {
    private Student[] students;
    private Teacher[] teachers;
    private int studentNumber = 0;
    private int teacherNumber = 0;
    private int maxStudents;
    private int maxTeachers;

    public Student[] getStudents() {
        return students;
    }

    public Teacher[] getTeachers() {
        return teachers;
    }

    public int getMaxStudents() {
        return maxStudents;
    }

    public int getMaxTeachers() {
        return maxTeachers;
    }

    // Constructor to initialize the arrays
    public Problem(int maxStudents, int maxTeachers) {
        this.maxStudents = maxStudents;
        this.maxTeachers = maxTeachers;
        this.students = new Student[maxStudents];
        this.teachers = new Teacher[maxTeachers];
    }

    public Person[][] getPersons() {
        int i;
        int maxPersons = Math.max(studentNumber, teacherNumber);
        Person[][] personArray = new Person[2][maxPersons];

        // Add students to the person array
        for (i = 0; i < studentNumber; i++) {
            personArray[0][i] = students[i];
        }

        // Add teachers to the person array
        for (i = 0; i < teacherNumber; i++) {
            personArray[1][i] = teachers[i];
        }

        return personArray;
    }

    // Adds a student if space allows and student isn't already in the array
    public int addStudent(Student s1) {
        // Check if the student already exists
        for (int i = 0; i < studentNumber; i++) {
            if (students[i] == s1) {
                System.out.println("Can't add the same student twice");
                return 0;
            }
        }

        // Check if there is space for another student
        if (studentNumber >= maxStudents) {
            System.out.println("No more room to add students in the problem");
            return 0;
        } else {
            students[studentNumber++] = s1;
            return 1;
        }
    }

    // Adds a teacher if space allows and teacher isn't already in the array
    public int addTeacher(Teacher t1) {
        // Check if the teacher already exists
        for (int i = 0; i < teacherNumber; i++) {
            if (teachers[i] == t1) {  // Or use t1.equals(teachers[i]) for better comparison
                System.out.println("Can't add the same teacher twice");
                return 0;
            }
        }

        // Check if there is space for another teacher
        if (teacherNumber >= maxTeachers) {
            System.out.println("No more room to add teachers in the problem");
            return 0;
        } else {
            teachers[teacherNumber++] = t1;
            return 1;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Students:\n");
        for (int i = 0; i < studentNumber; i++) {
            sb.append(students[i]).append("\n");
        }

        sb.append("Teachers:\n");
        for (int i = 0; i < teacherNumber; i++) {
            sb.append(teachers[i]).append("\n");
        }

        return sb.toString();
    }
}
