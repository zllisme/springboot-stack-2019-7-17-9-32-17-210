package com.tw.apistackbase.repository;

import com.tw.apistackbase.entity.Procurator;
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
public class ProcuratorRepositoryTest {

    @Autowired
    ProcuratorRepository procuratorRepository;

    @Test
    @DirtiesContext
    public void should_fail_when_add_same_name_procuratorate() {
        Procurator procurator = new Procurator("test");
        procuratorRepository.saveAndFlush(procurator);
        Procurator procurator1 = new Procurator("test");
        assertThrows(Exception.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                procuratorRepository.saveAndFlush(procurator1);
            }
        });


    }

}