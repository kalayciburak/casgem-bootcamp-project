package com.torukobyte.bootcampproject.business.dto.requests.blacklists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateBlacklistRequest {
    private int applicantId;
    private LocalDate date;
    private String reason;
}

