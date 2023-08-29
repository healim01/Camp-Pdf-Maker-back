package com.example.camppdfmakerback.dto.response;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Takes;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class CampOneResponse {
    private Long campId;
    private String campName;
    private String campImg;
    private String campSeason;
    private String campProf;
    private String startDate;
    private String endDate;

    private boolean isTaked;

    private List<TakesResponse> takesList;

    public CampOneResponse(Camp camp, boolean isTakes) {
        campId = camp.getCamp_id();
        campName = camp.getCampName();
        campImg = camp.getCampImg();
        campProf = camp.getCampProf();
        campSeason = camp.getCampSeason();
        startDate = camp.getStartDate();
        endDate = camp.getEndDate();
        this.isTaked = isTakes;
        takesList = camp
                .getTakesList()
                .stream()
                .map(TakesResponse::new)
                .toList();
    }


}
