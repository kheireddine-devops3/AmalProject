package com.amal.amalproject.models;

import com.amal.amalproject.entities.User;
import com.amal.amalproject.entities.dons;

import java.util.List;

public interface IDonsModel {
    dons addDons(dons DON);
    dons removeDons(dons DON);
    dons modifyDOns(dons DON);

    List<dons> getAllDons();

}
