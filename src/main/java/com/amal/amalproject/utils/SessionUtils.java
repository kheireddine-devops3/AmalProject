package com.amal.amalproject.utils;

import com.amal.amalproject.entities.Compte;
import com.amal.amalproject.entities.User;

import java.util.ArrayList;
import java.util.List;

public class SessionUtils {
    private static Compte compte = null;

    private List<String> roles = new ArrayList<>();

    public static void addCurrentUser(Compte compte) {
        SessionUtils.compte = compte;
    }

    public static void clearSession() {
        SessionUtils.compte = null;
    }

    public static Compte getCurrentUser() {
        return SessionUtils.compte;
    }
}
