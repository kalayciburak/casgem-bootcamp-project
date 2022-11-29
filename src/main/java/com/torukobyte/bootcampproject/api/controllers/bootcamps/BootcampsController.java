package com.torukobyte.bootcampproject.api.controllers.bootcamps;

import com.torukobyte.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.create.bootcamp.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.bootcamp.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.bootcamp.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetAllBootcampsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.bootcamps.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.bootcamp.UpdateBootcampResponse;
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
@RequestMapping(Paths.apiV1 + "bootcamps")
public class BootcampsController {
    private BootcampService service;

    @GetMapping
    DataResult<List<GetAllBootcampsResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateBootcampResponse> add(@Valid @RequestBody CreateBootcampRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetBootcampResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateBootcampResponse> update(@Valid @RequestBody UpdateBootcampRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}