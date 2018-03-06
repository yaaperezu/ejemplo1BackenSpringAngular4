package com.youtube.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.youtube.demo.dao.PermisoRepository;
import com.youtube.demo.model.PermisoEntity;

@Service
public class PermisoServiceImpl implements PermisoService {
	
	@Autowired
	protected PermisoRepository permisoRepository;

	@Override
	public List<PermisoEntity> findAll() {
		return permisoRepository.findAll();
	}

	@Override
	public List<PermisoEntity> listarPorPaginas(Pageable pageable) {
		return permisoRepository.findAll(pageable).getContent();
	}
}
