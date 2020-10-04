/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.services;

import java.util.List;
import java.util.Optional;
import org.una.ong.entities.Inversion;

/**
 *
 * @author farle_000
 */
public interface IInversionService {
    public Optional<List<Inversion>> findAll();
    
    public Optional<Inversion> findById(Long id);
}
