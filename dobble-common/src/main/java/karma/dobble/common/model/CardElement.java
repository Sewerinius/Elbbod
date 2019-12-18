package karma.dobble.common.model;

public class CardElement {
    private final int ID;

    public CardElement(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return Integer.toString(ID);
    }
}
