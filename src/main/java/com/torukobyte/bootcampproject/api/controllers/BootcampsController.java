package com.torukobyte.bootcampproject.api.controllers;

import com.torukobyte.bootcampproject.business.abstracts.BootcampService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetAllBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.UpdateBootcampResponse;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping(Paths.api + "bootcamps")
public class BootcampsController {
    private BootcampService service;

    @GetMapping
    DataResult<List<GetAllBootcampResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateBootcampResponse> add(@RequestBody CreateBootcampRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetBootcampResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateBootcampResponse> update(@RequestBody UpdateBootcampRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}