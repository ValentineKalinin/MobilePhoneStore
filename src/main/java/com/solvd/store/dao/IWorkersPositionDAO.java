package com.solvd.store.dao;

import com.solvd.store.models.WorkersPosition;

public interface IWorkersPositionDAO extends IBaseDAO<WorkersPosition> {
    WorkersPosition getEntityById(Long id);
}
