package com.solvd.Store.dao;

import com.solvd.Store.models.PhoneStore;

public interface IPhoneStoreDAO extends IBaseDAO<PhoneStore> {
    PhoneStore getStoreByOrderId(Long id);
}
