package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;

import java.util.Objects;
import java.util.function.Predicate;

public class IdColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        try{
            return switch (filterSign){
                case MORE_THAN -> createMorePredicate(Long.parseLong(value));
                case EQUALITY -> createEqualPredicate(Long.parseLong(value));
                case INEQUALITY -> createInequalPredicate(Long.parseLong(value));
                case LESS_THAN -> createLessPredicate(Long.parseLong(value));
            };
        }
        catch (NumberFormatException numberFormatException){
            return value == null ? Objects::isNull : x->false;
        }
    }

    private Predicate<Product> createMorePredicate(Long value){
        return (band) -> band.getId() > value;
    }

    private Predicate<Product> createLessPredicate(Long value){
        return (band) -> band.getId() < value;
    }

    private Predicate<Product> createEqualPredicate(Long value){
        return (band) -> Objects.equals(band.getId(), value);
    }

    private Predicate<Product> createInequalPredicate(Long value){
        return (band) -> !Objects.equals(band.getId(), value);
    }
}
