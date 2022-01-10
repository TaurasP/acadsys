package lt.tauras.acadsys.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 10)
    private int grade;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    /*public static final int GRADE_0 = 0;
    public static final int GRADE_1 = 1;
    public static final int GRADE_2 = 2;
    public static final int GRADE_3 = 3;
    public static final int GRADE_4 = 4;
    public static final int GRADE_5 = 5;
    public static final int GRADE_6 = 6;
    public static final int GRADE_7 = 7;
    public static final int GRADE_8 = 8;
    public static final int GRADE_9 = 9;
    public static final int GRADE_10 = 10;*/

    //List<Integer> gradesList = Arrays.asList(GRADE_0, GRADE_1, GRADE_2, GRADE_3, GRADE_4, GRADE_5, GRADE_6, GRADE_7, GRADE_8, GRADE_9, GRADE_10);


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
