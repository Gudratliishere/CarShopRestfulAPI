package com.company.controller;

import com.company.dto.CarsDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Cars;
import com.company.service.inter.CarsServiceInter;
import com.company.service.inter.ColorServiceInter;
import com.company.service.inter.ModelServiceInter;
import com.company.service.inter.ShapeServiceInter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Dunay Gudratli
 */
@RestController
public class CarsRestController
{

    public static final Logger LOG = Logger.getLogger(CarsRestController.class.getName());

    @Autowired
    private CarsServiceInter carsService;
    @Autowired
    private ModelServiceInter modelService;
    @Autowired
    private ColorServiceInter colorService;
    @Autowired
    private ShapeServiceInter shapeService;

    @GetMapping("/cars")
    public ResponseEntity<ResponseDTO> getCars()
    {
        List<Cars> cars = carsService.getAll();
        List<CarsDTO> carsDTOs = new ArrayList<>();

        cars.forEach((car) -> carsDTOs.add(CarsDTO.of(car)));

        ResponseDTO responseDTO = ResponseDTO.of(carsDTOs, "Successfully got!");

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/cars/number/{number}")
    public ResponseEntity<ResponseDTO> getCarByNumber(
            @PathVariable("number") String number
    )
    {
        Cars car = carsService.getByNumber(number);

        CarsDTO carsDTO = (car != null) ? CarsDTO.of(car) : null;

        ResponseDTO responseDTO = ResponseDTO.of(carsDTO, "Successfully got!");

        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/cars/id/{id}")
    public ResponseEntity<ResponseDTO> getCarById(
            @PathVariable("id") Integer id
    )
    {
        Cars car = carsService.getById(id);

        CarsDTO carsDTO = (car != null) ? CarsDTO.of(car) : null;

        ResponseDTO responseDTO = ResponseDTO.of(carsDTO, "Successfully got!");

        return ResponseEntity.ok(responseDTO);
    }

    @PostMapping(value = "/cars")
    public ResponseEntity<ResponseDTO> addCars(
            @RequestBody CarsDTO carsDTO
    )
    {
        Cars cars;
        try
        {
            if (carsDTO.getNumber().trim().isEmpty())
                throw new NullPointerException();
            cars = carsService.getByNumber(carsDTO.getNumber());
            if (cars == null)
                cars = new Cars();
            else
                return ResponseEntity.ok(ResponseDTO.of(carsDTO, "There is car already with this number!", 409));

            cars.setNumber(carsDTO.getNumber());

            cars.setModel(modelService.getById(carsDTO.getModel().getId()));
            cars.setColor(colorService.getById(carsDTO.getColor().getId()));
            cars.setShape(shapeService.getById(carsDTO.getShape().getId()));
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(carsDTO, "Any of properties can not be null!", 409));
        }

        cars = carsService.saveCars(cars);

        return ResponseEntity.ok(ResponseDTO.of(CarsDTO.of(cars), "Successfully added!"));
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<ResponseDTO> updateCars(
            @PathVariable("id") Integer id,
            @RequestBody CarsDTO carsDTO
    )
    {
        Cars cars;
        try
        {
            if (carsDTO.getNumber().trim().isEmpty())
                throw new NullPointerException();
            cars = carsService.getById(id);
            if (cars == null)
                return ResponseEntity.ok(ResponseDTO.of(carsDTO, "Car not found!", 404));

            if (carsService.getByNumber(carsDTO.getNumber()) != null
                    && !Objects.equals(carsService.getByNumber(carsDTO.getNumber()).getId(), id))
                return ResponseEntity.ok(ResponseDTO.of(carsDTO, "There is car already with this number!", 409));

            cars.setNumber(carsDTO.getNumber());
            cars.setModel(modelService.getById(carsDTO.getModel().getId()));
            cars.setColor(colorService.getById(carsDTO.getColor().getId()));
            cars.setShape(shapeService.getById(carsDTO.getShape().getId()));
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(carsDTO, "Any of properties can not be null!", 409));
        }

        cars = carsService.saveCars(cars);

        return ResponseEntity.ok(ResponseDTO.of(CarsDTO.of(cars), "Successfully updated!"));
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<ResponseDTO> deleteCars(
            @PathVariable("id") Integer id
    )
    {
        Cars cars = carsService.getById(id);
        if (cars == null)
            return ResponseEntity.ok(ResponseDTO.of(CarsDTO.of(cars), "Car not found!", 404));

        carsService.removeCars(cars);

        return ResponseEntity.ok(ResponseDTO.of(CarsDTO.of(cars), "Successfully deleted!"));
    }
}
