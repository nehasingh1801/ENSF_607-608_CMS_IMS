package Client.Controller.ViewController;

import Client.ClientView.*;
import Client.Controller.ModelController.ModelControllerCustomer;
import Client.Controller.ModelController.ModelControllerTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainViewController implements ActionListener {

	MainView view;
	//ModelControllerCustomer modelControllerCustomer;
	//ModelControllerTool modelControllerTool;
	CustomerViewController customerViewController;
	ToolViewController toolViewController;

	public MainViewController(MainView view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource() == view.getCustomerView()) {
			System.out.println("CustomerView");
			customerViewController = new CustomerViewController(new ModelControllerCustomer());
			//modelControllerCustomer = new ModelControllerCustomer();
			//modelControllerCustomer.setCustomerViewController(new CustomerViewController());

		}

		else if (e.getSource() == view.getToolView()) {
			System.out.println("ToolView");
			
			//modelControllerTool = new ModelControllerTool();
			//modelControllerTool.setToolViewController(new ToolViewController());
		}

		
	}

}
