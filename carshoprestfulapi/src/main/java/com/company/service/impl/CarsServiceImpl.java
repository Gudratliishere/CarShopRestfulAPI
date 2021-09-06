package com.company.service.impl;

import com.company.entity.Cars;
import com.company.repository.CarsRepository;
import com.company.service.inter.CarsServiceInter;
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
public class CarsServiceImpl implements CarsServiceInter
{
    @Autowired
    private CarsRepository carsRepository;

    @Override
    public List<Cars> getAll()
    {
        return carsRepository.findAll();
    }

    @Override
    public Cars getById(Integer id)
    {
        return carsRepository.findById(id).orElse(null);
    }

    @Override
    public Cars saveCars(Cars cars)
    {
        return carsRepository.save(cars);
    }

    @Override
    public void removeCars(Cars cars)
    {
        carsRepository.delete(cars);
    }
    
    
}
