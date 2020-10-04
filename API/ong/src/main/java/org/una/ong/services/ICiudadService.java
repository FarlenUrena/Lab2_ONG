/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.services;

import java.util.List;
import java.util.Optional;
import org.una.ong.entities.Ciudad;

/**
 *
 * @author farle_000
 */
public interface ICiudadService {
    public Optional<Ciudad> findById(Long id);
    public Optional<List<Ciudad>> findAll();
}
