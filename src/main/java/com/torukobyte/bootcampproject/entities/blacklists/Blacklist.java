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
    // TODO: sadece adaylar dahil edilebilir ve bu listede olan adaylar başvuruda bulunamaz
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "reason")
    private String reason;
    @ManyToOne()
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;
}
