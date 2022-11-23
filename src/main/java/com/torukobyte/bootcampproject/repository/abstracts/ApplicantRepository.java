package com.torukobyte.bootcampproject.repository.abstracts;

import com.torukobyte.bootcampproject.entities.users.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantRepository extends JpaRepository<Applicant, Integer> {
}
