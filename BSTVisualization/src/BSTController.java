
public class BSTController {
  private BSTModel model;
  private BSTView view;

  public BSTController(BSTModel model, BSTView view) {
    this.model = model;
    this.view = view;

    view.setModel(model);
    model.setView(view);

    view.getAddButton().addActionListener(view);
    view.getDeleteButton().addActionListener(view);
    view.getInputField().addKeyListener(view);
  }

  public void add(int data) {
    model.add(data);
  }

  public void delete(int data) {
    model.delete(data);
  }
}

