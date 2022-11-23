package com.torukobyte.bootcampproject.business.concretes;

import com.torukobyte.bootcampproject.business.abstracts.ApplicantService;
import com.torukobyte.bootcampproject.business.dto.requests.applicants.CreateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.requests.applicants.UpdateApplicantRequest;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.CreateApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetAllApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.GetApplicantResponse;
import com.torukobyte.bootcampproject.business.dto.responses.applicants.UpdateApplicantResponse;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.entities.users.Applicant;
import com.torukobyte.bootcampproject.repository.abstracts.ApplicantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ApplicantManager implements ApplicantService {
    private ApplicantRepository repository;
    private ModelMapperService mapper;

    @Override
    public List<GetAllApplicantResponse> getAll() {
        List<Applicant> appliicants = repository.findAll();
        List<GetAllApplicantResponse> response = appliicants
                .stream()
                .map(
                        applicant -> mapper.forResponse().map(applicant, GetAllApplicantResponse.class))
                .toList();

        return response;
    }

    @Override
    public GetApplicantResponse getById(int id) {
        Applicant appliicant = repository.findById(id).orElse(null);
        GetApplicantResponse response = mapper.forResponse().map(appliicant, GetApplicantResponse.class);

        return response;
    }

    @Override
    public CreateApplicantResponse add(CreateApplicantRequest request) {
        Applicant appliicant = mapper.forRequest().map(request, Applicant.class);
        appliicant.setId(0);
        repository.save(appliicant);
        CreateApplicantResponse response = mapper.forResponse().map(appliicant, CreateApplicantResponse.class);

        return response;
    }

    @Override
    public UpdateApplicantResponse update(UpdateApplicantRequest request, int id) {
        Applicant applicant = mapper.forRequest().map(request, Applicant.class);
        applicant.setId(id);
        repository.save(applicant);
        UpdateApplicantResponse response = mapper.forResponse().map(applicant, UpdateApplicantResponse.class);

        return response;
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
