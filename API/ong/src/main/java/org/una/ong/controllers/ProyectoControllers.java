/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.ong.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.una.ong.dto.ProyectoDTO;
import org.una.ong.entities.Proyecto;
import org.una.ong.services.IProyectoService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/proyectos") 
@Api(tags = {"Proyectos"})
public class ProyectoControllers {
    @Autowired
    private IProyectoService proyectoService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos los Proyectos", response = ProyectoDTO.class, responseContainer = "List", tags = "Proyectos")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Proyecto>> result = proyectoService.findAll();
            if (result.isPresent()) {
                List<ProyectoDTO> proyectosDTO = MapperUtils.DtoListFromEntityList(result.get(), ProyectoDTO.class);
                return new ResponseEntity<>(proyectosDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un proyecto apartir del id ingresado", response = ProyectoDTO.class, responseContainer = "ProyectoDto", tags = "Proyectos")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Proyecto> proyectoFound = proyectoService.findById(id);
            if (proyectoFound.isPresent()) {
                ProyectoDTO proyectoDto = MapperUtils.DtoFromEntity(proyectoFound.get(), ProyectoDTO.class);
                return new ResponseEntity<>(proyectoDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

