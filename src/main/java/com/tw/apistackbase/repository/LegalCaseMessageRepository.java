package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LegalCaseMessage;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

interface LegalCaseMessageRepository extends JpaRepository<LegalCaseMessage,Long> {
}
