package com.solvd.Store.dao;

import com.solvd.Store.models.Age;

public interface IAgeDAO extends IBaseDAO<Age> {
    Age getEntityById(Long id);
}
