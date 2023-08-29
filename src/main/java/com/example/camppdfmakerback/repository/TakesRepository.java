package com.example.camppdfmakerback.repository;

import com.example.camppdfmakerback.domain.Camp;
import com.example.camppdfmakerback.domain.Takes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TakesRepository extends JpaRepository<Takes, Long> {
}
