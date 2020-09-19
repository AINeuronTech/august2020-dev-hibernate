package hibernate.demo;

import hibernate.demo.entity.Stock;
import hibernate.demo.entity.StockDailyRecord;
import hibernate.demo.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

public class Many2OneDmo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();

        Stock stock = new Stock();
        stock.setStockCode("7052");
        stock.setStockName("PATNI");

        StockDailyRecord stockDailyRecords = new StockDailyRecord();
        stockDailyRecords.setPriceOpen(new Float("1.2"));
        stockDailyRecords.setPriceClose(new Float("1.1"));
        stockDailyRecords.setPriceChange(new Float("10.0"));
        stockDailyRecords.setVolume(3000000L);
        stockDailyRecords.setDate(new Date());
        stockDailyRecords.setStock(stock);

        StockDailyRecord stockDailyRecords2 = new StockDailyRecord();
        stockDailyRecords2.setPriceOpen(new Float("1.24444"));
        stockDailyRecords2.setPriceClose(new Float("1.10111"));
        stockDailyRecords2.setPriceChange(new Float("20.0"));
        stockDailyRecords2.setVolume(4000000L);
        Date date2=new Date();
        date2.setHours(1);
        stockDailyRecords2.setDate(date2);
        stockDailyRecords2.setStock(stock);

        stock.getStockDailyRecords().add(stockDailyRecords);
        stock.getStockDailyRecords().add(stockDailyRecords2);


        session.save(stock);
       /* session.save(stockDailyRecords);
        session.save(stockDailyRecords2);*/
        transaction.commit();


    }
}
