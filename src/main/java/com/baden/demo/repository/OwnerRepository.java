package com.baden.demo.repository;

import com.baden.demo.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OwnerRepository extends JpaRepository<Owner, Long> {

}
