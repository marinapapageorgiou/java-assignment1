import java.util.Random;
import java.io.*; 
import java.util.*; 

class Dealer
{
	private River game;
	private Hand dealerhand;
	
	public Dealer(River game){
		this.game=game;
		this.dealerhand = new Hand();
	}
	
	public Hand getDealerhand(){
		return this.dealerhand;
	}
	
	public void draw(){  
		this.dealerhand.addCard(this.game.nextCard());
		this.dealerhand.score();
	}
	
	public void deal(Player player){
		player.getPlayerhand().addCard(this.game.nextCard()); 
   	}
	
	public void play(){
		this.draw();
	
		while(this.getDealerhand().getPoints()<17){
			this.draw();
		}
	}
	
	public void settle(Player player){
				
		if(this.getDealerhand().getPoints()<player.getPlayerhand().getPoints() && player.getPlayerhand().getPoints()<=21){
			player.wins();
		}else if(player.getPlayerhand().getPoints()<this.getDealerhand().getPoints() && this.getDealerhand().getPoints()<=21){
			player.loses();
		}	
        else {
			
			System.out.println("Tie with "+player);
		}
			System.out.println("---------------------------------");
	}
	
	public String toString(){
		return  "Dealer: "+this.getDealerhand();
	}  
	
	public static void main(String args[]){
		River trapoula=new River(1);
		Dealer dealer=new Dealer(trapoula);
		dealer.play();
		System.out.println(dealer);
		
		CasinoCustomer marina=new CasinoCustomer("Marina",50);
		
		Hand playerhand=new Hand();
		
		Player player=new Player(marina,playerhand,50);  
		
		System.out.println(marina);
		
		dealer.deal(player);

		dealer.settle(player);
	}                      
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757