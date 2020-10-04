/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.una.ong.entities.Proyecto;

/**
 *
 * @author farle_000
 */
public interface IProyectoService {
    
    public Optional<Proyecto> findById(Long id);
    public Optional<List<Proyecto>> findAll();
}
