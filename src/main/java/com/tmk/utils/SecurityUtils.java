package com.tmk.utils;


import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Classe utilitaire pour accéder aux données de sécurité.
 */
public class SecurityUtils {

    /**
     * Login par défaut lorsqu'aucun utilisateur n'est connecté.
     */
    public static final String DEFAULT_LOGIN = "ANONYMOUS";

    private SecurityUtils() {
        super();
    }

    /**
     * @return le login de l'utilisateur connecte.
     */
    public static String lireLoginUtilisateurConnecte() {
        SecurityContext context = SecurityContextHolder.getContext();
        String login = DEFAULT_LOGIN;
        if (context != null && context.getAuthentication() != null) {
            login = (String) context.getAuthentication().getPrincipal();
        }
        return login;
    }
}
