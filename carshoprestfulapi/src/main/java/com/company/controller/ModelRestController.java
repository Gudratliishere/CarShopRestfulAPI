package com.company.controller;

import com.company.dto.ModelDTO;
import com.company.dto.ResponseDTO;
import com.company.entity.Model;
import com.company.service.inter.CompanyServiceInter;
import com.company.service.inter.ModelServiceInter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
public class ModelRestController
{

    @Autowired
    private ModelServiceInter modelService;
    @Autowired
    private CompanyServiceInter companyService;

    @GetMapping("/model")
    public ResponseEntity<ResponseDTO> getModels()
    {
        List<Model> models = modelService.getAll();
        List<ModelDTO> modelDTOs = new ArrayList<>();

        models.forEach((model) -> modelDTOs.add(ModelDTO.of(model)));

        return ResponseEntity.ok(ResponseDTO.of(modelDTOs, "Successfully got!"));
    }

    @GetMapping("/model/id/{id}")
    public ResponseEntity<ResponseDTO> getModelById(
            @PathVariable("id") Integer id
    )
    {
        Model model = modelService.getById(id);

        ModelDTO modelDTO = (model == null) ? null : ModelDTO.of(model);

        return ResponseEntity.ok(ResponseDTO.of(modelDTO, "Successfully got!"));
    }

    @GetMapping("/model/name/{name}")
    public ResponseEntity<ResponseDTO> getModelByName(
            @PathVariable("name") String name
    )
    {
        Model model = modelService.getByName(name);

        ModelDTO modelDTO = (model == null) ? null : ModelDTO.of(model);

        return ResponseEntity.ok(ResponseDTO.of(modelDTO, "Successfully got!"));
    }

    @PostMapping("/model")
    public ResponseEntity<ResponseDTO> addModel(
            @RequestBody ModelDTO modelDTO
    )
    {
        Model model = modelService.getByName(modelDTO.getName());
        if (model != null)
            if (Objects.equals(model.getCompany().getId(), modelDTO.getCompany().getId()))
                return ResponseEntity.ok(ResponseDTO.of(modelDTO,
                        "There is model already with this name and company!"));

        model = new Model();
        model.setName(modelDTO.getName());
        model.setCompany(companyService.getById(modelDTO.getCompany().getId()));

        model = modelService.saveModel(model);

        return ResponseEntity.ok(ResponseDTO.of(ModelDTO.of(model), "Successfully added!"));
    }

    @PutMapping("/model/{id}")
    public ResponseEntity<ResponseDTO> updateModel(
            @PathVariable("id") Integer id,
            @RequestBody ModelDTO modelDTO
    )
    {
        Model model = modelService.getById(id);
        if (model == null)
            return ResponseEntity.ok(ResponseDTO.of(modelDTO, "Model not found", 404));

        if (modelService.getByName(modelDTO.getName()) != null
                && !Objects.equals(modelService.getByName(modelDTO.getName()).getId(), id)
                && Objects.equals(modelService.getByName(modelDTO.getName()).getCompany().getId(),
                        modelDTO.getCompany().getId()))
            return ResponseEntity.ok(ResponseDTO.of(modelDTO,
                    "There is model already with this name and company!", 409));

        model.setName(modelDTO.getName());
        model.setCompany(companyService.getById(modelDTO.getCompany().getId()));

        model = modelService.saveModel(model);

        return ResponseEntity.ok(ResponseDTO.of(ModelDTO.of(model), "Successfully updated!"));
    }

    @DeleteMapping("/model/{id}")
    public ResponseEntity<ResponseDTO> deleteModel(
            @PathVariable("id") Integer id
    )
    {
        Model model = modelService.getById(id);

        modelService.removeModel(model);

        return ResponseEntity.ok(ResponseDTO.of(ModelDTO.of(model), "Successfully deleted!"));
    }
}
