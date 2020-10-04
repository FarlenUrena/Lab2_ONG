/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.ong.entities.Inversion;

/**
 *
 * @author farle_000
 */
public interface IInversionRepository extends JpaRepository<Inversion, Long>{
    
}
