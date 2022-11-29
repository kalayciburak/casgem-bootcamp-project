package com.torukobyte.bootcampproject.business.concretes.users;

import com.torukobyte.bootcampproject.business.abstracts.users.InstructorService;
import com.torukobyte.bootcampproject.business.constants.Messages;
import com.torukobyte.bootcampproject.business.constants.ValidationMessages;
import com.torukobyte.bootcampproject.business.dto.requests.create.users.instructor.CreateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.ChangeUserPasswordRequest;
import com.torukobyte.bootcampproject.business.dto.requests.update.users.instructor.UpdateInstructorRequest;
import com.torukobyte.bootcampproject.business.dto.responses.create.users.instructor.CreateInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetAllInstructorsResponse;
import com.torukobyte.bootcampproject.business.dto.responses.get.users.instructors.GetInstructorResponse;
import com.torukobyte.bootcampproject.business.dto.responses.update.users.instructor.UpdateInstructorResponse;
import com.torukobyte.bootcampproject.core.util.exceptions.BusinessException;
import com.torukobyte.bootcampproject.core.util.mapping.ModelMapperService;
import com.torukobyte.bootcampproject.core.util.results.DataResult;
import com.torukobyte.bootcampproject.core.util.results.Result;
import com.torukobyte.bootcampproject.core.util.results.SuccessDataResult;
import com.torukobyte.bootcampproject.core.util.results.SuccessResult;
import com.torukobyte.bootcampproject.entities.users.Instructor;
import com.torukobyte.bootcampproject.repository.abstracts.users.InstructorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.List;

@Service
@AllArgsConstructor
public class InstructorManager implements InstructorService {
    private InstructorRepository repository;
    private ModelMapperService mapper;

    @Override
    public DataResult<List<GetAllInstructorsResponse>> getAll() {
        List<Instructor> instructors = repository.findAll();
        List<GetAllInstructorsResponse> data = instructors
                .stream()
                .map(instructor -> mapper.forResponse().map(instructor, GetAllInstructorsResponse.class))
                .toList();

        return new SuccessDataResult<>(data, Messages.Instructor.ListAll);
    }

    @Override
    public DataResult<GetInstructorResponse> getById(int id) {
        checkIfInstructorExistById(id);
        Instructor instructor = repository.findById(id).orElseThrow();
        GetInstructorResponse data = mapper.forResponse().map(instructor, GetInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.ListById);
    }

    @Override
    public DataResult<CreateInstructorResponse> add(CreateInstructorRequest request) {
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfInstructorExistByNationalIdentity(request.getNationalIdentity());
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        repository.save(instructor);
        CreateInstructorResponse data = mapper.forResponse().map(instructor, CreateInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.Created);
    }

    @Override
    public DataResult<UpdateInstructorResponse> update(UpdateInstructorRequest request, int id) {
        checkIfInstructorExistById(id);
        comparePassword(request.getPassword(), request.getConfirmPassword());
        checkIfInstructorExistByNationalIdentity(request.getNationalIdentity());
        Instructor instructor = mapper.forRequest().map(request, Instructor.class);
        instructor.setId(id);
        repository.save(instructor);
        UpdateInstructorResponse data = mapper.forResponse().map(instructor, UpdateInstructorResponse.class);

        return new SuccessDataResult<>(data, Messages.Instructor.Updated);
    }

    @Override
    public Result delete(int id) {
        checkIfInstructorExistById(id);
        repository.deleteById(id);

        return new SuccessResult(Messages.Instructor.Deleted);
    }

    @Override
    public Result changePassword(ChangeUserPasswordRequest request, int id) {
        checkIfInstructorExistById(id);
        checkPasswordIsCorrect(request.getOldPassword(), id);
        checkPasswordIsNew(request.getOldPassword(), request.getNewPassword());
        comparePassword(request.getNewPassword(), request.getConfirmPassword());
        repository.changePassword(request.getNewPassword(), id);

        return new SuccessResult(Messages.User.PasswordChanged);
    }

    @Override
    public void checkIfInstructorExistById(int id) {
        if (!repository.existsById(id)) {
            throw new BusinessException(Messages.Instructor.InstructorNotExists);
        }
    }

    private void checkPasswordIsCorrect(String oldPassword, int id) {
        if (!repository.findById(id).get().getPassword().equals(oldPassword)) {
            throw new ValidationException(ValidationMessages.User.OldPasswordNotMatch);
        }
    }

    private void checkPasswordIsNew(String oldPassword, String newPassword) {
        if (oldPassword.equals(newPassword)) {
            throw new ValidationException(ValidationMessages.User.ThereIsNoChangeInPassword);
        }
    }

    private void checkIfInstructorExistByNationalIdentity(String nationalIdentity) {
        if (repository.existsInstructortByNationalIdentity(nationalIdentity)) {
            throw new BusinessException(Messages.Instructor.InstructorExists);
        }
    }

    private void comparePassword(String password, String confirmPassword) {
        if (!password.equals(confirmPassword)) {
            throw new ValidationException(ValidationMessages.User.ConfirmPasswordValid);
        }
    }
}
