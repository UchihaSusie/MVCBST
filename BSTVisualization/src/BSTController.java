
public class BSTController implements BSTControllerInterface{
  private BSTModel model;
  private BSTView view;

  public BSTController(BSTModel model, BSTView view) {
    this.model = model;
    this.view = view;
    //view.setModel(model);
    //model.setView(view);
    this.view.setController(this);
    this.model.setController(this);
    view.getAddButton().addActionListener(view);
    view.getDeleteButton().addActionListener(view);
    view.getInputField().addKeyListener(view);
  }

  public boolean add(int data) {
    return this.model.add(data);
  }

  public boolean delete(int data){
    return this.model.delete(data);
  }

  public void notifyView(Node root) {
    if (this.view != null) {
      this.view.updateTreePanel(root);
      this.view.updateTraversal(
        this.model.inorder(),
        this.model.preorder(),
        this.model.postorder()
      );
    }
  }
}

