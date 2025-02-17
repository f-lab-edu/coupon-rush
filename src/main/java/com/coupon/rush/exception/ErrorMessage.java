package com.coupon.rush.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    UNAUTHORIZED("Unauthorized"),
    FORBIDDEN("Forbidden"),
    NOT_FOUND_RESOURCE("Not Found Resource"),
    NOT_FOUND_FILE("Not Found File"),
    INTERNAL_SERVER_ERROR("Internal Server Error");

    private final String message;

}
