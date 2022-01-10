package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Group;
import lt.tauras.acadsys.model.Student;
import lt.tauras.acadsys.repository.GroupRepository;
import lt.tauras.acadsys.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService{

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void saveGroup(Group group) {
        this.groupRepository.save(group);
    }

    @Override
    public Group getGroupById(long id) {
        Optional<Group> optional = groupRepository.findById(id);
        Group group = null;
        if (optional.isPresent()) {
            group = optional.get();
        } else {
            throw new RuntimeException(" Group not found for id :: " + id);
        }
        return group;
    }

    @Override
    public void deleteGroupById(long id) {
        this.groupRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsByGroupId(long groupId) {
        return groupRepository.getById(groupId).getStudents();
    }

}
