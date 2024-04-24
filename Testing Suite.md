The main point is to store each separate Order from different users into the AVL Tree and return them in ascending order which represents a balanced tree.
Each order was added in incrementing order based on their OrderId. In-order traversal was done to go through each node and print their string representation.
First Case:
Order 1 = 65.99
Order 2 = 18.99
Order 3 = 8.99

Full order tree: 
Order ID: 3
User: user3
Products: [
Product Name: Icecream
Description: food
Price: $8.99
]
Price: 8.99
 Order ID: 2
User: user2
Products: [
Product Name: Batman
Description: toy
Price: $18.99
]
Price: 18.99
 Order ID: 1
User: user1
Products: [
Product Name: Pandora
Description: music
Price: $65.99
]
Price: 65.99

Second case:
Order 1 = 20.99
Order 2 = 8.99
Order 3 = 65.99

Full order tree: 
Order ID: 2
User: user2
Products: [
Product Name: Icecream
Description: food
Price: $8.99
]
Price: 8.99
 Order ID: 1
User: user2
Products: [
Product Name: Barbie
Description: toy
Price: $20.99
]
Price: 20.99
 Order ID: 3
User: user1
Products: [
Product Name: Pandora
Description: music
Price: $65.99
]
Price: 65.99

Third Case:
Order 1 = 7.99
Order 2 = 14.99
Order 3 = 18.99

Full order tree: 
Order ID: 1
User: user1
Products: [
Product Name: Popcorn
Description: food
Price: $7.99
]
Price: 7.99
 Order ID: 2
User: user2
Products: [
Product Name: Stereo
Description: music
Price: $14.99
]
Price: 12.99
 Order ID: 3
User: user3
Products: [
Product Name: Batman
Description: toy
Price: $18.99
]
Price: 18.99
