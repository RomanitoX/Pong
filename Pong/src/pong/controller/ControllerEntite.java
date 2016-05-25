/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.controller;

import java.awt.Color;
import pong.entite.Balle;
import pong.entite.Ping;

/**
 *
 * @author RomanitoX
 */
public class ControllerEntite {
    public static float opacity = 0.0f; 
    public static Balle balle;
    public static Ping ping;
    public static Ping ping2;
    public static boolean isReady = true;
    public static boolean isWin = false;
    public static boolean sensDepart = false;
    public static int direction = 0;

    public ControllerEntite() {
    }

    public static void initBalle() {
        balle = new Balle(Color.YELLOW, 25, 25, ControllerView.panneau.getWidth() / 2 - 13, ControllerView.panneau.getHeight() / 2 - 25);
        if (sensDepart) {
            balle.toRight = false;

        } else {
            balle.toRight = true;
        }
        if (direction < 1) {
            balle.toTop = false;
        } else {
            balle.toTop = true;
        }
    }

    public static void initPing() {
        ping = new Ping(25, 25, 25, 100, Color.BLUE);
        ping2 = new Ping(ControllerView.panneau.getWidth() - 50, 25, 25, 100, Color.RED);
    }

    public static void gestionMouvementBalle() {
        if (balle.go && !isReady);
        if (balle.toRight) {
            balle.x += balle.vitesseBalle;
        } else {
            balle.x -= balle.vitesseBalle;
        }
        if (balle.intersects(ping2)) {
            balle.vitesseBalle++;
            balle.toRight = false;
        }
        if (balle.intersects(ping)) {
            balle.vitesseBalle++;
            balle.toRight = true;
        }
        if (balle.toTop) {
            balle.y -= balle.vitesseBalle;
        } else {
            balle.y += balle.vitesseBalle;
        }
        if (balle.y + balle.height >= ControllerView.panneau.getHeight()) {
            balle.toTop = true;
        }
        if (balle.x + balle.height >= ControllerView.panneau.getWidth()) {
            ping.point++;
            balle.go = false;
            sensDepart = false;
            direction = (int) (Math.random() * 2);
            initBalle();
        }
        if (balle.x <= 0) {
            ping2.point++;
            balle.go = false;
            sensDepart = true;
            direction = (int) (Math.random() * 2);
            initBalle();
        }
        if (balle.y <= 0) {
            balle.toTop = false;
        }
    }

    public static void gestionPing() {
        if (ping.y <= 0) {
            ping.top = false;
        } else if (ping.y + ping.getHeight() >= ControllerView.panneau.getHeight()) {
            ping.down = false;
        }
        if (ping2.y <= 0) {
            ping2.top = false;
        } else if (ping2.y + ping2.getHeight() >= ControllerView.panneau.getHeight()) {
            ping2.down = false;
        }
        if (ping.top) {
            ping.y -= ping.vitessePing;
        } else if (ping.down) {
            ping.y += ping.vitessePing;
        }
        if (ping2.top) {
            ping2.y -= ping2.vitessePing;
        } else if (ping2.down) {
            ping2.y += ping2.vitessePing;
        }
    }

    public static void start() {
        initBalle();
        initPing();
        ping.setPoint(0);
        ping2.setPoint(0);
        ControllerEntite.isWin = false;
    }
}
