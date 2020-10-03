package com.stack.operation.stackpush.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stack.operation.stackpush.entity.ResponseData;
import com.stack.operation.stackpush.entity.StackData;
import com.stack.operation.stackpush.service.PushElement;


@Controller
public class PushStackElementController {

    @Autowired
    PushElement pushElement;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/{datasource}/push", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseData> pushElementMysql(
            @RequestBody StackData pushData, @PathVariable String datasource) throws Exception {
        logger.info("Pushelement():: Push element in datasource {}, data {}", datasource, pushData.getPushData());
        return new ResponseEntity<ResponseData>(pushElement.pushDataInStack(pushData.getPushData(), datasource), HttpStatus.OK);

    }

}


