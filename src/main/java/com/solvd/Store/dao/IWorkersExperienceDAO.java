package com.solvd.Store.dao;

import com.solvd.Store.models.WorkersExperience;

public interface IWorkersExperienceDAO extends IBaseDAO<WorkersExperience> {
    WorkersExperience getEntityById(Long id);
}
