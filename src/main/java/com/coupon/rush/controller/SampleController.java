package com.coupon.rush.controller;

import com.coupon.rush.dto.response.ApiResponse;
import com.coupon.rush.dto.response.SampleDto;
import com.coupon.rush.exception.AccessDeniedException;
import com.coupon.rush.exception.AuthenticationException;
import com.coupon.rush.exception.FileNotFoundException;
import com.coupon.rush.exception.ResourceNotFoundException;
import com.coupon.rush.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class SampleController {

    private final SampleService sampleService;

    // TEST CASE 1: 리소스가 없을 때 (404)
    @GetMapping("/test/resource")
    public ResponseEntity<ApiResponse<?>> testResourceNotFound() {
        throw new ResourceNotFoundException("리소스가 존재하지 않습니다.");
    }

    // TEST CASE 2: 파일이 없을 때 (404)
    @GetMapping("/test/file")
    public ResponseEntity<ApiResponse<?>> testFileNotFound() throws FileNotFoundException {
        throw new FileNotFoundException("파일이 존재하지 않습니다.");
    }

    // TEST CASE 3: 인증 실패 (401)
    @GetMapping("/test/authentication")
    public ResponseEntity<ApiResponse<?>> testAuthentication() {
        throw new AuthenticationException("인증에 실패했습니다.");
    }

    // TEST CASE 4: 권한 없음 (403)
    @GetMapping("/test/authorization")
    public ResponseEntity<ApiResponse<?>> testAuthorization() {
        throw new AccessDeniedException("권한이 존재하지 않습니다.");
    }

    // TEST CASE 5: String 리턴 테스트
    @GetMapping("/test/string")
    public ResponseEntity<ApiResponse<String>> testStringResponse() {
        String result = sampleService.getStringData();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.of(result));
    }

    // TEST CASE 6: DTO 리턴 테스트
    @GetMapping("/test/dto")
    public ResponseEntity<ApiResponse<SampleDto>> testDtoResponse() {
        SampleDto result = sampleService.getDtoData();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.of(result));
    }

    // TEST CASE 7: List 리턴 테스트
    @PostMapping("/test/list")
    public ResponseEntity<ApiResponse<List<SampleDto>>> testListResponse() {
        List<SampleDto> result = sampleService.getListData();
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.of(result));
    }

    // TEST CASE 8: Set 리턴 테스트
    @PutMapping("/test/set")
    public ResponseEntity<ApiResponse<Set<String>>> testSetResponse() {
        Set<String> result = sampleService.getSetData();
        return ResponseEntity.status(HttpStatus.OK)
                .body(ApiResponse.of(result));
    }

    // TEST CASE 9: Map 리턴 테스트
    @DeleteMapping("/test/map")
    public ResponseEntity<ApiResponse<Map<String, SampleDto>>> testMapResponse() {
        Map<String, SampleDto> result = sampleService.getMapData();
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(ApiResponse.of(result));
    }

}
