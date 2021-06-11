package com;

import javax.imageio.ImageIO;

import java.awt.Image;
import java.io.File;
import java.awt.image.BufferedImage;

public class Textures {
    public static String absolutePath;
    public static Image tex_mur, tex_chemin, tex_perso, tex_amulette, tex_uhd, tex_eau, noTexture,tex_escalierMonter,tex_escalierDescendre, tex_gameover,tex_piege,tex_hpPotion,tex_gameoverWin;
    public static Image[] guerrier,goblin;

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
            bigImg=ImageIO.read(new File("resources/Goblin/Goblin.png"));
            goblin = new BufferedImage[4 * 4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    goblin[(i * 4) + j] = bigImg.getSubimage(j * width, i * height, width, height);
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
            tex_escalierMonter = (Image) ImageIO.read(new File(absolutePath + "resources/textures/escalierMonter.png"));
            tex_escalierDescendre = (Image) ImageIO.read(new File(absolutePath + "resources/textures/escalierDescendre.png"));
            tex_gameover = (Image) ImageIO.read(new File(absolutePath + "resources/textures/game_over.png"));
            tex_piege= (Image) ImageIO.read(new File(absolutePath + "resources/textures/piege.png"));
            tex_hpPotion= (Image) ImageIO.read(new File(absolutePath + "resources/textures/hpPotion.png"));
            tex_gameoverWin=(Image) ImageIO.read(new File(absolutePath + "resources/textures/game_overWin.png"));
        } catch (Exception e) {
        }
    }
}
