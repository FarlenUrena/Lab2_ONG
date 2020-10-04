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
import org.una.ong.dto.InversionDTO;
import org.una.ong.entities.Inversion;
import org.una.ong.services.IInversionService;
import org.una.ong.utils.MapperUtils;

/**
 *
 * @author erikg
 */
@RestController
@RequestMapping("/inversiones") 
@Api(tags = {"Inversiones"})
public class InversionControllers {
    @Autowired
    private IInversionService inversionService;

    @GetMapping()
    @ApiOperation(value = "Obtiene una lista de todos las Inversiones", response = InversionDTO.class, responseContainer = "List", tags = "Inversiones")
    public @ResponseBody
    ResponseEntity<?> findAll() {
        try {
            Optional<List<Inversion>> result = inversionService.findAll();
            if (result.isPresent()) {
                List<InversionDTO> inversionsDTO = MapperUtils.DtoListFromEntityList(result.get(), InversionDTO.class);
                return new ResponseEntity<>(inversionsDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtiene un inversión apartir del id ingresado", response = InversionDTO.class, responseContainer = "InversionDto", tags = "Inversiones")
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id) {
        try {

            Optional<Inversion> inversionFound = inversionService.findById(id);
            if (inversionFound.isPresent()) {
                InversionDTO inversionDto = MapperUtils.DtoFromEntity(inversionFound.get(), InversionDTO.class);
                return new ResponseEntity<>(inversionDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

