package com.torukobyte.bootcampproject.entities.users;

import com.torukobyte.bootcampproject.entities.applications.Application;
import com.torukobyte.bootcampproject.entities.blacklists.Blacklist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applicants")
public class Applicant extends User {
    @Column(name = "about")
    private String about;
    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;
    @OneToMany(mappedBy = "applicant", cascade = CascadeType.MERGE)
    private List<Blacklist> blacklists;
}
