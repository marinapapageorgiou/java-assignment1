import java.util.Scanner;
class  BlackjackTable
{
	private River river;                    
	private CasinoCustomer[] myarray;
	private int participants;
	
	public BlackjackTable(int participants){
		
		this.river = new River(6);
		this.participants=participants;
		this.myarray=new CasinoCustomer[participants];
		for(int i=0;i<this.myarray.length;i++){
			myarray[i]=createCasinoCustomer();
		}
	}
	
	private CasinoCustomer createCasinoCustomer(){           
		Scanner input=new Scanner(System.in);
		
		System.out.println("Give me your name:");
		String name=input.next();
		
		System.out.println("Give me your money:");
		double money=input.nextDouble();
		
		CasinoCustomer customer = new CasinoCustomer(name, money);

		return customer;
	}
	
	public void play(){
		
		while (this.participants>0) {
		
			Round round=new Round(this.river); 
		
		
			if(this.river.shouldRestart()){
				this.river.restart();
			}
		
		    for(int i=0;i<this.myarray.length;i++){
				
				if(this.myarray[i].getCasinoCustomerMoney()>=1){
					round.addPlayer(this.myarray[i]);
					this.participants+=1;
				}
				else {
					
					this.participants-=1;
				}
			}
		
			if (this.participants>0) {
				System.out.println("--------------New Round-----------");
				round.playRound();
			}
			
			round=null;
		}
		
		/*for(int i=0;i<this.myarray.length;i++){
			while(!myarray[i].isBroke()){
				//(myarray[i].loses()){
				myarray[i].toString();
			}
		}
		
		/*Scanner input=new Scanner(System.in);
		System.out.println("Do you want to continue playing?");
		String answer=input.next();
		if(answer.equals(yes)){
			answer.play();
		}*/
	}
}

class Blackjack
{	
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.println("How many players you want to add?");
		int participants2=input.nextInt();
		BlackjackTable blackjacktable=new BlackjackTable(participants2);
		blackjacktable.play();
	}
}

//NAME: MARINA PAPAGEORGIOU
//AM: 4757