# Movie Ticket Management System

A Java Swing desktop app for booking movie tickets. The UI lets users pick a ticket type, showtime, and seating block, then reserve seats and generate a printable ticket summary saved to a local file.

## Project Output
![Output](https://github.com/AbrarKarim01/Movie-Ticket-Management-System/assets/76803325/4b30d03a-1a53-4ea7-901a-80ec61c121af)

## Features
- GUI-based booking flow with seat selection.
- Multiple showtimes: 1:00, 3:00, 5:00, 7:00, 9:00.
- Ticket types: Adult, Child, Senior Citizen.
- Seat blocks: Left, Middle, Right.
- Pricing by block and ticket type (currency shown as Taka).
- Prevents double-booking within a showtime/block.
- Exports booked tickets to `tickets.txt`.

## Tech Stack
- Java
- Java Swing (GUI)

## Project Structure
- `BookingDriver.java` - App entry point.
- `Booking.java` - Main UI, booking logic, and ticket export.
- `Seat.java` - Seat model and rendering.
- `Ticket.java` - Ticket model and pricing rules.
- `tickets.txt` - Output file generated after payment.

## How to Run (macOS)
1. Open a terminal in the project folder.
2. Compile the source files:
	```bash
	javac -d out Booking.java Seat.java Ticket.java BookingDriver.java
	```
3. Run the application:
	```bash
	java -cp out MovieTicket.BookingDriver
	```

## How to Use
1. Choose a ticket type, block, and time.
2. Click **Show** to display the seating grid for the selected time.
3. Enter a seat number (0-15) and click **Submit** to book it.
4. Repeat to add more seats.
5. Click **Pay** to finalize and generate `tickets.txt`.

## Pricing Rules
Prices are determined by ticket type and seating block.

| Block         | Adult | Child | Senior Citizen |
|---------------|------:|------:|---------------:|
| Left Block    |   500 |   200 |            300 |
| Middle Block  |  1000 |   500 |           3000 |
| Right Block   |   500 |   200 |            300 |

## Notes and Limitations
- Each block has a 4x4 grid (16 seats) per showtime.
- Maximum tickets tracked in memory: 30.
- Seat bookings are not persisted across app restarts.
- `tickets.txt` is overwritten each time **Pay** is used.

## Future Improvements
- Persist bookings across sessions.
- Add input validation for invalid seat numbers.
- Add a movie selector and multiple screens.
- Improve layout and accessibility for the GUI.
