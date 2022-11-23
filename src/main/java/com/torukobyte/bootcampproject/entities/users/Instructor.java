package com.torukobyte.bootcampproject.entities.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
public class Instructor extends User {
    @Column(name = "company_name")
    private String companyName;
}
