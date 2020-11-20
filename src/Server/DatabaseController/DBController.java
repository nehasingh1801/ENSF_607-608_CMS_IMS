package Server.DatabaseController;

public class DBController {
	
	
	
	private InventoryDBManager dbManager;
	
	public DBController() {
		
		dbManager = new InventoryDBManager();
		
	}
	
	

	public static void main(String[] args) {
		
		DBController myDBController = new DBController();
		
		// TODO Auto-generated method stub
		
		String query_res = myDBController.dbManager.getItem(1001);
		System.out.println("in DBController main: "+ query_res);
		
		

	}

}
