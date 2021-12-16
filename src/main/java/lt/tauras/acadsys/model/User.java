package lt.tauras.acadsys.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column(nullable = false, length = 4)
    @Column
    private boolean active;

    //@Column(nullable = false, length = 45)
    @Column
    private String name;

    //@Column(nullable = false, length = 45)
    @Column
    private String surname;

    //@Column(nullable = false, length = 100)
    @Column
    private String password;

    //@Column(nullable = false, length = 45, name = "user_name")
    @Column(name = "user_name")
    private String userName;

    //@Column(nullable = false, length = 45)
    @Column
    private String roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}