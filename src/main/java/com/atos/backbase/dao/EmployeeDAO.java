/**
 * 
 */
package com.atos.backbase.dao;

import java.util.List;

import com.atos.backbase.model.PersonData;

/**
 * @author a133995
 *
 */
public interface EmployeeDAO {
	
	public PersonData getEmployeeData();

	public boolean validateUser(PersonData personData);
	
	public String insertEmployeeData(PersonData personData);

	public List<PersonData> getAllEmployeeDetails();

	public String deleteSelectedEmployeeData(String strEmpId);

	public String updateEmployeeData(PersonData personData);

	public String insertNewEmployeeData(PersonData personData);

	public List<PersonData> getNewAllEmployeeDetails();

	public String deleteNewSelectedEmployeeData(String strEmpId);

	public String updateNewEmployeeData(PersonData personData);
	
	

}
