package com.solvd.Store.dao;

import com.solvd.Store.models.Country;

public interface ICountryDAO extends IBaseDAO<Country>{
    Country getEntityById(Long id);
}
