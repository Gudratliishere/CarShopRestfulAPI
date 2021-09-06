package com.company.service.inter;

import com.company.entity.Color;
import java.util.List;

/**
 *
 * @author Dunay Gudratli
 */
public interface ColorServiceInter 
{
    List<Color> getAll ();
    
    Color getById (Integer id);
    
    Color saveColor (Color color);
    
    void removeColor (Color color);
}
