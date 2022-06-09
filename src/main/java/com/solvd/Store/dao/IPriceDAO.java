package com.solvd.Store.dao;

import com.solvd.Store.models.Price;

public interface IPriceDAO extends IBaseDAO<Price> {
    Price getEntityById(Long id);
}
