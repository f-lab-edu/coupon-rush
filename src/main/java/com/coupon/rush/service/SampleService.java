package com.coupon.rush.service;

import com.coupon.rush.dto.response.SampleDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SampleService {

    public String getStringData() {
        return "Hello, World!";
    }

    public SampleDto getDtoData() {
        return SampleDto.builder()
                .id(1)
                .name("Sample DTO")
                .build();
    }

    public List<SampleDto> getListData() {
        return Arrays.asList(
                SampleDto.builder().id(1).name("DTO 1").build(),
                SampleDto.builder().id(2).name("DTO 2").build()
        );
    }

    public Set<String> getSetData() {
        return new HashSet<>(Arrays.asList("Value1", "Value2", "Value3"));
    }

    public Map<String, SampleDto> getMapData() {
        Map<String, SampleDto> map = new HashMap<>();
        map.put("first", SampleDto.builder().id(1).name("First DTO").build());
        map.put("second", SampleDto.builder().id(2).name("Second DTO").build());
        return map;
    }

}
