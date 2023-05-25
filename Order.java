import java.util.ArrayList;
import java.util.Date;

public class Order {
    private String restaurantUsername;
    private double foodPrice;
    protected ArrayList<Integer> foodQuantityArray =  new ArrayList<>();
    private String feedback;

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


    public int getFoodQuantity() {
        return foodQuantity;
    }

    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    private int foodQuantity;

    public ArrayList<Integer> getFoodQuantityArray() {
        return foodQuantityArray;
    }

    public void setFoodQuantityArray(ArrayList<Integer> foodQuantityArray) {
        this.foodQuantityArray = foodQuantityArray;
    }

    public double getTotalBill() {
        return totalBill;
    }
    public void calculateTotalBill(int custIndex, int ordersIndex){
        totalBill+=Admin.orderObjects.get(ordersIndex).getFoodPrice()*Admin.orderObjects.get(ordersIndex).getFoodQuantity();
        for(int priceIndex = 0; priceIndex<foodPricesArray.size(); priceIndex++){
            int q;
            q=foodQuantityArray.get(priceIndex);
            double temp;
            temp=foodPricesArray.get(priceIndex)*q;
            totalBill+=temp;
        }
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    private double totalBill;
    private String customerUsername;
    private String riderUsername;
    private String foodname;
    private String deliveryStatus=null;
    protected ArrayList<String> foodNameArray = new ArrayList<>();
    protected ArrayList<Double> foodPricesArray = new ArrayList<>();

    public Order(String customerUsername, String restaurantUsername, String foodname, int quantity) {
        this.restaurantUsername = restaurantUsername;
        this.customerUsername = customerUsername;
        this.riderUsername = riderUsername;
        this.foodname = foodname;
        this.timeOfOrder = timeOfOrder;
        this.quantity = quantity;
    }

    public double getFoodPrice() {
        return foodPrice;
    }

    public void setFoodPrice(double foodPrice) {
        this.foodPrice = foodPrice;
    }

    //below given const is for add to cart
    public Order(String customerUsername, String restaurantUsername, String foodname, int quantity, double foodPrice) {
        this.restaurantUsername = restaurantUsername;
        this.customerUsername = customerUsername;
        this.riderUsername = riderUsername;
        this.foodname = foodname;
        this.timeOfOrder = timeOfOrder;
        this.quantity = quantity;
        this.foodPrice=foodPrice;
    }
    //below one is for placeAllOrders of cart method
    public Order(String customerUsername, String restaurantUsername) {
        this.restaurantUsername = restaurantUsername;
        this.customerUsername = customerUsername;
    }

    private String paymentStatus=null;
    private Date timeOfOrder;
//    private double totalBill;
    private int quantity;
    private ArrayList<Integer> quantityArray = new ArrayList<>();
    private ArrayList<Double> pricesArray = new ArrayList<>();
    private ArrayList<String> foodItemsArray = new ArrayList<>();
    //for multiple items in an order while finalising the cart or whatever
    public void calculateBill(){

    }

    public Date getTimeOfOrder() {
        return timeOfOrder;
    }

    public void setTimeOfOrder(Date TOO) {
        this.timeOfOrder = TOO;
    }

    private static int orderNumber=0;
    private static int billNumber=0;

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getRestaurantUsername() {
        return restaurantUsername;
    }

    public void setRestaurantUsername(String restaurantUsername) {
        this.restaurantUsername = restaurantUsername;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }

    public String getRiderUsername() {
        return riderUsername;
    }

    public void setRiderUsername(String riderUsername) {
        this.riderUsername = riderUsername;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public Order() {
    }

    public void setOrderNumber() {
      int temp;
        ++orderNumber;
        temp=orderNumber;
        orderNumber = temp;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber() {
        int temp;
        ++billNumber;
        temp=billNumber;
        this.billNumber = temp;
    }

    public Order(String restaurantUsername, String customerUsername, String riderUsername, String foodname) {
        this.restaurantUsername = restaurantUsername;
        this.customerUsername = customerUsername;
        this.riderUsername = riderUsername;
        this.foodname=foodname;
    }
    public void displayOrder(int customerIndex){
        for(int i=0; i<Admin.orderObjects.size(); i++){
         //   for(int j=0; j<Admin.customerObjectsArray.size(); j++){
                if(Admin.orderObjects.get(i).getCustomerUsername().equalsIgnoreCase(Admin.customerObjectsArray.get(customerIndex).getCustomerUserName())) {
                    int orderIndex=i;
                   // int customerIndex=j;
                    //Matched
                    //just display the already stored data
                    System.out.println("Customer name: "+ Admin.orderObjects.get(orderIndex).getCustomerUsername());
                    for(int restObj=0; restObj<Admin.restaurantObjectsArray.size(); restObj++){
                        if(Admin.restaurantObjectsArray.get(restObj).getRestaurantUserName().
                                equalsIgnoreCase(Admin.orderObjects.get(orderIndex).getRestaurantUsername())) {
                            System.out.println("Restaurant name: " + Admin.restaurantObjectsArray.get(restObj).getRestaurantName());
                        }
                    }
                    for(int riderIndex=0; riderIndex<Admin.riderObjectsArray.size(); riderIndex++){
                        if((Admin.riderObjectsArray.get(riderIndex).getRiderUserName()).
                                equalsIgnoreCase(Admin.orderObjects.get(orderIndex).getRiderUsername())) {
                            System.out.println("Rider name: " + Admin.riderObjectsArray.get(riderIndex).getRiderName());
                        }
                    }
                    System.out.println("Order number: "+ Admin.orderObjects.get(orderIndex).getOrderNumber());
                    System.out.println("Billing number: "+ Admin.orderObjects.get(orderIndex).getBillNumber());
                    System.out.println("Time of order: "+ Admin.orderObjects.get(orderIndex).getTimeOfOrder());

                    System.out.println("Total Bill: ");

                }
          //  }


        }

    }
    public void displayAllFoodsOnCart(){
        for(int foodItem=0; foodItem<foodNameArray.size(); foodItem++){
            System.out.println("Food name: "+foodNameArray.get(foodItem));
            System.out.println("Food price: "+foodPricesArray.get(foodItem));
        }
    }
    public Order(String foodName, int foodQuantity, double foodPrice){
        foodNameArray.add(foodName);
        foodQuantityArray.add(foodQuantity);
        foodPricesArray.add(foodPrice);

    }
}
