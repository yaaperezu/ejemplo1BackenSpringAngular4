package com.youtube.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.youtube.demo.model.PermisoEntity;

public interface PermisoRepository extends JpaRepository<PermisoEntity, Long> {
	public abstract Page<PermisoEntity> findAll(Pageable pageable);
}
