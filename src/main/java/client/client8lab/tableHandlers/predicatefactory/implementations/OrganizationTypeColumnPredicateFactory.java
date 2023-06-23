package client.client8lab.tableHandlers.predicatefactory.implementations;

import client.client8lab.tableHandlers.predicatefactory.FilterSigns;
import client.client8lab.tableHandlers.predicatefactory.PredicateFactory;
import common.src.models.OrganizationType;
import common.src.models.Product;
import java.util.function.Predicate;


public class OrganizationTypeColumnPredicateFactory extends PredicateFactory {
    @Override
    public Predicate<Product> createPredicate(FilterSigns filterSign, String value) {
        return switch (filterSign){
            case MORE_THAN -> createMorePredicate(OrganizationType.valueOf(value));
            case EQUALITY -> createEqualPredicate(OrganizationType.valueOf(value));
            case INEQUALITY -> createInequalPredicate(OrganizationType.valueOf(value));
            case LESS_THAN -> createLessPredicate(OrganizationType.valueOf(value));
        };
    }

    private Predicate<Product> createMorePredicate(OrganizationType value){
        return (band) ->  band.getManufacturer() != null && band.getManufacturer().getOrganizationType().ordinal()>value.ordinal();
    }

    private Predicate<Product> createLessPredicate(OrganizationType value){
        return (band) ->  band.getManufacturer() != null &&  band.getManufacturer().getOrganizationType().ordinal()<value.ordinal();
    }

    private Predicate<Product> createEqualPredicate(OrganizationType value){
        return (band) ->  band.getManufacturer() != null && band.getManufacturer().getOrganizationType().ordinal()==value.ordinal();
    }

    private Predicate<Product> createInequalPredicate(OrganizationType value){
        return (band) -> band.getManufacturer() != null && band.getManufacturer().getOrganizationType().ordinal() != value.ordinal();
    }
}
