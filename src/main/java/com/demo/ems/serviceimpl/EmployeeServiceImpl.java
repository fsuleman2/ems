package com.demo.ems.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.ems.dto.EmployeeDTO;
import com.demo.ems.model.Employee;
import com.demo.ems.repository.EmployeeRepository;
import com.demo.ems.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	EmployeeDTO employeeDTO;
	@Autowired
	Employee employeeEntity;
	@Autowired
	RestTemplate restTemplate;
	
	@Override
	public EmployeeDTO getEmplpyeeDetailById(Long Id) {
		employeeEntity = restTemplate.getForObject("http://localhost:9091/ems/id/"+Id, Employee.class);
		if (employeeEntity!=null) {
			employeeDTO = EmployeeDTO.toDTO(employeeEntity);
		}
		return employeeDTO;
	}

	@Override
	public EmployeeDTO addEmployeeDetails(Employee employee) {
	employeeEntity = restTemplate.postForObject("http://localhost:9091/ems/",employee,Employee.class);
	employeeDTO = EmployeeDTO.toDTO(employeeEntity);
		return employeeDTO;
	}

	@Override
	public EmployeeDTO updateEmployeeDetailsById(Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(employee.getEmpId());
		if (emp.isPresent()) {
			employeeEntity = emp.get();
			employeeEntity = employeeRepository.save(employee);
			employeeDTO = EmployeeDTO.toDTO(employeeEntity);
		}
		return employeeDTO;
	}

	@Override
	public EmployeeDTO updateEmplpyeeSalaryById(Long id, Long salary) {
		Optional<Employee> empOptional = employeeRepository.findById(id);
		if (empOptional.isPresent()) {
			employeeEntity = empOptional.get();
			employeeEntity.setEmpSalary(salary);
			Employee empUpdatedEntity = employeeRepository.save(employeeEntity);
			employeeDTO = EmployeeDTO.toDTO(empUpdatedEntity);
		}
		return employeeDTO;
	}

	@Override
	public String deleteEmployeeByID(Long empId) {
		employeeRepository.deleteById(empId);
		return "Employee Details Deleted Successfully";
	}

	@Override
	public List<EmployeeDTO> getAllEmployeeDetails() {
		List<EmployeeDTO> empDTOList = null;
		List<Employee> empList = employeeRepository.findAll();
		empDTOList = employeeDTO.toDTOList(empList);
		return empDTOList;
	}

}
