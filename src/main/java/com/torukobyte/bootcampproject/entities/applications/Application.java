package com.torukobyte.bootcampproject.entities.applications;

import com.torukobyte.bootcampproject.entities.bootcamps.Bootcamp;
import com.torukobyte.bootcampproject.entities.users.Applicant;
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
@Table(name = "applications")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "state")
    private int state;
    @ManyToOne()
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
    @ManyToOne()
    @JoinColumn(name = "bootcamp_id")
    private Bootcamp bootcamp;
}
