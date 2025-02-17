package com.coupon.rush.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ApiResponse<T> {
    @Builder.Default
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp = LocalDateTime.now();

    @Builder.Default
    private String authenticatedUserName = "홍정완";

    // 요청 데이터 (예: DTO, String, List, Set, Map 등 다양한 타입 가능)
    private T data;

    public static <T> ApiResponse<T> of(T data) {
        return ApiResponse.<T>builder()
                .data(data)
                .build();
    }

}
