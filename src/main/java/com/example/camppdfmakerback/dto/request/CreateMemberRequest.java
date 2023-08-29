package com.example.camppdfmakerback.dto.request;

import lombok.Data;

@Data
public class CreateMemberRequest {
    private String sid;
    private String name;
    private String email;

    private String Dept;

}