/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ong.entities.Poblacion;

/**
 *
 * @author farle_000
 */
public interface IPoblacionRepository extends JpaRepository<Poblacion, Long>{
    
}
