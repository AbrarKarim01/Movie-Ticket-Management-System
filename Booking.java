
package MovieTicket;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;

public class Booking extends JFrame implements ActionListener
{
	JTextField seat, totalCost;
	Choice type, block, time; // Choices for the GUI
	JLabel typeLable, blockLable, timeLable,inputseatLable, totalLable, title;
	JButton submitButton, showButton, payButton;
	String selectedTime, total, selectedSeat, selectedBlock, ticketType;
	
	private int timeChoice, convertedSeat1, convertedSeat2, totalPrice;
	private int totalTickets = 0, currentI;

	Seat leftSide1[][] = new Seat [4] [4];
	Seat midSide1[][] = new Seat [4] [4];
	Seat rightSide1[][] = new Seat [4] [4]; // Each one of these creates an array for each block

	Seat leftSide3[][] = new Seat [4] [4];
	Seat midSide3[][] = new Seat [4] [4];
	Seat rightSide3[][] = new Seat [4] [4];

	Seat leftSide5[][] = new Seat [4] [4];
	Seat midSide5[][] = new Seat [4] [4];
	Seat rightSide5[][] = new Seat [4] [4];

	Seat leftSide7[][] = new Seat [4] [4];
	Seat midSide7[][] = new Seat [4] [4];
	Seat rightSide7[][] = new Seat [4] [4];

	Seat leftSide9[][] = new Seat [4] [4];
	Seat midSide9[][] = new Seat [4] [4];
	Seat rightSide9[][] = new Seat [4] [4];

	Ticket tickets[] = new Ticket[30]; //Array for storing the tickets booked

	public Booking()
	{
		setSize(800,500);
		setLocation(200,200);
		setResizable(false);
                setTitle("Movie Ticket Managemest System");
		setLayout(new FlowLayout());
		ImageIcon imgtitle = new ImageIcon("");
		title = new JLabel(imgtitle);
		typeLable = new JLabel("Ticket Type: ");
		typeLable.setFont(new Font("Verdana", Font.BOLD, 22));
		type = new Choice();
		type.add("Adult");
		type.add("Child");
		type.add("Senior Citizen");
		blockLable = new JLabel("Block:");
		blockLable.setFont(new Font("Verdana", Font.BOLD, 22));
		block = new Choice();
		block.add("Left Block");
		block.add("Middle Block");
		block.add("Right Block");
		timeLable = new JLabel("Time: ");
		timeLable.setFont(new Font("Verdana", Font.BOLD, 22));
		time = new Choice();
		time.add("1:00");
		time.add("3:00");
		time.add("5:00");
		time.add("7:00");
		time.add("9:00");
		payButton = new JButton("Pay");
		payButton.setBackground(Color.white);
		inputseatLable = new JLabel ("Enter Seat Num: ");
		inputseatLable.setFont(new Font("Verdana", Font.BOLD, 22));
		seat = new JTextField(2);
		seat.setFont(new Font("Verdana", Font.BOLD, 20));
		seat.setHorizontalAlignment(seat.CENTER);
		totalLable = new JLabel ("Total Price: ");
		totalLable.setFont(new Font("Verdana", Font.BOLD, 22));
		totalCost = new JTextField(7);
		totalCost.setFont(new Font("Verdana", Font.BOLD, 22));
		totalCost.setHorizontalAlignment(totalCost.CENTER);
		totalCost.setEditable(false);
		submitButton = new JButton("Submit");
		submitButton.setBackground(Color.white);
		showButton = new JButton("Show");
		showButton.setBackground(Color.white);

		/* The following delcarations
		initialise the variables for
		the positions of the blocks */

		int xLeft = 0;
		int yLeft = 0;
		
		int xMid = 0;
		int yMid = 0;
		
		int xRight = 0;
		int yRight = 0;


		xLeft = 50;
		yLeft = 310; 
		int totalleftSide1 = 0; 

		for (int i = 0; i < leftSide1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftSide1[i][j]=new Seat(totalleftSide1, 0, xLeft, yLeft);
				xLeft += 50; 
				totalleftSide1 ++; 
			}
			xLeft = 50; 
			yLeft += 30; 
		}

