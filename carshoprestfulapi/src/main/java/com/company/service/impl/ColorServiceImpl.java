package com.company.service.impl;

import com.company.entity.Color;
import com.company.repository.ColorRepository;
import com.company.service.inter.ColorServiceInter;
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
public class ColorServiceImpl implements ColorServiceInter
{
    @Autowired
    private ColorRepository colorRepository;

    @Override
    public List<Color> getAll()
    {
        return colorRepository.findAll();
    }

    @Override
    public Color getById(Integer id)
    {
        return colorRepository.findById(id).orElse(null);
    }

    @Override
    public Color saveColor(Color color)
    {
        return colorRepository.save(color);
    }

    @Override
    public void removeColor(Color color)
    {
        colorRepository.delete(color);
    }

    @Override
    public Color getByName(String name)
    {
        return colorRepository.findByName(name);
    }

}
