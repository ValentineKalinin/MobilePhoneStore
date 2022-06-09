package com.solvd.Store.dao;

import com.solvd.Store.models.StoresSquare;

public interface IStoreSquareDAO extends IBaseDAO<StoresSquare> {
    StoresSquare getEntityById(Long id);
}
