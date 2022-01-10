package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    List<Student> getAllStudentsWithoutGroup();
    List<Student> getAllStudentsWithGroup();
    void saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
