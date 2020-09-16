package hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="contract_employee")
@PrimaryKeyJoinColumn(name="ID")
public class ContractEmployee extends Employee {

    @Column(name="pay_per_hour")
    private float payPerHour;

    @Column(name="contract_duration")
    private String contractDuration;

    public ContractEmployee() {

    }

    public ContractEmployee(float payPerHour, String contractDuration) {
        this.payPerHour = payPerHour;
        this.contractDuration = contractDuration;
    }

    public float getPayPerHour() {
        return payPerHour;
    }

    public void setPayPerHour(float payPerHour) {
        this.payPerHour = payPerHour;
    }

    public String getContractDuration() {
        return contractDuration;
    }

    public void setContractDuration(String contractDuration) {
        this.contractDuration = contractDuration;
    }


}
