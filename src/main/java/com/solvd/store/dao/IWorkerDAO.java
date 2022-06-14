package com.solvd.store.dao;

import com.solvd.store.models.Worker;

public interface IWorkerDAO extends IBaseDAO<Worker> {
    Worker getEntityById(Long id);
}
