package com.example.camppdfmakerback.dto.response;

import com.example.camppdfmakerback.domain.Takes;
import lombok.Data;

@Data
public class TakesResponse {

    private String studentId;
    private String studentName;

    public TakesResponse(Takes takes) {
        studentId =takes.getMember().getSid();
        studentName = takes.getMember().getName();
    }
}
