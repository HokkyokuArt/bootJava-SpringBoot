package br.com.tiacademy.apidontstarve.crud;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudService<T,ID> {
    @Autowired
    protected CrudRepository<T,ID> repository;
}