package com.amal.amalproject.models;

import java.sql.Connection;
import java.util.List;

import com.amal.amalproject.entities.Formation;
import com.amal.amalproject.utils.DBConnection;

public class FormationModel implements IFormationModel {
    Connection connection = DBConnection.getConnection();

	@Override
	public Formation addFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation deleteFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Formation editFormation(Formation formation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Formation> getAllFormation() {
		// TODO Auto-generated method stub
		return null;
	}

}
