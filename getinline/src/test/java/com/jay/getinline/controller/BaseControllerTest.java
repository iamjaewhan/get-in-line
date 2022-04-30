package com.jay.getinline.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@AutoConfigureMockMvc
@SpringBootTest
class BaseControllerTest {

@Autowired
    private MockMvc mvc;

    //테스트 직전에 수행되는 동작
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    //테스트 직후 수행되는 동작
    //테스트 네이밍 컨벤션 : test + 해당 메소드명 - but 메소드명은 스펙 : 메소드 명을 따르는 것은 지양
    //해당 테스트의 목적 판단 불가
    @Test
    void testRoot() throws Exception{
        //given


        //when & then
        mvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML))
                .andExpect(content().string(containsString("this is default page")))
                .andExpect(view().name("index"))
                .andDo(print());

    }
}