import java.util.ArrayList;
import java.util.Scanner;

public class Restaurant implements RestaurantInterface {
    private static int restaurantIndex;
    private static boolean restaurantFound;
    private String restaurantName;
    private String restaurantAddress;
    private Long restaurantContactNumber;
    private String restaurantUserName;
    private String restaurantPassword;
    private boolean deliveryStatus = false;

    //    private ArrayList<Order> cartArray = new ArrayList<>();
    public void setDeliveryStatus(boolean deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public boolean isDeliveryStatus() {
        return deliveryStatus;
    }

    private static boolean restaurantVerifiedFlag = false;
    private boolean noMatchinguserName = false;
    private ArrayList<String> restaurantNames = new ArrayList<>();
    protected ArrayList<Food> foodObjects = new ArrayList<>();

    public Restaurant() {

    }


    public void setRestaurantNames(ArrayList<String> restaurantNames) {
        this.restaurantNames = restaurantNames;
    }

    public void setRestaurantAddresses(ArrayList<String> restaurantAddresses) {
        this.restaurantAddresses = restaurantAddresses;
    }

    public void setRestaurantContactNumbers(ArrayList<Long> restaurantContactNumbers) {
        this.restaurantContactNumbers = restaurantContactNumbers;
    }

    public void setRestaurantUserNames(ArrayList<String> restaurantUserNames) {
        this.restaurantUserNames = restaurantUserNames;
    }

    public void setRestaurantPasswords(ArrayList<String> restaurantPasswords) {
        this.restaurantPasswords = restaurantPasswords;
    }

    private ArrayList<String> restaurantAddresses = new ArrayList<>();
    private ArrayList<Long> restaurantContactNumbers = new ArrayList<>();
    private ArrayList<String> restaurantUserNames = new ArrayList<>();
    private ArrayList<String> restaurantPasswords = new ArrayList<>();

    public ArrayList<String> getRestaurantNames() {
        for (int i = 0; i < restaurantNames.size(); i++) {
            System.out.println(restaurantNames.get(i));
        }
        return restaurantNames;
    }

    public ArrayList<String> searchRestaurantNames(String name) {
        return restaurantNames;              //erooooorrr
    }

    public ArrayList<String> getRestaurantAddresses() {
        return restaurantAddresses;
    }

    public ArrayList<Long> getRestaurantContactNumbers() {
        return restaurantContactNumbers;
    }

    public ArrayList<String> getRestaurantUserNames() {
        return restaurantUserNames;
    }

    public ArrayList<String> getRestaurantPasswords() {
        return restaurantPasswords;
    }

    Scanner restaurantScanner = new Scanner(System.in);

    public void setRestaurantAddress() {
        String address;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter restaurant address: ");
        address = sc.nextLine();
        restaurantAddresses.add(address);
    }

    public void setRestaurantContactNumber() {
        Long number;
        System.out.println("Enter restaurant number: ");
        number = restaurantScanner.nextLong();
        restaurantContactNumbers.add(number);
    }

    public void setPassword() {
        String password;
        System.out.println("Enter password: ");
        password = restaurantScanner.next();
        this.password = password;
    }

    public void setRestaurantName() {
        Scanner sc = new Scanner(System.in);
        String name;
        System.out.println("Enter restaurant name: ");
        name = sc.nextLine();
        restaurantName = name;
        restaurantNames.add(name);
    }

    public void setRestaurantUserName() {
        String username;
        System.out.println("Enter restaurant username: ");
        username = restaurantScanner.next();
        if (restaurantUserNames.size() != 0) {
            for (String usname : restaurantUserNames) {
                if (username.equalsIgnoreCase(usname)) {
                    noMatchinguserName = true;
                }
            }
        } else {
            noMatchinguserName = true;
        }
    }

    public void userNameMatched() {
        int indexNumber;
        indexNumber = restaurantNames.size() - 1;
        restaurantNames.remove(indexNumber);
        restaurantAddresses.remove(indexNumber);
        restaurantContactNumbers.remove(indexNumber);

    }

    public void userNameMatched(boolean value) {
        int indexNumber;
        indexNumber = restaurantNames.size() - 1;
        restaurantNames.remove(indexNumber);
        restaurantAddresses.remove(indexNumber);
        restaurantContactNumbers.remove(indexNumber);
        restaurantUserNames.remove(indexNumber);

    }

    public boolean confirmPassword(String password) {
        boolean confirmPasswordFlag = false;
        String passwordAgain;
        System.out.println("Re-enter password: ");
        passwordAgain = restaurantScanner.next();
        if (password.equals(passwordAgain)) {
            confirmPasswordFlag = true;
            return true;
        } else {
            confirmPasswordFlag = false;
            return false;
        }
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public Long getRestaurantContactNumber() {
        return restaurantContactNumber;
    }

    public String getPassword() {
        return password;
    }

    private String password;

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public String getRestaurantUserName() {
        return restaurantUserName;
    }

    public Restaurant(String restaurantName, String restaurantUserName) {
        this.restaurantName = restaurantName;
        this.restaurantUserName = restaurantUserName;
    }

    public Restaurant(String restaurantName, String restaurantAddress, Long restaurantContactNumber, String restaurantUserName, String restaurantPassword) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
        this.restaurantContactNumber = restaurantContactNumber;
        this.restaurantUserName = restaurantUserName;
        this.restaurantPassword = restaurantPassword;
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
        name=scName.nextLine();
        System.out.println("Enter address:");
        address=scAddress.nextLine();
        System.out.println("Enter contact number:");
        contactNumber=scContactNumber.nextLong();
        System.out.println("Enter username:");
        username=scUsername.nextLine();
        System.out.println("Enter password:");
        password=scPassword.nextLine();
        Restaurant restObjToBeStored = new Restaurant(name, address, contactNumber, username, password);
        Admin.tempRestaurantsObjectsArray.add(restObjToBeStored);
        System.out.println("Your request of account creation has been sent to the admin." +
                "\n You will get a notification soon about acceptance or rejection.");
    }

    public void loginInfo() {
        Scanner loginInfoScanner = new Scanner(System.in);
        String userName, password;
        System.out.println("Enter username: ");
        userName = loginInfoScanner.nextLine();
        System.out.println("Enter password: ");
        password = loginInfoScanner.nextLine();
        restaurantUserName = userName;
        restaurantPassword = password;
    }

    public void verifyLoginInfo(String userName, String password) {
        //System.out.println(name + userName + password);

        for(int restaurantIndex=0; restaurantIndex<Admin.restaurantObjectsArray.size(); restaurantIndex++) {
            if (userName.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).getRestaurantUserName())) {
                if (password.equals(Admin.restaurantObjectsArray.get(restaurantIndex).getRestaurantPassword())) {
                    System.out.println("Login successfully");
                    int foodChoice;
                    Scanner foodScanner = new Scanner(System.in);
                    System.out.println("Below are the operation that you can perform by entering their respective numbers:" +
                            "\n1)Add a food item" +
                            "\n2)Update a food item" +
                            "\n3)Delete a food item" +
                            "\n4)View all the food orders" +
                            "\n5)View Delivery Status of a particular order" +
                            "\n6)View all the feedback about the restaurant");
                    foodChoice=foodScanner.nextInt();
                    if(foodChoice==1){
                        Admin.restaurantObjectsArray.get(restaurantIndex).addFoodDetails(restaurantIndex);
                    }
                    else if(foodChoice==2){
                        Admin.restaurantObjectsArray.get(restaurantIndex).updateFoodDetails(restaurantIndex);

                    }
                    else if(foodChoice==3){
                        Admin.restaurantObjectsArray.get(restaurantIndex).deleteFood(restaurantIndex);
                    }
                    else if(foodChoice==4){

                        }
                    else if(foodChoice==5){

                    }
                    else if(foodChoice==6){
                        viewFeedback();
                    }
                    else{

                    }
                }
            }
        }

//        boolean userNameFlag = false, passwordFlag = false;
//
//            for(Restaurant restStr : Admin.restaurantObjectsArray) {
//                if ((userName.equals(restStr.restaurantUserName))){
//                    if((password.equals(restStr.restaurantPassword))){
////                        restaurantIndex=i;
//                        restaurantFound=true;
//                        System.out.println("Restaurant verified successfully.");
//                        System.out.println("Press 1 to add a food.\n Press 2 to update a food.\n Press 3 to delete a food");
//                        Scanner foodManipScanner = new Scanner(System.in);
//                        int foodManipChoice;
//                        foodManipChoice = foodManipScanner.nextInt();
//                        if (foodManipChoice == 1) {
//                            addFoodDetails(restaurantIndex);
//                        } else if (foodManipChoice == 2) {
//                            updateFoodDetails(restaurantIndex);
//                        } else if (foodManipChoice == 3) {
//                            deleteFood(restaurantIndex);
//                        } else {
//                            System.out.println("Wrong choice entered for food manipulation");
//                        }
//                    }
//                }
//            }
    }

        @Override
        public void login () {
            loginInfo();
            verifyLoginInfo(restaurantUserName, restaurantPassword);
                //find restaurant bulao aur parameters mein rest obj pass krao
                //because dude has already logged in
        }
        public void findRestaurant () {
            restaurantIndex = 0;
            restaurantFound = false;
            String restName;
            System.out.println("Enter restaurant name: ");
            Scanner updateScanner = new Scanner(System.in);
            restName = updateScanner.nextLine();
            for (int i = 0; i < Admin.restaurantObjectsArray.size(); i++) {
                if (restName.equalsIgnoreCase(Admin.restaurantObjectsArray.get(i).getRestaurantName())) {
                    restaurantIndex = i;
                    restaurantFound = true;
                }
            }
        }
        public void findRestaurant (String username){
            restaurantIndex = 0;
            restaurantFound = false;
//        String restName;
//        System.out.println("Enter restaurant name: ");
//        Scanner updateScanner = new Scanner(System.in);
//        restName=updateScanner.nextLine();
            for (int i = 0; i < Admin.restaurantObjectsArray.size(); i++) {
                if (username.equalsIgnoreCase(Admin.restaurantObjectsArray.get(i).getRestaurantUserName())) {
                    restaurantIndex = i;
                    restaurantFound = true;
                }
            }
        }
        @Override
        public void addFoodDetails ( int restaurantIndex){
            String name, des;
            double price;
            System.out.println("Enter food name: ");
            Scanner n = new Scanner(System.in);
            name = n.nextLine();
            System.out.println("Enter food price: ");
            Scanner p = new Scanner(System.in);
            price = p.nextDouble();
            System.out.println("Enter food description: ");
            Scanner d = new Scanner(System.in);
            des = d.nextLine();
            Food foodObj = new Food(name, price, des);
            Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.add(foodObj);
        }
        @Override
        public void updateFoodDetails ( int restaurantIndex){
            int foodIndex = 0;
            boolean foodFound = false;
            String inputItem;
//        System.out.println("Enter restaurant name: ");
//        Scanner updateScanner = new Scanner(System.in);
//        restName=updateScanner.nextLine();
//        for(int i=0; i<Admin.restaurantObjectsArray.size(); i++) {
//        if(restName.equalsIgnoreCase(Admin.restaurantObjectsArray.get(i).getRestaurantName())){
//            restaurantIndex=i;
//            restaurantFound=true;
//        }
//        }
            System.out.println("Enter food item name:");
            Scanner updateScanner2 = new Scanner(System.in);
            inputItem = updateScanner2.nextLine();
            for (int i = 0; i < Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.size(); i++) {
                if (inputItem.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(i).getFoodName())) {
                    foodIndex = i;
                    foodFound = true;
                }
//                if(inputItem.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(i).getFoodName())){

//                }
            }
            if (foodFound == true) {
                System.out.println("Edit this food item however you like");
                Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).setFoodName();
                Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).setFoodDescription();
                Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(foodIndex).setFoodPrice();
            }
        }

        @Override
        public void deleteFood ( int restaurantIndex){
            int foodIndex = 0;
            boolean foodFound = false;
            String inputItem;
                System.out.println("Enter food item name:");
                Scanner updateScanner2 = new Scanner(System.in);
                inputItem = updateScanner2.nextLine();
                for (int i = 0; i < Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.size(); i++) {
                    if (inputItem.equalsIgnoreCase(Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.get(i).getFoodName())) {
                        foodIndex = i;
                        foodFound = true;
                    }
                }
                if (foodFound == true) {
                    Admin.restaurantObjectsArray.get(restaurantIndex).foodObjects.remove(foodIndex);
                    System.out.println("All details of entered food have been deleted");
                }
        }
        @Override
        public void checkFoodOrder (int restaurantIndex) {
            System.out.println("==============================");
            for(int foodObj=0; foodObj<Admin.orderObjects.size(); foodObj++){
                if(Admin.restaurantObjectsArray.get(restaurantIndex).getRestaurantUserName().
                        equals(Admin.orderObjects.get(foodObj).getRestaurantUsername())){
                    System.out.println("Billing number: " + Admin.orderObjects.get(foodObj).getBillNumber());
                    System.out.println("Order number: " + Admin.orderObjects.get(foodObj).getOrderNumber());
                    System.out.println("Time of order: " + Admin.orderObjects.get(foodObj));    //set it
                    System.out.println("Delivery status: " + Admin.orderObjects.get(foodObj).getDeliveryStatus());
                    System.out.println("Payment status: " + Admin.orderObjects.get(foodObj).getPaymentStatus());
                    for(int riderObj = 0; riderObj<Admin.riderObjectsArray.size(); riderObj++) {
                        if(Admin.riderObjectsArray.get(riderObj).getRiderUserName().
                                equals(Admin.orderObjects.get(foodObj).getRiderUsername())){
                            //match for rider username found
                            System.out.println("Rider name: " + Admin.riderObjectsArray.get(riderObj).getRiderName());
                            System.out.println("Rider bike number: " + Admin.riderObjectsArray.get(riderObj).getRiderBikeNumber());
                            System.out.println("Rider contact number: " + Admin.riderObjectsArray.get(riderObj).getRiderContactNumber());
                            System.out.println("Rider username: " + Admin.riderObjectsArray.get(riderObj).getRiderUserName());

                        }
                        for (int customerObj = 0; customerObj < Admin.customerObjectsArray.size(); customerObj++) {
                            if (Admin.customerObjectsArray.get(customerObj).getCustomerUserName().
                                    equals(Admin.orderObjects.get(foodObj).getRestaurantUsername())) {
                                System.out.println("Customer name: " + Admin.orderObjects.get(foodObj).getRestaurantUsername());
                                System.out.println("Customer address: " + Admin.orderObjects.get(foodObj).getRestaurantUsername());
                                System.out.println("Customer username: " + Admin.orderObjects.get(foodObj).getRestaurantUsername());
                                System.out.println("Customer contact number: " + Admin.orderObjects.get(foodObj).getRestaurantUsername());
                            }
                        }
                        System.out.println("==============================");
                    }
                }
            }
        }
        @Override
        public boolean updateDeliveryStatus () {
            int localStatus;
            System.out.println("Press 1 if delivery is done. Press any other integer if it isn't done: ");
            Scanner deliveryScanner = new Scanner(System.in);
            localStatus = deliveryScanner.nextInt();
            if (localStatus == 1) {
                setDeliveryStatus(true);
            } else {
                setDeliveryStatus(false);
            }
            return false;
        }

        @Override
        public void calculateBills () {
        //in customer where order was placed
            //take quantity as well
            //charges of the rider will be an add-on


        }



    public String getRestaurantPassword() {
        return restaurantPassword;
    }

    public void setRestaurantPassword(String restaurantPassword) {
        this.restaurantPassword = restaurantPassword;
    }
    public void displayMenu(int restIndex){
        System.out.println("=================================");
        for(int foodItemIndex = 0; foodItemIndex<Admin.restaurantObjectsArray.get(restIndex).foodObjects.size(); foodItemIndex++){
            System.out.println("Food item name: " + Admin.restaurantObjectsArray.get(restIndex).foodObjects.get(foodItemIndex).getFoodName());
            System.out.println("Food item description: " + Admin.restaurantObjectsArray.get(restIndex).foodObjects.get(foodItemIndex).getFoodDescription());
            System.out.println("Food item price: " + Admin.restaurantObjectsArray.get(restIndex).foodObjects.get(foodItemIndex).getFoodPrice());
            System.out.println("=================================");
        }
    }
    public void viewFeedback(){
        System.out.println("Below are names of the customers, " +
                "\ntheir order numbers and their feedbacks about the restaurant:");
        for(int o=0; o<Admin.orderObjects.size(); o++){
            System.out.println("Order number: "+Admin.orderObjects.get(o).getOrderNumber());
            System.out.println("Customer username: "+Admin.orderObjects.get(o).getCustomerUsername());
            System.out.println("Customer Feedback: "+Admin.orderObjects.get(o).getFeedback());
        }

    }
}