package hibernate.demo.dao;

import hibernate.demo.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void saveStudent(Student student);
    public List<Student> readAllStudents();
    public Student findByID(int id);
    public  void delete(Integer id);
    public  void deleteAll();
}
