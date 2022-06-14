package com.solvd.store.dao;

import com.solvd.store.models.Technique;

public interface ITechniqueDAO extends IBaseDAO<Technique> {
    Technique getAllTechniqueByOrderId(Long id);
}
