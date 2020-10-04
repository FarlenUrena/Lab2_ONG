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
import org.una.ong.Repositories.IProyectoRepository;
import org.una.ong.entities.Proyecto;

/**
 *
 * @author farle_000
 */
@Service
public class ProyectoServiceImplementation implements IProyectoService{

     @Autowired
    private IProyectoRepository proyectoRepository;
    
     @Override
    @Transactional(readOnly = true)
    public Optional<List<Proyecto>> findAll() {
        return Optional.ofNullable(proyectoRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Proyecto> findById(Long id) {
        return proyectoRepository.findById(id);
    }
    
    
}
