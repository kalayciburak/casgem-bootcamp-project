package com.torukobyte.bootcampproject.api.controllers.blacklists;

import com.torukobyte.bootcampproject.business.abstracts.blacklists.BlacklistService;
import com.torukobyte.bootcampproject.business.constants.Paths;
import com.torukobyte.bootcampproject.business.dto.requests.create.blacklist.CreateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.blacklist.UpdateBlacklistRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.blacklist.CreateBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.blacklists.GetAllBlacklistsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.blacklists.GetBlacklistResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.blacklist.UpdateBlacklistResponse;
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
@RequestMapping(Paths.apiV1 + "blacklists")
public class BlacklistsController {
    private BlacklistService service;

    @GetMapping
    DataResult<List<GetAllBlacklistsResponse>> getAll() {
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
    DataResult<UpdateBlacklistResponse> update(
            @Valid @RequestBody UpdateBlacklistRequest request,
            @PathVariable int id) {
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    Result delete(@PathVariable int id) {
        return service.delete(id);
    }
}
