## Revature - Project 1
Set up the backend for an online store to buy items. Users can register and log in to add items to their cart. Then they can place orders. Registered users are stored in the Users table. Items that users can buy are stored in the Items table. User's carts are stored in the Cart table. Users orders are stored in the Orders table. Features to be Implemented [ You can add also some other features ] Register - register new users Login/Logout - login and logout users Get Users - get all users and their cart Get Items - gets all items that are available in store Add Item to Cart - adds selected item to the cart

#Technologies Used
- Java, Spring, REST, DBeaver, Postman, AWS, PostGreSQL

#How to Run <br/>
AWS services are running. In Postman, perform requests provided in the "Requirements Implemented" section below.

## Project Features 
- Register a User
- Delete a User 
- Login/Logout  
- Get all Users 
- Create an Item
- Delete an Item by Id
- Get all Items 
- Add Item to Cart 

## Requirements Implemented
- Register a User: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/registerUser <br/>
EXAMPLE BODY: { "name": "Nicole Pang", <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"email": "npang@me.com", <br/>
 &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"password": "root", <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"cartList": [] }
- Delete a User by User Id: DELETE http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/{userId}
- Login Using Email and Password: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/login <br/>
 Example BODY: { "email": "npang@me.com", <br/>
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; "password": "root" }
- Logout: http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/logout
- Get all Users: GET http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user
- Create an Item: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/item/addItemToDB <br/>
EXAMPLE BODY: { "itemName": "Medicine", <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;   "itemPrice": 18.59
}
- Delete an Item by Item Id: DELETE http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080//item/{itemId}
- Get all Items: GET http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/item
- Add an Item to a User's Cart: PUT http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/addItemToCart/{userId} <br/>
EXAMPLE BODY {
&emsp;"name": "Luis Marquez", <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"cart": { <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"cartId": 1, <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"itemList": [ <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;{ <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"itemName": "Medicine", <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"itemPrice": 18.59 <br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;},<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;{<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"itemName": "NewItem",<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"itemPrice": 14.35<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;}<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;]<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;},<br/>
&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;"orders": [] &emsp;}
