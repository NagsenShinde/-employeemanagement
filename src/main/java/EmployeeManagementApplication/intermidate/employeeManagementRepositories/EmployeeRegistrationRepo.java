package EmployeeManagementApplication.intermidate.employeeManagementRepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeManagementApplication.intermidate.entityClasses.EmployeeRegistrationEntity;

public interface EmployeeRegistrationRepo extends JpaRepository<EmployeeRegistrationEntity, String>{

	List<EmployeeRegistrationEntity> findAll();


}
