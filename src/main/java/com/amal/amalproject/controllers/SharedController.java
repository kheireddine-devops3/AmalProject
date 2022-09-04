package com.amal.amalproject.controllers;

import com.amal.amalproject.MainApplication;

import java.io.IOException;

public class SharedController {
    protected void switchView(String view) {
        try {
            MainApplication.loadView(view);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
