package com.torukobyte.bootcampproject.api.controllers.applications;

import com.torukobyte.bootcampproject.business.abstracts.applications.ApplicationService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.applications.CreateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applications.UpdateApplicationRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applications.CreateApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetAllApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.GetApplicationResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applications.UpdateApplicationResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(Paths.api + "applications")
public class ApplicationsController {
    private ApplicationService service;

    @GetMapping
    DataResult<List<GetAllApplicationResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateApplicationResponse> add(@Valid @RequestBody CreateApplicationRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetApplicationResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateApplicationResponse> update(@Valid @RequestBody UpdateApplicationRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}

