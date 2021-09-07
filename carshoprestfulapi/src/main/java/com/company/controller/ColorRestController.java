package com.company.controller;

import com.company.dto.ColorDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Color;
import com.company.service.inter.ColorServiceInter;
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
public class ColorRestController
{

    public static final Logger LOG = Logger.getLogger(ColorRestController.class.getName());

    @Autowired
    private ColorServiceInter colorService;

    @GetMapping("/color")
    public ResponseEntity<ResponseDTO> getColors()
    {
        List<Color> colors = colorService.getAll();
        List<ColorDTO> colorDTOs = new ArrayList<>();

        colors.forEach((color) -> colorDTOs.add(ColorDTO.of(color)));

        return ResponseEntity.ok(ResponseDTO.of(colorDTOs, "Successfully got!"));
    }

    @GetMapping("/color/id/{id}")
    public ResponseEntity<ResponseDTO> getColorById(
            @PathVariable("id") Integer id
    )
    {
        Color color = colorService.getById(id);

        ColorDTO colorDTO = (color == null) ? null : ColorDTO.of(color);

        return ResponseEntity.ok(ResponseDTO.of(colorDTO, "Successfully got!"));
    }

    @GetMapping("/color/name/{name}")
    public ResponseEntity<ResponseDTO> getColorByName(
            @PathVariable("name") String name
    )
    {
        Color color = colorService.getByName(name);

        ColorDTO colorDTO = (color == null) ? null : ColorDTO.of(color);

        return ResponseEntity.ok(ResponseDTO.of(colorDTO, "Successfully got!"));
    }

    @PostMapping("/color")
    public ResponseEntity<ResponseDTO> addColor(
            @RequestBody ColorDTO colorDTO
    )
    {
        Color color;
        try
        {
            if (colorDTO.getName().trim().isEmpty())
                throw new NullPointerException();
            color = colorService.getByName(colorDTO.getName());
            if (color != null)
                return ResponseEntity.ok(ResponseDTO.of(colorDTO, "There is color already with this name!", 409));

            color = new Color();
            color.setName(colorDTO.getName());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(colorDTO, "Any of properties can not be null!", 409));
        }

        color = colorService.saveColor(color);

        return ResponseEntity.ok(ResponseDTO.of(ColorDTO.of(color), "Successfully added!"));
    }

    @PutMapping("/color/{id}")
    public ResponseEntity<ResponseDTO> updateColor(
            @PathVariable("id") Integer id,
            @RequestBody ColorDTO colorDTO
    )
    {
        Color color;
        try
        {
            if (colorDTO.getName().trim().isEmpty())
                throw new NullPointerException();
            color = colorService.getById(id);
            if (color == null)
                return ResponseEntity.ok(ResponseDTO.of(colorDTO, "Color not found", 404));

            if (colorService.getByName(colorDTO.getName()) != null
                    && !Objects.equals(colorService.getByName(colorDTO.getName()).getId(), id))
                return ResponseEntity.ok(ResponseDTO.of(colorDTO, "There is color already with this name!", 409));

            color.setName(colorDTO.getName());
        } catch (NullPointerException ex)
        {
            LOG.log(Level.SEVERE, null, ex);
            return ResponseEntity.ok(ResponseDTO.of(colorDTO, "Any of properties can not be null!", 409));
        }

        color = colorService.saveColor(color);

        return ResponseEntity.ok(ResponseDTO.of(ColorDTO.of(color), "Successfully updated!"));
    }

    @DeleteMapping("/color/{id}")
    public ResponseEntity<ResponseDTO> deleteColor(
            @PathVariable("id") Integer id
    )
    {
        Color color = colorService.getById(id);

        colorService.removeColor(color);

        return ResponseEntity.ok(ResponseDTO.of(ColorDTO.of(color), "Successfully deleted!"));
    }
}
