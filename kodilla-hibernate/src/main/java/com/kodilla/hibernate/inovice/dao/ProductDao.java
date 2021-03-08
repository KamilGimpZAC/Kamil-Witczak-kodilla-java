package com.kodilla.hibernate.inovice.dao;

import com.kodilla.hibernate.inovice.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface ProductDao extends CrudRepository<Product, Integer>{
}
