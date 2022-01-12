package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Course;
import lt.tauras.acadsys.model.Grade;
import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.repository.CourseRepository;
import lt.tauras.acadsys.repository.GradeRepository;
import lt.tauras.acadsys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService{

    @Autowired
    private GradeRepository gradeRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Grade> getAllGrades() {
        return gradeRepository.findAll();
    }

    @Override
    public void saveGrade(Grade grade) {
        this.gradeRepository.save(grade);
    }

    @Override
    public Grade getGradeById(long id) {
        Optional<Grade> optional = gradeRepository.findById(id);
        Grade grade;
        if (optional.isPresent()) {
            grade = optional.get();
        } else {
            throw new RuntimeException(" Grade not found for id :: " + id);
        }
        return grade;
    }

    @Override
    public void deleteGradeById(long id) {
        this.gradeRepository.deleteById(id);
    }

    @Override
    public List<Grade> getAllStudentCourseGrades(Student student) {
        List<Grade> grades = gradeRepository.findAll();
        List<Grade> studentGrades = new ArrayList<>();

        for (int i = 0; i < grades.size(); i++) {

            if(grades.get(i).getStudent().getId() == (student.getId())) {
                studentGrades.add(grades.get(i));
            }
        }

        return studentGrades;
    }
}
