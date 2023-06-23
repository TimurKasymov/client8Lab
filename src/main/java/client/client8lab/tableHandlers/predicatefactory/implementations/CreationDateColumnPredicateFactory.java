package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.Product;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.function.Predicate;

public class CreationDateColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        try {
            return switch (filterSign){
                case MORE_THAN -> createMorePredicate(LocalDate.parse(value));
                case EQUALITY -> createEqualPredicate(LocalDate.parse(value));
                case INEQUALITY -> createInequalPredicate(LocalDate.parse(value));
                case LESS_THAN -> createLessPredicate(LocalDate.parse(value));
            };
        }
        catch (DateTimeParseException dateTimeParseException){
            return value == null ? Objects::isNull : x->false;
        }
    }

    private Predicate<Product> createMorePredicate(LocalDate value){
        return (band) -> band.getCreationDate().toLocalDate().isAfter(value);
    }

    private Predicate<Product> createLessPredicate(LocalDate value){
        return (band) -> band.getCreationDate().toLocalDate().isBefore(value);
    }

    private Predicate<Product> createEqualPredicate(LocalDate value){
        return (band) -> band.getCreationDate().toLocalDate().equals(value);
    }

    private Predicate<Product> createInequalPredicate(LocalDate value){
        return (band) -> !band.getCreationDate().toLocalDate().equals(value);
    }
}
