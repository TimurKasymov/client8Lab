package client.client8lab.tableHandlers.predicatefactory;

import common.src.models.Product;

import java.util.function.Predicate;

public abstract class PredicateFactory {
    public abstract Predicate<Product> createPredicate(FilterSigns filterSign, String value);
}
