package ATMSimulation;

public class Main {
    public static void main(String[] args) {
        AccountInfo accountInfo = new AccountInfo();

        PerformAction performAction = new PerformAction();
        performAction.startATM(accountInfo);
    }
}
