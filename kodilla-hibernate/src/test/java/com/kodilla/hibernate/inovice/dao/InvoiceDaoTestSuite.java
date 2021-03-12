package com.kodilla.hibernate.inovice.dao;

import com.kodilla.hibernate.inovice.Inovice;
import com.kodilla.hibernate.inovice.Item;
import com.kodilla.hibernate.inovice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private ItemDao itemDao;
    private ProductDao productDao;
    private InoviceDao inoviceDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
        Item item1 = new Item(new BigDecimal(250), 3, new BigDecimal(750));
        Item item2 = new Item(new BigDecimal(400), 5, new BigDecimal(2000));
        Product product1 = new Product("P1");
        Product product2 = new Product("P2");
        Inovice inovice1 = new Inovice("23003");
        Inovice inovice2 = new Inovice("43203");
        item1.setInovice(inovice1);
        item2.setInovice(inovice2);
        item1.setProduct(product1);
        item2.setProduct(product2);
        product1.getItems().add(item1);
        product2.getItems().add(item2);
        inovice1.getItems().add(item1);
        inovice2.getItems().add(item2);
        //When
        itemDao.save(item1);
        int id1 = item1.getId();
        itemDao.save(item2);
        int id2 = item2.getId();
        productDao.save(product1);
        int id3 = product1.getId();
        productDao.save(product2);
        int id4 = product2.getId();
        inoviceDao.save(inovice1);
        int id5 = inovice1.getId();
        inoviceDao.save(inovice2);
        int id6 = inovice2.getId();
        //Then
        assertNotEquals(0, id1);
        assertNotEquals(0, id2);
        assertNotEquals(0, id3);
        assertNotEquals(0, id4);
        assertNotEquals(0, id5);
        assertNotEquals(0, id6);
        //CleanUp


    }
}
