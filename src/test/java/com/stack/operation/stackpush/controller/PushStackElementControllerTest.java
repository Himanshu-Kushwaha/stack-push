package com.stack.operation.stackpush.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import com.stack.operation.stackpush.entity.ResponseData;
import com.stack.operation.stackpush.entity.StackData;
import com.stack.operation.stackpush.service.PushElement;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PushStackElementControllerTest {

    @Mock
    PushElement pushElement;

    @InjectMocks
    PushStackElementController pushStackElementController;

    @Test
    public void testSuccessScenario() throws Exception {
        StackData stackdata = new StackData();
        stackdata.setId(1L);
        stackdata.setPushData("12");
        stackdata.setStackElements("13");

        List<String> stackElement = Arrays.asList(new String[] { "12", "13" });

        ResponseData responseData = new ResponseData();
        responseData.setDatasource("mysql");
        responseData.setElements(stackElement);

        Mockito.when(pushElement.pushDataInStack(Mockito.anyString(), Mockito.anyString())).thenReturn(responseData);
        ResponseEntity<ResponseData> responseEntity = pushStackElementController.pushElementMysql(stackdata, "mysql");
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test(expected = Exception.class)
    public void testFailure() throws Exception {
        pushStackElementController.pushElementMysql(null, null);
    }

}
