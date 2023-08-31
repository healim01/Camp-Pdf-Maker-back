package com.example.camppdfmakerback.service;

import com.example.camppdfmakerback.domain.Camp;
//import com.example.camppdfmakerback.domain.Student;
import com.example.camppdfmakerback.domain.Member;
import com.example.camppdfmakerback.domain.Takes;
import com.example.camppdfmakerback.dto.request.CampRequest;
//import com.example.camppdfmakerback.dto.request.StudentRequest;
import com.example.camppdfmakerback.dto.response.CampAllResponse;
import com.example.camppdfmakerback.dto.response.CampOneResponse;
import com.example.camppdfmakerback.repository.CampRepository;
//import com.example.camppdfmakerback.repository.StudentRepository;
import com.example.camppdfmakerback.repository.MemberRepository;
import com.example.camppdfmakerback.repository.TakesRepository;
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

    private final MemberRepository memberRepository;
    private final CampRepository campRepository;
    private final TakesRepository takesRepository;

    public Camp create(CampRequest campRequest){
        Camp camp = Camp.builder()
                .campName(campRequest.getCampName())
                .campProf(campRequest.getCampProf())
                .campSeason(campRequest.getCampSeason())
                .campImg(campRequest.getCampImg())
                .startDate(campRequest.getStartDate())
                .endDate(campRequest.getEndDate())
                .build();
        campRepository.save(camp);
//        List<StudentRequest> studentList = campRequest.getStudentList();
//        for (StudentRequest studentRequest : studentList) {
//            Student s = Student.builder()
//                    .camp(camp)
//                    .studentId(studentRequest.getStudentId())
//                    .studentName(studentRequest.getStudentName())
//                    .studentDept(studentRequest.getStudentDept())
//                    .build();
//            studentRepository.save(s);
//        }
        return camp;
    }


//    public List<CampAllResponse> findAll() {
//        List<Camp> camplist = campRepository.findAll();
//        return new CampAllResponse(camp);
//    }
    public List<CampAllResponse> findAll() {
        List<Camp> camplist = campRepository.findAll();
        List<CampAllResponse> campResponses = CampAllResponse.createFromCampList(camplist);
        return campResponses;
    }


    public CampOneResponse findOne(Long campId, String userId) {
        boolean isTakes = false;

        Camp camp = campRepository
                .findById(campId)
                .orElseThrow();

        Optional<Member> member = memberRepository.findById(userId);
        List<Takes> takesList = member.get().getTakesList();
        for(int i = 0 ; i < takesList.size(); ++i){
            if(takesList.get(i).getCamp().getCamp_id() == campId) isTakes = true;
        }


        return new CampOneResponse(camp, isTakes);
    }

}
