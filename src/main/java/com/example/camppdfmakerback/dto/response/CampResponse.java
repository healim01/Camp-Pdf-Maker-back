package com.example.camppdfmakerback.dto.response;

import com.example.camppdfmakerback.domain.Camp;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class CampResponse {

    private String campName;
    private String campImg;
    private String campSeason;
    private String campProf;
    private String startDate;
    private String endDate;

    private List<StudentResponse> studentList;

    public CampResponse(Camp camp) {
        campName = camp.getCampName();
        campImg = camp.getCampImg();
        campProf = camp.getCampProf();
        campSeason = camp.getCampSeason();
        startDate = camp.getStartDate();
        endDate = camp.getEndDate();
        studentList = camp
                .getStudentList()
                .stream()
                .map(StudentResponse::new)
                .toList();
    }

}
