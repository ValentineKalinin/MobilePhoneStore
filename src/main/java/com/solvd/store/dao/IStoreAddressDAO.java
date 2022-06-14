package com.solvd.store.dao;

import com.solvd.store.models.StoreAddress;

public interface IStoreAddressDAO extends IBaseDAO<StoreAddress> {
    StoreAddress getEntityById(Long id);
}
