package com.tw.apistackbase.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
public class Procurator {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    @Length(max=255, min=0)
    private String name;

    public Procurator(@Length(max = 255, min = 0) String name) {
        this.name = name;
    }

    public Procurator() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Procurator{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
