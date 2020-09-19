package hibernate.demo.dao;

import hibernate.demo.entity.Student;
import hibernate.demo.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.List;
@Slf4j
public class StudentDAOImpl  implements StudentDAO{
    @Override
    public void saveStudent(Student student) {
        Transaction transaction=null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction= session.beginTransaction();
            session.save(student);
            transaction.commit();
            log.info("Student record is saved...");

        }catch(Exception exception){
            log.error("Error...");
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }

    @Override
    public List<Student> readAllStudents() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<Student> students = session.createQuery("FROM Student").list();
            return students;
        }
    }

    @Override
    public Student findByID(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
          /* Student student=(Student)session.load(Student.class,new Integer(id));
           Student student1=(Student)session.load(Student.class,new Integer(id));
          Student student2=(Student)session.load(Student.class,new Integer(id));*/

            Student student=(Student)session.get(Student.class,new Integer(id));
            Student student1=(Student)session.get(Student.class,new Integer(id));
            Student student2=(Student)session.get(Student.class,new Integer(id));
          return student;

        }
    }

    @Override
    public void delete(Integer id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Student student = findByID(id);
            session.delete(student);
            session.getTransaction().commit();
            log.info("Successfully deleted " + student.getFirstName());
        }
    }

    @Override
    public void deleteAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query=session.createQuery("DELETE FROM Student");
            query.executeUpdate();
        }
    }
}
