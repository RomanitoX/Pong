/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.controller;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import pong.listener.KeyListenerFenetre;
import pong.view.Fenetre;
import pong.view.Panneau;

/**
 *
 * @author RomanitoX
 */
public class ControllerView {

    public static Fenetre fenetre;
    public static Panneau panneau;

    public static void init() {
        fenetre = new Fenetre();
        fenetre.addKeyListener(new KeyListenerFenetre());
        panneau = new Panneau();
        fenetre.getContentPane().setLayout(new BorderLayout());
        fenetre.getContentPane().add(panneau, BorderLayout.CENTER);
        fenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fenetre.setVisible(true);
    }
}
