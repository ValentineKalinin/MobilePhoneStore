package com.solvd.store.dao;

import com.solvd.store.models.Age;

public interface IAgeDAO extends IBaseDAO<Age> {
    Age getEntityById(Long id);
}
