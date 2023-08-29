package com.example.camppdfmakerback.dto.request;

//import com.example.camppdfmakerback.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class CampRequest {
    private String campName;
    private String campImg;
    private String campSeason;
    private String campProf;
    private String startDate;
    private String endDate;
//    private List<StudentRequest> studentList;
}
