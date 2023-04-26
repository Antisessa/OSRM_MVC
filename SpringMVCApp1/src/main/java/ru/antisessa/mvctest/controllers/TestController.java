package ru.antisessa.mvctest.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.antisessa.mvctest.osrm.ResponseTransfer;

@Controller
public class TestController {
    @RequestMapping("/helloString")
    @ResponseBody
    public String hello() {
        return "Hello world";
    }

    @RequestMapping("/helloObject")
    @ResponseBody
    public ResponseTransfer getResponseObject() {
        return new ResponseTransfer("Objectkey");
    }

    @RequestMapping(value = "/helloJSON", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseTransfer postResponseJsonContent() {
        return new ResponseTransfer("JSON Content!");
    }
}

