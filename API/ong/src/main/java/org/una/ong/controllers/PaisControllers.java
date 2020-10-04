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
import org.una.ong.dto.PaisDTO;
import org.una.ong.entities.Pais;
import org.una.ong.services.IPaisService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/paises") 
@Api(tags = {"Paises"})
public class PaisControllers {
    @Autowired
    private IPaisService paisService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las Paises", response = PaisDTO.class, responseContainer = "List", tags = "Paises")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Pais>> result = paisService.findAll();
            if (result.isPresent()) {
                List<PaisDTO> paissDTO = MapperUtils.DtoListFromEntityList(result.get(), PaisDTO.class);
                return new ResponseEntity<>(paissDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un país apartir del id ingresado", response = PaisDTO.class, responseContainer = "PaisDto", tags = "Paises")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Pais> paisFound = paisService.findById(id);
            if (paisFound.isPresent()) {
                PaisDTO paisDto = MapperUtils.DtoFromEntity(paisFound.get(), PaisDTO.class);
                return new ResponseEntity<>(paisDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

