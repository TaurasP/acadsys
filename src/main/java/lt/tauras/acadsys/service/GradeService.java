package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Grade;
import lt.tauras.acadsys.model.Student;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrades();
    List<Grade> getAllStudentCourseGrades(Student student);
    void saveGrade(Grade grade);
    Grade getGradeById(long id);
    void deleteGradeById(long id);
}
