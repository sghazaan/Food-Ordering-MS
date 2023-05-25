import java.util.ArrayList;
import java.util.Scanner;

public class Rider extends Person implements RiderInterface {
    private String riderName;
    private String riderUserName;
    private String riderPassword;
    private String riderBikeNumber;
    private Long riderContactNumber;
   // private int riderIndex;
    private ArrayList<Order> riderOrdersHistory = new ArrayList<>();
    private int newOrderNumber;
    private boolean isOrderDelivered=false;
    private boolean isRiderOccupied =false;
    private boolean hasRiderAccepted =false;


    public boolean isCashCollected() {
        return isCashCollected;
    }

    public void setCashCollected(boolean cashCollected) {
        isCashCollected = cashCollected;
    }

    private boolean isCashCollected =false;
    public Long getRiderContactNumber() {
        return riderContactNumber;
    }

    public void setRiderContactNumber(Long riderContactNumber) {
        this.riderContactNumber = riderContactNumber;
    }

    public String getRiderPassword() {
        return riderPassword;
    }

    public void setRiderPassword(String riderPassword) {
        this.riderPassword = riderPassword;
    }

    public String getRiderBikeNumber() {
        return riderBikeNumber;
    }

    public void setRiderBikeNumber(String riderBikeNumber) {
        this.riderBikeNumber = riderBikeNumber;
    }

    public boolean isRiderOrderAcceptance() {
        return riderOrderAcceptance;
    }

    public void setRiderOrderAcceptance(boolean riderOrderAcceptance) {
        this.riderOrderAcceptance = riderOrderAcceptance;
    }

    private boolean riderOrderAcceptance;



    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public void setRiderUserName(String riderUserName) {
        this.riderUserName = riderUserName;
    }

    public String getRiderName() {
        return riderName;
    }

    public String getRiderUserName() {
        return riderUserName;
    }

    public Rider(String riderName, Long riderContactNumber, String riderBikeNumber, String riderUserName, String riderPassword) {
        this.riderName = riderName;
        this.riderUserName = riderUserName;
        this.riderPassword = riderPassword;
        this.riderBikeNumber = riderBikeNumber;
        this.riderContactNumber = riderContactNumber;
    }
    @Override
    public void createAccount() {
        Scanner scName = new Scanner(System.in);
        Scanner scBikeNumber = new Scanner(System.in);
        Scanner scUsername = new Scanner(System.in);
        Scanner scPassword = new Scanner(System.in);
        Scanner scContactNumber = new Scanner(System.in);
        String name, bikeNo, username, password;
        Long contactNo;
        System.out.println("Enter name: ");
        name=scName.nextLine();
        System.out.println("Enter your contact number: ");
        contactNo=scContactNumber.nextLong();
        System.out.println("Enter bike number: ");
        bikeNo=scBikeNumber.nextLine();
        System.out.println("Enter username: ");
        username=scUsername.next();
        System.out.println("Enter password: ");
        password=scPassword.next();
        Rider riderObj = new Rider(name, contactNo, bikeNo, username, password);
        Admin.tempRiderObjectsArray.add(riderObj);
    }
    public void loginInfo(){
        Scanner scUsername = new Scanner(System.in);
        Scanner scPassword = new Scanner(System.in);
        String username, password;
        System.out.println("Enter username: ");
        username=scUsername.next();
        System.out.println("Enter password: ");
        password=scPassword.next();
        this.riderUserName=username;
        this.riderPassword=password;
    }

    public Rider() {
    }

