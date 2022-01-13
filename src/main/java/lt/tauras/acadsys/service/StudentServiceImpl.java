package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> getAllStudentsWithoutGroup() {
        List<Student> allStudents = studentRepository.findAll();
        List<Student> studentsWithoutGroup = new ArrayList<>();

        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getGroup() == null) {
                studentsWithoutGroup.add(allStudents.get(i));
            }
        }

        return studentsWithoutGroup;
    }

    @Override
    public List<Student> getAllStudentsWithGroup() {
        List<Student> allStudents = studentRepository.findAll();
        List<Student> studentsWithGroup = new ArrayList<>();

        for (int i = 0; i < allStudents.size(); i++) {
            if (allStudents.get(i).getGroup() != null) {
                studentsWithGroup.add(allStudents.get(i));
            }
        }

        return studentsWithGroup;
    }

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student;
        if (optional.isPresent()) {
            student = optional.get();
        } else {
            throw new RuntimeException(" Studentas nerastas pagal id :: " + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {
        this.studentRepository.deleteById(id);
    }
}
