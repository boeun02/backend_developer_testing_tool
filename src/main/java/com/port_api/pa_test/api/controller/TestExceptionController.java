package com.port_api.pa_test.api.controller;

import com.port_api.pa_test.api.exception.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestExceptionController {

    // 404 Not Found 예제
    @GetMapping("/not-found")
    public void throwNotFoundException() {
        throw new ResourceNotFoundException("404 Not Found 에러입니다.");
    }

    // 400 Bad Request 예제
    @PostMapping("/bad-request")
    public void throwBadRequestException() {
        throw new InvalidRequestException("400 Bad Request: 요청 본문이 비어 있습니다.");
    }

    // 401 Unauthorized 예제
    @GetMapping("/unauthorized")
    public void throwUnauthorizedException() {
        throw new UnauthorizedAccessException("401 Unauthorized: 인증이 필요합니다.");
    }

    // 403 Forbidden 예제
    @GetMapping("/forbidden")
    public void throwForbiddenException() {
        throw new AccessDeniedException("403 Forbidden: 접근이 금지된 리소스입니다.");
    }

    // 500 Internal Server Error 예제
    @GetMapping("/internal-error")
    public void throwInternalServerErrorException() {
        throw new RuntimeException("500 Internal Server Error 발생!");
    }
}