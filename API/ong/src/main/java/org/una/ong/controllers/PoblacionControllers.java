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
import org.una.ong.dto.PoblacionDTO;
import org.una.ong.entities.Poblacion;
import org.una.ong.services.IPoblacionService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/poblaciones") 
@Api(tags = {"Poblaciones"})
public class PoblacionControllers {
    @Autowired
    private IPoblacionService poblacionService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las Poblaciones", response = PoblacionDTO.class, responseContainer = "List", tags = "Poblaciones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Poblacion>> result = poblacionService.findAll();
            if (result.isPresent()) {
                List<PoblacionDTO> poblacionsDTO = MapperUtils.DtoListFromEntityList(result.get(), PoblacionDTO.class);
                return new ResponseEntity<>(poblacionsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una población apartir del id ingresado", response = PoblacionDTO.class, responseContainer = "PoblacionDto", tags = "Poblaciones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Poblacion> poblacionFound = poblacionService.findById(id);
            if (poblacionFound.isPresent()) {
                PoblacionDTO poblacionDto = MapperUtils.DtoFromEntity(poblacionFound.get(), PoblacionDTO.class);
                return new ResponseEntity<>(poblacionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
