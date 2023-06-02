package com.example.controller;

import com.example.config.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class DBController {

    @Autowired

    private DBConnector dbConnector;

    //2040706101 杨艾琳

    @RequestMapping("/showDB")
    public void showDB(){
        dbConnector.configure();
    }
}
