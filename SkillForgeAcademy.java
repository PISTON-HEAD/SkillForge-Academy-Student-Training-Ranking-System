import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private String email;
    private ArrayList<CoursePerformance> performances;
    private ArrayList<Course> enrolledCourses;

    public Student(String studentId, String name, String email) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.performances = new ArrayList<>();
        this.enrolledCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<CoursePerformance> getPerformances() {
        return performances;
    }

    public void addPerformance(CoursePerformance performance) {
        this.performances.add(performance);
    }

    public double calculateOverallScore() {
        double weightedAvg = 0.0;
        for (CoursePerformance cPerformance : performances) {
            weightedAvg += cPerformance.calculateFinalScore();
        }
        return weightedAvg / performances.size();
    }

    public void displayStudentDetails() {
        System.out.println("========================================");
        System.out.println("           STUDENT DETAILS              ");
        System.out.println("========================================");
        System.out.println("Student ID      : " + studentId);
        System.out.println("Name            : " + name);
        System.out.println("Email           : " + email);
        System.out.println("----------------------------------------");

        if (performances.isEmpty()) {
            System.out.println("No course performances available.");
        } else {
            System.out.println("Course Performances:");
            int count = 1;
            for (CoursePerformance p : performances) {
                Course c = p.getCourse();
                System.out.println("  " + count + ". Course ID      : " + c.getCourseId());
                System.out.println("     Course Name    : " + c.getCourseName());
                System.out.println("     Instructor     : " + c.getInstructorName());
                System.out.println("     Course Type    : " + c.getCourseType());
                System.out.println("     Difficulty     : " + c.getDifficultyLevel());
                System.out.println("     Assignment     : " + p.getAssignmentScore());
                System.out.println("     Quiz           : " + p.getQuizScore());
                System.out.println("     Project        : " + p.getProjectScore());
                System.out.println("     Final Score    : " + String.format("%.2f", p.calculateFinalScore()));
                System.out.println("----------------------------------------");
                count++;
            }

            double overall = calculateOverallScore();
            System.out.println("Overall Score   : " + String.format("%.2f", overall));
        }

        System.out.println("========================================\n");
    }

}

class Course {
    private String courseId;
    private String courseName;
    private String instructorName;
    private String courseType;
    private int difficultyLevel;
    private ArrayList<Student> enrolledStudents;

    public Course(String courseId, String courseName, String instructorName, String courseType, int difficultyLevel) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.courseType = courseType;
        this.difficultyLevel = difficultyLevel;
        this.enrolledStudents = new ArrayList<>();
    }

    public ArrayList<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void displayCourseDetails() {
        System.out.println("----- Course Details -----");
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Instructor: " + instructorName);
        System.out.println("Course Type: " + courseType);
        System.out.println("Difficulty Level: " + difficultyLevel + " / 5");
        System.out.println("--------------------------");
    }

}

class CoursePerformance {
    private Course course;
    private double assignmentScore;
    private double quizScore;
    private double projectScore;

    public CoursePerformance(Course course, double assignmentScore, double quizScore, double projectScore) {
        this.course = course;
        this.assignmentScore = assignmentScore;
        this.quizScore = quizScore;
        this.projectScore = projectScore;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public double getAssignmentScore() {
        return assignmentScore;
    }

    public void setAssignmentScore(double assignmentScore) {
        this.assignmentScore = assignmentScore;
    }

    public double getQuizScore() {
        return quizScore;
    }

    public void setQuizScore(double quizScore) {
        this.quizScore = quizScore;
    }

    public double getProjectScore() {
        return projectScore;
    }

    public void setProjectScore(double projectScore) {
        this.projectScore = projectScore;
    }

    public void displayPerformanceDetails() {
        System.out.println("----- Course Performance -----");
        if (course != null) {
            course.displayCourseDetails();
        }
        System.out.println("Assignment Score: " + assignmentScore);
        System.out.println("Quiz Score: " + quizScore);
        System.out.println("Project Score: " + projectScore);
        System.out.println("------------------------------");
    }

    public double calculateFinalScore() {
        return (this.assignmentScore * 0.3) + (this.quizScore * 0.2) + (this.projectScore * 0.5);

    }
}

class AcademyManagementSystem {
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    AcademyManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void enrollStudentInCourse(String courseId, String studentId) {
        Course course = checkValidCourse(courseId);
        Student student = checkValidStudent(studentId);
        if (course != null || student != null) {
            if (!student.getEnrolledCourses().contains(course) && !course.getEnrolledStudents().contains(student)) {
                student.getEnrolledCourses().add(course);
                course.getEnrolledStudents().add(student);
            } else
                System.out.println("X Student already enrolled in course " + course.getCourseName());
        } else {
            System.out.println("Invalid Details");
        }
    }

    private Course checkValidCourse(String id) {
        return courses.stream().filter(i -> i.getCourseId().equals(id)).findAny().orElse(null);
    }

    private Student checkValidStudent(String id) {
        return students.stream().filter(i -> i.getStudentId().equals(id)).findAny().orElse(null);
    }

