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
import org.una.ong.dto.SedeDTO;
import org.una.ong.entities.Sede;
import org.una.ong.services.ISedeService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/sedes") 
@Api(tags = {"Sedes"})
public class SedeControllers {
 @Autowired
    private ISedeService sedeService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las Sedes", response = SedeDTO.class, responseContainer = "List", tags = "Sedes")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Sede>> result = sedeService.findAll();
            if (result.isPresent()) {
                List<SedeDTO> sedesDTO = MapperUtils.DtoListFromEntityList(result.get(), SedeDTO.class);
                return new ResponseEntity<>(sedesDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene una sede apartir del id ingresado", response = SedeDTO.class, responseContainer = "SedeDto", tags = "Sedes")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Sede> sedeFound = sedeService.findById(id);
            if (sedeFound.isPresent()) {
                SedeDTO sedeDto = MapperUtils.DtoFromEntity(sedeFound.get(), SedeDTO.class);
                return new ResponseEntity<>(sedeDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   
}
