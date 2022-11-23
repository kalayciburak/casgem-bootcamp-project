package com.torukobyte.bootcampproject.api.controllers;

import com.torukobyte.bootcampproject.business.abstracts.InstructorService;
import com.torukobyte.bootcampproject.business.dto.requests.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.instructors.UpdateInstructorResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/instructors")
public class InstructorsController {
    private InstructorService service;

    @GetMapping
    List<GetAllInstructorResponse> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    CreateInstructorResponse add(@RequestBody CreateInstructorRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    GetInstructorResponse getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    UpdateInstructorResponse update(@RequestBody UpdateInstructorRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void delete(@PathVariable int id) {
        service.delete(id);
    }
}
