package lt.tauras.acadsys.service;

import lt.tauras.acadsys.model.Group;

import java.util.List;

public interface GroupService {
    List<Group> getAllGroups();
    void saveGroup(Group group);
    Group getGroupById(long id);
    void deleteGroupById(long id);
}
