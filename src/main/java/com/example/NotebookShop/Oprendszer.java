package com.example.NotebookShop;
import javax.persistence.*;


@Entity
@Table(name = "oprendszer")
public class Oprendszer {

    @Id
    private int id;

    @Column(name = "nev")
    private String nev;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }
}