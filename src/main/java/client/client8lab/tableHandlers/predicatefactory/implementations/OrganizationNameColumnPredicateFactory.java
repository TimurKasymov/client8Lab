package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;

import java.util.function.Predicate;


public class OrganizationNameColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        return switch (filterSign){
            case MORE_THAN -> createMorePredicate(value);
            case EQUALITY -> createEqualPredicate(value);
            case INEQUALITY -> createInequalPredicate(value);
            case LESS_THAN -> createLessPredicate(value);
        };
    }

    private Predicate<Product> createMorePredicate(String value){
        return (band) ->  band.getManufacturer() != null && band.getManufacturer().getName().compareTo(value)>0;
    }

    private Predicate<Product> createLessPredicate(String value){
        return (band) ->  band.getManufacturer() != null &&  band.getManufacturer().getName().compareTo(value)<0;
    }

    private Predicate<Product> createEqualPredicate(String value){
        return (band) ->  band.getManufacturer() != null &&  band.getManufacturer().getName().equals(value);
    }

    private Predicate<Product> createInequalPredicate(String value){
        return (band) -> band.getManufacturer() != null && !band.getManufacturer().getName().equals(value);
    }
}
