package com.torukobyte.bootcampproject.api.controllers.users;

import com.torukobyte.bootcampproject.business.abstracts.users.InstructorService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.create.users.instructor.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.instructor.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.instructor.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetAllInstructorsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.instructor.UpdateInstructorResponse;
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
@RequestMapping(Paths.apiV1 + "instructors")
public class InstructorsController {
    private InstructorService service;

    @GetMapping
    DataResult<List<GetAllInstructorsResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateInstructorResponse> add(@Valid @RequestBody CreateInstructorRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetInstructorResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateInstructorResponse> update(
            @Valid @RequestBody UpdateInstructorRequest request,
            @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }

    @PutMapping("/change-password/{id}")
    Result changePassword(@RequestBody ChangeUserPasswordRequest request, @PathVariable int id) {
        return service.changePassword(request, id);
    }
}
