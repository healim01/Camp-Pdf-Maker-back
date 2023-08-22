package com.example.camppdfmakerback.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Camp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String campName;
    private String campImg;
    private String campSeason;
    private String campProf;

    private String startDate;
    private String endDate;

    @OneToMany(mappedBy = "camp")
    private List<Student> studentList;
}
