package com.company.repository;

import com.company.entity.Shape;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Dunay Gudratli
 */
public interface ShapeRepository extends JpaRepository<Shape, Integer>
{
    Shape findByForm (String form);
}
