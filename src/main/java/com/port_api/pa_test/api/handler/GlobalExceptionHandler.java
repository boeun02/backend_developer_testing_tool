package com.port_api.pa_test.api.handler;

import com.port_api.pa_test.api.dto.ErrorResponseDto;
import com.port_api.pa_test.api.exception.InvalidRequestException;
import com.port_api.pa_test.api.exception.ResourceNotFoundException;
import com.port_api.pa_test.api.exception.UnauthorizedAccessException;
import com.port_api.pa_test.api.exception.AccessDeniedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    // InvalidRequestException을 처리
    @ExceptionHandler(InvalidRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequest(InvalidRequestException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                status.getReasonPhrase(),
                "Invalid Request",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    // ResourceNotFoundException을 처리
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFound(ResourceNotFoundException ex) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                status.getReasonPhrase(),
                "Resource Not Found",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    // UnauthorizedAccessException을 처리
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ResponseEntity<ErrorResponseDto> handleUnauthorized(UnauthorizedAccessException ex) {
        HttpStatus status = HttpStatus.UNAUTHORIZED;
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                status.getReasonPhrase(),
                "Unauthorized Access",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    // AccessDeniedException을 처리
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponseDto> handleForbidden(AccessDeniedException ex) {
        HttpStatus status = HttpStatus.FORBIDDEN;
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                status.getReasonPhrase(),
                "Access Denied",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }

    // 모든 기타 예외를 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleInternalServerError(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        ErrorResponseDto errorResponse = new ErrorResponseDto(
                status.value(),
                status.getReasonPhrase(),
                "Internal Server Error",
                ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, status);
    }
}
