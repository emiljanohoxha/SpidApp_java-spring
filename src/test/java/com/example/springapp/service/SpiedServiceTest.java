package com.example.springapp.service;

import com.example.springapp.SpringbootDemoApplication;
import com.example.springapp.entities.Spid;
import com.example.springapp.entities.StatusEnum;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {SpringbootDemoApplication.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
//@ExtendWith(MockitoExtension.class)

class SpiedServiceTest {

    @Mock
    SpidService spidService;

    @BeforeAll
    public void setup() {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(StatusEnum.APPROVED);
        when(spidService.approveSpid(spid)).thenReturn(spid);
    }

    @Test
    public void testDatabaseRetrievalForSpids() {
        Spid spid = new Spid();
        spid.setId(1L);
        spid.setStatus(StatusEnum.APPROVED);
        assertEquals(spid, spidService.approveSpid(spid));
    }

}