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
public interface Participant {
    void giveCard(Card card);
    
    Card[] getCards();
    int getTotalPoints();
    
    boolean isInGame();
    
    
}
