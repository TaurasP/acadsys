package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Lecturer;
import lt.tauras.acadsys.repository.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerServiceImpl implements LecturerService{

    @Autowired
    private LecturerRepository lecturerRepository;

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public void saveLecturer(Lecturer lecturer) {
        this.lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturerById(long id) {
        Optional<Lecturer> optional = lecturerRepository.findById(id);
        Lecturer lecturer;
        if (optional.isPresent()) {
            lecturer = optional.get();
        } else {
            throw new RuntimeException(" Dėstytojas nerastas pagal id :: " + id);
        }
        return lecturer;
    }

    @Override
    public void deleteLecturerById(long id) {
        this.lecturerRepository.deleteById(id);
    }
}
