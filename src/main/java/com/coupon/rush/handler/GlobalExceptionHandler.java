package com.coupon.rush.handler;

import com.coupon.rush.dto.response.ErrorResponse;
import com.coupon.rush.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 인증 실패 -> 401
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<ErrorResponse> handleAuthenticationException(AuthenticationException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.UNAUTHORIZED, ErrorMessage.UNAUTHORIZED.getMessage(), ex, request);
    }

    // 권한 없음 -> 403
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(AccessDeniedException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.FORBIDDEN, ErrorMessage.FORBIDDEN.getMessage(), ex, request);
    }

    // 리소스 없음 -> 404
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND_RESOURCE.getMessage(), ex, request);
    }

    // 파일 없음 -> 404
    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(FileNotFoundException ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND_FILE.getMessage(), ex, request);
    }

    // 그 외 모든 예외 -> 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, HttpServletRequest request) {
        return buildErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ErrorMessage.INTERNAL_SERVER_ERROR.getMessage(), ex, request);
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(HttpStatus status, String error, Exception ex, HttpServletRequest request) {
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(status.value())
                .error(error)
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, status);
    }

}
