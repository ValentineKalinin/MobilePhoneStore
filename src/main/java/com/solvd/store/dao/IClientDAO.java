package com.solvd.store.dao;

import com.solvd.store.models.Client;

public interface IClientDAO extends IBaseDAO<Client>{
    Client getClientByOrderId(Long id);
}
