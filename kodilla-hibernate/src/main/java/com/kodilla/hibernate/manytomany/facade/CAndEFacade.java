package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import java.util.List;

@Service
public class CAndEFacade {
    private final CompanyDao companyDao;

    private final EmployeeDao employeeDao;

    public CAndEFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public Company findCompany(String name){
        return companyDao.retrieveCompanyByCompanyName(name);
    }

    public Employee findEmployee(String name){
        return employeeDao.retrieveEmployeeByEmployeeName(name);
    }

}
