package com.torukobyte.bootcampproject.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBootcampRequest {
    private int instructorId;
    private String name;
    private int state;
    private LocalDate startDate;
    private LocalDate endDate;
}