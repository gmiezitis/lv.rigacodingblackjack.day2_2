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
 public class Player implements Participant{
    protected Hand hand;
    
    public Player(){
        hand = new Hand();
    }
    @Override
    public void giveCard(Card card) {
        System.out.println("Player get card " + card.getFullName());
        hand.addCard(card);
    }
     @Override
     public Card[] getCards(){
         return hand.getCards();
     }
      @Override
      public int getTotalPoints() {
          return hand.countPoints();
      }

    @Override
    public boolean isInGame() {
        System.out.println("You have " + getTotalPoints() + " points.");
        
        if(getTotalPoints() > 21 ){
            return false;   
        }
        
       return Game.getAnswer("More cards (y/n)?");
    }
    public void removeCards(){
        hand.clearCards();
    }
    
    
}
