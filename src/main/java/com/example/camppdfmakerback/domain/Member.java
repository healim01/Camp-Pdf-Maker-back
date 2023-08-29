package com.example.camppdfmakerback.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Member {

    @Id
    @Column(name = "sid")
    private String sid;

    private String email;

    private String name;

    private String dept;

    @OneToMany(mappedBy = "member")
    private List<Takes> takesList;
}
