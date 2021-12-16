package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Lecturer;

import java.util.List;

public interface LecturerService {
    List<Lecturer> getAllLecturers();
    void saveLecturer(Lecturer lecturer);
    Lecturer getLecturerById(long id);
    void deleteLecturerById(long id);
}
