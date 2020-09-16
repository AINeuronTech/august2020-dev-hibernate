package hibernate.demo;

import hibernate.demo.entity.ContractEmployee;
import hibernate.demo.entity.Employee;
import hibernate.demo.entity.RegularEmployee;
import hibernate.demo.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

@Slf4j
public class TablePerSubclass {

    public static void main(String[] args) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            log.info("Started processing ....");

            Employee employee = new Employee();
            employee.setName("Hary");

            RegularEmployee regularEmployee = new RegularEmployee();
            regularEmployee.setName("John doe");
            regularEmployee.setBonus(500);
            regularEmployee.setSalary(5000l);

            ContractEmployee contractEmployee=new ContractEmployee();
            contractEmployee.setContractDuration("2 year");
            contractEmployee.setName("Joseph");
            contractEmployee.setPayPerHour(65l);

            Transaction transaction = session.beginTransaction();
            session.persist(employee);
            session.persist(regularEmployee);
            session.persist(contractEmployee);
            transaction.commit();
            System.exit(0);
        }
    }
}
