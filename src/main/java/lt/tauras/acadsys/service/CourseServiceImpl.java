package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Course;
import lt.tauras.acadsys.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        Optional<Course> optional = courseRepository.findById(id);
        Course course = null;
        if (optional.isPresent()) {
            course = optional.get();
        } else {
            throw new RuntimeException(" Dėstomas dalykas nerastas pagal id :: " + id);
        }
        return course;
    }

    @Override
    public void deleteCourseById(long id) {
        this.courseRepository.deleteById(id);
    }
}
