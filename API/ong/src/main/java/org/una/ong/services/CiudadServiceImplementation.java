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
import org.una.ong.Repositories.ICiudadRepository;
import org.una.ong.entities.Ciudad;
/**
 *
 * @author farle_000
 */
@Service
public class CiudadServiceImplementation implements ICiudadService{

      @Autowired
    private ICiudadRepository ciudadRepository;
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Ciudad>> findAll() {
        return Optional.ofNullable(ciudadRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Ciudad> findById(Long id) {
        return ciudadRepository.findById(id);
    }
    
    
}
