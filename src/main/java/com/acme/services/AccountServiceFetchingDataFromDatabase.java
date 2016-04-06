package com.acme.services;

import java.util.List;
import com.google.gson.Gson;
import org.apache.camel.builder.RouteBuilder;

import com.atos.backbase.dao.EmployeeDAOImpl;
import com.atos.backbase.model.PersonData;

public class AccountServiceFetchingDataFromDatabase extends RouteBuilder {
    @Override
    public void configure() throws Exception {
 
    	List<PersonData> employeeDataList= EmployeeDAOImpl.getAllEmployeeDetails();
    	String employeesjsonData = null;
    	Gson gson = new Gson();
    	
    	employeesjsonData = gson.toJson(employeeDataList);
    	
    	from("restlet:/employeeData")
        .setBody().constant(employeesjsonData)
        .setHeader("Content-Type", constant("application/json"));
    	    	
    }

}
