package com.torukobyte.bootcampproject.repository.abstracts.users;

import com.torukobyte.bootcampproject.entities.users.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}
