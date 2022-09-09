package br.com.tiacademy.apidontstarve.crud;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudController<T extends CrudDomain<ID>,ID>{
    @Autowired
    protected CrudService<T, ID> service;
}