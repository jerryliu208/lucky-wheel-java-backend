package com.developerExam.backend.Model;

import javax.persistence.*;

@Table
@Entity(name = "prizes")
public class Prize {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "prize_name")
    private String prizeName;

    @Column(name = "prize_stock")
    private Integer prizeStock;

    public Integer getId() {
        return id;
    }

    public Prize setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public Prize setPrizeName(String prizeName) {
        this.prizeName = prizeName;
        return this;
    }

    public Integer getPrizeStock() {
        return prizeStock;
    }

    public Prize setPrizeStock(Integer prizeStock) {
        this.prizeStock = prizeStock;
        return this;
    }
}
