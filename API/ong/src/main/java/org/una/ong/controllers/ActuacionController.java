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
import org.una.ong.dto.ActuacionDTO;
import org.una.ong.entities.Actuacion;
import org.una.ong.services.IActuacionService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/actuaciones") 
@Api(tags = {"Actuaciones"})
public class ActuacionController {
    @Autowired
    private IActuacionService actuacionService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las Actuaciones", response = ActuacionDTO.class, responseContainer = "List", tags = "Actuaciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Actuacion>> result = actuacionService.findAll();
            if (result.isPresent()) {
                List<ActuacionDTO> actuacionsDTO = MapperUtils.DtoListFromEntityList(result.get(), ActuacionDTO.class);
                return new ResponseEntity<>(actuacionsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un actuacion apartir del id ingresado", response = ActuacionDTO.class, responseContainer = "ActuacionDto", tags = "Actuaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Actuacion> actuacionFound = actuacionService.findById(id);
            if (actuacionFound.isPresent()) {
                ActuacionDTO actuacionDto = MapperUtils.DtoFromEntity(actuacionFound.get(), ActuacionDTO.class);
                return new ResponseEntity<>(actuacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
