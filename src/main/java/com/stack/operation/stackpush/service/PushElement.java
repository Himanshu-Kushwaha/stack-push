package com.stack.operation.stackpush.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.operation.stackpush.entity.ResponseData;
import com.stack.operation.stackpush.entity.StackData;
import com.stack.operation.stackpush.repository.mysql.StackElementRepositoryMysql;
import com.stack.operation.stackpush.repository.psql.StackElementRepositoryPsql;

@Service
public class PushElement {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private StackElementRepositoryMysql stackRepositoryMysql;
    
    @Autowired
    private StackElementRepositoryPsql stackRepositoryPsql;
    
    @Autowired
    private ResponseData responseData;
    
    public ResponseData pushDataInStack(String data, String dataSource) throws Exception {
        StackData insertData = new StackData();
        logger.info("PushElement():: element {}, db {}", data, dataSource);
        insertData.setStackElements(data);
        if ("psql".equalsIgnoreCase(dataSource)) {
            stackRepositoryPsql.saveAndFlush(insertData);
        } else {
            stackRepositoryMysql.saveAndFlush(insertData);
        }

        responseData.setElements(setStackState(dataSource));
        responseData.setDatasource(dataSource);

        return responseData;

    }

    private List<String> setStackState(String dataSource) {
        List<String> stackState = new ArrayList<String>();
        if ("psql".equalsIgnoreCase(dataSource)) {
            for (StackData allData : stackRepositoryPsql.findAll()) {
                stackState.add(allData.getStackElements());
            }
        } else {
            for (StackData allData : stackRepositoryMysql.findAll()) {
                stackState.add(allData.getStackElements());
            }
        }
        return stackState;
    }
    

}


