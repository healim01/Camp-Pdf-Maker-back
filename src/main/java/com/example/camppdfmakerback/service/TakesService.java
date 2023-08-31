package com.example.camppdfmakerback.service;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Member;
import com.example.camppdfmakerback.domain.Takes;
import com.example.camppdfmakerback.dto.request.TakesRequest;
import com.example.camppdfmakerback.repository.CampRepository;
import com.example.camppdfmakerback.repository.MemberRepository;
import com.example.camppdfmakerback.repository.TakesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class TakesService {
    private final MemberRepository memberRepository;
    private final CampRepository campRepository;
    private final TakesRepository takesRepository;


    public Takes create(TakesRequest takesRequest) {
        Camp camp = campRepository.findById(takesRequest.getCamp_id()).get();
        Member member = memberRepository.findById(takesRequest.getSid()).get();

        Takes takes = Takes.builder()
                .camp(camp)
                .member(member)
                .build();
        camp.getTakesList().add(takes);
        member.getTakesList().add(takes);
        takesRepository.save(takes);

        return takes;

    }
}
