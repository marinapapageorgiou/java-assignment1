import java.util.Scanner;
import java.util.Random;

import java.io.*; 
import java.util.*; 

class River
{
	private int NumberOfCards;
	private String[] array;
	private Card[] myarray;
	private int CardsLeft;                          
		
	public River(int cards){  
		this.array=new String[52];
		array[0]="Ace";
		array[1]="Ace";
		array[2]="Ace";
		array[3]="Ace";
		array[4]="K";
		array[5]="K";
		array[6]="K";
		array[7]="K";
		array[8]="Q";
		array[9]="Q";
		array[10]="Q";
		array[11]="Q";
		array[12]="J";
		array[13]="J";
		array[14]="J";
		array[15]="J";
		array[16]="10";
		array[17]="10";
		array[18]="10";
		array[19]="10";
		array[20]="9";
		array[21]="9";
		array[22]="9";
		array[23]="9";
		array[24]="8";
		array[25]="8";
		array[26]="8";
		array[27]="8";
		array[28]="7";
		array[29]="7";
		array[30]="7";
		array[31]="7";
		array[32]="6";
		array[33]="6";
		array[34]="6";
		array[35]="6";
		array[36]="5";
		array[37]="5";
		array[38]="5";
		array[39]="5";
		array[40]="4";
		array[41]="4";
		array[42]="4";
		array[43]="4";
		array[44]="3";
		array[45]="3";
		array[46]="3";
		array[47]="3";
		array[48]="2";
		array[49]="2";
		array[50]="2";
		array[51]="2";
	
		this.NumberOfCards=cards*52;
	   	this.CardsLeft=this.NumberOfCards;
		
		this.myarray=new Card[this.NumberOfCards];
		int k=0;
		for(int i=0;i<cards;i++){
			for(int j=0;j<array.length;j++){				
				myarray[k]=new Card(array[j]);  
				k++;
			}
			
		}
	}
	
	public Card nextCard(){            
		Random random = new Random();
		int r;
		if(this.CardsLeft>1){
			r=random.nextInt(CardsLeft-1);
			swap(myarray[r],myarray[CardsLeft-1]);
			this.CardsLeft--;  
		}else{
			return null;
		}
		return this.myarray[r];
	}

    public Card[] getmyarray() {
		return this.myarray;
	}
	
	public int getCardsLeft(){
		return this.CardsLeft;
	}
	
	
	public void swap(Card c1,Card c2)
	{
		Card temp=c1;
		c1=c2;
		c2=temp;
	}
	
	public boolean shouldRestart(){
		int x=this.myarray.length/4;
		if(this.CardsLeft<=x){                      
			return true;
		}
		return false;
	}
		
	public void restart(){
		this.CardsLeft=this.NumberOfCards;
	}
	
	public static void main(String args[]){
		River Card1=new River(1);
				
		while(Card1.shouldRestart()==false){             
			System.out.println(Card1.nextCard().getFigure());
		}
		System.out.println("---------------------");
		Card1.restart();
		Card card=Card1.nextCard();
		while(card!=null){
			System.out.println(card.getFigure());
			System.out.println(Card1.CardsLeft);
			
			card=Card1.nextCard();
		}
	}
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757
