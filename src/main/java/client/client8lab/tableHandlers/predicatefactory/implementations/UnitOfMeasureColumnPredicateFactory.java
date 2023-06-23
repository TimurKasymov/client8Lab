package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;
import common.src.models.UnitOfMeasure;

import java.util.Objects;
import java.util.function.Predicate;


public class UnitOfMeasureColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        try{
            return switch (filterSign) {
                case MORE_THAN -> createMorePredicate(UnitOfMeasure.valueOf(value));
                case EQUALITY -> createEqualPredicate(UnitOfMeasure.valueOf(value));
                case INEQUALITY -> createInequalPredicate(UnitOfMeasure.valueOf(value));
                case LESS_THAN -> createLessPredicate(UnitOfMeasure.valueOf(value));
            };
        } catch (NumberFormatException numberFormatException) {
            return value.isBlank() ? Objects::isNull : x -> false;
        }
    }

    private Predicate<Product> createMorePredicate(UnitOfMeasure value) {
        return (band) -> band.getUnitOfMeasure().ordinal() > value.ordinal() ;
    }

    private Predicate<Product> createLessPredicate(UnitOfMeasure value) {
        return (band) -> band.getUnitOfMeasure().ordinal() < value.ordinal() ;
    }

    private Predicate<Product> createEqualPredicate(UnitOfMeasure value) {
        return (band) -> band.getUnitOfMeasure().ordinal() == value.ordinal() ;
    }

    private Predicate<Product> createInequalPredicate(UnitOfMeasure value) {
        return (band) -> band.getUnitOfMeasure().ordinal() != value.ordinal() ;
    }
}
