package example.entity;

import javax.persistence.*;
import javax.persistence.Id;

@Entity
@Table(name="employee")
public class Employee {
    @Id
    private long id;
    private String name;
    private String salary;

    public Employee(long id, String name, String salary){
        this.id = id;
        this.name = name;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
