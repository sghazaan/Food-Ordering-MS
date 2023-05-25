public interface RestaurantInterface {
    void createAccount();
    void login();
    void addFoodDetails(int restaurantIndex);
    void updateFoodDetails(int restaurantIndex);
    void deleteFood(int restaurantIndex);
    void checkFoodOrder(int restIndex);
    boolean updateDeliveryStatus();
    void calculateBills();

}
