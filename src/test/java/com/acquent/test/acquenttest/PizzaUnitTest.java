package com.acquent.test.acquenttest;


import com.acquent.test.acquenttest.Order;
import com.acquent.test.acquenttest.Pizza;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PizzaUnitTest {

    @Autowired
    Pizza pizza;

    @Test
    public void testCurrentDate() {
        Long epoch = 1477405487L;
        String currentDate = pizza.currentDate(epoch);
        Assert.assertEquals("25/10/2016 09:24:47", currentDate);
    }

    @Test(expected = NullPointerException.class)
    public void testCurrentDate_NullPointerException() {
        pizza.currentDate(null);
    }

    @Test
    public void testLexicographicalOrder() throws IOException{
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("Pizza", "anyTime"));
        orders.add(new Order("Bread", "anyTime"));
        pizza.lexicographicalOrder(orders);
        Assert.assertEquals("Bread", orders.get(0).getName());
    }

    @Test(expected = FileNotFoundException.class)
    public void testreadOut_FileNotFound() throws IOException {
        pizza.readInput("/","/") ;
    }

    @Test(expected = FileNotFoundException.class)
    public void testOut_FileNotFoundException() throws IOException {
        pizza.outPutFile("/", new ArrayList<>()); ;
    }

    @Test(expected = FileNotFoundException.class)
    public void testReadOut_FileNotFound1() throws IOException {
        pizza.outPutFile("/", new ArrayList<>()); ;
    }
}

