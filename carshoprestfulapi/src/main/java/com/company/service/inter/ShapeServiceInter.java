package com.company.service.inter;

import com.company.entity.Shape;
import java.util.List;

/**
 *
 * @author Dunay Gudratli
 */
public interface ShapeServiceInter 
{
    List<Shape> getAll ();
    
    Shape getById (Integer id);
    
    Shape getByForm (String form);
    
    Shape saveShape (Shape shape);
    
    void removeShape (Shape shape);
}
