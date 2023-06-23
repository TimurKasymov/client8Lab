package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;
import java.util.Objects;
import java.util.function.Predicate;

public class OrganizationTurnOverColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        try{
            return switch (filterSign){
                case MORE_THAN -> createMorePredicate(Integer.parseInt(value));
                case EQUALITY -> createEqualPredicate(Integer.parseInt(value));
                case INEQUALITY -> createInequalPredicate(Integer.parseInt(value));
                case LESS_THAN -> createLessPredicate(Integer.parseInt(value));
            };
        }
        catch (NumberFormatException numberFormatException){
            return value == null ? Objects::isNull : x->false;
        }
    }

    private Predicate<Product> createMorePredicate(int value){
        return (band) -> band.getManufacturer() != null && band.getManufacturer().getAnnualTurnover() > value;
    }

    private Predicate<Product> createLessPredicate(int value){
        return (band) -> band.getManufacturer() != null &&  band.getManufacturer().getAnnualTurnover() < value;
    }

    private Predicate<Product> createEqualPredicate(int value){
        return (band) -> band.getManufacturer() != null &&  band.getManufacturer().getAnnualTurnover() == value;
    }

    private Predicate<Product> createInequalPredicate(int value){
        return (band) -> band.getManufacturer() != null &&  band.getManufacturer().getAnnualTurnover() != value;
    }
}
