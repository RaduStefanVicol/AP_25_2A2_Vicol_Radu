import java.util.ArrayList;
import java.util.List;

public class Solution {
    private Project[] projects; //assigned to students

    public static void solveGreedy(Problem pb) {
        int i, i2, k, m; // Loop counters
        int maxStudents = pb.getMaxStudents();
        int maxTeachers = pb.getMaxTeachers();
        Student[] studentList = pb.getStudents();
        Teacher[] pbTeachers = pb.getTeachers();

        for (i = 0; i < maxStudents; i++) {
            Project[] studentWanted = studentList[i].getWantedProjects();

            for (i2 = 0; i2 < maxTeachers; i2++) {
                Project[] teacherProjects = pbTeachers[i2].getProjectList();

                for (k = 0; k < studentWanted.length; k++) {
                    for (m = 0; m < teacherProjects.length; m++) {
                        if (studentWanted[k] == teacherProjects[m] && !studentWanted[k].isTaken()) {
                            studentWanted[k].selectProject();
                            studentList[i].setChosenProject(studentWanted[k]);
                            System.out.println("Student: "
                                    + studentList[i].getName() +
                                    " has chosen project: " + studentList[i].getChosenProject());
                            break; // Exit inner loop after assigning project
                        }
                    }
                }
            }
        }
    }

    public static void solveHall(Problem pb){
        boolean[] inca_vor= {true};
        Student[] students = pb.getStudents();
        List<Student> selectedStudents = new ArrayList<>();
        backtrackHall(students, selectedStudents, 0, inca_vor);
        System.out.println("Conform teoremei lui Hall:");
        if (inca_vor[0])
            System.out.println("Alocarea unui proiect fiecarui student e posibila");
        else System.out.println("Alocarea unui proiect fiecarui student NU e posibila");
    }

    private static void backtrackHall(Student[] students, List<Student> selectedStudents, int index, boolean[] incaVor) {
        if (!incaVor[0]) return;
        if (!selectedStudents.isEmpty()) {
            int uniqueCount = 0;
            List<Project> tempMarked = new ArrayList<>();
            for (Student s : selectedStudents) {
                Project[] wantedProjects = s.getWantedProjects();
                if (wantedProjects != null) {
                    for (Project p : wantedProjects) {
                        if (!p.isTaken()) {
                            p.selectProject();
                            tempMarked.add(p);
                            uniqueCount++;
                        }
                    }
                }
            }
            if (uniqueCount < selectedStudents.size()) {
                incaVor[0] = false;
                for (Project p : tempMarked) {
                    p.abandonProject();
                }
                return;  // Exit recursion
            }

            for (Project p : tempMarked) {
                p.abandonProject();
            }
        }

        for (int i = index; i < students.length; i++) {
            selectedStudents.add(students[i]);
            backtrackHall(students, selectedStudents, i + 1, incaVor);
            selectedStudents.remove(selectedStudents.size() - 1);
        }
    }

}
