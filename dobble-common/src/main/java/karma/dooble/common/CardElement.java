package karma.dooble.common;

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