		xMid = 300;
		yMid = 310; 
		int totalmidSide1 = 0; 
		for (int i = 0; i < midSide1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midSide1[i][j]=new Seat(totalmidSide1, 0, xMid, yMid);
				xMid += 50; 
				totalmidSide1 ++; //Adding one to the total for the next seat
			}
			xMid = 300; //Moving back to the left for the next row
			yMid += 30;  //Moving down for the next row
		}

		xRight = 550;
		yRight = 310; //Initial positions
		int totalrightSide1 = 0; 
		for (int i = 0; i < rightSide1.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightSide1[i][j]=new Seat(totalrightSide1, 0, xRight, yRight);
				xRight += 50; //Moving the next seat along the x position by 50
				totalrightSide1 ++; //Adding one to the total for the next seat
			}
			xRight = 550; //Moving back to the left for the next row
			yRight += 30; //Moving down for the next row
		}

		

		xLeft = 50;
		yLeft = 310;
		int totalleftSide3 = 0;

		for (int i = 0; i < leftSide3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftSide3[i][j]=new Seat(totalleftSide3, 0, xLeft, yLeft);
				xLeft += 50;
				totalleftSide3 ++;
			}
			xLeft = 50;
			yLeft += 30;
		}

		xMid = 300;
		yMid = 310;
		int totalmidSide3 = 0;
		for (int i = 0; i < midSide3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midSide3[i][j]=new Seat(totalmidSide3, 0, xMid, yMid);
				xMid += 50;
				totalmidSide3 ++;
			}
			xMid = 300;
			yMid += 30;
		}

		xRight = 550;
		yRight = 310;
		int totalrightSide3 = 0;
		for (int i = 0; i < rightSide3.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightSide3[i][j]=new Seat(totalrightSide3, 0, xRight, yRight);
				xRight += 50;
				totalrightSide3 ++;
			}
			xRight = 550;
			yRight += 30;
		}


		xLeft = 50;
		yLeft = 310;
		int totalleftSide5 = 0;

		for (int i = 0; i < leftSide5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftSide5[i][j]=new Seat(totalleftSide5, 0, xLeft, yLeft);
				xLeft += 50;
				totalleftSide5 ++;
			}
			xLeft = 50;
			yLeft += 30;
		}

		xMid = 300;
		yMid = 310;
		int totalmidSide5 = 0;
		for (int i = 0; i < midSide5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midSide5[i][j]=new Seat(totalmidSide5, 0, xMid, yMid);
				xMid += 50;
				totalmidSide5 ++;
			}
			xMid = 300;
			yMid += 30;
		}

		xRight = 550;
		yRight = 310;
		int totalrightSide5 = 0;
		for (int i = 0; i < rightSide5.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightSide5[i][j]=new Seat(totalrightSide5, 0, xRight, yRight);
				xRight += 50;
				totalrightSide5 ++;
			}
			xRight = 550;
			yRight += 30;
		}


		xLeft = 50;
		yLeft = 310;
		int totalleftSide7 = 0;

		for (int i = 0; i < leftSide7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftSide7[i][j]=new Seat(totalleftSide7, 0, xLeft, yLeft);
				xLeft += 50;
				totalleftSide7 ++;
			}
			xLeft = 50;
			yLeft += 30;
		}

		xMid = 300;
		yMid = 310;
		int totalmidSide7 = 0;
		for (int i = 0; i < midSide7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midSide7[i][j]=new Seat(totalmidSide7, 0, xMid, yMid);
				xMid += 50;
				totalmidSide7 ++;
			}
			xMid = 300;
			yMid += 30;
		}

		xRight = 550;
		yRight = 310;
		int totalrightSide7 = 0;
		for (int i = 0; i < rightSide7.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightSide7[i][j]=new Seat(totalrightSide7, 0, xRight, yRight);
				xRight += 50;
				totalrightSide7 ++;
			}
			xRight = 550;
			yRight += 30;
		}

		xLeft = 50;
		yLeft = 310;
		int totalleftSide9 = 0;

		for (int i = 0; i < leftSide9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				leftSide9[i][j]=new Seat(totalleftSide9, 0, xLeft, yLeft);
				xLeft += 50;
				totalleftSide9 ++;
			}
			xLeft = 50;
			yLeft += 30;
		}

		xMid = 300;
		yMid = 310;
		int totalmidSide9 = 0;
		for (int i = 0; i < midSide9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				midSide9[i][j]=new Seat(totalmidSide9, 0, xMid, yMid);
				xMid += 50;
				totalmidSide9 ++;
			}
			xMid = 300;
			yMid += 30;
		}

		xRight = 550;
		yRight = 310;
		int totalrightSide9 = 0;
		for (int i = 0; i < rightSide9.length; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				rightSide9[i][j]=new Seat(totalrightSide9, 0, xRight, yRight);
				xRight += 50;
				totalrightSide9 ++;
			}
			xRight = 550;
			yRight += 30;
		}
		/* Adding the labels and text boxes to the screen */

		getContentPane().add(title);
		getContentPane().add(typeLable);
		getContentPane().add(type);
		getContentPane().add(blockLable);
		getContentPane().add(block);
		getContentPane().add(timeLable);
		getContentPane().add(time);
		getContentPane().add(showButton);
		getContentPane().add(inputseatLable);
		getContentPane().add(seat);
		getContentPane().add(submitButton);
		getContentPane().add(totalLable);
		getContentPane().add(totalCost);
		getContentPane().add(payButton);


		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Color mycolor = new Color(255,255,255);
		getContentPane().setBackground(mycolor);

		submitButton.addActionListener(this);
		showButton.addActionListener(this); //Action listener for each individual button
		payButton.addActionListener(this);
	}
	public void paint(Graphics graf)
	{
		super.paint(graf);

		switch(timeChoice)
		{
			case 1:
				for (int i = 0; i < leftSide1.length; i++) //Looping throw the leftside at 1 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide1[i][j].display(graf); //Displaying the left side @ 1
						midSide1[i][j].display(graf); //Displaying the mid side @ 1
						rightSide1[i][j].display(graf); //Displaying the right side @ 1
					}
				}
				break;
			case 3:
				for (int i = 0; i < leftSide3.length; i++) //Looping through the leftside at 3 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide3[i][j].display(graf); //Displaying the left side @ 3
						midSide3[i][j].display(graf); //Displaying the mid side @ 3
						rightSide3[i][j].display(graf); //Displaying the right side @ 3
					}
				}
				break;
			case 5:
				for (int i = 0; i < leftSide5.length; i++) //Looping through the leftside at 5 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide5[i][j].display(graf); //Displaying the left side @ 5
						midSide5[i][j].display(graf); //Displaying the mid side @ 5
						rightSide5[i][j].display(graf); //Displaying the right side @ 5
					}
				}
				break;
			case 7:
				for (int i = 0; i < leftSide7.length; i++) //Looping through the leftside at 7 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide7[i][j].display(graf); //Displaying the left side @ 7
						midSide7[i][j].display(graf); //Displaying the mid side @ 7
						rightSide7[i][j].display(graf); //Displaying the right side @ 7
					}
				}
				break;
			case 9:
				for (int i = 0; i < leftSide9.length; i++) //Looping through the leftside at 7 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide9[i][j].display(graf); //Displaying the left side @ 7
						midSide9[i][j].display(graf); //Displaying the mid side @ 7
						rightSide9[i][j].display(graf); //Displaying the right side @ 7
					}
				}
				break;
			default:
			/* Used as what appears when the program starts */
				for (int i = 0; i < leftSide1.length; i++) //Looping through the leftside at 1 block - gives initial size
				{
					for (int j = 0; j < 4; j++) //Looping through each row fully
					{
						leftSide1[i][j].display(graf); //Displaying the left side @ 1
						midSide1[i][j].display(graf); //Displaying the mid side @ 1
						rightSide1[i][j].display(graf); //Displaying the right side @ 1
					}
				}
				break;
		}
	}
	public void actionPerformed(ActionEvent ev)
	{
		selectedBlock = block.getSelectedItem(); //The values neeeded to book seats and check for availability taken from text boxes
		selectedTime = time.getSelectedItem();
		ticketType = type.getSelectedItem();

		if (ev.getSource() == submitButton)
		{
			selectedSeat = seat.getText();
			int selectSeat = Integer.parseInt(selectedSeat); //Getting the seat number and converting it to an integer

			/* The following set of if statements checks for seat number and converts it
			to an X, Y position which can be used for booking */

			if (selectSeat == 0)
				{convertedSeat1 = 0;
				convertedSeat2 = 0;}
			if (selectSeat == 1)
				{convertedSeat1 = 0;
				convertedSeat2 = 1;}
			if (selectSeat == 2)
				{convertedSeat1 = 0;
				convertedSeat2 = 2;}
			if (selectSeat == 3)
				{convertedSeat1 = 0;
				convertedSeat2 = 3;}
			if (selectSeat == 4)
				{convertedSeat1 = 1;
				convertedSeat2 = 0;}
			if (selectSeat == 5)
				{convertedSeat1 = 1;
				convertedSeat2 = 1;}
			if (selectSeat == 6)
				{convertedSeat1 = 1;
				convertedSeat2 = 2;}
			if (selectSeat == 7)
				{convertedSeat1 = 1;
				convertedSeat2 = 3;}
			if (selectSeat == 8)
				{convertedSeat1 = 2;
				convertedSeat2 = 0;}
			if (selectSeat == 9)
				{convertedSeat1 =2;
				convertedSeat2 = 1;}
			if (selectSeat == 10)
				{convertedSeat1 = 2;
				convertedSeat2 = 2;}
			if (selectSeat == 11)
				{convertedSeat1 = 2;
				convertedSeat2 = 3;}
			if (selectSeat == 12)
				{convertedSeat1 = 3;
				convertedSeat2 = 0;}
			if (selectSeat == 13)
				{convertedSeat1 = 3;
				convertedSeat2 = 1;}
			if (selectSeat == 14)
				{convertedSeat1 = 3;
				convertedSeat2 = 2;}
			if (selectSeat == 15)
				{convertedSeat1 = 3;
				convertedSeat2 = 3;}


				if (selectedTime == "1:00") 
				{
				timeChoice = 1;
				repaint();
				if (selectedBlock == "Left Block") // If they are trying to book a seat in the left block
				{
					int ifTaken = leftSide1[convertedSeat1][convertedSeat2].isTaken(); 
					if (ifTaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); 
					}
					else if (ifTaken == 0)
					{
						leftSide1[convertedSeat1][convertedSeat2].setSeat(); //Sets the seat to booked
						repaint(); //Re-displays it
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime); //Creates a new ticket objects in the tickets array
						int tempPrice = tickets[totalTickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice)); //Updates and adds to the text box
						totalTickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
				if (selectedBlock == "Middle Block")  // If they are trying to book a seat in the middle block
				{
					int ifTaken = midSide1[convertedSeat1][convertedSeat2].isTaken(); //Uses the istaken() method to see if it is taken
					if (ifTaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked"); //Seat is taken and outputs an error message
					}
					else if (ifTaken == 0)
					{
						midSide1[convertedSeat1][convertedSeat2].setSeat(); //Sets the seat to booked
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime); //Creates a new ticket objects in the tickets array
						int tempPrice = tickets[totalTickets].getSeatPrice();  //Gets the seat price using the getSeatPrice() method
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice)); //Updates and adds to the text box
						totalTickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
				if (selectedBlock == "Right Block")  // If they are trying to book a seat in the right block
				{
					int ifTaken = rightSide1[convertedSeat1][convertedSeat2].isTaken(); //Uses the istaken() method to see if it is taken
					if (ifTaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");  //Seat is taken and outputs an error message
					}
					else if (ifTaken == 0)
					{
						rightSide1[convertedSeat1][convertedSeat2].setSeat(); //Sets the seat to booked
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);  //Creates a new ticket objects in the tickets array
						int tempPrice = tickets[totalTickets].getSeatPrice(); //Gets the seat price using the getSeatPrice() method
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice)); //Updates and adds to the text box
						totalTickets += 1; //Updates the total amount of tickets booked
						seat.setText("");
					}
				}
			}

			/* Code is replicated for each of the times the user wants to book*/

			if (selectedTime == "3:00")
			{
				timeChoice = 3;
				repaint();

				if (selectedBlock == "Left Block")
				{
					int ifTaken = leftSide3[convertedSeat1][convertedSeat2].isTaken();
					if (ifTaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (ifTaken == 0)
					{
						leftSide3[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Middle Block")
				{
					int iftaken = midSide3[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midSide3[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Right Block")
				{
					int iftaken = rightSide3[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightSide3[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}

			}
			if (selectedTime == "5:00")
			{
				timeChoice = 5;
				repaint();

				if (selectedBlock == "Left Block")
				{
					int iftaken = leftSide5[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftSide5[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Middle Block")
				{
					int iftaken = midSide5[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midSide5[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Right Block")
				{
					int iftaken = rightSide5[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightSide5[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedTime == "7:00")
			{
				timeChoice = 7;
				repaint();

				if (selectedBlock == "Left Block")
				{
					int iftaken = leftSide7[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftSide7[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Middle Block")
				{
					int iftaken = midSide7[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midSide7[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempprice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempprice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Right Block")
				{
					int iftaken = rightSide7[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightSide7[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempprice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempprice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
			}
			if (selectedTime == "9:00")
			{
				timeChoice = 9;
				repaint();

				if (selectedBlock == "Left Block")
				{
					int iftaken = leftSide9[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						leftSide9[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Middle Block")
				{
					int iftaken = midSide9[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						midSide9[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka "+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
				if (selectedBlock == "Right Block")
				{
					int iftaken = rightSide9[convertedSeat1][convertedSeat2].isTaken();
					if (iftaken == 1)
					{
						JOptionPane.showMessageDialog(null, "This seat is taken and cannot be booked");
					}
					else if (iftaken == 0)
					{
						rightSide9[convertedSeat1][convertedSeat2].setSeat();
						repaint();
						tickets[totalTickets] = new Ticket(ticketType, selectSeat, selectedBlock, selectedTime);
						int tempPrice = tickets[totalTickets].getSeatPrice();
						totalPrice = totalPrice + tempPrice;
						totalCost.setText("Taka"+ Integer.toString(totalPrice));
						totalTickets += 1;
						seat.setText("");
					}
				}
			}
		}
		if (ev.getSource() == showButton)
		{
			/* If the user has clicked the show button it sets a variable and then repaints the desired time */

			if (selectedTime == "1:00")
			{
				timeChoice = 1;
				repaint();
			}
			if (selectedTime == "3:00")
			{
				timeChoice = 3;
				repaint();
			}
			if (selectedTime == "5:00")
			{
				timeChoice = 5;
				repaint();
			}
			if (selectedTime == "7:00")
			{
				timeChoice = 7;
				repaint();
			}
			if(selectedTime == "9:00")
			{
				timeChoice = 9;
				repaint();
			}

		}
		if (ev.getSource() == payButton) //Pay button to generate tickets
		{

  				try{
  					FileWriter stream= new FileWriter("tickets.txt"); //Opening the tickets.txt file
  					BufferedWriter output = new BufferedWriter(stream);

					for (int i = 0; i < totalTickets; i++) //Looping through the number of tickets booked
					{
  						/* Getting the variables needed from methods related to the object */

  						int ticketNum = tickets[i].getSeatNum();
						int ticketPrice = tickets[i].getSeatPrice();
						String ticketType = tickets[i].getType();
						String ticketTime = tickets[i].getTime();
						String ticketBlock = tickets[i].getBlock();
						String newLine = System.getProperty("line.separator");

						output.write(newLine);
						output.write("Ticket Details");
						output.write(newLine);
						output.write(newLine);
						output.write("Ticket Number: " + ticketNum); //Writing ticketnum
						output.write(newLine);
						output.write("Ticket Price: " + ticketPrice);
						output.write(newLine);
						output.write("Ticket Type: " + ticketType);
						output.write(newLine);
						output.write("Ticket Time: " + ticketTime);
						output.write(newLine);
						output.write("Ticket Block: " + ticketBlock);
						output.write(newLine);
						output.write("____________________________________________________________________________________");
						output.write(newLine);
					}
					output.close();
  					}catch (Exception e){//Catch exception if any
  					System.err.println("Error: " + e.getMessage());}

  				JOptionPane.showMessageDialog(null, "Success!! Ticket(s) are booked."); //Success message

  				for(int i=0; i < tickets.length; i++)
  				{
					tickets[i] = null; //Setting the tickets array values to null so new tickets can be booked
				}
				totalTickets = 0; //Resets totaltickets to 0
				totalPrice = 0; //Resets totalprice to 0
				totalCost.setText(""); //Sets totalcost to an empty text field
				seat.setText(""); //Wipes seat number text field
		}
	}
}
