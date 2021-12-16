package lt.tauras.acadsys.model;

import lt.tauras.acadsys.service.UserServiceImpl;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student extends User{
}
