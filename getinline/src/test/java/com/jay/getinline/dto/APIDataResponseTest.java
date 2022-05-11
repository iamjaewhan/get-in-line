package com.jay.getinline.dto;

import com.jay.getinline.constant.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class APIDataResponseTest {

    @DisplayName("문자열 데이터 주어지면, 표준 성공 응답 생성")
    @Test
    void givenStringData_whenCreatingResponse_thenReturnsSuccessfulResponse() {
        //given
        String data = "test data";

        //when
        APIDataResponse response = APIDataResponse.of(data);

        //then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", data);
    }

    @DisplayName("데이터가 없을때, 비어있는 표준 성공 응답 생성")
    @Test
    void givenNothing_whenCreatingResponse_thenReturnsSuccessfulEmptyResponse() {
        //given

        //when
        APIDataResponse response = APIDataResponse.empty();

        //then
        assertThat(response)
                .hasFieldOrPropertyWithValue("success", true)
                .hasFieldOrPropertyWithValue("errorCode", ErrorCode.OK.getCode())
                .hasFieldOrPropertyWithValue("message", ErrorCode.OK.getMessage())
                .hasFieldOrPropertyWithValue("data", null);
    }
}