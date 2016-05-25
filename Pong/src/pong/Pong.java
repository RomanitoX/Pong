/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.logging.Level;
import java.util.logging.Logger;
import pong.controller.ControllerEntite;
import pong.controller.ControllerView;
import pong.thread.Boucle;
import pong.view.Fenetre;

/**
 *
 * @author RomanitoX
 */
public class Pong {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ControllerView.init();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(16);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Pong.class.getName()).log(Level.SEVERE, null, ex);
                }
                ControllerEntite.start();
                Boucle.goTour();
            }
        }).start();

    }

}
