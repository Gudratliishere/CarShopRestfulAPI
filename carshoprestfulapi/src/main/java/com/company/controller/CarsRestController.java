package com.company.controller;

import com.company.dto.CarsDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Cars;
import com.company.service.inter.CarsServiceInter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dunay Gudratli
 */
@RestController
public class CarsRestController
{
    
    @Autowired
    private CarsServiceInter carsService;
    
    @GetMapping("/cars")
    public ResponseEntity<ResponseDTO> getCars ()
    {
        List<Cars> cars = carsService.getAll();
        List<CarsDTO> carsDTOs = new ArrayList<>();
        
        cars.forEach((car) -> carsDTOs.add(CarsDTO.of(car)));
        
        ResponseDTO responseDTO = ResponseDTO.of(carsDTOs, "Successfully got!");
        
        return ResponseEntity.ok(responseDTO);
    }
}
