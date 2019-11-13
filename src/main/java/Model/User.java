package Model;

import java.util.Objects;
import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "job")
    private String job;

    @Column(name = "salary")
    private Long salary;




    public User() {

    }

    public User(String job, Long salary) {
        this.job = job;
        this.salary = salary;
    }

    public User(String name, String password, String role, String job, long salary) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.job = job;
        this.salary = salary;
    }

    public User(long id, String name, String password, String role, String job, long salary) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
        this.job = job;
        this.salary = salary;
    }

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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return getName().equals(user.getName()) &&
                getJob().equals(user.getJob());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getJob());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
}
