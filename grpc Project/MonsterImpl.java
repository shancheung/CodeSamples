/*
Shannon McHugh
11-29-2021

@Overrides:
- view (service.EmptyM request, io.grpc.stub.StreamObserver<service.MonsterResponse> responseObserver)
	Allows the user to view monsters

- generate (service.NewMonReq request, io.grpc.stub.StreamObserver<service.MonsterResponse> responseObserver)
	Allows user to generate new monsters
	
- feed(service.FeedMonReq request, io.grpc.stub.StreamObserver<service.MonsterResponseFood> responseObserver)


Features
- ye go on do the math
*/

package example.grpcclient;

///////////////////////////////////////////////////////////////////////////////
//Inclusions
import io.grpc.*; 	//grpc
import io.grpc.stub.StreamObserver;
import java.io.*; 	//input, output streams mostly.
import java.util.*; 	//array list
import java.lang.*; 
import java.net.*; 	//socket?
import java.io.File; 	//for file stuff
import service.*; 
import java.io.IOException;

//extends CalcGrpc.CalcGrpcBase
class MonsterImpl extends MonstGrpc.MonstImplBase{
///////////////////////////////////////////////////////////////////////////////
//Variables
	ArrayList<String> monst= new ArrayList<String>(); 	//may have to change the format.
	String fname = "monsters.txt";
	File file = new File(fname);
	private String[] type={"Monkey","Frog","Lizard","Cat","Chicken","Rat","Fish","Turtle","Bear"};
	private String[] color={"Green","Red","Blue","Rainbow","Orange","Pink","Gold","Purple","Vanta Black"};
	private String[] attr={"Squishy","Bouncy","Rotund","Puffy","Iron-Clad","Stumpy","16-bit","LOOOOONG","Crusty"};
///////////////////////////////////////////////////////////////////////////////
//OVERRIDES & MonsterImpl()
	public MonsterImpl(){
		super();
		try{	readFile();
		}catch(IOException ioe){System.out.println("Exception in MonsterImpl()");}
	}
	
	@Override	//Display the list of monsters
	public void view(EmptyM request, StreamObserver<service.MonsterResponse> responseObserver){
		System.out.println("Client has requested to view monsters");
		MonsterResponse.Builder response = MonsterResponse.newBuilder();
		try{
			try{	readFile();
			}catch(IOException ioe){System.out.println("Exception in view reading file");}
			int ms=monst.size();
			System.out.println(ms);
			for(int i=0;i<ms;i++){
				response.setData(monst.toString());
			}
		}
		catch(Exception e){System.out.println("Exception in viewing monsters");}
		
		MonsterResponse resp = response.build();
		responseObserver.onNext(resp);
		responseObserver.onCompleted();
	}
	@Override	//Generate a new monster and tell the client!
	public void generate(NewMonReq request, StreamObserver<service.MonsterResponse> responseObserver){
		MonsterResponse.Builder response=MonsterResponse.newBuilder();
		System.out.println("--- Data from client");
		System.out.println("User: "+request.getUName());
		System.out.println("Data sent: "+request.getAttrList());
		try{
			//code here
			response.setData(genMon(request.getUName(),request.getAttrList()));
			writeListToFile();
		}
		catch(Exception e){System.out.println("Exception in generate();");}
		
		MonsterResponse resp = response.build();
		responseObserver.onNext(resp);
		responseObserver.onCompleted();
	}
	@Override	//Feed the monsters
	public void feed(FeedMonReq request, StreamObserver<service.MonsterResponseFood> responseObserver){
		MonsterResponseFood.Builder response=MonsterResponseFood.newBuilder();
		System.out.println("--- Data from client");
		System.out.println("User: "+request.getWho());
		System.out.println("Food: "+request.getFood());
		System.out.println("Quantity: "+request.getQuant());
		
		try{
			//code goes here
		}
		catch(Exception e){System.out.println("Exception in feed()");}
		
		MonsterResponseFood resp = response.build();
		responseObserver.onNext(resp);
		responseObserver.onCompleted();
	}
///////////////////////////////////////////////////////////////////////////////
//OTHER FUNCTIONS
	//default monsters to generate
	//Syntax to follow:: monsterName:CreatorName:foodConsumed[hard boiled egg - 20, french fry -1]
	//separator per part is ":", for food encapsulated with "[]" with "|" separators and "-" to quantity
	public ArrayList<String> defaultMonsters(){
		monst.add("Squishy Green Monkey:Shan:[hard boiled egg-20-Shan_french fry-1-Ray]");
		monst.add("Rotund Rainbow Dog:Shan:[chicken nugget-5-Shan]");
		monst.add("Bouncy Orange Lizard:Ray:[worm-10-Ray]");
		return monst;
	}
	//Generate a monster based off of inputs
	public String genMon(String un, List<Integer> lst) throws IOException{
		String c=color[lst.get(1)-1];
		String a=attr[lst.get(2)-1];
		String t=type[lst.get(0)-1];
		System.out.println("Monster generated: "+a+" "+c+" "+t+" by "+un);
		String m=" "+a+" "+c+" "+t+":"+un+":[]";
		System.out.println("File will contain: "+m);
		monst.add(m);
		return m;
	}
///////////////////////////////////////////////////////////////////////////////
//FILE HANDLING
	//reads file sends it to an array list.
	public ArrayList<String> readToArrayList(File file) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String line;
		while ((line=reader.readLine())!=null){
			if(monst.contains(line)==false){
				monst.add(line);
			}
		}
		reader.close();
		//System.out.println("Size from readToArrayList: "+monst.size());
		return monst;
	}
	//writer, for updating the file.
	public void writeListToFile() throws IOException{
		try{
			if(file.exists()){
				file.delete();		//out with the old
				file.createNewFile();	//in with the new
				BufferedWriter writer = new BufferedWriter(new FileWriter(file,true));
				for(int i=0;i<monst.size();i++){
					writer.write(monst.get(i)+System.lineSeparator());
				}
				writer.close();
			}
			else{
				System.out.println("UHHHHH COULD NOT WRITE TO FILE");
			}
		}
		catch(IOException ioe){System.out.println("EXCEPTION");}
	}
	//read file, if it's there. if not, generate a new story and .. whatever.
	public void readFile() throws IOException{
		try{
			if(file.createNewFile()){
				System.out.println("monsters.txt didn't exist so I'll make some for you!~");
				defaultMonsters();	//if no file exists, just throw in the pregen monsters.
				writeListToFile();
				readToArrayList(file);
			}
			else{
				System.out.println("monsters.txt exists, here we go");
				readToArrayList(file);
			}
		}
		catch(IOException ioe){ioe.printStackTrace(); System.out.println("D: ow my leg");}
	}
}
