package Card;

public enum Suit {
    SPADE("♠︎",true),
    CLUB("♣︎",true),
    DIAMOND("♦︎",true),
    HEART("❤︎",true),
    JOKER("🤡",false);

    private String symbol;
    private Boolean isSuit;
    private Suit(String symbol, Boolean isSuit){
        this.symbol = symbol;
        this.isSuit = isSuit;
    }
    public String getSymbol(){
        return this.symbol;
    }
    public Boolean getIsSuit(){
        return this.isSuit;
    }
    public Boolean isEqual(Suit suit){
        if(this.symbol.equals(suit.getSymbol()))
            return true;
        else return false;
    }
}
