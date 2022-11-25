package com.torukobyte.bootcampproject.business.dto.responses.bootcamps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBootcampResponse {
    private int id;
    private int instructorId;
    private String name;
    private int state;
    private LocalDate startDate;
    private LocalDate endDate;
    private String instructorFirstName;
    private String instructorLastName;
}