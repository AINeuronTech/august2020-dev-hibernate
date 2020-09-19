package hibernate.demo;

import hibernate.demo.entity.Cart;
import hibernate.demo.entity.Item;
import hibernate.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.HashSet;
import java.util.Set;

public class M2MDemo {
    public static void main(String[] args) {

        Item iphone = new Item();
        iphone.setPrice(100);
        iphone.setDescription("iPhone");

        Item ipod = new Item();
        ipod.setPrice(50);
        ipod.setDescription("Ipod");


        Set<Item> items = new HashSet<Item>();
        items.add(iphone);
        items.add(ipod);

        Cart cart = new Cart();
        cart.setItems(items);
        cart.setTotal(150);

        Cart cart1 = new Cart();
        Set<Item> items1 = new HashSet<Item>();
        items1.add(iphone);
        cart1.setItems(items1);
        cart1.setTotal(100);

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            session.save(cart);
            session.save(cart1);
            System.out.println("Before committing transaction");
            tx.commit();
            System.out.println("Cart ID=" + cart.getId());
            System.out.println("Cart1 ID=" + cart1.getId());
            System.out.println("Item1 ID=" + iphone.getId());
            System.out.println("Item2 ID=" + ipod.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
