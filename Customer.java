import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;
public class Customer extends Person implements CustomerInterface{
    private String name;
    private String address;
    protected String userName;
    protected String password;
    private String customerName;
    private String customerAddress;
    private Long customerContactNumber;
    private String customerUserName;
    private String blockedUsername;
    public boolean isOrderCompleted() {
        return isOrderCompleted;
    }

    public void setOrderCompleted(boolean orderCompleted) {
        isOrderCompleted = orderCompleted;
    }

    private boolean isOrderCompleted=true;

    public String getBlockedUsername() {
        return blockedUsername;
    }

    public void setBlockedUsername(String blockedUsername) {
        this.blockedUsername = blockedUsername;
    }

    public String getBlockingReason() {
        return blockingReason;
    }

    public void setBlockingReason(String blockingReason) {
        this.blockingReason = blockingReason;
    }

    private String blockingReason;

    public Long getCustomerContactNumber() {
        return customerContactNumber;
    }

    public void setCustomerContactNumber(Long customerContactNumber) {
        this.customerContactNumber = customerContactNumber;
    }

    private String customerPassword;
    protected  ArrayList<Order> customerCart = new ArrayList<>();

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setCustomerUserName(String customerUserName) {
        this.customerUserName = customerUserName;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    private boolean customerVerifiedFlag =false;
    boolean noMatchingUserName=false;
    public void setCustomerVerifiedFlag(boolean customerVerifiedFlag) {
        this.customerVerifiedFlag = customerVerifiedFlag;
    }

    public boolean isCustomerVerifiedFlag() {
        return customerVerifiedFlag;
    }

    private String reEnteredPassword;
    private ArrayList<String> customerNames = new ArrayList<>();
    private ArrayList<String> customerAddresses = new ArrayList<>();
    private ArrayList<String> customerUserNames = new ArrayList<>();
    private ArrayList<String> customerPasswords = new ArrayList<>();
    private ArrayList<Order>  customerOrderHistory= new ArrayList<>();
    Scanner customerScanner = new Scanner(System.in);
    //====setter staerted
    public void setName() {
        String name;
        System.out.println("Enter name: ");
        name=customerScanner.nextLine();
        customerNames.add(name);

    }

    public void setUserName() {
        noMatchingUserName = false;
        String enteredUsername;
        System.out.println("Enter userName: ");
        enteredUsername=customerScanner.nextLine();
        for(Customer custArray : Admin.customerObjectsArray){
            for (String userNames : custArray.customerUserNames) {
                if (userNames.equalsIgnoreCase(enteredUsername)) {
                    noMatchingUserName = false;
                    System.out.println("This username already exists");
                }
                if(noMatchingUserName==true){
                    System.out.println("Your username is unique. I am saving it.");


                }
            }
        }
    }

    public void setPassword() {
        String password;
        System.out.println("Enter password: ");
        password=customerScanner.nextLine();
        customerPasswords.add(password);
    }
    public boolean confirmPassword(String password) {
        boolean confirmPasswordFlag=false;
        String passwordAgain;
        System.out.println("Re-enter password: ");
        passwordAgain=customerScanner.nextLine();
        if(password.equals(passwordAgain)){
            confirmPasswordFlag=true;
            return confirmPasswordFlag;
        }
        else{
            confirmPasswordFlag=false;
            return confirmPasswordFlag;
        }
    }
    public void setAddress() {
        String address;
        System.out.println("Enter address: ");
        address=customerScanner.nextLine();
        customerAddresses.add(address);
    }


    public void setCustomerOrder(ArrayList<Order> customerOrder) {
        this.customerOrderHistory = customerOrder;
    }
//=========setters ended
    //========login attributes will be checked by following methods
    public void loginInfo(){
        String userName, password;
        System.out.println("Enter username: ");
        userName=customerScanner.nextLine();
        System.out.println("Enter password: ");
        password=customerScanner.nextLine();
        this.userName=userName;
        this.password=password;
    }
    public void verifyLoginInfo(String userName, String password){
//        try{
//            File custAccDetails = new File("C:\\Users\\Shah Rukh Ghazaan\\IdeaProjects\\Foodies\\src\\CustomerData");
//
//            FileReader rw = new FileReader(custAccDetails);
//            BufferedReader reader = new BufferedReader(rw);
//            for(int r=0; r<Admin.customerObjectsArray.size(); r++) {
//                Admin.customerObjectsArray.add(rw.re);
//
//            }
//
//        }
//        catch(IOException e){
//
//        }
        boolean breakFlag=false;
        boolean blockFlag=false;
        for (int b=0; b<Admin.blockedCustomersArray.size(); b++) {
            if (userName.equals(Admin.blockedCustomersArray.get(b).getCustomerName())) {
                blockFlag=true;
            }
        }
        if(blockFlag) {
            System.out.println("Sorry. You can not login. You have been blocked due to some reason.");
        }
        else{
                for (int i = 0; i < Admin.customerObjectsArray.size(); i++) {
                    if (userName.equalsIgnoreCase(Admin.customerObjectsArray.get(i).getCustomerUserName())) {
                        if (password.equals(Admin.customerObjectsArray.get(i).getCustomerPassword())) {
                            //login verified
                            breakFlag = true;
                            {  //oprations block strated
                                Admin.customerObjectsArray.get(i).viewRestaurants(i);


                            }


                        }
                        break;
                    }
                    if (breakFlag) {
                        break;
                    }


                }
            }

     }

    public void userNameMatched(){
        int indexNumber;
        indexNumber=customerNames.size()-1;
        customerNames.remove(indexNumber);
        customerAddresses.remove(indexNumber);

    }
    public void userNameMatched(boolean value){
        int indexNumber;
        indexNumber=customerNames.size()-1;
        customerNames.remove(indexNumber);
        customerAddresses.remove(indexNumber);
        customerUserNames.remove(indexNumber);

    }
    //===========login attributes ended
    //===========cart part started
    //============getters started
    public String getAddress() {
        return address;
    }
    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Order> getCustomerOrder() {
        return customerOrderHistory;
    }
//=====getter ended
    public Customer(String name, String userName, String password) {
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public Customer() {
    }
    @Override
    public void viewRestaurants(int customerIndex) {
        int restaurantIndex = 0;
        boolean restaurantFound=false;
//        int foodIndex=0;
//        boolean foodFound=false;
            int restaurantList;
            Scanner menuScanner = new Scanner(System.in);
            while(true) {
                System.out.println("Press 1 to view restaurants available around you in order to make an order.\nPress 2 to view Order History" +
                        "\nPress 3 to check food delivery status.\n Press 4 to give feedback on a particular order of yours");
                restaurantList = menuScanner.nextInt();
                if (restaurantList == 1) {
                    System.out.println("Below is a list of all available restaurants: " +
                            "\n==============================================");
                    for (int i = 0; i < Admin.restaurantObjectsArray.size(); i++) {
                        System.out.println("Restaurant: " + Admin.restaurantObjectsArray.get(i).getRestaurantName());
                        System.out.println("Restaurant Address: " + Admin.restaurantObjectsArray.get(i).getRestaurantAddress());
                        System.out.println("Restaurant contact number: " + Admin.restaurantObjectsArray.get(i).getRestaurantContactNumber());
                        System.out.println("==============================================");
                    }
                    {
                        String rname;
                        Scanner rnameScanner = new Scanner(System.in);
                        System.out.println("Enter the restaurant name from which you want to order: ");
                        rname = rnameScanner.nextLine();
                        for (int restIndex = 0; restIndex < Admin.restaurantObjectsArray.size(); restIndex++) {
                            if (rname.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restIndex).getRestaurantName())) {
                                Admin.restaurantObjectsArray.get(restIndex).displayMenu(restIndex);
                                System.out.println("Enter the food item name which you want to order: ");
                                String fname;
                                Scanner scFName = new Scanner(System.in);
                                fname=scFName.nextLine();
                                String foodName;
                                boolean foodMatched=false;
                                int foodIndex;
                                for (int fIndex = 0; fIndex<Admin.restaurantObjectsArray.get(restIndex).foodObjects.size(); fIndex++){
                                    if(fname.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restIndex).foodObjects.get(fIndex).getFoodName())){
                                        System.out.println("This food item is available." +
                                                "\nPress 1 to place an order immediately." +
                                                "\nPress 2 to add the food item to cart.");
                                        foodMatched=true;
                                        foodName=fname;
                                        fIndex=fIndex;
                                        int orderChoice;
                                        Scanner scOrderChoice = new Scanner(System.in);
                                        orderChoice=scOrderChoice.nextInt();
                                        if(orderChoice==1){
                                            boolean orderPlacingflag=isOrderCompleted();
                                            if(orderPlacingflag) {
                                                Admin.customerObjectsArray.get(customerIndex).placeOrder(customerIndex, restIndex, fIndex, fname);
                                            }
                                            else{
                                                System.out.println("You have already placed an order." +
                                                        "\n You can only place another order when first one has completed");
                                            }

                                        }
                                        else if(orderChoice==2) {
                                            boolean orderPlacingflag = isOrderCompleted();
                                            if (orderPlacingflag) {
                                                Admin.customerObjectsArray.get(customerIndex).addToCart(customerIndex, restIndex, fIndex, fname);
                                            } else {
                                                System.out.println("You have already placed an order." +
                                                        "\n You can only place another order when first one has completed");
                                            }
                                        }
                                        else{
                                            System.out.println("Invalid choice has been selected");
                                        }

                                    }
                                }
                                if(!foodMatched){
                                    System.out.println("Food item with this name not found. Try other keywords");
                                }
                                restIndex = restIndex;
                                restaurantFound = true;
//                                System.out.println("Restaurant found!!!");


                             //   placeOrder(customerIndex, restIndex );

                            }
                        }
                    }
                    {
                        //=============show the whole menu=================
                        String inputItem;
                        if (restaurantFound == true) {
                            //=======save it for itemSearch

                    }
                         else {
                            System.out.println("Restaurant not found.");
                        }
                    }
                }
                else if (restaurantList==2){
                    viewOrderHistory(customerIndex);

                }
                else if (restaurantList==3){
                    checkDeliveryStatus();

                }
                else if (restaurantList==4){
                    giveFeedback();

                }
                else{
                    System.out.println("Going back to previous menu");
                    break;
                }
            }
        }
    public Customer(String customerName, String customerAddress, Long customerContactNumber, String customerUserName, String customerPassword) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerContactNumber = customerContactNumber;
        this.customerUserName = customerUserName;
        this.customerPassword = customerPassword;
    }

    @Override
    public void createAccount() {
        Scanner scName = new Scanner(System.in);
        Scanner scAddress = new Scanner(System.in);
        Scanner scContactNumber = new Scanner(System.in);
        Scanner scUsername = new Scanner(System.in);
        Scanner scPassword = new Scanner(System.in);
        String name, address, username, password;
        Long contactNumber;
        System.out.println("Enter name:");
        name = scName.nextLine();
        System.out.println("Enter address:");
        address = scAddress.nextLine();
        System.out.println("Enter contact number:");
        contactNumber = scContactNumber.nextLong();
        String custUsername, riderUsername, restUsername, foodname;
        System.out.println("Enter username:");
        username = scUsername.nextLine();
        System.out.println("Enter password:");
        password = scPassword.nextLine();
        Customer custObj = new Customer(name, address, contactNumber, username, password);
        Admin.customerObjectsArray.add(custObj);
//        try{
//            File custAccFile = new File("CustomerData.txt");
//            FileWriter writer = new FileWriter(custAccFile);
//            for(int w=0; w<Admin.customerObjectsArray.size(); w++) {
//                Customer cObj = Admin.customerObjectsArray.get(w);
//                writer.write(cObj+"\n");
//            }
//            writer.close();
//        }catch (IOException e){
//            System.out.println("File of customer's new account was not created. Some error occurred");
//        }
    }
    @Override
    public void login() {
    loginInfo();
    }
    @Override
    public void addToCart(int customerIndex, int restaurantIndex, int foodIndex, String inputItem) {
        System.out.println("Enter the quantity: ");
        Scanner scQuantity = new Scanner(System.in);
        int quantity;
        quantity=scQuantity.nextInt();
        String custUsername, riderUsername, restUsername, foodname;
        double foodPrice;
        custUsername = Admin.customerObjectsArray.get(customerIndex).getCustomerUserName();
        restUsername = Admin.restaurantObjectsArray.get(restaurantIndex).getRestaurantUserName();
        foodname = Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).getFoodName();
        foodPrice=Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).getFoodPrice();
        Order orderObj = new Order(custUsername, restUsername, foodname, quantity, foodPrice);
        customerCart.add(orderObj);
    }
    @Override
    public void checkout(int customerIndex, int restaurantIndex){
        //need multiple foods only
        String custUN=null, restUN=null;
        int ordersIndex=0;
        for(int orderIndex = 0; orderIndex<Admin.orderObjects.size(); orderIndex++) {
            for (int orders = 0; orders < Admin.customerObjectsArray.get(customerIndex).customerCart.size(); orders++) {
                if (Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getCustomerUsername().equalsIgnoreCase
                        (Admin.orderObjects.get(orderIndex).getCustomerUsername())){
                    ordersIndex=orders;
                    Admin.orderObjects.get(orderIndex).foodNameArray.add(
                            Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getFoodname());
                    Admin.orderObjects.get(orderIndex).foodPricesArray.add(
                            Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getFoodPrice());
                    Admin.orderObjects.get(orderIndex).foodQuantityArray.add(
                            Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getFoodQuantity());
                    custUN=Admin.customerObjectsArray.get(customerIndex).getCustomerName();
                    restUN=Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getRestaurantUsername();
                }
            }
        }
        {
            Order finalOrderObj = new Order(custUN, restUN);
            Date timeOfOrder = new Date();
            finalOrderObj.setTimeOfOrder(timeOfOrder);
            finalOrderObj.setOrderNumber();
            finalOrderObj.setBillNumber();
            Rider tempRiderObj = new Rider();
            tempRiderObj.assignOrderToRider(finalOrderObj.getOrderNumber());
            for (int i = 0; i < Admin.riderObjectsArray.size(); i++) {
                if (finalOrderObj.getOrderNumber() == Admin.riderObjectsArray.get(i).getNewOrderNumber()) {
                    finalOrderObj.setRiderUsername(Admin.riderObjectsArray.get(i).getRiderUserName());
                }
            }
            finalOrderObj.calculateTotalBill(customerIndex, ordersIndex);
            System.out.println("Press 1 to view the items in cart." +
                    "\nPress 2 to update cart." +
                    "\nPress 0 to proceed placing the order of all the items added in cart.");
            Scanner scCart = new Scanner(System.in);
            int cartChoice;
            cartChoice=scCart.nextInt();
            if(cartChoice==1){
                finalOrderObj.displayAllFoodsOnCart();
            }
            else if(cartChoice==2){

                System.out.println("Enter the name of the food item you want to remove from cart: ");
                Scanner scName = new Scanner(System.in);
                String name;
                name=scName.nextLine();
                for (int orders = 0; orders < Admin.customerObjectsArray.get(customerIndex).customerCart.size(); orders++) {
                    if (Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getFoodname().equalsIgnoreCase
                            (name)){
                        Admin.customerObjectsArray.get(customerIndex).customerCart.remove(orders);
                        System.out.println("That food order has been removed");
                    }
            }
            }
            else if(cartChoice==0) {
                setOrderCompleted(false);
                System.out.println("All Orders in cart have been placed");
                for (int orders = 0; orders < Admin.customerObjectsArray.get(customerIndex).customerCart.size(); orders++) {
                    System.out.println("Total Bill: ");
                    Admin.customerObjectsArray.get(customerIndex).customerCart.get(orders).getTotalBill();
                }
            }
            else{
                System.out.println("Invalid entry.");
            }
        }
////////////


    }

    @Override
    public void placeOrder(int customerIndex, int restaurantIndex, int foodIndex, String inputItem) {        //no need for rider index as that is yet to be assigned
        // String inputItem;
        boolean foodFound = false;
//        System.out.println("Enter food item name:");
//        Scanner updateScanner2 = new Scanner(System.in);
//        inputItem = updateScanner2.nextLine();
        for (int fIndex = 0; fIndex < Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.size(); fIndex++) {
            if (inputItem.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(fIndex).getFoodName())) {
                foodIndex = fIndex;
                foodFound = true;
                break;
            }
        }
        if (foodFound == true) {
            //place the order
            //call the order constructor
            //pass the already done data here
            System.out.println("Enter the quantity: ");
            Scanner scQuantity = new Scanner(System.in);
            int quantity;
            quantity=scQuantity.nextInt();
//            int orderNo;
            String custUsername, riderUsername, restUsername, foodname;
            custUsername = Admin.customerObjectsArray.get(customerIndex).getCustomerUserName();
            restUsername = Admin.restaurantObjectsArray.get(restaurantIndex).getRestaurantUserName();
            foodname = Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).getFoodName();
            {
                Order orderObj = new Order(custUsername, restUsername, foodname, quantity);
                orderObj.setBillNumber();
                orderObj.setOrderNumber();
                Date timeOfOrder = new Date();
                orderObj.setTimeOfOrder(timeOfOrder);
                Rider tempRiderObj = new Rider();
                tempRiderObj.assignOrderToRider(orderObj.getOrderNumber());
                for (int i = 0; i < Admin.riderObjectsArray.size(); i++) {
                    if (orderObj.getOrderNumber() == Admin.riderObjectsArray.get(i).getNewOrderNumber()) {
                        orderObj.setRiderUsername(Admin.riderObjectsArray.get(i).getRiderUserName());
                    }
                }
                Admin.orderObjects.add(orderObj);
                customerOrderHistory.add(orderObj);
                setOrderCompleted(false);
                System.out.println("Do you want to add something else in your order?" +
                        "\nPress 1 for yes" +
                        "\nPress 2 for No" +
                        "\nPress 3 to cancel entire order");
                Scanner ch = new Scanner(System.in);
                int c=ch.nextInt();
                if(c==1) {
                    while (true) {
                        Admin.restaurantObjectsArray.get(restaurantIndex).displayMenu(restaurantIndex);
                        System.out.println("Enter the food item name which you want to order: ");
                        String fname;
                        Scanner scFName = new Scanner(System.in);
                        fname = scFName.nextLine();
                        String foodName;
                        boolean foodMatched = false;
                        int fIndexSaver;
                        for (int fIndex = 0; fIndex < Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.size(); fIndex++) {
                            if (fname.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(fIndex).getFoodName())) {
                                System.out.println("Enter quantity: ");
                                Scanner scQ = new Scanner(System.in);
                                int q;
                                q = scQ.nextInt();
                                double price = 0;
                                for (int i = 0; i < Admin.restaurantObjectsArray.size(); i++) {
                                    if (Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(i).getFoodName().
                                            equalsIgnoreCase(fname)) {
                                        price = Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(i).getFoodPrice();
                                    }
                                }
                                orderObj.foodNameArray.add(fname);
                                orderObj.foodQuantityArray.add(q);
                                orderObj.foodPricesArray.add(price);
                            }
                        }
                        System.out.println("Do you want to add something else." +
                                "\nPress 1 for yes." +
                                "\nPress 2 for no");
                        Scanner sc = new Scanner(System.in);
                        int scCh=sc.nextInt();
                        if(scCh==1){
                            continue;

                        }
                        else if(scCh==2){
                            break;

                        }
                        else{
                            System.out.println("invalid entry");
                            continue;
                        }

                    }
                }
                else if(c==2){
                }
                else if(c==3){
                    for(int z=0; z<Admin.orderObjects.size(); z++){
                        if(Admin.orderObjects.get(z).getCustomerUsername().equalsIgnoreCase(
                                Admin.customerObjectsArray.get(customerIndex).getCustomerUserName())){
                            cancelOrder(true, z);
                            break;
                        }
                    }
                }
                else{
                    System.out.println("Invalid input");
                }

            }

        } else {
            System.out.println("Food item with this name not found");
        }
