package com.tw.apistackbase.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Procuratorate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Length(max=50, min=0)
    private String name;

    public Procuratorate(String name) {
        this.name = name;
    }

    public Procuratorate() {
    }

    @Override
    public String toString() {
        return "Procuratorate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
