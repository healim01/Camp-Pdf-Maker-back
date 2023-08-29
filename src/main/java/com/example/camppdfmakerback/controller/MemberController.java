package com.example.camppdfmakerback.controller;

import com.example.camppdfmakerback.domain.Member;
import com.example.camppdfmakerback.domain.Takes;
import com.example.camppdfmakerback.dto.request.CreateMemberRequest;
import com.example.camppdfmakerback.dto.response.CreateMemberResponse;
import com.example.camppdfmakerback.dto.response.GetProfileResponse;
import com.example.camppdfmakerback.repository.MemberRepository;
import com.example.camppdfmakerback.repository.TakesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class MemberController {

    private final MemberRepository memberRepository;
    private final TakesRepository takesRepository;

    @PostMapping("/api/user")
    public CreateMemberResponse saveMemberFirst(@RequestBody CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setSid(request.getSid());
        member.setEmail(request.getEmail());
        member.setDept(request.getDept());

        Member save = memberRepository.save(member);


        return new CreateMemberResponse(save.getSid());
    }

    @GetMapping("/api/user/{userId}")
    public GetProfileResponse getProfile(@PathVariable("userId") String userId ){
        Optional<Member> member = memberRepository.findById(userId);
        Long userIdLong = Long.parseLong(userId);
        List<Takes> takes = takesRepository.findAllById(Collections.singleton(userIdLong));
        List<GetProfileResponse.TakesDto> collect = takes.stream().map(o ->
                new GetProfileResponse.TakesDto(o.getCamp().getCampName(),
                        o.getCamp().getCampSeason(),
                        o.getCamp().getCampProf())).collect(Collectors.toList());


        return new GetProfileResponse(new GetProfileResponse.MemberDto(member.get().getSid(),member.get().getName(),member.get().getEmail(),member.get().getDept()) ,collect);
    }

}
