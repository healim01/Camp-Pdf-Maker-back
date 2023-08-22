package com.example.camppdfmakerback.repository;

import com.example.camppdfmakerback.domain.Camp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampRepository extends JpaRepository<Camp, Long> {
//    public List<Camp> findAllWithStudent()
}
