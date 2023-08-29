package com.example.camppdfmakerback.controller;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.dto.request.CampRequest;
import com.example.camppdfmakerback.dto.response.CampAllResponse;
import com.example.camppdfmakerback.dto.response.CampOneResponse;
import com.example.camppdfmakerback.service.CampService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class CampController {
    private final CampService campService;

    @PostMapping("/camp")
    public void camp(@RequestBody CampRequest request) {
        campService.create(request);
    }

    @GetMapping("/camp")
    public ResponseEntity<List<CampAllResponse>> getAllCampList() {
        return ResponseEntity.ok(campService.findAll());
    }

    @GetMapping("/camp/{id}/{userId}")
    public CampOneResponse getOneCampInfo(@PathVariable("id") Long campId , @PathVariable("userId")String userId) {
        return campService.findOne(campId, userId);
    }
}
