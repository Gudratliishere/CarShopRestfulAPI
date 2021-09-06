package com.company.repository;

import com.company.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dunay Gudratli
 */
public interface ColorRepository extends JpaRepository<Color, Integer>
{
    
}
