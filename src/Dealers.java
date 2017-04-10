import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

public class Dealers {

	TreeSet<String> sorted = new TreeSet<String>();

	private void getlist() {
		try{
			File dealersFile = new File ("C:\\Users\\amanda\\Desktop\\IS\\Java\\final-project\\dealers.txt");
			BufferedReader reader = new BufferedReader(new FileReader(dealersFile));
			String line=null;
			while((line=reader.readLine())!=null){
				addnames(line);
			}reader.close();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}void addnames(String a){
		sorted.add(a);
		for(int i=1; i<a.length();i++){
			
		}
	}
	
	public void list(){
		getlist();
		System.out.println(sorted);
	}
	
	public static void main(String[] args) {
		new Dealers().list();

	}
	
	

}
