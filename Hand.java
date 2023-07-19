import java.util.ArrayList;
class Hand
{
	private ArrayList<Card> myList = new ArrayList<Card>();     
	private int points=0;
	private Card myarray;
	
	
	public void addCard(Card card){
		this.myList.add(card);
	}
	
	public void score(){
		this.points=0;
		for(int i=0;i<this.myList.size();i++){                       
				this.points+=this.myList.get(i).getValue();
		}
		for(int i=0;i<this.myList.size();i++){
			if(this.myList.get(i).getFigure()=="Ace" && this.points+10<=21){
				this.points=this.points+10;
			}
		}
	}
	
	public int getPoints(){
		return this.points;
	}
	
	public boolean canSplit(){
		if(this.myList.get(0).getFigure()==this.myList.get(1).getFigure()){
			return true;
		}
		return false;
	}		
	
	public static Hand[] split(Hand currentHand){
		Hand[] doubleHand = new Hand[2];
		
		Card card1=new Card(currentHand.myList.get(0).getFigure());
		Card card2=new Card(currentHand.myList.get(1).getFigure());
		
		currentHand.myList.remove(1);
	   
		doubleHand[0]=new Hand();
		doubleHand[0].addCard(card1);
		
		doubleHand[1]=new Hand();
		doubleHand[1].addCard(card2);
			
		return doubleHand;
	}

	public boolean isBlackjack(){
		if((this.myList.get(0).getFigure()=="Ace" && this.myList.get(1).getValue()==10) || (this.myList.get(1).getFigure()=="Ace" && this.myList.get(0).getValue()==10)){
			return true;
		}
		return false;
	}
	
	public boolean isBust(){
		score();
		if(this.points>21){
			return true;
		}
		return false;
	}
	
	public String toString(){
		String cards="";
		for(int i=0;i<myList.size();i++){
			cards+=this.myList.get(i).getFigure()+" ";
		}
		score();
		return cards+" - "+this.points;
	}
	
	public static void main(String args[]){
		Hand player1=new Hand(); 
		Hand[] player12=new Hand[2];
		
		Card card=new Card("Ace");
		player1.addCard(card);
		player1.addCard(card);
		
		System.out.println(player1+" - " + player1.canSplit());
		//--------------kanw split-------------------

		player12=split(player1);
		//--------------typwnw ta dyo xeria------------------------
		System.out.println(player12[0]);
		System.out.println(player12[1]);	
		
		Card card1=new Card("K");
		//----------------prosthetw ena riga sto prwto xeri-----------------
		player12[0].addCard(card1);
		System.out.println(player12[0]+" - " +player12[0].isBlackjack());

		//----------------prosthetw enan asso sto prwto xeri-----------------
		player12[0].addCard(card);
		System.out.println(player12[0]);
		
		Card card2=new Card("10");
		//----------------prosthetw ena 10 sto prwto xeri-----------------
		player12[0].addCard(card2);
		System.out.println(player12[0]+" - " +player12[0].isBust());
	}
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757