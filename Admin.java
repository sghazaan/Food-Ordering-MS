import java.util.ArrayList;
import java.util.Scanner;

public class Admin implements AdminInterface{
    protected static ArrayList<Customer> customerObjectsArray = new ArrayList<>();
    protected static ArrayList<Customer> blockedCustomersArray = new ArrayList<>();
    protected static ArrayList<Restaurant> restaurantObjectsArray = new ArrayList<>();
    protected static ArrayList<Order> orderObjects = new ArrayList<>();
    protected static ArrayList<Rider> riderObjectsArray = new ArrayList<>();
    protected static ArrayList<Restaurant> tempRestaurantsObjectsArray = new ArrayList<>();
    protected static ArrayList<Rider> tempRiderObjectsArray = new ArrayList<>();
    protected static ArrayList<Customer> tempBlockedCustomersArray = new ArrayList<>();
    private String username="admin123";
    private String password="foodies123";


    @Override
    public void adminMenu() {
        while (true){
        System.out.println("===========Welcome to admin menu===========");
        System.out.println("Press 1 to manage riders" +
                "\nPress 2 to manage restaurants" +
                "\nPress 3 to manage restaurant's menu" +
                "\nPress 4 to manage Customers" +
                "\nPress 5 to manage Food Order details" +
                "\nPress 6 to manage Payment details" );
        int c;
        Scanner scC = new Scanner(System.in);
        c = scC.nextInt();
        if (c == 1) {
           manageRiders();
        } else if (c == 2) {
            manageVendors();

        } else if (c == 3) {
            manageVendorProducts();

        } else if (c == 4) {

            manageCustomers();
        } else if (c == 5) {
            manageFoodOrderDetails();


        } else if (c == 6) {
            managePaymentDetails();

        }
        else {
            System.out.println("Invalid entry. Logging out of Admin mode");
            break;

        }
    }


    }

    public void viewRestaurantRequests(){
        System.out.println("Below are all requests for restaurant account creation");
        for(Restaurant restObj : tempRestaurantsObjectsArray){
            System.out.println("Restaurant name: "+restObj.getRestaurantName());
            System.out.println("Restaurant address: "+restObj.getRestaurantAddress());
            System.out.println("Restaurant username: "+restObj.getRestaurantUserName());
            System.out.println("Restaurant contact number: "+restObj.getRestaurantContactNumber());
            System.out.println("======================");

        }
        String rname;
        Scanner rnameScanner = new Scanner(System.in);
        System.out.println("Enter the restaurant name which you want to approve for the app: ");
        rname = rnameScanner.nextLine();
        boolean restFound=false;
        for (int restIndex = 0; restIndex < Admin.tempRestaurantsObjectsArray.size(); restIndex++) {
            if (rname.equalsIgnoreCase(Admin.tempRestaurantsObjectsArray.get(restIndex).getRestaurantName())) {
                restaurantObjectsArray.add(tempRestaurantsObjectsArray.get(restIndex));
                System.out.println("Restaurant "+tempRestaurantsObjectsArray.get(restIndex).getRestaurantName()+
                " has been added to your app");
                restFound=true;
            }
        }
        if(!restFound){
            System.out.println("No match found. Try different keywords for the restaurant names in the waiting list");
        }


}
    public void viewRiderRequests(){
        System.out.println("Below are all pending requests for riders account creation");
        for(Rider restObj : tempRiderObjectsArray){
            System.out.println("Rider name: "+restObj.getRiderName());
            System.out.println("Rider username: "+restObj.getRiderUserName());
            System.out.println("Rider bike number : "+restObj.getRiderBikeNumber());
            System.out.println("Rider contact number: "+restObj.getRiderContactNumber());
            System.out.println("======================");
        }
        String rname;
        Scanner rnameScanner = new Scanner(System.in);
        System.out.println("Enter the rider name which you want to approve for the app: ");
        rname = rnameScanner.nextLine();
        boolean restFound=false;
        for (int restIndex = 0; restIndex < Admin.tempRiderObjectsArray.size(); restIndex++) {
            if (rname.equalsIgnoreCase(Admin.tempRiderObjectsArray.get(restIndex).getRiderName())) {
                riderObjectsArray.add(tempRiderObjectsArray.get(restIndex));
                System.out.println("Rider "+tempRiderObjectsArray.get(restIndex).getRiderName()+
                        " has been added to your app");
                restFound=true;
            }
        }
        if(!restFound){
            System.out.println("No match found. Try different keywords for the rider names in the waiting list");
        }
    }

