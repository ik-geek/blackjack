package BlackJack;

import Card.Number;
import Card.Suit;
import Card.Cards;
import Card.Card;
import Card.CardException;

import java.util.List;

public class Stack extends Cards{
//    Joker 以外の５２枚のトランプカードの作成
    public Stack() throws CardException {
        super();
        for(Suit suit: Suit.values()){
                for(Number number: Number.values()){
                    if(suit.getIsSuit()&&number.getIsNumber()) {
                        Card card = new Card(suit, number);
                        this.addCard(card);
                    }
                }
        }
    }
    @Override
    public Card removeRandomCard() throws CardException {
        return super.removeRandomCard();
    }
    @Override
    public List<Card> getCards() {
        return super.getCards();
    }
    @Override
    public void printCards() {
        super.printCards();
        System.out.println("");
    }
}
