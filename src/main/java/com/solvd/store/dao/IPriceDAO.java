package com.solvd.store.dao;

import com.solvd.store.models.Price;

public interface IPriceDAO extends IBaseDAO<Price> {
    Price getEntityById(Long id);
}
