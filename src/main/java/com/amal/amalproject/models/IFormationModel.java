package com.amal.amalproject.models;

import java.util.*;

import com.amal.amalproject.entities.Formation;

public interface IFormationModel {
	
	Formation addFormation(Formation formation);
	Formation deleteFormation(Formation formation);
	Formation editFormation(Formation formation);	
    List<Formation> getAllFormation();
    
    

}
