package com.github.rsoi.repository;

import com.github.rsoi.domain.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phone, Long> {

}
