package com.company.controller;

import com.company.dto.ResponseDTO;
import com.company.dto.ShapeDTO;
import com.company.entity.Shape;
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
public class ShapeRestController
{

    public static final Logger LOG = Logger.getLogger(CarsRestController.class.getName());

    @Autowired
    private ShapeServiceInter shapeService;

    @GetMapping("/shape")
    public ResponseEntity<ResponseDTO> getShapes()
    {
        List<Shape> shapes = shapeService.getAll();
        List<ShapeDTO> shapeDTOs = new ArrayList<>();

        shapes.forEach((shape) -> shapeDTOs.add(ShapeDTO.of(shape)));

        return ResponseEntity.ok(ResponseDTO.of(shapeDTOs, "Successfully got!"));
    }

    @GetMapping("/shape/id/{id}")
    public ResponseEntity<ResponseDTO> getShapeById(
            @PathVariable("id") Integer id
    )
    {
        Shape shape = shapeService.getById(id);

        ShapeDTO shapeDTO = (shape == null) ? null : ShapeDTO.of(shape);

        return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "Successfully got!"));
    }

    @GetMapping("/shape/form/{form}")
    public ResponseEntity<ResponseDTO> getShapeByName(
            @PathVariable("form") String form
    )
    {
        Shape shape = shapeService.getByForm(form);

        ShapeDTO shapeDTO = (shape == null) ? null : ShapeDTO.of(shape);

        return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "Successfully got!"));
    }

    @PostMapping("/shape")
    public ResponseEntity<ResponseDTO> addShape(
            @RequestBody ShapeDTO shapeDTO
    )
    {
        Shape shape;
        try
        {
            if (shapeDTO.getForm().trim().isEmpty())
                throw new NullPointerException();
            shape = shapeService.getByForm(shapeDTO.getForm());
            if (shape != null)
                return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "There is shape already with this form!", 409));

            shape = new Shape();
            shape.setForm(shapeDTO.getForm());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "Any of properties can not be null!", 409));
        }

        shape = shapeService.saveShape(shape);

        return ResponseEntity.ok(ResponseDTO.of(ShapeDTO.of(shape), "Successfully added!"));
    }

    @PutMapping("/shape/{id}")
    public ResponseEntity<ResponseDTO> updateShape(
            @PathVariable("id") Integer id,
            @RequestBody ShapeDTO shapeDTO
    )
    {
        Shape shape;
        try
        {
            if (shapeDTO.getForm().trim().isEmpty())
                throw new NullPointerException();
            shape = shapeService.getById(id);
            if (shape == null)
                return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "Shape not found", 404));

            if (shapeService.getByForm(shapeDTO.getForm()) != null
                    && !Objects.equals(shapeService.getByForm(shapeDTO.getForm()).getId(), id))
                return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "There is shape already with this form!", 409));

            shape.setForm(shapeDTO.getForm());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(shapeDTO, "Any of properties can not be null!", 409));
        }

        shape = shapeService.saveShape(shape);

        return ResponseEntity.ok(ResponseDTO.of(ShapeDTO.of(shape), "Successfully updated!"));
    }

    @DeleteMapping("/shape/{id}")
    public ResponseEntity<ResponseDTO> deleteShape(
            @PathVariable("id") Integer id
    )
    {
        Shape shape = shapeService.getById(id);

        shapeService.removeShape(shape);

        return ResponseEntity.ok(ResponseDTO.of(ShapeDTO.of(shape), "Successfully deleted!"));
    }
}
