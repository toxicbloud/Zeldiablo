package com;
import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;

public class Textures {
    public static String absolutePath;
    public static Image tex_mur;
    public static Image tex_chemin;
    public static Image tex_perso;
    public static void chargerTextures() {
        try {
            // on recupere le chemin asbolut pour les textures
            String path = new java.io.File(".").getCanonicalPath();

            int index = path.indexOf("projet_zeldiablo", 0);
            absolutePath = path.substring(0, index)+"projet_zeldiablo/";
            tex_mur = (Image) ImageIO.read(new File(absolutePath+"resources/textures/Mur.png"));
            tex_chemin = (Image) ImageIO.read(new File(absolutePath+"resources/textures/Chemin.png"));
            tex_perso = (Image) ImageIO.read(new File(absolutePath+"resources/textures/Perso.png"));
        } catch (Exception e) {}
    }
}
