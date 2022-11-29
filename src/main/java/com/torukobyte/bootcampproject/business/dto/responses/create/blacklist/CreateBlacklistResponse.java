package com.torukobyte.bootcampproject.business.dto.responses.create.blacklist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistResponse {
    private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
}

