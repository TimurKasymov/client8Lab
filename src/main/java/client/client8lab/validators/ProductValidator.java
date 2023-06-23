package client.client8lab.validators;

public class ProductValidator {

    public static boolean validateName(String value){
        return !value.isEmpty();
    }

    public static boolean validateXCoordinate(String value){
        try{
            return !Double.valueOf(value).isNaN() && 0 < Double.parseDouble(value) && Double.parseDouble(value) < 910;
        }
        catch (Exception ignored){
            return false;
        }
    }

    public static boolean validateYCoordinate(String value){
        try{
            return !Float.valueOf(value).isNaN() && 0 < Double.parseDouble(value) && Double.parseDouble(value) < 590;
        }
        catch (Exception ignored){
            return false;
        }
    }

    public static boolean validatePrice(String value){
        try{
            return !Float.valueOf(value).isNaN() && Float.parseFloat(value) > -1;
        }
        catch (Exception ignored){
            return false;
        }
    }
    public static boolean validateManufactureCost(String value){
        try{
            return !Double.valueOf(value).isNaN() && Double.parseDouble(value) > -1;
        }
        catch (Exception ignored){
            return false;
        }
    }

    public static boolean validateOrganizationName(String value){
        return !value.isEmpty();
    }

    public static boolean validateOrganizationAnnualTurnOver(String value){
        try{
            var anTurnOVer = Integer.parseInt(value);
            return anTurnOVer > -1;
        }
        catch (Exception ignored){
            return false;
        }
    }

}
