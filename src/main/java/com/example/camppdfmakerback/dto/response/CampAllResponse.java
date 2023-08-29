package com.example.camppdfmakerback.dto.response;

import com.example.camppdfmakerback.domain.Camp;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CampAllResponse {
    private Long campId;
    private String campName;
    private String campImg;
    private String campSeason;
    private String campProf;
    private String startDate;
    private String endDate;

    public CampAllResponse(Camp camp) {
        campId = camp.getCamp_id();
        campName = camp.getCampName();
        campImg = camp.getCampImg();
        campProf = camp.getCampProf();
        campSeason = camp.getCampSeason();
        startDate = camp.getStartDate();
        endDate = camp.getEndDate();
    }
    public static List<CampAllResponse> createFromCampList(List<Camp> camps) {
        List<CampAllResponse> campResponses = new ArrayList<>();
        for (Camp camp : camps) {
            campResponses.add(new CampAllResponse(camp));
        }
        return campResponses;
    }
}


