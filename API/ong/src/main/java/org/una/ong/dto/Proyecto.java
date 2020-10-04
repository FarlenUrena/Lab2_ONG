/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author farle_000
 */

@Data
@AllArgsConstructor
@NoArgsConstructor 
@ToString

public class Proyecto {
    private Long id;
    private String titulo;
    private Date fechaInicio; 
    private Date fechaFinalizacion;
    private double presupuesto;
    private String nombreResponsable;
}
