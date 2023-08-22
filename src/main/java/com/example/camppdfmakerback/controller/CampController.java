package com.example.camppdfmakerback.controller;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.dto.request.CampRequest;
import com.example.camppdfmakerback.service.CampService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CampController {
    private final CampService campService;

    @PostMapping("/camp")
    public Camp camp(@RequestBody CampRequest request){
        Camp camp = Camp.builder()
//                .campId(request.getCampId())
                .campName(request.getCampName())
                .campImg(request.getCampImg())
                .campSeason(request.getCampSeason())
                .campProf(request.getCampProf())
                .build();
        campService.create(camp);
        return camp;
    }

    @GetMapping("/camp")
    public List<Camp> campList() {
        return campService.findAll();
    }

}
