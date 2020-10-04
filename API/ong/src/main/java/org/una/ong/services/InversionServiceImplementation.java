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
import org.una.ong.Repositories.IInversionRepository;
import org.una.ong.entities.Inversion;

/**
 *
 * @author farle_000
 */
@Service
public class InversionServiceImplementation implements IInversionService{

      @Autowired
    private IInversionRepository inversionRepository;
    
    @Override
    @Transactional(readOnly = true)
    public Optional<List<Inversion>> findAll() {
        return Optional.ofNullable(inversionRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Inversion> findById(Long id) {
        return inversionRepository.findById(id);
    }
    
    
}
