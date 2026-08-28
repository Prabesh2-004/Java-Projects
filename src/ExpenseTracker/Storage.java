package ExpenseTracker;

public class Storage<T, U> {
    private T name;
    private U amount;

    Storage(T name, U amount) {
        this.name = name;
        this.amount = amount;
    }

    public void setExpenses(T name, U amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getExpenses() {
        return name + ": " + amount;
    }
}
