package com.company.service.impl;

import com.company.entity.Model;
import com.company.repository.ModelRepository;
import com.company.service.inter.ModelServiceInter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Dunay Gudratli
 */
@Service
@Transactional
public class ModelServiceImpl implements ModelServiceInter
{

    @Autowired
    private ModelRepository modelRepository;
    
    @Override
    public List<Model> getAll()
    {
        return modelRepository.findAll();
    }
    
    @Override
    public Model getById(Integer id)
    {
        return modelRepository.findById(id).orElse(null);
    }
    
    @Override
    public Model saveModel(Model model)
    {
        return modelRepository.save(model);
    }
    
    @Override
    public void removeModel(Model model)
    {
        modelRepository.delete(model);
    }

    @Override
    public Model getByName(String name)
    {
        return modelRepository.findByName(name);
    }
    
}
