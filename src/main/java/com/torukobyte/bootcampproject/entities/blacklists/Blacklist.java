package com.torukobyte.bootcampproject.entities.blacklists;

import com.torukobyte.bootcampproject.entities.users.Applicant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "blacklists")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private LocalDate date = LocalDate.now();
    @Column(name = "reason")
    private String reason;
    @ManyToOne()
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
