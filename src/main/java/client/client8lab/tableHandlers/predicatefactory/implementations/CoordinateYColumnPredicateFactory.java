package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;

import java.util.Objects;
import java.util.function.Predicate;

public class CoordinateYColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        try{
            return switch (filterSign){
                case MORE_THAN -> createMorePredicate(Double.parseDouble(value));
                case EQUALITY -> createEqualPredicate(Double.parseDouble(value));
                case INEQUALITY -> createInequalPredicate(Double.parseDouble(value));
                case LESS_THAN -> createLessPredicate(Double.parseDouble(value));
            };
        }
        catch (NumberFormatException numberFormatException){
            return value == null ? Objects::isNull : x->false;
        }
    }

    private Predicate<Product> createMorePredicate(double value){
        return (band) -> band.getCoordinates().getY() > value;
    }

    private Predicate<Product> createLessPredicate(double value){
        return (band) -> band.getCoordinates().getY() < value;
    }

    private Predicate<Product> createEqualPredicate(double value){
        return (band) -> band.getCoordinates().getY() == value;
    }

    private Predicate<Product> createInequalPredicate(double value){
        return (band) -> band.getCoordinates().getY()!=value;
    }
}
