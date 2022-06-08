package com.jay.getinline.constant;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ErrorCodeTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("예외를 받으면, 예외 메세지 포함된 메세지 출력")
    void givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage(ErrorCode errorCode, String expected) {
        //Given
        Exception e = new Exception("This is test message");

        //When
        String actual = errorCode.getMessage(e);
        //parameterized test
        
        //Then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> givenExceptionWithMessage_whenGettingMessage_thenReturnsMessage(){
        return Stream.of(
                arguments(ErrorCode.OK, "Ok - This is test message"),
                arguments(ErrorCode.BAD_REQUEST, "bad request - This is test message"),
                arguments(ErrorCode.SPRING_BAD_REQUEST, "Spring-detected bad request - This is test message"),
                arguments(ErrorCode.VALIDATION_ERROR, "Validation error - This is test message"),
                arguments(ErrorCode.INTERNAL_ERROR, "internal error - This is test message"),
                arguments(ErrorCode.SPRING_INTERNAL_ERROR, "Spring-detected internal error - This is test message")
        );
    }

}