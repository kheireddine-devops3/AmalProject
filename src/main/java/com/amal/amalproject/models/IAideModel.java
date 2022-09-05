package com.amal.amalproject.models;



import com.amal.amalproject.entities.Aide;



public interface IAideModel {
	Aide AddAide(Aide aide);
	Aide UpdateAide(Aide aide);
	Aide DeleteAide(Aide aide);
	Aide GetId(int id);
	 
	

}
