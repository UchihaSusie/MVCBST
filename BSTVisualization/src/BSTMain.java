public class BSTMain {
  public static void main(String[] args) {
    BSTModel model = new BSTModel();
    BSTView view = new BSTView();
    new BSTController(model, view);

    view.setVisible(true);
  }
}

