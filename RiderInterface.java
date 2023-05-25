public interface RiderInterface {
    void createAccount();
    void loginAccount(String username, String password);
    void viewOrder(int riderIndex);
    void orderAcceptOrReject(int orderNo);
    void updateDeliveryStatus(int orderIndex);
    void updateCashCollectionStatus();
}