    @Override
    public void viewBlockRequests() {
        System.out.println("Below are all pending requests for blocked customers by riders");
        for(Customer restObj : tempBlockedCustomersArray){
            System.out.println("Customer username: "+restObj.getBlockedUsername());
            System.out.println("Reason for blocking: "+restObj.getBlockingReason());
            System.out.println("===================");

        }
        String rname;
        Scanner rnameScanner = new Scanner(System.in);
        System.out.println("Enter the username of customer from the requests to block from the app: ");
        rname = rnameScanner.nextLine();
        boolean restFound=false;
        for (int restIndex = 0; restIndex < Admin.tempBlockedCustomersArray.size(); restIndex++) {
            if (rname.equalsIgnoreCase(Admin.tempBlockedCustomersArray.get(restIndex).getBlockedUsername())) {
                blockedCustomersArray.add(tempBlockedCustomersArray.get(restIndex));
                System.out.println("Customer of username: "+tempBlockedCustomersArray.get(restIndex).getBlockedUsername()+
                        " has been added to your app");
                restFound=true;
            }
        }
        if(!restFound){
            System.out.println("No match found. Try different keywords for the customers in the pending block list");
        }

    }

    public void chooseInterface(){
        int interfaceChoice;
        while(true) {
            System.out.println("Press 1 for Customer Interface.\nPress 2 for Restaurant Interface." +
                    "\nPress 3 for Rider Interface");
            Scanner interfaceScanner = new Scanner(System.in);
            interfaceChoice = interfaceScanner.nextInt();
            if (interfaceChoice == 1) {
                int customerChoice;
                Scanner customerScanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Press 1 for create account.\nPress 2 to login.");
                    customerChoice = customerScanner.nextInt();
                    if (customerChoice == 1) {
                        Customer customerobj1 = new Customer();
                        customerobj1.createAccount();
                    } else if (customerChoice == 2) {
                        Customer customerobj2 = new Customer();
                        customerobj2.login();
                        customerobj2.verifyLoginInfo(customerobj2.userName, customerobj2.password);
                    } else {
                        System.out.println("Wrong entry in customer menu");
                        break;
                    }
                }
            } else if (interfaceChoice == 2) {
                int restaurantChoice;
                Scanner restaurantScanner = new Scanner(System.in);
                while (true) {
                    System.out.println("Press 1 for create account.\nPress 2 to login.");
                    restaurantChoice = restaurantScanner.nextInt();
                    if (restaurantChoice == 1) {
                        Restaurant restaurantobj1 = new Restaurant();
                        restaurantobj1.createAccount();
                    } else if (restaurantChoice == 2) {
                        Restaurant restaurantobj2 = new Restaurant();
                        restaurantobj2.login();

                    } else {
                        System.out.println("Wrong entry in customer menu");
                        break;
                    }
                }
            } else if (interfaceChoice == 3) {
                int riderChoice;
                Scanner scRider = new Scanner(System.in);
                System.out.println("Press 1 to create account." +
                        "\nPress 2 to login.");
                riderChoice=scRider.nextInt();
                if(riderChoice==1){
                    Rider riderObj = new Rider();
                    riderObj.createAccount();
                }
                else if(riderChoice==2){
                    Rider riderObj2 = new Rider();
                    riderObj2.loginInfo();
                    riderObj2.loginAccount(riderObj2.getRiderUserName(), riderObj2.getRiderPassword());
                }
                else{

                }

            } else {
                    break;
            }
        }

//        {
//            Customer cs = new Customer();
//            cs.createAccount();
//        }
//        {
//            Customer cs = new Customer();
//            cs.login();
//            {
//                //build other functions
//            }
//        }
    }

    @Override
    public void manageVendors() {
        viewRestaurantRequests();
        while (true) {
            System.out.println("Press 1 to view all restaurants." +
                    "\nPress 2 to delete a restaurant" +
                    "\nPress 3 to view restaurant registration requests");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {
                for(int i=0; i<restaurantObjectsArray.size(); i++){
                    System.out.println("Restaurant name: "+restaurantObjectsArray.get(i).getRestaurantName());
                    System.out.println("Restaurant username: "+restaurantObjectsArray.get(i).getRestaurantUserName());
                    System.out.println("Restaurant address: "+restaurantObjectsArray.get(i).getRestaurantAddress());
                    System.out.println("Restaurant contact number: "+restaurantObjectsArray.get(i).getRestaurantContactNumber());
                    System.out.println("=========================");
                }

            } else if (manageChoice == 2) {
                System.out.println("Enter name: ");
                Scanner scN = new Scanner(System.in);
                String name=scN.nextLine();
                for (int i=0; i<restaurantObjectsArray.size(); i++){
                    if(name.equalsIgnoreCase(restaurantObjectsArray.get(i).getRestaurantName())){
                        restaurantObjectsArray.remove(i);
                    }

                }

            } else if (manageChoice == 3) {
                viewRestaurantRequests();

            }
            else {
                System.out.println("Invalid entry.");
                break;
            }
        }

    }

    @Override
    public void manageVendorProducts() {
        while (true) {
            System.out.println("Press 1 to delete" +
                    "\nPress 2 to read" +
                    "\nPress 3 to update");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {
                System.out.println("Enter the name of the restaurant: ");
                Scanner rest = new Scanner(System.in);
                Scanner food = new Scanner(System.in);
                String r, f;
                r=rest.nextLine();
                for(int restIndex=0; restIndex<restaurantObjectsArray.size(); restIndex++) {
                    if(r.equalsIgnoreCase(restaurantObjectsArray.get(restIndex).getRestaurantName())) {
                        System.out.println("Enter the food name: ");
                        f = food.nextLine();
                        for(int fIn = 0; fIn<restaurantObjectsArray.get(restIndex).foodObjects.size(); fIn++){
                            if(f.equalsIgnoreCase(restaurantObjectsArray.get(restIndex).foodObjects.get(fIn).getFoodName())){
                                restaurantObjectsArray.get(restIndex).foodObjects.remove(fIn);
                                System.out.println("Entered food item removed successfully");
                            }
                        }
                    }
                }
            } else if (manageChoice == 2) {
                System.out.println("Enter the name of the restaurant: ");
                Scanner rest = new Scanner(System.in);
                Scanner food = new Scanner(System.in);
                String r, f;
                r=rest.nextLine();
                for(int restIndex=0; restIndex<restaurantObjectsArray.size(); restIndex++) {
                    if(r.equalsIgnoreCase(restaurantObjectsArray.get(restIndex).getRestaurantName())) {
                        for(int fIn = 0; fIn<restaurantObjectsArray.get(restIndex).foodObjects.size(); fIn++){
                            System.out.println("Food name:" +restaurantObjectsArray.get(restIndex).foodObjects.get(fIn).getFoodName());
                            System.out.println("Food price: "+restaurantObjectsArray.get(restIndex).foodObjects.get(fIn).getFoodPrice());
                            System.out.println("Food description: "+restaurantObjectsArray.get(restIndex).foodObjects.get(fIn).getFoodDescription());
                        }
                    }
                }

            } else if (manageChoice == 3) {

            }
            else {
                System.out.println("Invalid entry.");
                break;
            }
        }


    }

    @Override
    public void manageCustomers() {
        while (true) {
            System.out.println("Press 1 to delete a customer." +
                    "\nPress 2 to view all customers" +
                    "\nPress 3 to view block requests about customers");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {
                System.out.println("Enter name: ");
                Scanner scN = new Scanner(System.in);
                String name=scN.nextLine();
                for(int i=0; i<customerObjectsArray.size(); i++){
                    if(name.equalsIgnoreCase(customerObjectsArray.get(i).getCustomerName())){
                        customerObjectsArray.remove(i);
                        System.out.println("Customer has been deleted successfully");
                    }

                }

            } else if (manageChoice == 2) {
                for(int i=0; i<customerObjectsArray.size(); i++){
                    System.out.println("Customer name: "+customerObjectsArray.get(i).getCustomerName());
                    System.out.println("Customer address: "+customerObjectsArray.get(i).getCustomerAddress());
                    System.out.println("Customer username: "+customerObjectsArray.get(i).getCustomerUserName());
                    System.out.println("===============================");

                }


                } else if (manageChoice == 3) {
                viewBlockedCustomersList();

            }
            else {
                System.out.println("Invalid entry.");
                break;
            }
        }


    }

    @Override
    public void manageFoodOrderDetails() {
        while (true) {
            System.out.println("Press 1 to create." +
                    "\nPress 2 to read" +
                    "\nPress 3 to update" +
                    "\nPress 4 to delete");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {

            } else if (manageChoice == 2) {

            } else if (manageChoice == 3) {

            } else if (manageChoice == 4) {

            } else {
                System.out.println("Invalid entry.");
                break;
            }
        }


    }

    @Override
    public void managePaymentDetails() {
        while (true) {
            System.out.println("Press 1 to create." +
                    "\nPress 2 to read" +
                    "\nPress 3 to update" +
                    "\nPress 4 to delete");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {

            } else if (manageChoice == 2) {

            } else if (manageChoice == 3) {

            } else if (manageChoice == 4) {

            } else {
                System.out.println("Invalid entry.");
                break;
            }
        }


    }

    @Override
    public void manageRiders() {
        while (true) {
            System.out.println("Press 1 to view all riders" +
                    "\nPress 2 to delete a particular rider" +
                    "\nPress 3 to view Riders account registration requests");
            Scanner scManage = new Scanner(System.in);
            int manageChoice = scManage.nextInt();
            if (manageChoice == 1) {
                for(int i=0; i<riderObjectsArray.size(); i++){
                    System.out.println("Rider name: "+riderObjectsArray.get(i).getRiderName());
                    System.out.println("Rider username: "+riderObjectsArray.get(i).getRiderUserName());
                    System.out.println("Rider bike number: "+riderObjectsArray.get(i).getRiderBikeNumber());
                    System.out.println("Rider contact number: "+riderObjectsArray.get(i).getRiderContactNumber());
                    System.out.println("===================================");
                }

            } else if (manageChoice == 2) {
                System.out.println("Enter rider name");
                Scanner scName = new Scanner(System.in);
                String Ridername=scName.nextLine();
                for(int i=0; i<riderObjectsArray.size(); i++){
                    if(Ridername.equalsIgnoreCase(riderObjectsArray.get(i).getRiderName())){
                        riderObjectsArray.remove(i);
                        System.out.println("Rider removed successfully");
                    }
                }


                } else if (manageChoice == 3) {
                viewRiderRequests();

            }
            else {
                System.out.println("Invalid entry.");
                break;
            }
        }


    }
    public void changePassword(){
        Scanner scUS = new Scanner(System.in);
        Scanner scPass = new Scanner(System.in);
        System.out.println("Enter old password");
        String pass1, pass2;
        pass1 = scUS.nextLine();
        if(pass1.equals(password)){
            System.out.println("Enter new password");
            pass2 = scPass.next();
            password=pass2;
            System.out.println("Password has been changed");
        }
        else{
            System.out.println("Incorrect password entered");
        }

    }

    public void viewBlockedCustomersList(){
        for(int i=0; i<blockedCustomersArray.size(); i++){
            System.out.println("Customer name: "+blockedCustomersArray);
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void login() {
        while(true) {
            System.out.println("Press 1 to go to interfaces of customer, restaurant or Rider" +
                    "\nPress 2 to login to Admin." +
                    "\nPress 3 to exit the program");
            Scanner scC = new Scanner(System.in);
            int c;
            c = scC.nextInt();
            if (c == 1) {
                chooseInterface();
            } else if (c == 2) {
                System.out.println("There is only one admin and its username is set to admin123 and password is foodies123 by the developer" +
                        "\nPress 0 to change password." +
                        "\nPress 1 to proceed logging in");
                Scanner scC2 = new Scanner(System.in);
                int c2;
                c2 = scC2.nextInt();
                if (c2 == 0) {
                    changePassword();

                } else if (c2 == 1) {

                    System.out.println("Enter username: ");
                    Scanner scUS = new Scanner(System.in);
                    Scanner scPass = new Scanner(System.in);
                    String un, pass;
                    un = scUS.nextLine();
                    pass = scPass.next();
                    if (un.equalsIgnoreCase(username)) {
                        if (pass.equalsIgnoreCase(password)) {
                            System.out.println("Login verified");
                            adminMenu();
                        }
                    } else {
                        System.out.println("Username or password do not match");
                    }
                }
                else{
                    System.out.println("invalid entry");
                }
            }
            else if(c==3){
                System.out.println("Executing the program");
                break;
            }
            else{
                System.out.println("Invalid entry");
                System.out.println("==================");
            }
        }

    }


}
