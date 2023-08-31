package com.example.camppdfmakerback.repository;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Takes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TakesRepository extends JpaRepository<Takes, Long> {
//    List<Takes> findAllBySid(String sid);
List<Takes> findByMemberSid(String sid);

}
