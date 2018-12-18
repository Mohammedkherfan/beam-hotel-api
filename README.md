# Project Title

Beam Hotel Api

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
Java 8, Maven, intelliJ IDE
```

### note

```
Before Run beam-api you shall run data provider like best-hotel and crazy-hotel

```

### Installing

```
https://github.com/Mohammedkherfan/beam-hotel-api.git
mvn clean install
run main class
```

### REST Documentation

Swagger Doc. url: localhost:8080/swagger-ui.html#
you can run request and get response via swagger documentation api


### REST Service

```
http://localhost:8080/hotels/{fromDate}/{toDate}/{city}/{numberOfAdults}

sample request:
curl -X GET "http://localhost:8080/hotels/2019-05-05/2019-12-01/DXB/6" -H "accept: application/hal+json"

sample response:
[
  {
    "provider": "Crazy Hotel",
    "hotelName": "Four Seasons Resort Dubai",
    "fare": "150",
    "amenities": [
      "Wifi",
      "parking",
      "TV",
      "Smoking Room"
    ]
  },
  {
    "provider": "Best Hotel",
    "hotelName": "Four Seasons Resort Dubai",
    "fare": "$150.00",
    "amenities": [
      "DXB"
    ]
  }
]

```


### Testing

```
There is two type of testing
integration test: in hotel-controller module
controller test: in hotel-controller module
data provider test: in data-provider module
```


### Code Coverage

```
All code covered 100% excluded configuration files and request and response data structure.
```