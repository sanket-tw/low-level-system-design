# low-level-system-design

# https://www.educative.io/courses/grokking-the-object-oriented-design-interview/gxM3gRxmr8Z

Objectives: 
1. multi level ->. this says when we give ticket to user, it should have level and spot as well
2. multiple entry and exit points -> the paymentProcessor process, ticket generation should sync up, 
   so we do not allot a parking to both, and also clear parking spot evenly from all places. 
   a common database would do. 
   Since read and write would be 1:2 (read if spot occupied, when paymentProcessor done, release spot). 
   so we need strong consistency, hence relational database. Locking while changing.
   Might have strategy as to where to allot parking
3. Entry- should be responsible for: generate ticket, reserve spot, Exit- paymentProcessor processing, release spot; 
   log at both sides to common logger, monitoring( Out of scope)
4. Payment can be captured at 2 places, assistant is one role
5. Payment by various means, cash, credit, means capture.
6. Payment also at port info, paymentProcessor record as part of ticket, sync with Exit,
7. The system should not allow more vehicles than the maximum capacity of the parking lot.
   If the parking is full, the system should be able to show a message at the entrance panel and on the parking display board on the ground floor.
   max capacity warning.
8. parking floor spot with mixed vehicles.
9. electric car parking, extra charge if opt for charging.
10. vehicle type as well
11. per-hour parking fee model

Actors/Role:
Admin
System
com.bookmyshow.users.LoggedUser
Assistant:  can take paymentProcessor, be at info panel paymentProcessor,



Actions 
    | Admin does all 
1. generate ticket  S,A
2. pay ticket C
3. process paymentProcessor A,S
4. calculate amount S
5. reserve spot S
6. release spot S
7. accept paymentProcessor S,A
	
	com.bookmyshow.users.LoggedUser        1. Accept ticket
					2. scan ticker
					3. pay ticket
					4. Credit Card/Cash paymentProcessor

	Attendant: 1. manage customer account, view, update, sys login and cash paymentProcessor accept
	
	System: assign parketing spot, release spot, show full message, show available parking spot
	
	Admin: add floor, add spot, add parking attendat, add/update rate, add entry exit : modify infratstructure
	
	---------------------
	
	Parking Lot : id - Name, and address (singleton for now, if single but can be entity as well)
	
	ParkingFloor: has multiple spots, charging point, info panel, entry exit
	
	Parking Spot: id:, type, charging point, isOccupied, 
	
	Account: Admin, assiant, basic details, user login details, define access
	
	Ticket: id, parking spot, vehicle details, timeOfIssue, timeOfLeave, rateCard, paymentProcessor details 
	
	Vehicle: license plate, customer details, type of parking required, electric or not
	
	Entry/Exit: id, Entry: generateTicket , Exit: process paymentProcessor
	
	Payment: mode of paymentProcessor, interface to other paymentProcessor method (could be a service in its own, but have its own DB)
	
	ParkingRate: configs, id, timeOfIssue, (validTill, YAGNI?)
	
	ParkingDisplayBoard: outer interface, id, location, status, message. isWorking, lastUpdated
	
	ParkingAttendantPortal: has attendant, info about attendant logins and logout, floor ids, scan ticket, process paymentProcessor
	
	CustomerInfoPanel: ssame as above, pay, update ticket. details.
	
	ElectricPanel: pay and charge vehicle, property of a ParkingSpot
	
	
	
	
