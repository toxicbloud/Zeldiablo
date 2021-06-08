package com;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;

public class Textures {
    public static Image tex_mur;
    public static Image tex_chemin;
    public static void chargerTextures() {
        try {
            tex_mur = ImageIO.read(new File("./resources/textures/Mur.png"));
            tex_chemin = ImageIO.read(new File("./resources/textures/Chemin.png"));
        } catch (Exception e) {}
    }
}
