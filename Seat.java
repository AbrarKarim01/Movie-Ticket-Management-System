package MovieTicket;

import java.awt.Graphics;


public class Seat
{
	private final int Height = 30; //Height of the drawn text box
	private final int Width = 50; //Width of the drawn text box
	private int seatNumber;
	private int seatTaken;
	private int x;
	private int y;
	
	
	public void display(Graphics graf)
	{
		int xDraw, yDraw;
		
		switch (seatTaken)
		{
		case 0:
			xDraw = x +  Width;
			yDraw = y +  Height;
			graf.drawRect(x , y, Width, Height);
			graf.drawString(Integer.toString(seatNumber),x + 20,y + Height *3 / 4); //Painting the seat with the seat number printed inside
			break;
		case 1:
			xDraw = x + Width;
			yDraw = y + Height;
			graf.drawRect(x ,y ,Width, Height);
			String msg = "N/A";
			graf.drawString(msg, x + 20, y + Height *3 / 4); //Painting the seat with N/A printed inside
			break;
		default:
			break;
		}

	}

	public Seat(int number, int taken, int xStart, int yStart)
	{
		seatNumber = number; //Setting the seatnumber
		seatTaken = taken; //Setting whether it is taken
		x = xStart; //Display position
		y = yStart;
	}

	public int isTaken()
	{
		return seatTaken;
	}
	public void setSeat()
	{
		seatTaken = 1;
	}
}
