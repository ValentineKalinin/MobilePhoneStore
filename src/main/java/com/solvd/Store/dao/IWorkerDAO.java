package com.solvd.Store.dao;

import com.solvd.Store.models.Worker;

public interface IWorkerDAO extends IBaseDAO<Worker> {
    Worker getEntityById(Long id);
}
