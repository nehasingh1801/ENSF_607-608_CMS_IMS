package Server.DatabaseController;

import java.sql.*;

public class InventoryDBManager {

	// Attributes
//	private Connection myConn;//Object of type connection from the JDBC class that deals with connecting to the database

	private Statement myStmt; // object of type statement from JDBC class that enables the creation "Query
								// statements"

	private ResultSet myres;// object of type ResultSet from the JDBC class that stores the result of the
							// query

	private PreparedStatement prepStatment;

	private Driver myDriver;

	public InventoryDBManager() {

		myDriver = new Driver();

	}

	public String getItem(int itemId) {

		System.out.println("searching for item");
		String temp = "";
		String query = "select item_id,item_name from item where item_id = ?";

		try {
//			mystm = myConn.createStatement();

			prepStatment = myDriver.getMyConn().prepareStatement(query);
			prepStatment.setInt(1, itemId);

			myres = prepStatment.executeQuery();
//			System.out.println(myres);

			// 4. process the result set
			while (myres.next()) {

				temp = myres.getInt("item_id") + ", " + myres.getString("item_name");

			}
//			

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return temp;

	}

	// Query to create Customer table in db.
	public void createCustomerTable() {

		/*
		 * create table customer( 
		 * customer_id integer not null, 
		 * fname varchar(20) not null, 
		 * lname varchar(20) not null, 
		 * address varchar(50), 
		 * postal_code varchar(7), 
		 * phone_number varchar(12), 
		 * customer_type char(10), 
		 *  primary key (customer_id) );
		 */
		String sql = "create table customer " + "(customer_id integer not null, " + "fname varchar(20) not null, "
				+ "lname varchar(20) not null, " + "address varchar(50), " + "postal_code varchar(7), "
				+ "phone_number varchar(12), " + "customer_type char(10), " 
				+ "primary key (customer_id)\r\n" + "		) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created customer table in given database...");
	}

