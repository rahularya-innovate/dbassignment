>>>>>>>

Run Spring Boot Application

Connect to DB:

http://localhost:8081/h2-console/

Database available at :: jdbc:h2:mem:testdb

>>>>>>>

Create a new trade entry :

http://localhost:8081/trade

Sample Request Payload :

>>>>
{
    "tradeId": "T1",
    "version": 1,
    "counterPartyId": "CP-1",
    "bookId": "B1",
    "maturityDate": "2021-05-19",
    "createdDate": "2021-05-19",
    "expired": "N"
}
>>>>