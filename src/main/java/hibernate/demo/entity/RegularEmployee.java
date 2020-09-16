package hibernate.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="REGULAR_EMPLOYEE")
@PrimaryKeyJoinColumn(name="ID")
public class RegularEmployee extends Employee {

    @Column(name="salary")
    private float salary;

    @Column(name="bonus")
    private int bonus;

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
