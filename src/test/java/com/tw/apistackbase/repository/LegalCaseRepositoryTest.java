package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.LegalCase;
import com.tw.apistackbase.entity.LegalCaseMessage;
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
import java.util.ListIterator;

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
    @DirtiesContext
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

    @Test
    @DirtiesContext
    public void should_return_legal_case_when_find_by_name() {
        LegalCase legalCase = new LegalCase(1L,"test", 123L);
        legalCaseRepository.saveAndFlush(legalCase);
        LegalCase result = legalCaseRepository.findLegalCaseByName("test");
        Assertions.assertSame(1L, result.getId());
        Assertions.assertEquals("test", result.getName());
        Assertions.assertSame(123L, result.getTime());

    }

    @Test
    @DirtiesContext
    public void should_return_relevant_message() {
        LegalCaseMessage legalCaseMessage = new LegalCaseMessage(1L,"objectiveDesc", "subjective desc");
        LegalCase legalCase = new LegalCase(1L,"test", 123L);
        legalCase.setLegalCaseMessage(legalCaseMessage);
        legalCaseRepository.saveAndFlush(legalCase).getId();
        LegalCase result = legalCaseRepository.findLegalCaseByName("test");
        Assertions.assertEquals("subjective desc", result.getLegalCaseMessage().getSubjectiveDesc());
        Assertions.assertSame("objectiveDesc", result.getLegalCaseMessage().getObjectiveDesc());
    }

    @Test
    @DirtiesContext
    public void should_return_not_null_when_add_message() {
        LegalCase legalCase = new LegalCase("test1", 12L);
        LegalCase legalCaseTwo = new LegalCase("test2", 13L);
        legalCaseRepository.saveAndFlush(legalCase);
        legalCaseRepository.saveAndFlush(legalCaseTwo);
        List<LegalCase> legalCases = legalCaseRepository.findAll();
        LegalCaseMessage legalCaseMessage = new LegalCaseMessage("objectiveDesc", "subjective desc");
        LegalCaseMessage legalCaseMessage2 = new LegalCaseMessage("test", "sub test");
        legalCases.get(0).setLegalCaseMessage(legalCaseMessage);
        legalCases.get(1).setLegalCaseMessage(legalCaseMessage2);

        List<LegalCase> result = legalCaseRepository.findAll();

        Assertions.assertEquals(legalCaseMessage.toString(), result.get(0).getLegalCaseMessage().toString());
        Assertions.assertEquals(legalCaseMessage2.toString(), result.get(1).getLegalCaseMessage().toString());
    }

    @Test
    @DirtiesContext
    public void should_fail_when_procuratorate_is_null() {
        LegalCase legalCase = new LegalCase("test", 100L);
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                legalCaseRepository.saveAndFlush(legalCase);
            }
        });

    }
}