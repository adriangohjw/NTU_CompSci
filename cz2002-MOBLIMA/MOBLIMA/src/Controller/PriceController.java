package Controller;

import Model.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Class which controls price of tickets, and price modifiers such as Weekend or Holiday charge.
 */
public class PriceController {

    private HolidaysController holidaysCtrl;
    private Map<PriceChanger,Double> priceMap = new HashMap<>();

    /**
     * Constructor used to initialize HolidaysController and call method to populate default prices.
     */
    public PriceController(){
        this.holidaysCtrl = new HolidaysController();
        populateDefaultPrices(priceMap);
    }

    /**
     * Populate the price map with ticket's prices, where key is PriceChanger and values is a price.
     * @param priceMap Map that should be populated with default prices
     */
    private void populateDefaultPrices(Map<PriceChanger,Double> priceMap) {
        priceMap.put(MovieType.TWO_D, 0.0);
        priceMap.put(MovieType.THREE_D, 3.0);
        priceMap.put(MovieType.BLOCKBUSTER, 3.0);
        priceMap.put(CinemaType.PREMIUM, 1.0);
        priceMap.put(CinemaType.STANDARD, 0.0);
        priceMap.put(PriceType.STUDENT, 8.0);
        priceMap.put(PriceType.HOLIDAY, 12.0);
        priceMap.put(PriceType.NORMAL, 10.0);
        priceMap.put(PriceType.SENIOR_CITIZEN, 6.0);
        priceMap.put(PriceType.WEEKEND, 3.0);
    }

    /**
     * Add new price changer to the map.
     * @param priceChanger Price changer to be added
     * @param value Value of this price changer
     */
    public void addPriceChanger(PriceChanger priceChanger, double value){
        priceMap.put(priceChanger, value);
    }

    /**
     * Change the price of given price changer if it exists.
     * @param priceChanger Price changer to be changed
     * @param newPrice New value for this price changer
     */
    public void changePriceChanger(PriceChanger priceChanger, double newPrice){
        if(priceMap.containsKey(priceChanger)){
            priceMap.replace(priceChanger, newPrice);
        }
    }

    /**
     * Remove the price changer.
     * @param priceChanger Price changer to be removed
     */
    public void removePriceChanger(PriceChanger priceChanger){
        priceMap.remove(priceChanger);
    }

    /**
     * Return all price changers and their values.
     * @return Map of all price changers and their values
     */
    public Map<PriceChanger,Double> getAllPriceChangers(){
        return priceMap;
    }

    /**
     * Return all price changers and their values as string.
     * @return String made from all price changers and their values
     */
    public String getAllPriceChangersToString(){
        String result = "";
        for(PriceChanger priceChanger : priceMap.keySet()){
            result += priceChanger.toString() + " " + priceMap.get(priceChanger) + "\n";
        }
        return result;
    }

    /**
     * Return value for given price changer.
     * @param priceChanger Price changer, whose value is to be retrieved
     * @return Double The value of given price changer
     */
    public double getPrice(PriceChanger priceChanger){
        return priceMap.getOrDefault(priceChanger, 0.0);
    }

    /**
     * Return the price based on given parameters.
     * @param session Session for which price needs to be calculated
     * @param cinema Cinema for which price needs to be calculated
     * @param priceType Price type for which price needs to be calculated
     * @return Double The price of the ticket with given parameters
     */
    public double computePrice(Session session, Cinema cinema, PriceType priceType){
        double addToPrice   = getPrice(session.getMovie().getType()) 
                            + getPrice(cinema.getCinemaType());
        if (session.isWeekend())
            addToPrice += 2.0;
        if(holidaysCtrl.isHoliday(session.getSessionDateTime().toLocalDate())){
            return getPrice(PriceType.HOLIDAY) + addToPrice;
        }
        else{
            return getPrice(priceType) + addToPrice;
        }
    }

}
