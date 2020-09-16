package hibernate.demo;

import hibernate.demo.entity.Address;
import hibernate.demo.entity.User;
import hibernate.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class O2ODemo {
    public static void main(String[] args) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction transaction=session.beginTransaction();
            Address address =new Address();
            address.setAptNo("12");
            address.setCityName("Haric Street");
            address.setState("New Jersey");
            address.setCountry("USA");

            User user=new User();
            user.setName("John Dao");
            user.setRollNumber(1);
            user.setPhoneNumber("777-777-7777");
            user.setAddress(address);
            session.save(user);

            transaction.commit();
            System.exit(0);
        }

    }
}
