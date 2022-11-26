package com.torukobyte.bootcampproject.api.controllers.bootcamps;

import com.torukobyte.bootcampproject.business.abstracts.bootcamps.BootcampService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.bootcamps.CreateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.requests.bootcamps.UpdateBootcampRequest;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.CreateBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.GetAllBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.GetBootcampResponse;
import com.torukobyte.bootcampproject.business.dto.responses.bootcamps.UpdateBootcampResponse;
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
@RequestMapping(Paths.api + "bootcamps")
public class BootcampsController {
    private BootcampService service;

    @GetMapping
    DataResult<List<GetAllBootcampResponse>> getAll() {
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