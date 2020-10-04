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
import org.una.ong.dto.CiudadDTO;
import org.una.ong.entities.Ciudad;
import org.una.ong.services.ICiudadService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/ciudad") 
@Api(tags = {"Ciudades"})
public class CiudadControllers {
    @Autowired
    private ICiudadService ciudadService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todas las Ciudades", response = CiudadDTO.class, responseContainer = "List", tags = "Ciudades")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Ciudad>> result = ciudadService.findAll();
            if (result.isPresent()) {
                List<CiudadDTO> ciudadsDTO = MapperUtils.DtoListFromEntityList(result.get(), CiudadDTO.class);
                return new ResponseEntity<>(ciudadsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un ciudad apartir del id ingresado", response = CiudadDTO.class, responseContainer = "CiudadDto", tags = "Ciudades")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Ciudad> ciudadFound = ciudadService.findById(id);
            if (ciudadFound.isPresent()) {
                CiudadDTO ciudadDto = MapperUtils.DtoFromEntity(ciudadFound.get(), CiudadDTO.class);
                return new ResponseEntity<>(ciudadDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
