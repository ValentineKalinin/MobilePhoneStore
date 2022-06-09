package com.solvd.Store.dao;

import com.solvd.Store.models.StoreAddress;

public interface IStoreAddressDAO extends IBaseDAO<StoreAddress> {
    StoreAddress getEntityById(Long id);
}
