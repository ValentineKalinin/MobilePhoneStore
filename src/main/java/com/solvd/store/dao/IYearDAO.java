package com.solvd.store.dao;

import com.solvd.store.models.Year;

public interface IYearDAO extends IBaseDAO<Year> {
    Year getEntityById(Long id);
}
