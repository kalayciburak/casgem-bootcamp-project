package com.torukobyte.bootcampproject.api.controllers.users;

import com.torukobyte.bootcampproject.business.abstracts.users.ApplicantService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.create.users.applicant.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.applicant.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.applicant.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants.GetAllApplicantsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.applicant.UpdateApplicantResponse;
import com.torukobyte.bootcampproject.core.utils.results.DataResult;
import com.torukobyte.bootcampproject.core.utils.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(Paths.apiV1 + "applicants")
public class ApplicantsController {
    private ApplicantService service;

    @GetMapping
    DataResult<List<GetAllApplicantsResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @Valid
    @ResponseStatus(HttpStatus.CREATED)
    DataResult<CreateApplicantResponse> add(@Valid @RequestBody CreateApplicantRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetApplicantResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateApplicantResponse> update(
            @Valid @RequestBody UpdateApplicantRequest request,
            @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }

    @PostMapping("/be-an-applicant/{id}")
    DataResult<GetApplicantResponse> beAnApplicant(@RequestParam String about, @PathVariable int id) {
        return service.beAnApplicant(about, id);
    }

    @DeleteMapping("/remove-an-applicant/{id}")
    Result removeAnApplicant(@PathVariable int id) {
        return service.removeAnApplicant(id);
    }

    @PutMapping("/change-password/{id}")
    Result changePassword(@RequestBody ChangeUserPasswordRequest request, @PathVariable int id) {
        return service.changePassword(request, id);
    }
}
