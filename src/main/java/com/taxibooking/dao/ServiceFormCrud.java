package com.taxibooking.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taxibooking.model.ServiceForm;

@Repository
public interface ServiceFormCrud extends JpaRepository<ServiceForm, Integer>{

	@Override
	public <S extends ServiceForm> S save(S entity);
	
		
	@Override
	public List<ServiceForm> findAll();
	
	@Override
	public void deleteById(Integer id);
	
}
