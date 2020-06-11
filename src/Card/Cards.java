package Card;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public abstract class Cards {
    private List<Card> cards;

    protected Cards(){
        this.cards = new LinkedList<>();
    }
    private Boolean isDuplicate(Card card){
        for(Card cell: this.cards){
            if(cell.isEqual(card))
                return true;
        }
        return false;
    }
    protected Integer addCard(Card card) throws CardException {
        if(!this.isDuplicate(card))
            this.cards.add(card);
        else
            throw new CardException("不正なカードが挿入されました。");
        return this.cards.size();
    }
    protected Integer removeSpecificCard(Card card) throws CardException{
        if(!this.cards.remove(card))
            throw new CardException("削除しようとしているカードは存在しません。");
        return this.cards.size();
    }
    protected Card removeRandomCard() throws CardException{
        Random rand = new Random();
        Card card = this.cards.get(rand.nextInt(this.cards.size()));
        if(!this.cards.remove(card))
            throw new CardException("削除しようとしているカードは存在しません。");
        return card;
    }
    protected List<Card> getCards(){
        return this.cards;
    }
    protected void printCards(){
        for(Card card: this.cards){
            card.printCard();
        }
    }
    protected Card drawCardFrom(Cards cards){
        Card card = new Card();
        try {
            card = cards.removeRandomCard();
            this.addCard(card);
            return card;
        } catch (CardException e) {
            e.printStackTrace();
            return null;
        }
    }
}
