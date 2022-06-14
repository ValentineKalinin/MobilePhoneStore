package com.solvd.store.dao;

import com.solvd.store.models.PhoneStore;

public interface IPhoneStoreDAO extends IBaseDAO<PhoneStore> {
    PhoneStore getStoreByOrderId(Long id);
}
