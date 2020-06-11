package BlackJack;

import Card.Number;
import Card.*;

import java.util.List;

public class Hand extends Cards{
    public Hand(){
        super();
    }
    @Override
    public Integer addCard(Card card) throws CardException {
        return super.addCard(card);
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
    @Override
    public Card drawCardFrom(Cards cards) {
        return super.drawCardFrom(cards);
    }
}
