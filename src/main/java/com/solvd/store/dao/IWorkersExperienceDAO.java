package com.solvd.store.dao;

import com.solvd.store.models.WorkersExperience;

public interface IWorkersExperienceDAO extends IBaseDAO<WorkersExperience> {
    WorkersExperience getEntityById(Long id);
}
