package com.company.service.inter;

import com.company.entity.Model;
import java.util.List;

/**
 *
 * @author Dunay Gudratli
 */
public interface ModelServiceInter 
{
    List<Model> getAll ();
    
    Model getById (Integer id);
    
    Model getByName (String name);
    
    Model saveModel (Model model);
    
    void removeModel (Model model);
}
