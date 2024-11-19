package com.civa.retotecnico.repository;

import com.civa.retotecnico.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface BusRepository extends JpaRepository<Bus, UUID> {


    Page<Bus> findByStatusTrue(Pageable page);
}
