package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LegalCase;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class LegalCaseRepositoryTest {

    @Autowired
    LegalCaseRepository legalCaseRepository;

    @Test
    @DirtiesContext
    public void should_return_legal_case_sorted_by_time() {
        //given
        LegalCase legalCase = new LegalCase("rob",1234L);
        LegalCase legalCaseTwo = new LegalCase("harry", 1235L);
        legalCaseRepository.save(legalCase);
        legalCaseRepository.save(legalCaseTwo);

        //when
        List<LegalCase> result = legalCaseRepository.findAllLegalCasesSortByTime();

        //then
        Assertions.assertEquals("harry", result.get(0).getName());
        Assertions.assertEquals("rob", result.get(1).getName());
    }

    @Test
    public void should_fail_when_save() {
        LegalCase legalCase = new LegalCase("test", null);
        LegalCase legalCaseTwo = new LegalCase(null, 100L);
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                legalCaseRepository.saveAndFlush(legalCase);
            }
        });
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                legalCaseRepository.saveAndFlush(legalCaseTwo);
            }
        });

    }
}