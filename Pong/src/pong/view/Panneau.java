/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import pong.controller.ControllerEntite;
import pong.entite.Ping;

/**
 *
 * @author RomanitoX
 */
public class Panneau extends JPanel {

    public Panneau() {
    }

    @Override
    public void paintComponent(Graphics g) {

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        if (ControllerEntite.ping2 != null) {
            if (ControllerEntite.ping.point == ControllerEntite.ping.pointMax || ControllerEntite.ping2.point == ControllerEntite.ping.pointMax) {
                ControllerEntite.isWin = true;
                g.setFont(new Font("Segoe UI Light", 1, 72));
                g.setColor(Color.white);
                g.drawString("Le " + (ControllerEntite.ping.point == 4 ? " joueur 1 " : " joueur 2") + " a gagner !", this.getWidth() / 2 - 360, this.getHeight() / 2);
            } else {
                g.setColor(ControllerEntite.balle.color);
                g.fillOval(ControllerEntite.balle.x, ControllerEntite.balle.y, ControllerEntite.balle.width, ControllerEntite.balle.height);
                g.setColor(ControllerEntite.ping.c);
                g.fillRect(ControllerEntite.ping.x, ControllerEntite.ping.y, ControllerEntite.ping.width, ControllerEntite.ping.height);
                g.setColor(ControllerEntite.ping2.c);
                g.fillRect(ControllerEntite.ping2.x, ControllerEntite.ping2.y, ControllerEntite.ping2.width, ControllerEntite.ping2.height);
                g.setColor(Color.white);
                g.drawLine(this.getWidth() / 2, 0, this.getWidth() / 2, this.getHeight());
                g.setFont(new Font("Segoe UI Light", 1, 72));
                g.drawString(Integer.toString(ControllerEntite.ping2.point), this.getWidth() / 2 + 100, 75);
                g.drawString(Integer.toString(ControllerEntite.ping.point), this.getWidth() / 2 - 140, 75);
                g.setFont(new Font("Segoe UI Light", 1, 32));
                ((Graphics2D) g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ControllerEntite.opacity));
                ControllerEntite.opacity -= ControllerEntite.opacity < 0.02f ? 0f : 0.01f;
                g.drawString("Score max : " + Integer.toString(Ping.pointMax), 25, this.getHeight() - 25);
            }
        }
    }
}
