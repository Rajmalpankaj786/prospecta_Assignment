# prospecta_Assignment
## Assignment-1 : 
1. **Task 1:** Create an API that lists the product details (title, price, description, etc.) based on the category passed as an input parameter. Use the following endpoint to retrieve the data:<br>
API Reference: [GET /products/category/](https://fakestoreapi.com/products/category/jewelery)<br>
Ans.<br> GetMapping = http://localhost:8080/products/category/jewelery<br>
   output : 
   [{"id":5,"title":"John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet","price":695,"description":"From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.","category":"jewelery","image":"https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg","rating":{"rate":4.6,"count":400}},{"id":6,"title":"Solid Gold Petite Micropave ","price":168,"description":"Satisfaction Guaranteed. Return or exchange any order within 30 days.Designed and sold by Hafeez Center in the United States. Satisfaction Guaranteed. Return or exchange any order within 30 days.","category":"jewelery","image":"https://fakestoreapi.com/img/61sbMiUnoGL._AC_UL640_QL65_ML3_.jpg","rating":{"rate":3.9,"count":70}},{"id":7,"title":"White Gold Plated Princess","price":9.99,"description":"Classic Created Wedding Engagement Solitaire Diamond Promise Ring for Her. Gifts to spoil your love more for Engagement, Wedding, Anniversary, Valentine's Day...","category":"jewelery","image":"https://fakestoreapi.com/img/71YAIFU48IL._AC_UL640_QL65_ML3_.jpg","rating":{"rate":3,"count":400}},{"id":8,"title":"Pierced Owl Rose Gold Plated Stainless Steel Double","price":10.99,"description":"Rose Gold Plated Double Flared Tunnel Plug Earrings. Made of 316L Stainless Steel","category":"jewelery","image":"https://fakestoreapi.com/img/51UDEzMJVpL._AC_UL640_QL65_ML3_.jpg","rating":{"rate":1.9,"count":100}}]<br>
<br>
2. **Task 2:** Create an API that allows adding a new product entry with all the relevant properties. Use the following endpoint to perform the POST request: API Reference: [POST /products](https://fakestoreapi.com/products)<br>
Ans <br>
PostMapping : http://localhost:8080/products
   output :
    {"id":21,"title":"laptop1","price":401,"description":"A great laptop","image":"https://example.com/product.jpg","category":"electronics"}<br>
    <br>
3.  What are the key things you would consider when creating/consuming an API to ensure that it is secure and reliable?<br>
Ans. So using the rest template and web Client we can solve these problems and I want to use the rest template. I'm facing difficulty in post-operation because we can't store the data permanently in the database.<br>
<br>
## Assignment-2 : 
CSV file output :<br>
5, 3, 10 <br>
7, 8, 15 <br>
9, 9, 24 <br>
