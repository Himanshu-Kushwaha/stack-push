package com.stack.operation.stackpush.repository;

import java.util.Stack;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.operation.stackpush.entity.StackData;

public interface StackElementRepository extends JpaRepository<StackData, Long>  {

//    void save(Stack<Integer> stackData);
//    Stack<Integer> save(Stack<Integer> stackData);

}

