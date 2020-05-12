package com.gwnu.smart.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MedicineRepository extends CrudRepository<Medicine, Long> {
    List<Medicine> findAll();
}
