package com.acquent.test.acquenttest;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/pizza")
public class PizzaController {

    @Autowired
    Pizza pizza;

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "sort Orders in lexicographicalOrder", notes = "Takes the input File and sorts them in order and writes to a destination file")
    public void pizza(@RequestParam(value="inputFilePath", required = true) String inputFilePath,
                         @RequestParam(value = "outputFilePath", required = true) String outPutFilePath) throws IOException {
        pizza.readInput(inputFilePath, outPutFilePath);
    }

}
