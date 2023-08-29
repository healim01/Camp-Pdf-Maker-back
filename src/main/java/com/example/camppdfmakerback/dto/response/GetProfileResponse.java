package com.example.camppdfmakerback.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GetProfileResponse {

    private MemberDto member;
    private List<TakesDto> takes;

    @Data
    @AllArgsConstructor
    public static class MemberDto {

        private String sid;
        private String name;
        private String email;
        private String dept;
    }

    @Data
    @AllArgsConstructor
    public static class TakesDto {
        private String campName;
        private String campSeason;
        private String campProf;
    }
}
