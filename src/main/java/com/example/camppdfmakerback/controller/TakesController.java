package com.example.camppdfmakerback.controller;

import com.example.camppdfmakerback.dto.request.TakesRequest;
import com.example.camppdfmakerback.service.TakesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class TakesController {

    private final TakesService takesService;

    @PostMapping("/takes")
    public void takes(@RequestBody TakesRequest request) {takesService.create(request);}
}
