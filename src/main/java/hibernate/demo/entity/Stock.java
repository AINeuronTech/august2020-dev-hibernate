package hibernate.demo.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "STOCK_ID", unique = true, nullable = false)
    private Integer stockId;
    @Column(name = "STOCK_CODE")
    private String stockCode;
    @Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
    private String stockName;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "stock" )
    private Set<StockDailyRecord> stockDailyRecords = new HashSet<StockDailyRecord>(0);

    public Stock() {
    }

    public Integer getStockId() {
        return stockId;
    }

    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public Set<StockDailyRecord> getStockDailyRecords() {
        return stockDailyRecords;
    }

    public void setStockDailyRecords(Set<StockDailyRecord> stockDailyRecords) {
        this.stockDailyRecords = stockDailyRecords;
    }
}
