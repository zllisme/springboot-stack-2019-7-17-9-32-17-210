package com.tw.apistackbase.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;

@Entity
public class LegalCaseMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "long")
    private Long id;

    @Length(max=255,min=0)
    @Column(name = "objectivedesc", nullable = false)
    private String objectiveDesc;

    @Length(max=255,min=0)
    @Column(name = "subjectivedesc", nullable = false)
    private String subjectiveDesc;

    public LegalCaseMessage(Long id, @Max(255) String objectiveDesc, @Max(255) String subjectiveDesc) {
        this.id = id;
        this.objectiveDesc = objectiveDesc;
        this.subjectiveDesc = subjectiveDesc;
    }

    public LegalCaseMessage(@Max(255) String objectiveDesc, @Max(255) String subjectiveDesc) {
        this.objectiveDesc = objectiveDesc;
        this.subjectiveDesc = subjectiveDesc;
    }

    public LegalCaseMessage() {
    }

    public String getObjectiveDesc() {
        return objectiveDesc;
    }

    public void setObjectiveDesc(String objectiveDesc) {
        this.objectiveDesc = objectiveDesc;
    }

    public String getSubjectiveDesc() {
        return subjectiveDesc;
    }

    public void setSubjectiveDesc(String subjectiveDesc) {
        this.subjectiveDesc = subjectiveDesc;
    }

    @Override
    public String toString() {
        return "LegalCaseMessage{" +
                "id=" + id +
                ", objectiveDesc='" + objectiveDesc + '\'' +
                ", subjectiveDesc='" + subjectiveDesc + '\'' +
                '}';
    }
}
