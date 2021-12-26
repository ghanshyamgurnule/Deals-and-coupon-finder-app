package com.adminservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservice.custom.exception.AdminNotFound;
import com.adminservice.model.Admin;
import com.adminservice.repository.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	public int saveAdmin(Admin admin)
	{
		int id = adminRepository.save(admin).getId();
		return id ;
	}
	
	public List<Admin> getAllAdmin()
	{
		List<Admin> list = adminRepository.findAll();
		return list;
	}
	
	public Admin getAdminById(int id)
	{
		Optional<Admin> opt=  adminRepository.findById(id);
		Admin admin=opt.orElseThrow(()-> new AdminNotFound("Admin Not Found"));
		
		return admin;
	}
	
		
	public void deleteAdmin(int id)
	{
		Admin admin = getAdminById(id);
		adminRepository.delete(admin);
	}

}
