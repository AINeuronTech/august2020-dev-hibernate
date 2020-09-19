package hibernate.demo;

import hibernate.demo.entity.Student;
import hibernate.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class StudentCriteriaDemo {
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSessionFactory().openSession()){

            Transaction tx = session.beginTransaction();
            Student student1 = new Student();
            student1.setFirstName("Jonathan");
            student1.setLastName("Dao");
            student1.setEmail("john.doe@test.com");
            student1.setTotalMark(100);

            Student student2 = new Student();
            student2 .setFirstName("Stefen");
            student2.setLastName("Ross");
            student2.setEmail("stefen.ross@test");
            student2.setTotalMark(200);

            Student student3 = new Student();
            student3.setFirstName("Jonathan");
            student3.setLastName("charlse");
            student3.setEmail("john.doe@test.com");
            student3.setTotalMark(300);

            Student student4 = new Student();
            student4 .setFirstName("John");
            student4.setLastName("Paul");
            student4.setEmail("john.paul@test.com");
            student4.setTotalMark(400);

            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);
            tx.commit();
            System.out.println(":::Saved in the Student table ::::");

            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Student> criteriaQuery= criteriaBuilder.createQuery(Student.class);
            Root<Student> studentRoot=criteriaQuery.from(Student.class);
            criteriaQuery.select(studentRoot);
            criteriaQuery.where(criteriaBuilder.equal(studentRoot.get("firstName"),"Stefen"));
            Query<Student> student=session.createQuery(criteriaQuery);
            List<Student> students=student.list();
            students.forEach(System.out::println);

        }

    }
}
