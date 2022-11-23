package com.torukobyte.bootcampproject.entities.users;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicants")
public class Applicant extends User {
    @Column(name = "about")
    private String about;
}
