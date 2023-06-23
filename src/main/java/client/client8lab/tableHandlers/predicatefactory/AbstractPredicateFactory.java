package client.client8lab.tableHandlers.predicatefactory;

import client.client8lab.tableHandlers.ProductColumnNames;
import client.client8lab.tableHandlers.predicatefactory.implementations.*;

public class AbstractPredicateFactory {
    public PredicateFactory createFactory(ProductColumnNames name){
        return switch (name){
            case PRODUCT_ID -> new IdColumnPredicateFactory();
            case CREATION_DATE -> new CreationDateColumnPredicateFactory();
            case PRICE -> new PriceColumnPredicateFactory();
            case MANUFACTURE_COST -> new ManufactureCostColumnPredicateFactory();
            case UNIT_OF_MEASURE -> new UnitOfMeasureColumnPredicateFactory();
            case NAME -> new NameColumnPredicateFactory();
            case COORDINATES_ID -> new CoordinateIdColumnPredicateFactory();
            case X_COORDINATE -> new CoordinateXColumnPredicateFactory();
            case Y_COORDINATE -> new CoordinateYColumnPredicateFactory();
            case ORGANIZATION_ID -> new OrganizationIdColumnPredicateFactory();
            case ORGANIZATION_NAME -> new OrganizationNameColumnPredicateFactory();
            case ORGANIZATION_ANNUAL_TURN_OVER -> new OrganizationTurnOverColumnPredicateFactory();
            case USER_NAME -> new PersonNameColumnPredicateFactory();
            case USER_ID -> new OwnerIdColumnPredicateFactory();
            case ORGANIZATION_TYPE -> new OrganizationTypeColumnPredicateFactory();
        };
    }
}
