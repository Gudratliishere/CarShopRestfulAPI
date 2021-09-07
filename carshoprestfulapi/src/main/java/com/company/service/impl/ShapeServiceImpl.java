package com.company.service.impl;

import com.company.entity.Shape;
import com.company.repository.ShapeRepository;
import com.company.service.inter.ShapeServiceInter;
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
public class ShapeServiceImpl implements ShapeServiceInter
{
    @Autowired
    private ShapeRepository shapeRepository;

    @Override
    public List<Shape> getAll()
    {
        return shapeRepository.findAll();
    }

    @Override
    public Shape getById(Integer id)
    {
        return shapeRepository.findById(id).orElse(null);
    }

    @Override
    public Shape saveShape(Shape shape)
    {
        return shapeRepository.save(shape);
    }

    @Override
    public void removeShape(Shape shape)
    {
        shapeRepository.delete(shape);
    }

    @Override
    public Shape getByForm(String form)
    {
        return shapeRepository.findByForm(form);
    }
}
