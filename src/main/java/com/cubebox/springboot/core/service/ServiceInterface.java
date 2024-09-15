package com.cubebox.springboot.core.service;

import com.cubebox.springboot.core.model.AbstractAuditableModel;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ServiceInterface<T extends AbstractAuditableModel> {
    T create(T entity) throws Exception;

    Collection<T> findAll();

    Optional<T> findOne(UUID id);

    T update(T entity) throws Exception;

    void delete(UUID id);

    Boolean isExist(UUID id);
}
