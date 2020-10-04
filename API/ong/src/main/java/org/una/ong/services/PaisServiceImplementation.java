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
import org.una.ong.Repositories.IPaisRepository;
import org.una.ong.entities.Pais;

/**
 *
 * @author farle_000
 */
@Service
public class PaisServiceImplementation implements IPaisService {

     @Autowired
    private IPaisRepository paisRepository;
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Pais>> findAll() {
        return Optional.ofNullable(paisRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pais> findById(Long id) {
        return paisRepository.findById(id);
    }
    
    
}
