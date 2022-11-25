package com.torukobyte.bootcampproject.api.controllers.blacklists;

import com.torukobyte.bootcampproject.business.abstracts.blacklists.BlacklistService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.blacklists.CreateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.requests.blacklists.UpdateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.CreateBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetAllBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.GetBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.blacklists.UpdateBlacklistResponse;
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
@RequestMapping(Paths.api + "blacklists")
public class BlacklistsController {
    private BlacklistService service;

    @GetMapping
    DataResult<List<GetAllBlacklistResponse>> getAll() {
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    DataResult<CreateBlacklistResponse> add(@Valid @RequestBody CreateBlacklistRequest request) {
        return service.add(request);
    }

    @GetMapping("/{id}")
    DataResult<GetBlacklistResponse> getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    DataResult<UpdateBlacklistResponse> update(@RequestBody UpdateBlacklistRequest request, @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}
