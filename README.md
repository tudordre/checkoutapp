# Java Checkout Service

This repository will demonstrate how a promotion & checkout service will work.

### Setup ###

#### Install Dependencies
* Java 11
* Gradle 7.3.1


### Run ###

./gradlew bootRun

### Request sample ###
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

