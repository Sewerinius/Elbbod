package karma.dobble.client.components;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.DoubleBinding;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import karma.dobble.client.utils.FXMLUtils;
import karma.dooble.common.model.Card;
import karma.dooble.common.model.CardElement;

public class CardComponent extends Pane {
    private Card card;
    private ToggleGroup toggleGroup;

    public CardComponent() {
        FXMLUtils.loadFXML(this);
    }

    public void setCard(Card card) {
        if (this.card == card)
            return;
        this.card = card;
        this.toggleGroup = new ToggleGroup();

        int i = 0;
        int size = card.getCardElements().size();

        System.out.println(getWidth());
        System.out.println(getHeight());

        for (CardElement element : card.getCardElements()) {
            ToggleButton button = new ToggleButton(element.toString());
            button.setToggleGroup(toggleGroup);
            getChildren().add(button);

            int finalI = i;
            button.layoutXProperty().bind(Bindings.createDoubleBinding(() -> widthProperty().get() * (0.5 + 0.4 * Math.sin(2 * Math.PI * finalI / size)), widthProperty()));
            button.layoutYProperty().bind(Bindings.createDoubleBinding(() -> heightProperty().get() * (0.5 + 0.4 * Math.cos(2 * Math.PI * finalI / size)), heightProperty()));
            i++;

        }
    }
}
