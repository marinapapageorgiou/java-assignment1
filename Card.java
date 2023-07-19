class Card
{
	private String figure;
	private int value;
	
	public Card(String figure)
	{
		this.figure=figure;   
		this.value=value;
	}
	
	public String getFigure()
	{
		return this.figure;
		
	}
	
	public int getValue()
	{
		if(this.figure=="J" || this.figure=="Q" || this.figure=="K"){
			value=10;
			return value;
		}else if(this.figure=="Ace"){
			return 1;
		}else{
			value=Integer.parseInt(this.figure);
		}
		return value;           
	}
	
	public boolean isAce()
	{
		if(figure!="Ace"){
			return false;
		}
		return true;
	}
	
	public boolean equals(Card other){
		if(!other.figure.equals(figure)){              
			return false;
		}
		return true;
	}
	
	public String toString()
	{
		return figure;
	}
	
	public static void main(String args[])
	{
		Card price=new Card("9");
		System.out.println(price);
	}
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757