package com.stack.operation.stackpush.repository.psql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stack.operation.stackpush.entity.StackData;

public interface StackElementRepositoryPsql extends JpaRepository<StackData, Long> {

}

