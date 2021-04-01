# ENSF_607-608_CMS_IMS

**Design and Development of a Distributed Inventory Management and Customer Management system**

The inventory management and customer management system is designed as a distributed system using **MVC client server architecture**. 
The system manages the inventory of different type of tools sold by a retail shop and allows the user to manage customers and other functionalities for the inventory. 
The application can also handle multiple clients. 

### High level UML diagram of the entire system

![High_level_UML](https://user-images.githubusercontent.com/64886621/113250421-b2026200-927d-11eb-96bb-b6ebb8503709.jpeg)

### Low Level UML Diagram:

**Client Low Level UML:**

![client_low_level_uml](https://user-images.githubusercontent.com/64886621/113250461-c8a8b900-927d-11eb-9241-c8728aabe967.jpeg)

**Server Low Level UML:**

![server_low_level_uml](https://user-images.githubusercontent.com/64886621/113250503-d65e3e80-927d-11eb-8234-1fa6a3947395.jpeg)


### EER diagram for the database application

![EER diagram](https://user-images.githubusercontent.com/64886621/113250559-ef66ef80-927d-11eb-8459-c92b77504c69.jpeg)

### Relational Model

![relational_model](https://user-images.githubusercontent.com/64886621/113250582-0279bf80-927e-11eb-954c-ae115f4db063.jpeg)


### Implementation:

1. Customer can purchase any number of items and one item can be purchased by any number of customers, thus cardinality is M:N between them. 
2. Customer can exist in the database without purchasing any items i.e. we can have the information about the customer prior to the purchase thus it has partial participation constraint.
3. Customer_type represents Residential (R), or Commercial (C). 
4. Customer name is a composite attribute.
5. Item specialization is attribute defined specialization based on attribute item_type.
6. Each item is being supplied by 1 supplier but supplier can supply multiple items thus cardinality ratio is N:1 between them.
7. Each item will have a supplier thus it has total participation constraint but supplier can exist even if the item count in inventory is 0, thus supplier has partial participation.
8. Supplier specialization is attribute defined specialization based on attribute Supplier_type.
9. 'ORDERLINE' is ternary relation with simple attribute Amount_ordered.
10. Order has total participation constraint as 'ORDER' is only generated when some item is ordered.
11. Supplier and Item has partial participation as they can exist without order being placed.
12. One item will be present in an order only once, thus we have N:N cardinality ratio between them in ternary relation. 13. Item and Supplier specializations are total disjoint in nature.
