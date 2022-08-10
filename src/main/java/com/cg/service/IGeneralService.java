package com.cg.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {

    boolean existsById(Long id);

    List<T> findAll();

    Optional<T> findById(Long id);

    T getById(Long id);

    T save(T customer);

    void delete(Long id);

    void delete(T customer);
}