//        for (int i = 0; i < Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.size(); i++) {
//        }
//
    }

    @Override
    public void trackOrder() {

    }

    @Override
    public void cancelOrder(int customerIndex) {
        System.out.println("Enter the food item name which you want to cancel: ");
        Scanner scName = new Scanner(System.in);
        String name;
        name=scName.nextLine();
        for (int i=0; i<Admin.orderObjects.size(); i++){
            if(Admin.customerObjectsArray.get(customerIndex).customerUserName.equalsIgnoreCase(Admin.orderObjects.get(i).getCustomerUsername())){
                for(int it=0; it<Admin.orderObjects.size(); it++) {
                    if (name.equalsIgnoreCase(Admin.orderObjects.get(i).getFoodname()) ||
                            name.equalsIgnoreCase(Admin.orderObjects.get(i).foodNameArray.get(it))) {
                        Admin.orderObjects.remove(i);
                        System.out.println("Selected order has been removed");
                    }
                }
            }
        }
    }
    public void cancelOrder(boolean t, int orderIndex) {
//        System.out.println("Enter the food item name which you want to cancel: ");
//        Scanner scName = new Scanner(System.in);
//        String name;
//        name=scName.nextLine();
                        Admin.orderObjects.remove(orderIndex);
                        System.out.println("Selected order has been removed");
                    }

    @Override
    public void updateCart() {

    }


    @Override
    public void payCOD() {

    }

    @Override
    public void checkDeliveryStatus() {

    }
    Customer(String blockedUsername, String blockingReason){
        this.blockedUsername=blockedUsername;
        this.blockingReason=blockingReason;
    }
    public void viewOrderHistory(int custIndex){
        for(int h=0; h<Admin.customerObjectsArray.get(custIndex).customerOrderHistory.size(); h++){
            System.out.println("Order no."+h+1);
            System.out.println("Restaurant username: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getRestaurantUsername());
            System.out.println("Rider username: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getRiderUsername());
            System.out.println("Food name: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getFoodname());
            System.out.println("Food quantity: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getFoodQuantity());
            for(int i=0; i<Admin.customerObjectsArray.get(custIndex).customerOrderHistory.size(); i++){
                System.out.println(Admin.customerObjectsArray.get(custIndex).customerOrderHistory.get(h).foodNameArray.get(i));
                System.out.println(Admin.customerObjectsArray.get(custIndex).customerOrderHistory.get(h).foodPricesArray.get(i));
            }
            System.out.println("Time of order: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getTimeOfOrder());
            System.out.println("Total Bill: "+ Admin.customerObjectsArray.get(custIndex).
                    customerOrderHistory.get(h).getTotalBill());

        }
    }
    public void giveFeedback(){
        int restIndex=0;
        String restUN;
        boolean restIndexFound=false;
        System.out.println("Enter restaurant name:");
        Scanner name = new Scanner(System.in);
        String rname=name.nextLine();
        for(int i=0; i<Admin.orderObjects.size(); i++){
            if(customerUserName.equalsIgnoreCase(Admin.orderObjects.get(i).getCustomerUsername())){
                System.out.println("Write down your feed back about the restaurant: ");
                Scanner scFeedback = new Scanner(System.in);
                String feedback = scFeedback.nextLine();
                Admin.orderObjects.get(i).setFeedback(feedback);
                restIndexFound=true;
            }
        }
        if(!restIndexFound) {
            System.out.println("No restaurant from your prior orders found with this name");
        }


    }
}
