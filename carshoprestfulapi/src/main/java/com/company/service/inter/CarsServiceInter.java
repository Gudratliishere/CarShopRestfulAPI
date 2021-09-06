package com.company.service.inter;

import com.company.entity.Cars;
import java.util.List;

/**
 *
 * @author Dunay Gudratli
 */
public interface CarsServiceInter 
{
    List<Cars> getAll ();
    
    Cars getById (Integer id);
    
    Cars saveCars (Cars cars);
    
    void removeCars (Cars cars);
}
