package com.tw.apistackbase.entity;


import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Valid
@Table(name="legalcase")
public class LegalCase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "long")
    private Long id;


    @NotNull
    @Length(max=255)
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "time", nullable = false)
    private Long time;

    @OneToOne(cascade = CascadeType.ALL)
    private LegalCaseMessage legalCaseMessage;

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    private Procuratorate procuratorate;

    public LegalCaseMessage getLegalCaseMessage() {
        return legalCaseMessage;
    }

    public void setLegalCaseMessage(LegalCaseMessage legalCaseMessage) {
        this.legalCaseMessage = legalCaseMessage;
    }

    public Procuratorate getProcuratorate() {
        return procuratorate;
    }

    public void setProcuratorate(Procuratorate procuratorate) {
        this.procuratorate = procuratorate;
    }

    public LegalCase(@NotNull @Length(max = 255) String name, @NotNull Long time) {
        this.name = name;
        this.time = time;
    }

    public LegalCase(Long id, @NotNull @Length(max = 255) String name, Long time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public LegalCase() {
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

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }
}
