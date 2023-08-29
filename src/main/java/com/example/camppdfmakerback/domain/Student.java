//package com.example.camppdfmakerback.domain;
//
//import com.example.camppdfmakerback.dto.request.StudentRequest;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Entity
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//public class Student {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    private String studentId;
//    private String studentName;
//    private String studentDept;
//
//    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private Camp camp;
//
//    public Student toEntity(StudentRequest request) {
//        studentId = request.getStudentId();
//        studentName = request.getStudentName();
//        studentDept = request.getStudentDept();
//        return this;
//    }
//}
