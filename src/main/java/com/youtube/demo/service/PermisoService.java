package com.youtube.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.youtube.demo.model.PermisoEntity;

public interface PermisoService {
	List<PermisoEntity> findAll();
	List<PermisoEntity> listarPorPaginas(Pageable pageable);
}
