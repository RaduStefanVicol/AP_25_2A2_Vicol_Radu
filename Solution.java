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
}
