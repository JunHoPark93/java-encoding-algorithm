package com.nexters.javaencodingalgorithm.controllers;

import com.nexters.javaencodingalgorithm.services.MainService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class MainControllerTest {

    @MockBean
    MainService mainService;

    @Test
    public void initMain() throws Exception {
    }
}