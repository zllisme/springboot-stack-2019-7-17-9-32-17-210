package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LegalCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LegalCaseRepository extends JpaRepository<LegalCase,Long> {

    @Query(value = "select * from legalcase order by time desc", nativeQuery = true)
    List<LegalCase> findAllLegalCasesSortByTime();

    LegalCase findLegalCaseByName(String name);
}
