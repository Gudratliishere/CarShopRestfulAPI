package com.company.repository;

import com.company.entity.Cars;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dunay Gudratli
 */
public interface CarsRepository extends JpaRepository<Cars, Integer>
{
    
}
