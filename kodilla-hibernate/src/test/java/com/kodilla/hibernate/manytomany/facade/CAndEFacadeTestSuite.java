package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CAndEFacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CAndEFacade cAndEFacade;

    @Test
    public void testFindCompany(){
        //Given
        Company company = new Company("Test");
        companyDao.save(company);
        int id = company.getId();
        //When
        Company output = cAndEFacade.findCompany("Test");
        //Then
        assertEquals(company.getName(), output.getName());
        //Cleanup
        companyDao.deleteById(id);
    }

    @Test
    public void testFindEmployee(){
        //Given
        Employee employee = new Employee("Test", "Smith");
        employeeDao.save(employee);
        int id = employee.getId();
        //When
        Employee output = cAndEFacade.findEmployee("Test");
        //Then
        assertEquals(employee.getFirstname(), output.getFirstname());
        //Cleanup
        employeeDao.deleteById(id);
    }
}