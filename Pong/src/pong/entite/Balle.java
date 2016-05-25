/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.entite;

import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author RomanitoX
 */
public class Balle extends Rectangle {

    public Color color;

    public boolean toRight = true;
    public boolean toTop = true;
    public boolean go = false;
    public int vitesseBalle = 5;

    public Balle(Color color, int width, int height, int x, int y) {
        super(x, y, width, height);
        this.color = color;
    }

}
