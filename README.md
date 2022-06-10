## Revature - Project 1
Set up the backend for an online store to buy items. Users can register and log in to add items to their cart. Then they can place orders. Registered users are stored in the Users table. Items that users can buy are stored in the Items table. User's carts are stored in the Cart table. Users orders are stored in the Orders table. Features to be Implemented [ You can add also some other features ] Register - register new users Login/Logout - login and logout users Get Users - get all users and their cart Get Items - gets all items that are available in store Add Item to Cart - adds selected item to the cart

## Project Requirements 
- Register - register new users 
- Login/Logout - login and logout users 
- Get Users - get all users and their cart 
- Get Items - gets all items that are available in store 
- Add Item to Cart - adds selected item to the cart

## Requirements Implemented
- Register a User: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/registerUser
- Get Users: GET http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user
- Get Items: GET http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/item
- Add an Item to a User's Cart: PUT http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/addItemToCart/{userId} <br/>
    
- Login Using Email and Password: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/login <br/>
 Example BODY: { "email": "npang@me.com", <br/>
  &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp; "password": "root" }
- Logout: http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/logout
## Additional Features Implemented
- Delete a User by User Id: DELETE http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/user/{userId}
- Create an Item: POST http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080/item/addItemToDB
- Delete an Item by Item Id: DELETE http://ec2-18-218-235-230.us-east-2.compute.amazonaws.com:8080//item/{itemId}
