package com.stack.operation.stackpush.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.operation.stackpush.entity.StackData;

public interface StackElementRepositoryMysql extends JpaRepository<StackData, Long>  {
}


