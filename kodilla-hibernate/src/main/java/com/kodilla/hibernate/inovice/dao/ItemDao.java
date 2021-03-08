package com.kodilla.hibernate.inovice.dao;

import com.kodilla.hibernate.inovice.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Transactional
@Repository
public interface ItemDao extends CrudRepository<Item,Integer>{
}
