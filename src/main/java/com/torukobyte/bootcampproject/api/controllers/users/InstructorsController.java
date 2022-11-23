package com.torukobyte.bootcampproject.api.controllers.users;

import com.torukobyte.bootcampproject.business.abstracts.users.InstructorService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.users.instructors.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetAllInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.users.instructors.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(Paths.api + "instructors")
public class InstructorsController {
    private InstructorService service;

    @GetMapping
    DataResult<List<GetAllInstructorResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateInstructorResponse> add(@RequestBody CreateInstructorRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetInstructorResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateInstructorResponse> update(@RequestBody UpdateInstructorRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}
