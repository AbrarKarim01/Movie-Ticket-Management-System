package MovieTicket;

class Ticket
{
	private int price;
	private String ticketType;
	private int seatNum;
	private String ticketTime;
	private String blockTicket;


	public Ticket (String type, int seatnumber, String block, String time)
	{
		seatNum = seatnumber; //Setting tickets seat number
		ticketType = type; //Setting ticket type
		blockTicket = block; //Setting block
		ticketTime = time; //Setting time

		if (blockTicket == "Left Block")
		{

			if (type == "Adult")
			{
				price = 500; //Setting adult price
			}
			if (type == "Senior Citizen")
			{
				price = 300; //Setting Senior Citizen price
			}
			if (type == "Child")
			{
				price = 200;  //Setting child price
			}
		}

		if (blockTicket == "Middle Block")
		{

			if (type == "Adult")
			{
				price = 1000; //Setting adult price
			}
			if (type == "Senior Citizen")
			{
				price = 3000; //Setting Senior Citizen price
			}
			if (type == "Child")
			{
				price = 500;  //Setting child price
			}
		}

		if (blockTicket == "Right Block")
		{

			if (type == "Adult")
			{
				price = 500; //Setting adult price
			}
			if (type == "Senior Citizen")
			{
				price = 300; //Setting Senior Citizen price
			}
			if (type == "Child")
			{
				price = 200;  //Setting child price
			}
		}
	}
	/* The following get methods are used to print tickets */
	public int getSeatPrice()
	{
		return price;
	}
	public String getTime()
	{
		return ticketTime;
	}
	public String getBlock()
	{
		return blockTicket;
	}
	public String getType()
	{
		return ticketType;
	}
	public int getSeatNum()
	{
		return seatNum;
	}

}

