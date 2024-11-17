package app;

import model.ComuNetwork;
import view.ComuNetworkView;
import controller.ComuNetworkController;

public class MainApp {
    public static void main(String[] args) {
        ComuNetwork model = new ComuNetwork();
        ComuNetworkView view = new ComuNetworkView();
        ComuNetworkController controller = new ComuNetworkController(model, view);

        controller.run();
    }
}
