package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;
import java.util.Objects;
import java.util.function.Predicate;

public class PriceColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        if (value.isBlank()) return Objects::isNull;
        return switch (filterSign){
            case MORE_THAN -> createMorePredicate(Float.valueOf(value));
            case EQUALITY -> createEqualPredicate(Float.valueOf(value));
            case INEQUALITY -> createInequalPredicate(Float.valueOf(value));
            case LESS_THAN -> createLessPredicate(Float.valueOf(value));
        };
    }

    private Predicate<Product> createMorePredicate(Float  value){
        return (band) ->  band.getPrice() > value;
    }

    private Predicate<Product> createLessPredicate(Float value){
        return (band) -> band.getPrice() < value;
    }

    private Predicate<Product> createEqualPredicate(Float value){
        return (product) -> product.getPrice().equals(value);
    }

    private Predicate<Product> createInequalPredicate(Float value){
        return (band) -> band.getPrice() != value;
    }
}
