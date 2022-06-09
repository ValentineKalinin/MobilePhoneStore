package com.solvd.Store.dao;

import com.solvd.Store.models.Client;

public interface IClientDAO extends IBaseDAO<Client>{
    Client getClientByOrderId(Long id);
}
