package Card;

public enum Number {
    NonNumber(0,"NonNumber",false),
    Ace(1,"Ace",true),
    Two(2,"Two",true),
    Three(3,"Three",true),
    Four(4,"Four",true),
    Five(5,"Five",true),
    Six(6,"Six",true),
    Seven(7,"Seven",true),
    Eight(8,"Eight",true),
    Nine(9,"Nine",true),
    Ten(10,"Ten",true),
    Jack(11,"Jack",true),
    Queen(12,"Queen",true),
    King(13,"King",true);

    private Integer number;
    private String symbol;
    private Boolean isNumber;
    private Number(Integer number, String symbol, Boolean isNumber){
        this.number = number;
        this.symbol = symbol;
        this.isNumber = isNumber;
    }
    public Integer getNumber(){
        return this.number;
    }
    public String getSymbol() {
        return this.symbol;
    }
    public Boolean getIsNumber() {
        return this.isNumber;
    }
    public Boolean isEqual(Number number){
        if(this.number.equals(number.getNumber())
                &&this.symbol.equals(number.getSymbol()))
            return true;
        else return false;
    }
}
