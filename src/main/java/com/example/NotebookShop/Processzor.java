package com.example.NotebookShop;
import javax.persistence.*;


@Entity
@Table(name = "processzor")
public class Processzor {

    @Id
    private int id;

    @Column(name = "gyarto")
    private String gyarto;

    @Column(name = "tipus")
    private String tipus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGyarto() {
        return gyarto;
    }

    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
}