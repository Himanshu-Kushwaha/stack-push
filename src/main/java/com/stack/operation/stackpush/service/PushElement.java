package com.stack.operation.stackpush.service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.internal.util.collections.Stack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stack.operation.stackpush.entity.ResponseData;
import com.stack.operation.stackpush.entity.StackData;
import com.stack.operation.stackpush.repository.StackElementRepository;

@Service
public class PushElement {
    
    @Autowired
    private StackElementRepository stackRepository;
    
    @Autowired
    private ResponseData responseData;
    
    public ResponseData pushDataInStack(Integer data) {
        StackData insertData = new StackData();
        insertData.setStackElements(data);
        stackRepository.saveAndFlush(insertData);
        
        List <Integer> stackState = new ArrayList();
        for (StackData allData : stackRepository.findAll()) {
            stackState.add(allData.getStackElements());
        }
        
        responseData.setElements(stackState);
        
        return responseData;

//        for (StackData allData : stackRepository.findAll()) {
//            if (allData.getId() == 1L) {
//                Stack<Integer> local = allData.getStackElements();
//                local.push(data);
//                allData.setStackElements(local);
//                stackRepository.save(allData);

//            } else {
//                Stack<Integer> elements = new Stack<>();
//                elements.push(data);
//                StackData stackData = new StackData();
//                stackData.setId(1L);
//                stackData.setStackElements(elements);
//                stackRepository.save(stackData);
//            }
//        }
//      Optional<StackData> getData = stackRepository.findById(1L);
//        if(!getData.isPresent()) {
//            StackData existingStack = getData.get();
//            Stack<Integer> local = existingStack.getStackElements();
//            local.push(data);
//            existingStack.setStackElements(local);
//            stackRepository.save(existingStack);
//        } else {
//            Stack<Integer> elements = null;
//            elements.push(data);
//            StackData stackData = new StackData();
//            stackData.setId(1L);
//            stackData.setStackElements(elements);
//            stackRepository.save(stackData);
//        }
//        
//        Optional<StackData> retrieveData = stackRepository.findById(1L);
//        StackData dataFromDB = retrieveData.get();
//        System.out.println("DATA FROM DB: "+ dataFromDB.getStackElements());
//        return dataFromDB.getStackElements();
//        List<StackData> stackList = stackRepository.findAll();
//        
//        for (StackData stack : stackList) {
//            stack.getStackElements().push(data);
//            stackRepository.save(stack);
//            return stack;
//        }
//        
//        return null;
        
    }
    

}

