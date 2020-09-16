package hibernate.demo.dao;

import hibernate.demo.entity.Student;
import hibernate.demo.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        return null;
    }

    @Override
    public Student findByID(int id) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void deleteAll() {

    }
}