    @Override
    public void loginAccount(String username, String password) {
        for(int riderIndex=0; riderIndex<Admin.riderObjectsArray.size(); riderIndex++){
            if(username.equalsIgnoreCase(Admin.riderObjectsArray.get(riderIndex).getRiderUserName())){
                if(password.equals(Admin.riderObjectsArray.get(riderIndex).getRiderPassword())){
                    System.out.println("Login verified");
                    System.out.println("Press 1 to view order." +
                            "\nPress 2 to update delivery status." +
                            "\nPress 3 to block a customer.");
                    Scanner scRiderMenu = new Scanner(System.in);
                    int riderMenu;
                    riderMenu=scRiderMenu.nextInt();
                    if(riderMenu==1){
                        Admin.riderObjectsArray.get(riderIndex).viewOrder(riderIndex);
                    }
                    else if(riderMenu==2){
                     //   Admin.riderObjectsArray.get(riderIndex).updateDeliveryStatus();

                    }
                    else if(riderMenu==3){
                        Admin.riderObjectsArray.get(riderIndex).blockCustomer();
                    }
                    else{
                        System.out.println("Invalid entry");
                    }
                }
            }
        }
    }
    @Override
    public void viewOrder(int loggedRiderIndex) {
        if(Admin.riderObjectsArray.get(loggedRiderIndex).isRiderOccupied==true){
            //order has been made
            //some assignment has been made
            System.out.println("==================================");
            for(int orderIndex=0; orderIndex<Admin.orderObjects.size(); orderIndex++){
                if(Admin.riderObjectsArray.get(loggedRiderIndex).getNewOrderNumber()
                        ==Admin.orderObjects.get(orderIndex).getOrderNumber()){
                    if(Admin.riderObjectsArray.get(loggedRiderIndex).getRiderUserName().equals(
                            Admin.orderObjects.get(orderIndex).getRiderUsername())) {
                        //order matched
                        //show the rider the order
                        System.out.println("Customer information: ");
                        for (int custIndex = 0; custIndex < Admin.customerObjectsArray.size(); custIndex++) {
                            if (Admin.customerObjectsArray.get(custIndex).
                                    getCustomerUserName().equalsIgnoreCase(Admin.orderObjects.get(orderIndex)
                                    .getCustomerUsername())) {
                                System.out.println("Customer name: " + Admin.customerObjectsArray.get(custIndex).getCustomerName());
                                System.out.println("Customer address: " + Admin.customerObjectsArray.get(custIndex).getCustomerAddress());
                                System.out.println("Customer contact number: " + Admin.customerObjectsArray.
                                        get(custIndex).getCustomerContactNumber());
                            }
                        }
                        System.out.println("Restaurant information: ");
                        for (int restIndex = 0; restIndex < Admin.restaurantObjectsArray.size(); restIndex++) {
                            if (Admin.orderObjects.get(orderIndex).getRestaurantUsername()
                                    .equalsIgnoreCase(Admin.restaurantObjectsArray.get(restIndex).getRestaurantUserName())) {
                                System.out.println("Restaurant name: " + Admin.restaurantObjectsArray.get(restIndex).
                                        getRestaurantName());
                                System.out.println("Restaurant address: " + Admin.restaurantObjectsArray.get(restIndex)
                                        .getRestaurantAddress());
                                System.out.println("Restaurant contact number: " + Admin.restaurantObjectsArray.get(restIndex).
                                        getRestaurantContactNumber());
                            }
                        }
                        //restaurant info completed here
                        System.out.println("Food details: ");
                        System.out.println("Food name: " + Admin.orderObjects.get(orderIndex).getFoodname());
                        System.out.println("Order number: " + Admin.orderObjects.get(orderIndex).getOrderNumber());
                        System.out.println("Billing number: " + Admin.orderObjects.get(orderIndex).getBillNumber());
                        System.out.println("==================================");
                        Admin.riderObjectsArray.get(loggedRiderIndex).orderAcceptOrReject(Admin.orderObjects.get(orderIndex).getOrderNumber());
                    }


                }
            }
        }

    }
    @Override
    public void orderAcceptOrReject(int orderNo) {
        Scanner scAcceptance = new Scanner(System.in);
        int acceptanceInput;
        System.out.println("Hello "+riderName+
                "\nDo you want to accept this order?" +
                "\nPress 1 for Yes" +
                "\nPress 0 for No");
        acceptanceInput=scAcceptance.nextInt();
        if(acceptanceInput==1){
            hasRiderAccepted =true;
            isRiderOccupied =true;
            System.out.println("Order has been accepted");
        }
        else if(acceptanceInput==0){
            hasRiderAccepted =false;
            isRiderOccupied =false;
            newOrderNumber=0;
            for (int r=0; r<Admin.riderObjectsArray.size(); r++){
                if(Admin.riderObjectsArray.get(r).isRiderOccupied==false){
                    Admin.riderObjectsArray.get(r).isRiderOccupied=true;
                    Admin.riderObjectsArray.get(r).newOrderNumber=orderNo;
                    System.out.println("Order has been passed on to another rider named: "+Admin.riderObjectsArray.get(r).getRiderName());

                }
            }
        }
        else{
            System.out.println("Invalid entry");
        }
    }