    public void recordPerformance(String studentId, String courseId, double assignmentScore, double quizScore,
            double projectScore) {
        Course course = checkValidCourse(courseId);
        Student student = checkValidStudent(studentId);

        if (!student.getEnrolledCourses().contains(course) || student == null) {
            System.out.println("X Invalid Details.");
            return;
        }

        CoursePerformance coursePerformance = new CoursePerformance(course, assignmentScore, quizScore, projectScore);
        student.addPerformance(coursePerformance);
        System.out.println("Performance Recorded for " + student.getName() + " in " + course.getCourseName());
    }

    public void showSortedStudentDetails() {
        students.sort(Comparator.comparing(Student::getName));
        for (Student student : students) {
            student.displayStudentDetails();
        }

    }

    private HashMap<String, Double> calculateOverallScoreForAllStudents() {
        HashMap<String, Double> ranking = new HashMap<>();

        for (Student student : students) {
            double finalScore = student.calculateOverallScore();
            ranking.put(student.getName(), finalScore);
        }
        return ranking;

    }

    public ArrayList<String> rankingOfAllStudents() {
        ArrayList<String> rankingSortedList = new ArrayList<>();
        HashMap<String, Double> ranking = new HashMap<>();
        ranking = calculateOverallScoreForAllStudents();
        List<Map.Entry<String, Double>> rankList = new ArrayList<>(ranking.entrySet());
        rankList.sort(Map.Entry.comparingByValue());
        System.out.println("--- Student Rankings ---");
        int rank = 1;
        for (Map.Entry<String, Double> entry : rankList) {
            rankingSortedList.add(rank + entry.getKey() + " — " + String.format("%.1f", entry.getValue()));
            rank++;
        }
        return rankingSortedList;
    }
}

public class SkillForgeAcademy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AcademyManagementSystem academy = new AcademyManagementSystem();
        ArrayList<String> rankingSortedList = new ArrayList<>();
        boolean running = true;

        while (running) {
            System.out.println("===== SkillForge Academy =====");
            System.out.println("1. Add Course");
            System.out.println("2. Add Student");
            System.out.println("3. Enroll Student to Course");
            System.out.println("4. Record Performance");
            System.out.println("5. Show All Students");
            System.out.println("6. Show Rankings");
            System.out.println("7. Show Top 3 Performers");
            System.out.println("8. Exit");
            System.out.println("==============================");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String cId = sc.nextLine();
                    System.out.print("Enter Course Name: ");
                    String cName = sc.nextLine();
                    System.out.print("Enter Instructor Name: ");
                    String instructor = sc.nextLine();
                    System.out.print("Enter Course Type (Coding/Design/Management): ");
                    String type = sc.nextLine();
                    System.out.print("Enter Difficulty Level (1-5): ");
                    int difficulty = sc.nextInt();
                    sc.nextLine();

                    Course course = new Course(cId, cName, instructor, type, difficulty);
                    academy.addCourse(course);
                    System.out.println("✅ Course Added Successfully!");
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    String sId = sc.nextLine();
                    System.out.print("Enter Student Name: ");
                    String sName = sc.nextLine();
                    System.out.print("Enter Student Email: ");
                    String email = sc.nextLine();

                    Student student = new Student(sId, sName, email);
                    academy.addStudent(student);
                    System.out.println("✅ Student Added Successfully!");
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    sId = sc.nextLine();
                    System.out.print("Enter Course ID: ");
                    cId = sc.nextLine();

                    academy.enrollStudentInCourse(cId, sId);
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    sId = sc.nextLine();
                    System.out.print("Enter Course ID: ");
                    cId = sc.nextLine();
                    System.out.print("Enter Assignment Score: ");
                    double as = sc.nextDouble();
                    System.out.print("Enter Quiz Score: ");
                    double qs = sc.nextDouble();
                    System.out.print("Enter Project Score: ");
                    double ps = sc.nextDouble();
                    sc.nextLine();

                    academy.recordPerformance(sId, cId, as, qs, ps);
                    break;

                case 5:
                    academy.showSortedStudentDetails();
                    break;

                case 6:
                    System.out.println();
                    rankingSortedList = academy.rankingOfAllStudents();
                    for (int i = 0; i < rankingSortedList.size(); i++) {
                        System.out.println(rankingSortedList.get(i));
                    }
                    System.out.println();
                    break;

                case 7:
                    System.out.println("--- Top 3 Performers ---");
                    rankingSortedList = academy.rankingOfAllStudents();
                    for (int i = 0; i < rankingSortedList.size(); i++) {
                        if (i == 4)
                            break;
                        System.out.println(rankingSortedList.get(i));
                    }
                    System.out.println("-------------------------\n");
                    break;

                case 9:
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                    break;

                case 8:
                    academy.showSortedStudentDetails();
                    break;

                default:
                    System.out.println("❌ Invalid Choice! Try again.");
            }
        }
        sc.close();
    }
}
