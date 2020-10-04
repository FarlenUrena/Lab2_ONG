/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.una.ong.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Data;
import lombok.Setter;

/**
 *
 * @author thony
 */

@Entity
@Table(name = "lab2_proyectos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Proyecto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private boolean estado;

    @Column(name = "fecha_registro", updatable = false)
    @Temporal(TemporalType.DATE)
    @Setter(AccessLevel.NONE)
    private Date fechaRegistro;

    @Column(name = "fecha_modificacion")
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    
    @Column(name = "titulo", length = 50)
    private String titulo;
    
    @Column(name = "presupuesto")
    private Float presupuesto;
    
    @Column(name = "nombre_responsable", length = 50)
    private String nombreResponsable;
    
    @ManyToOne 
    @JoinColumn(name="sedes_id")
    private Sede sedes;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto") 
    private List<Poblacion> poblaciones = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proyecto") 
    private List<Actuacion> actuaciones = new ArrayList<>();
    
    @PrePersist
    public void prePersist() {
        estado=true;
        fechaRegistro = new Date();
        fechaModificacion = new Date();
    }

    @PreUpdate
    public void preUpdate() {
        fechaModificacion = new Date();
    }
}