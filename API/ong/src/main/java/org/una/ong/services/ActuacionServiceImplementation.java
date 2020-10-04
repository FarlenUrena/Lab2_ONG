/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.ong.Repositories.IActuacionRepository;
import org.una.ong.entities.Actuacion;

/**
 *
 * @author farle_000
 */
@Service
public class ActuacionServiceImplementation implements IActuacionService{

    @Autowired
    private IActuacionRepository actuacionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Actuacion>> findAll() {
        return Optional.ofNullable(actuacionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Actuacion> findById(Long id) {
        return actuacionRepository.findById(id);
    }
    
}
