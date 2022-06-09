package com.solvd.Store.dao;

import com.solvd.Store.models.Technique;

public interface ITechniqueDAO extends IBaseDAO<Technique> {
    Technique getAllTechniqueByOrderId(Long id);
}
