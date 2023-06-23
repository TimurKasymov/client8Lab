package client.client8lab.tableHandlers.predicatefactory;

public enum FilterSigns {
    MORE_THAN(">"),
    LESS_THAN("<"),
    EQUALITY("="),
    INEQUALITY("<>");
    String stringInterpretation;
    FilterSigns(String sign){
        this.stringInterpretation = sign;
    }

    @Override
    public String toString(){
        return stringInterpretation;
    }

}
