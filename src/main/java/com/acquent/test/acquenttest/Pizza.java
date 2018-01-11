package com.acquent.test.acquenttest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class Pizza {

    Order order;

    public  void readInput(String fileLocation, String outputFileLocation) throws IOException {

        final int START_LINE = 1;

        String line;
        BufferedReader reader = new BufferedReader(new FileReader(fileLocation));
        int counter = START_LINE;

        List<Order> orders = new ArrayList<Order>();

        while ((line = reader.readLine()) != null) {
            if (counter > START_LINE) {
                String[] parts = line.split("\\s+", 2);
                if (parts.length >= 2) {
                    orders.add(new Order(parts[0], parts[1]));
                }
            }
            counter++;
        }

        orders.stream().forEach(order -> {
            Long epoch = Long.valueOf(order.getCurretTime()).longValue();
            order.setCurretTime(currentDate(epoch));
        });
        reader.close();
        outPutFile(outputFileLocation, orders);
    }

    public  void outPutFile(String fileLocation, List<Order> orders) throws IOException{

        OutputStream os = (OutputStream) new FileOutputStream(fileLocation);
        String encoding = "UTF8";
        OutputStreamWriter osw = new OutputStreamWriter(os, encoding);
        BufferedWriter bw = new BufferedWriter(osw);
        outPut(bw, "name", "Time");

        orders.stream().forEach(order -> {
            outPut(bw, order.getName(), order.getCurretTime());
        });
        bw.flush();
        bw.close();
    }

    public  void lexicographicalOrder(List<Order> orders){
        Comparator<Order> cmp = new Comparator<Order>() {
            public int compare(Order o1, Order o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        };

         Collections.sort(orders, cmp);
    }

    public  void outPut(BufferedWriter bw,String name, String currentTime){
        try {
            bw.write(name);
            bw.write("  ");
            bw.write(currentTime);
            bw.write("\n");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  String currentDate(Long epoch) {
        String currentTime;
        if(epoch != null){
        String format = "dd/MM/yyyy HH:mm:ss";
            currentTime = new SimpleDateFormat(format).format(new Date (epoch*1000));
            return currentTime;
        }else {
            throw new NullPointerException("Epoch time cannot be null");
        }

    }
}
