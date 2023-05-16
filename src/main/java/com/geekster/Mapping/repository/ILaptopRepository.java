package com.geekster.Mapping.repository;

import com.geekster.Mapping.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILaptopRepository extends JpaRepository<Laptop,Integer> {
}
