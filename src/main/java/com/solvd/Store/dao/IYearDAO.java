package com.solvd.Store.dao;

import com.solvd.Store.models.Year;

public interface IYearDAO extends IBaseDAO<Year> {
    Year getEntityById(Long id);
}
