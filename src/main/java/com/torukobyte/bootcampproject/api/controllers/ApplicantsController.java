package com.torukobyte.bootcampproject.api.controllers;

import com.torukobyte.bootcampproject.business.abstracts.ApplicantService;
import com.torukobyte.bootcampproject.business.dto.requests.applicants.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applicants.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetAllApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.UpdateApplicantResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/applicants")
public class ApplicantsController {
    private ApplicantService service;

    @GetMapping
    List<GetAllApplicantResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CreateApplicantResponse add(@RequestBody CreateApplicantRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    GetApplicantResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    UpdateApplicantResponse update(@RequestBody UpdateApplicantRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }

    @PostMapping("/{id}/apply")
    @ResponseStatus(code = HttpStatus.CREATED)
    void apply(@RequestBody String about, @PathVariable int id) {
        service.becomeApplicant(about, id);
    }
}
