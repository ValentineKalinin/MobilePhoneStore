package com.solvd.Store.dao;

import com.solvd.Store.models.Model;

public interface IModelDAO extends IBaseDAO<Model>{
    Model getEntityById(Long id);
}
