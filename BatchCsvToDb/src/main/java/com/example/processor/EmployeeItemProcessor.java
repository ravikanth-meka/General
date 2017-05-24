package com.example.processor;

import org.springframework.batch.item.ItemProcessor;

import com.example.model.Employee;

public class EmployeeItemProcessor implements ItemProcessor<Employee, Employee> {

	@Override
	public Employee process(Employee employee) throws Exception {
		
		return employee;
	}


}
