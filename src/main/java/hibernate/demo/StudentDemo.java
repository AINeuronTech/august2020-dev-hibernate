package hibernate.demo;

import hibernate.demo.dao.StudentDAO;
import hibernate.demo.dao.StudentDAOImpl;
import hibernate.demo.entity.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StudentDemo {

    public static void main(String[] args) {

        log.info("Save students ............");
        Student student1 = new Student();
        student1.setFirstName("Jonathan");
        student1.setLastName("charlse");
        student1.setEmail("john.doe@test.com");
        student1.setTotalMark(100);

        Student student2 = new Student();
        student2 .setFirstName("Stefen");
        student2.setLastName("Ross");
        student2.setEmail("stefen.ross@test.com");
        student2.setTotalMark(200);

        StudentDAO dao=new StudentDAOImpl();
        dao.saveStudent(student1);
        dao.saveStudent(student2);

        System.out.println("Saved 2 students ............");
        System.out.println("Fetching Students By Id ............");
        Student student =dao.findByID(1);
        System.out.println("Printing Students::::"+student.toString());

        System.out.println("::::DB Operation Completed::::");
        System.exit(0);
    }
}
