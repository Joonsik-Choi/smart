package com.gwnu.smart.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Medicine1Repository extends CrudRepository<Medicine1, Long> {
    List<Medicine1> findAll();
    Medicine1 save(Medicine1 medicine);
    List<Medicine1> findAllByDrugShapeAndColorClass1AndLineFront(String dugShape, String colorClass1, String lineFront);
}
