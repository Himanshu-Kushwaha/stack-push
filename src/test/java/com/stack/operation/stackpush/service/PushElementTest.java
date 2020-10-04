package com.stack.operation.stackpush.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;

import com.stack.operation.stackpush.entity.ResponseData;
import com.stack.operation.stackpush.entity.StackData;
import com.stack.operation.stackpush.repository.mysql.StackElementRepositoryMysql;
import com.stack.operation.stackpush.repository.psql.StackElementRepositoryPsql;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PushElementTest {

    @Mock
    private StackElementRepositoryMysql stackRepositoryMysql;
    @Mock
    private StackElementRepositoryPsql stackRepositoryPsql;
    @Mock
    private ResponseData responseData;
    
    @InjectMocks
    private PushElement pushElement;
    
    @Test
    public void pushDataInStackMysqlTest() throws Exception {
        when(stackRepositoryMysql.findAll()).thenReturn(getStackList());
        pushElement.pushDataInStack("23", "mysql");
    }
    
    @Test
    public void pushDataInStackPsqlTest() throws Exception {
        when(stackRepositoryPsql.findAll()).thenReturn(getStackList());
        pushElement.pushDataInStack("23", "psql");
    }
    
    private List<StackData> getStackList() {
        StackData stackdata = new StackData();
        stackdata.setId(1L);
        stackdata.setPushData("3");
        stackdata.setStackElements("34");

        StackData stackdata1 = new StackData();
        stackdata1.setId(2L);
        stackdata1.setPushData("4");
        stackdata1.setStackElements("34");

        StackData stackdata3 = new StackData();
        stackdata3.setId(3L);
        stackdata3.setPushData("5");
        stackdata3.setStackElements("34");

        List<StackData> stackList = new ArrayList<StackData>();
        stackList.add(stackdata);
        stackList.add(stackdata1);
        stackList.add(stackdata3);
        return stackList;
    }
}