    public boolean isRiderOccupied() {
        return isRiderOccupied;
    }

    public void setRiderOccupied(boolean riderOccupied) {
        isRiderOccupied = riderOccupied;
    }

    public boolean isOrderDelivered() {
        return isOrderDelivered;
    }

    public void setOrderDelivered(boolean orderDelivered) {
        isOrderDelivered = orderDelivered;
    }

    @Override
    public void updateDeliveryStatus(int orderIndex) {
        if(hasRiderAccepted) {
            System.out.println("Press 1 if the order has been delivered." +
                    "\nOtherwise press any other integer.");
            Scanner scDelivery = new Scanner(System.in);
            int deliveryChoice;
            deliveryChoice = scDelivery.nextInt();
            if (deliveryChoice == 1) {
                for (int custIndex = 0; custIndex < Admin.customerObjectsArray.size(); custIndex++) {
                    if (Admin.customerObjectsArray.get(custIndex).
                            getCustomerUserName().equalsIgnoreCase(Admin.orderObjects.get(orderIndex)
                            .getCustomerUsername())) {
                        Admin.customerObjectsArray.get(custIndex).setOrderCompleted(true);
                    }
                    }
                isOrderDelivered = true;
                isRiderOccupied = false;
                hasRiderAccepted=false;
                newOrderNumber=0;
                updateCashCollectionStatus();
            } else {
                isOrderDelivered = false;
                isRiderOccupied = true;
            }
        }
        else{
            System.out.println("You have not accepted any order yet.");
        }

    }

    @Override
    public void updateCashCollectionStatus() {
            System.out.println("Press 1 if cash has been paid. " +
                    "\nPress 2 if the cash was not paid: ");
            Scanner scCash = new Scanner(System.in);
            int cashChoice;
            cashChoice = scCash.nextInt();
            if (cashChoice == 1) {
                isCashCollected = true;

            } else {
                isCashCollected = false;
            }
    }
    public int getNewOrderNumber() {
        return newOrderNumber;
    }

    public void setNewOrderNumber(int newOrderNumber) {
        this.newOrderNumber = newOrderNumber;
    }

    public void assignOrderToRider(int orderNo) {
        boolean riderFound=false;
        try {
            for (int riderIndex = 0; riderIndex < Admin.riderObjectsArray.size(); riderIndex++) {
                if ((Admin.riderObjectsArray.get(riderIndex).isRiderOccupied) == false) {
                    Admin.riderObjectsArray.get(riderIndex).isRiderOccupied = true;
                    System.out.println("Rider " + Admin.riderObjectsArray.get(riderIndex).getRiderName() + " has been asked to pick your order." +
                            "\nYou will be notified as soon as rider accepts to pick up the order.");
                    Admin.riderObjectsArray.get(riderIndex).newOrderNumber=orderNo;
                    riderFound=true;

                }
            }

            if(riderFound){
                //rider has been found
            }
            else{
                System.out.println("No available rider right now");
            }
            //automatically assign
            //if all riders are busy, then display the same message

        }
        catch(NullPointerException e){
            System.out.println("No rider has been instantiated yet.");

        }
    }
    public void blockCustomer(){
        boolean bCustomerFound=false;
        System.out.println("Enter customer's username: ");
        Scanner scCust = new Scanner(System.in);
        String cust;
        cust=scCust.next();
        for (int i=0; i<Admin.customerObjectsArray.size(); i++){
            if(cust.equalsIgnoreCase(Admin.customerObjectsArray.get(i).getCustomerUserName())){
                bCustomerFound=true;
                System.out.println("Explain the reason for blocking: ");
                Scanner scReason = new Scanner(System.in);
                String reason;
                reason=scReason.nextLine();
                Customer blockedCustomerObj = new Customer(cust, reason);
                Admin.tempBlockedCustomersArray.add(blockedCustomerObj);
            }
        }

    }
}
