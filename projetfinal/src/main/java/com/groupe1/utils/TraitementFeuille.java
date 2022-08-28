package com.groupe1.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.groupe1.modeles.EmployeProjet;
import com.groupe1.modeles.Regle;
import com.groupe1.modeles.Resultat;

public class TraitementFeuille {
    public static Resultat traitement(ArrayList<EmployeProjet> employe_projets) {
        Resultat res = new Resultat();

        Regle r = testRegle1();
        //res.ajouterRegle(r);
        r = testRegle2(employe_projets);

        //Regle r3 = testRegle3();
        r = testRegle3(employe_projets);
        //res.ajouterRegle(r);
        
        /* 
        res.ajouterRegle(r);
        r = testRegle4();
        res.ajouterRegle(r);
        r = testRegle5();
        res.ajouterRegle(r);       
        r = testRegle6();
        res.ajouterRegle(r);       
        r = testRegle7();
        res.ajouterRegle(r);       
        */
        
        return res;
    }
    
    

    public static Regle testRegle1() {
        Regle regle;

        // Test #1 : Les employes de l'administration (numero_employe est INFERIEUR à 1000) doivent travailler AU MOINS 
        // 36 heures au bureau par semaine (code_projet INFERIEUR à 900).
        // faire les test
        
        regle = new Regle(1, true, "le message");
        return regle;
    }

    // Méthode testée manuellement, fonctionne correctement
    public static Regle testRegle2(ArrayList<EmployeProjet> employe_projets) {
        //Test #2 : Les employes normaux (numero_employe est SUPERIEUR à 1000) doivent travailler AU MOINS 38 heures au
        //bureau par semaine (code_projet inferieur à 900).
   
        Regle regle;
        String message;
        int minutes_travaillees_bureau = 0;
        int temps_requis_en_minutes = 60*38;
        int numero_employe = employe_projets.get(0).getNumeroEmploye();
        if (numero_employe < 1000) {
            message = "Il s'agit d'un employé de l'administration donc il remplit forcément cette règle";
            regle = new Regle(2, true, message);
        }
        else {
            for (EmployeProjet emp_p : employe_projets) {
                if (emp_p.getNumeroProjet() < 900) 
                    minutes_travaillees_bureau += emp_p.getTempsTravail();
            }
            if (minutes_travaillees_bureau < temps_requis_en_minutes) {
                message = "L'employé régulier n'a pas travaillé au moins 38 heures au bureau cette semaine.";
                regle = new Regle(2, false, message);
            }
            else {
                message = "L'employé régulier a travaillé au moins 38 heures au bureau cette semaine.";
                regle = new Regle(2, true, message);
            }
        }

        return regle;
    }

    /**
     * @param employe_projets
     * @return
     */
    public static Regle testRegle3(ArrayList<EmployeProjet> employe_projets ) {
        //Test #3 : Aucun employé n'a le droit de passer plus de 43 heures au bureau (code_projet inferieur à 900).
        
        Regle regle;
        String message;
        int minutes_travaillees_bureau = 0;
        int temps_requis_en_minutes = 60*43;

                for (EmployeProjet emp_p : employe_projets)
                {
                    if (emp_p.getNumeroProjet() < 900)
                    minutes_travaillees_bureau += emp_p.getTempsTravail(); 
                }
                if(minutes_travaillees_bureau > temps_requis_en_minutes) 
                {
                    message = "L'employé travaillé plus de 43 heures au bureau cette semaine.";
                    regle = new Regle(3, false, message);
                }
                else
                {
                   message = "L'employé n'a pas travaillé plus de 43 heures au bureau cette semaine."; 
                   regle = new Regle(3, true, message);
                }
        //Regle regle = new Regle();
        return regle;
    }

    public static Regle testRegle4() {
        //Test #4 : Les employés de l'administration (numero_employe est INFERIEUR a 1000) ne peuvent pas faire plus de
        //10 heures de télétravail (code_projet SUPÉRIEUR à 1000) par semaine.

        Regle regle = new Regle();

        return regle;
    }   

    public static Regle testRegle5() {
        //   Test #5 : Les employés normaux (numero_employe est SUPERIEUR à 1000) peuvent faire autant de télétravail 
        //(code_projet supérieur à 1000) qu'ils le souhaitent.
   
        Regle regle = new Regle();

        return regle;
    }

    public static Regle testRegle6() {
        //Test #6 : Les employés normaux (numero_employe superieur à 1000) doivent faire un minimum de 6 heures au 
        //bureau (code_projet inferieur à 1000) les jours ouvrables.
   
        Regle regle = new Regle();

        return regle;
    }

    public static Regle testRegle7() {
        //Test #7 : Les employés de l'administration (numero_employe inferieur à 1000) doivent faire un minimum de 4 heures
        //au bureau (code_projet inferieur à 1000) les jours ouvrables.
        
        Regle regle = new Regle();

        return regle; 
    }
}
