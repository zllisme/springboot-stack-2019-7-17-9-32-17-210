package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procuratorate;
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
public class ProcuratorateRepositoryTest {

    @Autowired
    ProcuratorateRepository procuratorateRepository;

    @Test
    @DirtiesContext
    public void should_fail_when_add_same_name_procuratorate() {
        Procuratorate procuratorate = new Procuratorate("test");
        procuratorateRepository.saveAndFlush(procuratorate);
        Procuratorate procuratorate1 = new Procuratorate("test");
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                procuratorateRepository.saveAndFlush(procuratorate1);
            }
        });


    }
}