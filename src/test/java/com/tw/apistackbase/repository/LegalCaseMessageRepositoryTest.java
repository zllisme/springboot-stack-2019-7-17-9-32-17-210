package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LegalCaseMessage;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LegalCaseMessageRepositoryTest {

    @Autowired
    LegalCaseMessageRepository legalCaseMessageRepository;

    @Test
    @DirtiesContext
    public void should_fail_when_save() {
        LegalCaseMessage legalCase = new LegalCaseMessage(null, "test");
        LegalCaseMessage legalCaseTwo = new LegalCaseMessage("test", null);
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                legalCaseMessageRepository.saveAndFlush(legalCase);
            }
        });
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                legalCaseMessageRepository.saveAndFlush(legalCaseTwo);
            }
        });
    }
}