package com.jay.getinline.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class BaseControllerTest {

    private final MockMvc mvc;

    public BaseControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] 기본 페이지 요청 테스트")
    @Test
    void givenNothing_whenRequestingRootPage_thenReturnIndexPage() throws Exception{
        //Given

        //When and Then
        mvc.perform(get("/"))
                .andExpect(status().isOk()) //status가 ok인지 확인
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //content type이 html인지 확인
                .andExpect(content().string(containsString("this is default page")))
                .andDo(print());
    }
}