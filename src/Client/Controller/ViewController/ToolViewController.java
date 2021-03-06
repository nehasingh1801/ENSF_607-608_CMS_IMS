package Client.Controller.ViewController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Client.ClientView.ToolView;

public class ToolViewController {
	
	private ToolView toolView;
	
	public ToolViewController() {
		toolView = new ToolView();
		toolView.setVisible(true);
		toolView.pack();
		toolView.addToolListener(new ToolListener());
	}
	
	class ToolListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource() == toolView.getSearch())
				System.out.println("got search button");
			
		}
		
	}

	public ToolView getToolView() {
		return toolView;
	}

	public void setToolView(ToolView toolView) {
		this.toolView = toolView;
	}
	
	

}
