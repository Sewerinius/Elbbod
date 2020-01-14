package karma.dobble.common.model;

public class CardElement {
    private final int id;

    public CardElement(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
