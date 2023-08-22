package com.example.camppdfmakerback.service;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Student;
import com.example.camppdfmakerback.dto.request.CampRequest;
import com.example.camppdfmakerback.dto.request.StudentRequest;
import com.example.camppdfmakerback.dto.response.CampResponse;
import com.example.camppdfmakerback.repository.CampRepository;
import com.example.camppdfmakerback.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
@Transactional
public class CampService {
    private final CampRepository campRepository;
    private final StudentRepository studentRepository;

    public Camp create(CampRequest campRequest){
        Camp camp = Camp.builder()
                .campName(campRequest.getCampName())
                .campProf(campRequest.getCampProf())
                .campSeason(campRequest.getCampSeason())
                .campImg(campRequest.getCampImg())
                .startDate(campRequest.getStartDate())
                .endDate(campRequest.getEndDate())
                .build();
        List<StudentRequest> studentList = campRequest.getStudentList();
        for (StudentRequest studentRequest : studentList) {
            Student s = Student.builder()
                    .camp(camp)
                    .studentId(studentRequest.getStudentId())
                    .studentName(studentRequest.getStudentName())
                    .studentDept(studentRequest.getStudentDept())
                    .build();
            studentRepository.save(s);
        }
        return camp;
    }

    public List<Camp> findAll() {
        return campRepository.findAll();
    }

    public CampResponse findOne(String id) {
        Camp camp = campRepository
                .findById(Long.parseLong(id))
                .orElseThrow();
        return new CampResponse(camp);
    }

//    public List<Student>
}
