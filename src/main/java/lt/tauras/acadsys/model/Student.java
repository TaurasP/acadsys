package lt.tauras.acadsys.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//@Entity(name = "JoinTableStudent")
@Entity
@Table(name = "students")
public class Student extends User{

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Grade> grades = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
