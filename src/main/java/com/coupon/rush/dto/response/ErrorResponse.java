package com.coupon.rush.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ErrorResponse {
    // TODO: 명시적 초기화, 더 좋은 방법으로 수정 필요
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp = LocalDateTime.now();

    // TODO: 명시적 초기화, 인증/인가 적용 후 수정 필요
    @Builder.Default
    private String authenticatedUserName = "day";
    private int status;
    private String error;
    private String message;

}
