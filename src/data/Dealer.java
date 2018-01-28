/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author oscar
 */
public class Dealer extends Player {
    
    public Dealer(){
        super();
    }
    @Override
    public void giveCard(Card card) {
        System.out.println("Dealer get card ");
        hand.addCard(card);
    }
    @Override
    public boolean isInGame(){
        return hand.countPoints() < 17;
    }
    
}
