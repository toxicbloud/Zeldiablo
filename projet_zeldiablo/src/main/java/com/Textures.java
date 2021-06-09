package com;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;

public class Textures {
    public static String absolutePath;
    public static Image tex_mur, tex_chemin, tex_perso, tex_amulette, tex_uhd, tex_eau, noTexture;
    public static Image[] guerrier;

    public static void chargerTextures() {
        try {
            // on recupere le chemin asbolut pour les textures
            String path = new java.io.File(".").getCanonicalPath();

            final int width = 16;
            final int height = 16;
            final int rows = 5;
            final int cols = 5;
            BufferedImage bigImg = ImageIO.read(new File("resources/Guerrier/Guerrier.png"));
            guerrier = new BufferedImage[rows * cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    guerrier[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width, height);
                }
            }

            int index = path.indexOf("projet_zeldiablo", 0);
            absolutePath = path.substring(0, index) + "projet_zeldiablo/";
            noTexture = (Image) ImageIO.read(new File(absolutePath + "resources/textures/no.png"));
            tex_mur = (Image) ImageIO.read(new File(absolutePath + "resources/textures/Mur.png"));
            tex_eau = (Image) ImageIO.read(new File(absolutePath + "resources/textures/Eau.png"));
            tex_chemin = (Image) ImageIO.read(new File(absolutePath + "resources/textures/Chemin.png"));
            tex_perso = (Image) ImageIO.read(new File(absolutePath + "resources/textures/Perso.png"));
            tex_amulette = (Image) ImageIO.read(new File(absolutePath + "resources/textures/Amulette.png"));
            tex_uhd = (Image) ImageIO.read(new File(absolutePath + "resources/textures/hpUHD.png"));
        } catch (Exception e) {
        }
    }
}