	public void createSupplierTable() {

		/*
		 * CREATE TABLE supplier ( supplier_id integer not null, supplier_name
		 * varchar(25), supplier_type char(10), address varchar(25), company_name
		 * varchar(25), sales_contact varchar(25), phone varchar(12), primary key
		 * (supplier_id) );
		 */
		String sql = "CREATE TABLE supplier ( " + " supplier_id       integer not null, "
				+ " supplier_name		varchar(25), " + " supplier_type 	char(10), "
				+ " address      		varchar(25), " + " company_name 		varchar(25), "
				+ "sales_contact 	varchar(25), " + " phone 			varchar(12), "
				+ " primary key (supplier_id) \r\n" + "  ) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created Supplier table in given database...");

	}

	// Query to create Item table in db.
	public void createItemTable() {

		/*
		 * CREATE TABLE item ( item_id integer not null, item_name varchar(25),
		 * item_quantity integer, item_price decimal(10,2), item_type varchar(25),
		 * supplier_id integer, primary key (item_id), foreign key (supplier_id)
		 * references supplier(supplier_id) );
		 */
		String sql = "create table item " + "(item_id integer not null, " + "item_name varchar(25), "
				+ "item_quantity integer, " + "item_price decimal(10,2), " + "item_type varchar(25),, "
				+ "supplier_id  integer, " + "primary key (item_id), "
				+ "foreign key (supplier_id) references supplier(supplier_id)\r\n" + "			) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created item table in given database...");
	}

	// Query to create purchase table in db.
	public void createPurchaseTable() {

		/*
		 * CREATE TABLE purchase ( item_id integer not null, customer_id integer not
		 * null, primary key (item_id,customer_id), foreign key (item_id) references
		 * item(item_id), foreign key (customer_id) references customer(customer_id) );
		 */
		String sql = "create table purchase " + "(item_id integer not null, " + "customer_id  integer not null, "

				+ "primary key (item_id,customer_id), " + " foreign key (item_id) references item(item_id), "
				+ " foreign key (customer_id) references customer(customer_id)\r\n" + "			) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created purchase table in given database...");
	}

	// Query to create order table in db.
	public void createOrderTable() {

		/*
		 * CREATE TABLE order ( order_id integer not null, order_date date, primary key
		 * (order_id)
		 * 
		 * );
		 */
		String sql = "create table order " + "(order_id integer not null, " + "order_date  date, "

				+ "primary key (order_id) \r\n" + "			) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created order table in given database...");
	}

	// Query to create orderline table in db.
	public void createOrderLineTable() {

		/*
		 * CREATE TABLE orderline ( order_id integer not null, item_id integer not null,
		 * supplier_id integer , amount_ordered integer, primary key (order_id, item_id)
		 * foreign key (item_id) references item(item_id), foreign key (order_id)
		 * references order(order_id) foreign key (supplier_id) references
		 * supplier(supplier_id)
		 * 
		 * );
		 */
		String sql = "create table orderline " + "(order_id integer not null, " + "item_id integer not null, "
				+ " supplier_id  integer , " + " amount_ordered integer, "

				+ " primary key (order_id, item_id) " + " foreign key (item_id) references item(item_id), "
				+ " foreign key (order_id) references order(order_id) "
				+ "foreign key (supplier_id) references supplier(supplier_id) \r\n" + "			) ";

		try {
			myStmt = myDriver.getMyConn().createStatement();
			myStmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Created orderline table in given database...");
	}
	
	
	// Query to create electrical_item table in db.
		public void createElectricalItemTable() {

			/*
			 * CREATE TABLE electrical_item ( item_id integer not null, power_type varchar(10), primary key
			 * (item_id)
			 * 
			 * );
			 */
			String sql = "create table electrical_item " + "(item_id integer not null, " + " power_type varchar(10), "

					+ "primary key (item_id) \r\n" + "			) ";

			try {
				myStmt = myDriver.getMyConn().createStatement();
				myStmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Created electrical_item table in given database...");
		}
		
		
		
		// Query to create electrical_item table in db.
				public void createInternationalSuppTable() {

					/*
					 * CREATE TABLE international_supplier 
					 * ( supplier_id integer not null, 
					 * import_tax decimal, 
					 * primary key (supplier_id)
					 * 
					 * );
					 */
					String sql = "create table international_supplier " + "(supplier_id integer not null, " + " import_tax decimal , "

							+ "primary key (supplier_id) \r\n" + "			) ";

					try {
						myStmt = myDriver.getMyConn().createStatement();
						myStmt.executeUpdate(sql);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Created international_supplier table in given database...");
				}

	
	

	public void closeSqlConn() {

		try {

			myStmt.close();
			myres.close();
			prepStatment.close();
			myDriver.getMyConn().close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertCustomerPreparedStatment(int id, String fName, String lName, String address, String postal_code, String phone_number,
			String customer_type) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO customer ( id,  fName,  lName,  address,  postal_code,  phone_number, customer_type) values (?,?,?,?,?,?,?)";
			PreparedStatement pStat = myDriver.getMyConn().prepareStatement(query);
			pStat.setInt(1, id);
			pStat.setString(2, fName);
			pStat.setString(3, lName);
			pStat.setString(4, address);
			pStat.setString(5, postal_code);
			pStat.setString(6, customer_type);
			int rowCount = pStat.executeUpdate();
			System.out.println("row Count = " + rowCount);
			pStat.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * public static void main(String[] args) throws SQLException { Statement mystm
	 * = null;
	 * 
	 * try { //1. get a connection Connection myConn =
	 * DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory", "root",
	 * "password");
	 * 
	 * //2. craete a statement mystm = myConn.createStatement();
	 * 
	 * //3. execute sql query ResultSet myres =
	 * mystm.executeQuery("select item_id,item_name from item");
	 * 
	 * //4. process the result set while(myres.next()) {
	 * System.out.println(myres.getString("item_id") + ", " +
	 * myres.getString("item_name")); } } catch(Exception e) { e.printStackTrace();
	 * } finally { if(mystm != null) { mystm.close(); } } }
	 */

}
