public interface CustomerInterface {
    void viewRestaurants(int customerIndex);
    void createAccount();       //done
    void login();               //done
    void addToCart(int customerIndex, int restaurantIndex, int foodIndex, String inputItem);
    void placeOrder(int customerIndex, int restaurantIndex, int foodIndex, String inputItem);    //update order plus quantity
    void trackOrder();
    void cancelOrder(int custIndex);
    void updateCart();
    void checkout(int restIndex, int custIndex);
    void payCOD();
    void checkDeliveryStatus();

}
