package com.geekster.Mapping.repository;

import com.geekster.Mapping.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepository extends JpaRepository<Course,Integer> {
}
