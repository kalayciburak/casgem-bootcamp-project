package com.torukobyte.bootcampproject.repository.abstracts.blacklists;

import com.torukobyte.bootcampproject.entities.blacklists.Blacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlacklistRepository extends JpaRepository<Blacklist,Integer> {
}
