package com.tw.apistackbase.entity;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class LegalCaseMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "long")
    private Long id;

    @Max(255)
    @Column(name = "objective", nullable = false)
    private String objective;

    @Max(255)
    @Column(name = "subjective", nullable = false)
    private String subjective;

    public LegalCaseMessage(Long id, @Max(255) String objective, @Max(255) String subjective) {
        this.id = id;
        this.objective = objective;
        this.subjective = subjective;
    }

    public LegalCaseMessage(@Max(255) String objective, @Max(255) String subjective) {
        this.objective = objective;
        this.subjective = subjective;
    }
}
