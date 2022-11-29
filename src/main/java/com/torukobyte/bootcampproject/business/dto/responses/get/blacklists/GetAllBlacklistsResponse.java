package com.torukobyte.bootcampproject.business.dto.responses.get.blacklists;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetAllBlacklistsResponse {
    private int id;
    private int applicantId;
    private LocalDate date;
    private String reason;
    private String applicantFirstName;
    private String applicantLastName;
}
