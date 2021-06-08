package com;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class Textures {
    public static Image tex_mur;
    public static Image tex_chemin;
    public static Image tex_perso;
    public static void chargerTextures() {
        try {
            tex_mur = (Image) ImageIO.read(new File("./resources/textures/Mur.png"));
            tex_chemin = (Image) ImageIO.read(new File("./resources/textures/Chemin.png"));
            tex_perso = (Image) ImageIO.read(new File("./resources/textures/Perso.png"));
        } catch (Exception e) {}
    }
}
