package com.solvd.store.dao;

import com.solvd.store.models.StoresSquare;

public interface IStoreSquareDAO extends IBaseDAO<StoresSquare> {
    StoresSquare getEntityById(Long id);
}
