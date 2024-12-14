import controllers.BSTController;
import models.BSTModel;
import views.BSTView;

public class BSTMain {
  public static void main(String[] args) {
    BSTModel model = new BSTModel();
    BSTView view = new BSTView();
    BSTController controller = new BSTController(model, view);
    view.setVisible(true);
    controller.add(500);
    controller.add(250);
    controller.add(350);
    controller.add(200);
    controller.add(750);
    controller.add(1000);
    controller.add(700);
    controller.add(740);
  }
}

