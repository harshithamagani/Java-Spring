package com.coding.dojo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.coding.dojo.models.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findTopByOrderByNumberDesc();
}
