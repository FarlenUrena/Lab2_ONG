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
import org.una.ong.Repositories.IPoblacionRepository;
import org.una.ong.entities.Poblacion;

/**
 *
 * @author farle_000
 */
@Service
public class PoblacionServiceImplementation implements IPoblacionService{
      @Autowired
    private IPoblacionRepository poblacionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Poblacion>> findAll() {
        return Optional.ofNullable(poblacionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Poblacion> findById(Long id) {
        return poblacionRepository.findById(id);
    }
    
}
