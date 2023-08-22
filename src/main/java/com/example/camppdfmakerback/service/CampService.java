package com.example.camppdfmakerback.service;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Student;
import com.example.camppdfmakerback.repository.CampRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CampService {
    private final CampRepository campRepository;

    public Camp create(Camp camp){
        campRepository.save(camp);
        return camp;
    }

    public List<Camp> findAll() {
        return campRepository.findAll();
    }



//    public List<Student>
}
