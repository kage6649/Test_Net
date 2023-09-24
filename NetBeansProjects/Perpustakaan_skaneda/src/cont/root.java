/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cont;
import home.*;
import Login.*;


/**
 *
 * @author eater48
 */
public class root {
    public void Tohome(){
        home.Home h = new Home();
        h.setVisible(true);
    }
    public void Tologin(){
        Login l = new Login();
        l.setVisible(true);
    }
    public void Toentry(){
        Entry_anggota e = new Entry_anggota();
        e.setVisible(true);
    }
    public void Torak(){
        Rak r = new Rak();
        r.setVisible(true);
    }
}
