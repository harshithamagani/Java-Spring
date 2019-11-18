package com.coding.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coding.dojo.models.License;
import com.coding.dojo.models.Person;
import com.coding.dojo.repositories.DriverRepository;
import com.coding.dojo.repositories.LicenseRepository;

@Service
public class DLService {

	private final DriverRepository driverRepo;
	private final LicenseRepository licenseRepo;
	public int licenseNumber;
	
	public DLService(DriverRepository driverRepository, LicenseRepository licenseRepository){
		this.driverRepo=driverRepository;
		this.licenseRepo=licenseRepository;
	}
	
	public Person createPerson(Person person){
		return driverRepo.save(person);
	}
	
	public License createLicense(License license){
		return licenseRepo.save(license);
	}
	
	public Person findPerson(Long id) {
		Optional<Person> person = driverRepo.findById(id);
		if(person.isPresent()) {
			return  person.get();
		}
		else {
			return null;
		}
	}
	
	public String getLicenseNumber(){
		List<License> listLicense = licenseRepo.findTopByOrderByNumberDesc();
		if(listLicense.isEmpty()) {
			licenseNumber += 1;
			return strLicenseNumber(licenseNumber);
		}
		else {
			License license = listLicense.get(0);
			String number = license.getNumber();
			int num = Integer.parseInt(number);
			return strLicenseNumber(num + 1);
		}
	}
	
	public String strLicenseNumber(int number) {
		return String.format("%07d" , number);
	}
	
	public List<Person> getAllPersons(){
		return (List<Person>) driverRepo.findAll();
	}
	
	public List<License> getAllLicenses(){
		return (List<License>) licenseRepo.findAll();
	}
	
}