package com.podergital.pdp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.podergital.pdp.model.TemaModel;

@Repository
public interface TemaRepository extends JpaRepository<TemaModel, Long>{
	public List<TemaModel> findAllByTemaContainingIgnoreCase(@Param("tema") String tema);

}
