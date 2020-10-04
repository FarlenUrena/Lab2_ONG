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
import org.una.ong.Repositories.ISedeRepository;
import org.una.ong.entities.Sede;

/**
 *
 * @author farle_000
 */
@Service
public class SedeServiceImplementation implements ISedeService{

      @Autowired
    private ISedeRepository sedeRepository;
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Sede>> findAll() {
        return Optional.ofNullable(sedeRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Sede> findById(Long id) {
        return sedeRepository.findById(id);
    }
    
    
}
