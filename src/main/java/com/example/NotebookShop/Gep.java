package com.example.Notebookshop;
import javax.persistence.*;


@Entity
@Table(name = "gep")
public class Gep {
    @Id
    private int id;
    @Column(name = "gyarto")
    private String gyarto;
    @Column(name = "tipus")
    private String tipus;
    @Column(name = "kijelzo")
    private String kijelzo;
    @Column(name = "memoria")
    private Integer memoria;
    @Column(name = "merevlemez")
    private Integer merevlemez;
    @Column(name = "videovezerlo")
    private String videovezerlo;
    @Column(name = "ar")
    private Integer ar;

    @Column(name = "processzorid")
    private Integer cpuid;

    @Column(name = "oprendszerid")
    private Integer opsysid;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getGyarto() {return gyarto;}
    public void setGyarto(String gyarto) {
        this.gyarto = gyarto;
    }

    public String getTipus() {
        return tipus;
    }
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getKijelzo() {
        return kijelzo;
    }
    public void setKijelzo(String kijelzo) {
        this.kijelzo = kijelzo;
    }

    public Integer getMemoria() {
        return memoria;
    }
    public void setMemoria(Integer memoria) {
        this.memoria = memoria;
    }

    public Integer getMerevlemez() {
        return merevlemez;
    }
    public void setMerevlemez(Integer merevlemez) {
        this.merevlemez = merevlemez;
    }

    public String getVideovezerlo() {
        return videovezerlo;
    }
    public void setVideovezerlo(String videovezerlo) {
        this.videovezerlo = videovezerlo;
    }

    public Integer getAr() {
        return ar;
    }
    public void setAr(Integer ar) {
        this.ar = ar;
    }
}