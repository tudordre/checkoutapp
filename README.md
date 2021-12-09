# Java Checkout Service

This repository will demonstrate how a promotion & checkout service will work.


## Design and implementation ##
The aplication is written using **spring boot**.
It uses **spring web starter** dependency for the **controllers and endpoints**.

It uses the standard layers of a spring boot application:
* **controllers** - who expose the endpoints
* **service** - for business logic
* **repository** - for managing data. In this repository it uses an in memory list of products and promotions


For promotion appling it uses the **Chain of responsability Design Pattern** so it can add **very easy a lot of other promotions**. Just implement one of the interfaces
* CartPromotion (which is responsable for promotions at the cart/checkout level: Total amount bigger than XXX, At least XXX items in total, etc)
* MinimumItemNumberPromotion (which is responsable for promotions at product/item level: 1 item at 50%, buy at least 2 with 10% discount etc)

This makes easy to **add some other strategies** like freeshiping by implementing the root interface BasePromotion

The **product** contains the required fields: code, name, price.

Also when looking for an non existing product, the service will throw a 404 exception using the exception added in the exceptions package.

The promotions should be added in a specified order. First the item level ones and after that the ones at the checkout level. 
Otherwise there can be made this sort in the code based on the class of the promotion object. 

## Setup ##

### Install Dependencie
* Java 11
* Gradle 7.3.1


## Run ##

./gradlew bootRun

### Request sample ###

### Get all products
curl --location --request GET 'localhost:8080/products'

### Get all promotions
curl --location --request GET 'localhost:8080/promotions'

### Create checkout with specified products

curl --location --request POST 'localhost:8080/checkout?productCodes=001,002,003'
#### response
* status 200
* body 66.78

curl --location --request POST 'localhost:8080/checkout?productCodes=001,003,001'
#### response
* status 200
* body 36.95

curl --location --request POST 'localhost:8080/checkout?productCodes=001,002,001,003'
#### response
* status 200
* body 73.76


curl --location --request POST 'localhost:8080/checkout?productCodes=001,002,001,003dd'
#### response
* status 404
* body
>{
"timestamp": "2021-12-09T21:47:41.149+00:00",
"status": 404,
"error": "Not Found",
"path": "/checkout"
}

