package com.torukobyte.bootcampproject.entities.users;

import com.torukobyte.bootcampproject.entities.Bootcamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "instructors")
public class Instructor extends User {
    @Column(name = "company_name")
    private String companyName;
    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamp;
}
