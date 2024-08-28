## API Documentation

### Base URL

All endpoints are accessible via the base URL:
```
http://localhost:8085
```
## Overview
The POS System API allows clients to manage orders, customers, and items in a point-of-sale system. The API supports operations such as creating, retrieving, updating, and deleting orders, as well as managing items and customers.

---

## Authentication
This API does not require authentication. Ensure that appropriate security measures are implemented in a production environment.

---

### Endpoints

#### 1. Customer Management

##### **POST /customer**

**Description:** Create a new customer.

**Request:**
- **Content-Type:** `application/json`
- **Body:**
  ```json
  {
    "id": "C001",
    "name": "Ayoma Hansani",
    "address": "Makola",
    "phone": "0750838333"
  }
  ```

**Response:**
- **Status Code:** `201 Created` if successful
- **Status Code:** `400 Bad Request` if the request is invalid

**Error Response:**
```json
{
  "error": "Customer not saved..."
}
```

##### **PUT /customer**

**Description:** Update an existing customer.

**Request:**
- **Content-Type:** `application/json`
- **Query Parameter:** `id` - ID of the customer to update
- **Body:**
  ```json
  {
    "id": "C001",
    "name": "Ayoma Hansani",
    "address": "Kadawatha",
    "phone": "0776845234"
  }
  ```

**Response:**
- **Status Code:** `200 OK` if successful
- **Status Code:** `400 Bad Request` if the request is invalid
- **Status Code:** `500 Internal Server Error` if the update fails

**Error Response:**
```json
{
  "error": "Customer not updated..."
}
```

##### **DELETE /customer**

**Description:** Delete a customer.

**Request:**
- **Query Parameter:** `id` - ID of the customer to delete

**Response:**
- **Status Code:** `204 No Content` if successful
- **Status Code:** `400 Bad Request` if the ID is missing
- **Status Code:** `500 Internal Server Error` if the deletion fails

**Error Response:**
```json
{
  "error": "Customer not deleted..."
}
```

##### **GET /customer**

**Description:** Retrieve all customers.

**Response:**
- **Status Code:** `200 OK` with JSON array of customers if successful
- **Status Code:** `204 No Content` if no customers are found

**Example Response:**
```json
[
  {
    "id": "C001",
    "name": "Ayoma Hansani",
    "address": "Makola",
    "phone": "0750838333"
  },
  {
    "id": "C002",
    "name": "Dilrukshi Pradeepa",
    "address": "Kegalle",
    "phone": "0722739798"
  }
]
```


#### 2. Item Management

##### **POST /item**

**Description:** Create a new item.

**Request:**
- **Content-Type:** `application/json`
- **Body:**
  ```json
  {
    "code": "I001",
    "name": "Toffee",
    "price": 10.99,
    "qty": 100
  }
  ```

**Response:**
- **Status Code:** `201 Created` if successful
- **Status Code:** `400 Bad Request` if the request is invalid
- **Status Code:** `500 Internal Server Error` if the item creation fails

**Error Response:**
```json
{
  "error": "Item not saved..."
}
```

##### **PUT /item**

**Description:** Update an existing item.

**Request:**
- **Content-Type:** `application/json`
- **Query Parameter:** `code` - ID of the item to update
- **Body:**
  ```json
  {
    "code": "I001",
    "name": "Toffee",
    "price": 20.00,
    "qty": 50
  }
  ```

**Response:**
- **Status Code:** `200 OK` if successful
- **Status Code:** `400 Bad Request` if the request is invalid
- **Status Code:** `500 Internal Server Error` if the update fails

**Error Response:**
```json
{
  "error": "Item not updated..."
}
```

##### **DELETE /item**

**Description:** Delete an item.

**Request:**
- **Query Parameter:** `code` - ID of the item to delete

**Response:**
- **Status Code:** `204 No Content` if successful
- **Status Code:** `400 Bad Request` if the ID is missing
- **Status Code:** `500 Internal Server Error` if the deletion fails

**Error Response:**
```json
{
  "error": "Item not deleted..."
}
```

##### **GET /item**

**Description:** Retrieve all items.

**Response:**
- **Status Code:** `200 OK` with JSON array of items if successful
- **Status Code:** `204 No Content` if no items are found

**Example Response:**
```json
[
  {
    "code": "I001",
    "name": "Toffee",
    "price": 10.99,
    "qty": 100
  },
  {
    "code": "I002",
    "name": "Maliban",
    "price": 890.00,
    "qty": 40
  }
]
```


#### 3. Order Management

##### **POST /order**

**Description:** Create a new order.

**Request:**
- **Content-Type:** `application/json`
- **Body:**
  ```json
  {
    "orderId": "O001",
    "orderDate": "2024-08-28",
    "customerId": "C002",
    "itemsOfOrder": "chosenItems",
    "totalPrice": 2300.00,
    "discount": 0,
    "subTotal": 2300.00,
  }
  ```

**Response:**
- **Status Code:** `200 OK` if successful
- **Status Code:** `400 Bad Request` if the request is invalid
- **Status Code:** `500 Internal Server Error` if the order creation fails

**Error Response:**
```json
{
  "error": "Order not placed..."
}
```

##### **GET /order**

**Description:** Retrieve an order by ID or list all orders.

**Request:**
- **Query Parameter:** `orderId` - (Optional) ID of the order to retrieve

**Response:**
- **Status Code:** `200 OK` with JSON representation of the order if successful
- **Status Code:** `404 Not Found` if the order is not found
- **Status Code:** `400 Bad Request` if the ID is invalid

**Example Response (Single Order):**
```json
{
  "orderId": "O001",
  "orderDate": "2024-08-28",
  "customerId": "C002",
  "itemsOfOrder": "chosenItems",
  "totalPrice": 2300.00,
  "discount": 0,
  "subTotal": 2300.00,
}
```

**Example Response (All Orders):**
```json
[
  {
    "orderId": "O001",
    "orderDate": "2024-08-28",
    "customerId": "C002",
    "itemsOfOrder": "chosenItems",
    "totalPrice": 2300.00,
    "discount": 0,
    "subTotal": 2300.00,
  },
  {
    "orderId": "O002",
    "orderDate": "2024-08-29",
    "customerId": "C001",
    "itemsOfOrder": "chosenItems",
    "totalPrice": 347.00,
    "discount": 0,
    "subTotal": 347.00,
  }
]
```

### Error Codes

- **400 Bad Request:** The request could not be understood or was missing required parameters.
- **404 Not Found:** The requested resource could not be found.
- **500 Internal Server Error:** An error occurred on the server.

---
