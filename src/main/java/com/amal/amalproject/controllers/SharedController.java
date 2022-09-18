package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication3;

import java.io.IOException;

public class SharedController {
    protected void switchView(String view) {
        try {
            MainApplication3.loadView(view);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
