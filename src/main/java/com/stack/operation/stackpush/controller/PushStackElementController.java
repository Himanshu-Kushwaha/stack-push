package com.stack.operation.stackpush.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/push", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ResponseData> pushElement(
            @RequestBody StackData pushData) throws Exception {
        logger.info("HottestRepoController:getHottestRepo():: RepoCount request for hottest repos {}", pushData.getPushData());
        return new ResponseEntity<ResponseData>(pushElement.pushDataInStack(pushData.getPushData()), HttpStatus.OK);

    }

}

