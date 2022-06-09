package com.solvd.Store.dao;

import com.solvd.Store.models.WorkersPosition;

public interface IWorkersPositionDAO extends IBaseDAO<WorkersPosition> {
    WorkersPosition getEntityById(Long id);
}
