/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import pong.controller.ControllerEntite;
import pong.entite.Ping;

/**
 *
 * @author RomanitoX
 */
public class KeyListenerFenetre implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case KeyEvent.VK_SPACE:
                if (ControllerEntite.isWin) {
                    ControllerEntite.balle.go = false;
                    ControllerEntite.start();
                } else {
                    ControllerEntite.balle.go = true;
                }
                break;
            case KeyEvent.VK_S:
                ControllerEntite.ping.down = true;
                ControllerEntite.ping.top = false;
                break;
            case KeyEvent.VK_Z:
                ControllerEntite.ping.down = false;
                ControllerEntite.ping.top = true;
                break;
            case KeyEvent.VK_PAGE_DOWN:
                ControllerEntite.opacity = 1.0f;
                Ping.pointMax--;
                break;
            case KeyEvent.VK_PAGE_UP:
                ControllerEntite.opacity = 1.0f;
                Ping.pointMax++;
                break;
        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                ControllerEntite.ping2.down = true;
                ControllerEntite.ping2.top = false;
                break;
            case KeyEvent.VK_UP:
                ControllerEntite.ping2.down = false;
                ControllerEntite.ping2.top = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
                ControllerEntite.ping.down = false;
                break;
            case KeyEvent.VK_Z:
                ControllerEntite.ping.top = false;
                break;

        }
        switch (e.getKeyCode()) {
            case KeyEvent.VK_DOWN:
                ControllerEntite.ping2.down = false;
                break;
            case KeyEvent.VK_UP:
                ControllerEntite.ping2.top = false;
                break;

        }
    }

}
