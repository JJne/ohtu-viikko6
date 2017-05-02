/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;


public abstract class Lasku implements Komento {
    protected Sovelluslogiikka sovellus;
    protected JTextField tuloskentta;
    protected JTextField syotekentta;
    
    protected int edellinenTulos;
    protected String edellinenTuloskentta;
    protected String edellinenSyotekentta;
    
    public Lasku(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }
    
    @Override
    public void suorita() {
        edellinenTulos = sovellus.tulos();
        edellinenTuloskentta = tuloskentta.getText();
        edellinenSyotekentta = syotekentta.getText();
        
        int arvo = 0;
 
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        
        laske(arvo);
        tuloskentta.setText("" + sovellus.tulos());
        syotekentta.setText("");
    }
    
    @Override
    public void peru() {
        sovellus.nollaa();
        sovellus.plus(edellinenTulos);
        
        tuloskentta.setText(edellinenTuloskentta);
        syotekentta.setText(edellinenSyotekentta);
    }
    
    protected abstract void laske(int arvo);   
}
