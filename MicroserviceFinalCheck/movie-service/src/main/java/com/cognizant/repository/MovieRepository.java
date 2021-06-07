package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Movie;
@Repository
public interface MovieRepository extends  JpaRepository<Movie,Integer>{
@Query(value="select * from movielist where id= :id",nativeQuery = true)
	public Movie findById(@Param("id") Long id);

}
