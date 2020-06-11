package Card;

public class Card {
    private Suit suit;
    private Number number;
    public Card(){}
    public Card(Suit suit,Number number){
        this.suit = suit;
        this.number = number;
    }
    public Number getNumber(){
        return this.number;
    }
    public Integer getNumberNumber() {
        return this.number.getNumber();
    }
    public String getNumberSymbol() {
        return this.number.getSymbol();
    }
    public Suit getSuit(){
        return this.suit;
    }
    public String getSuitSymbol(){
        return this.suit.getSymbol();
    }
    public void printCard(){
        System.out.print("\""+getSuitSymbol()+getNumberNumber()+"\"");
    }
    public Boolean isEqual(Card card){
        if(this.suit.isEqual(card.getSuit())
        &&this.number.isEqual(card.getNumber()))
            return true;
        else return false;
    }
}
