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
public class Ping extends Rectangle {

    public boolean top = false;
    public boolean down = false;
    public int point = 0;
    public static int pointMax = 5;
    public int vitessePing = 10;
    public Color c;

    public Ping(int x, int y, int width, int height, Color c) {
        super(x, y, width, height);
        this.c = c;
    }

    public boolean isTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
