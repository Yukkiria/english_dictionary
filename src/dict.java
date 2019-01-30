import java.util.*;

class dict
{
	private static HashMap<String, Vector <String> > dict;


		public static void main(String[] args) {
			HashMap<String, Vector<String> > dict = new HashMap<String, Vector <String> >();
			Scanner in = new Scanner(System.in);
			String scan;
			String[] mas;
			Vector <String> t;

			System.out.println("===START===");
			//first console scan
			scan = in.nextLine();
			mas = scan.split(" ");

			while (!(new String(mas[0]).equals("exit"))) {
				t= new Vector <String>();

				switch (mas[0]){
					case "get":

						if (mas.length != 2){
							System.out.println("------\n=== Error in get ===\n------");
							break;
						}
						t=dict.get(mas[1]);
						if (t==null){
							System.out.println("------\nThis Word Is Not In The Dictionary\n------");							
							break;						
						}
						if (t.size()==0){
							System.out.println("------\nAll Definitions Deleted\n------");							
							break;
						}
						for (String retval:t) {
							System.out.printf("->%s\n",retval);
						}
						System.out.println("------");						
						break;

					case "put":

						if (mas.length != 3){
							System.out.println("------\n=== Error In put ===\n------");
							break;
						}
						t=dict.get(mas[1]);
						if (t==null){
						dict.put(mas[1], new Vector<String>());						
						}		
						dict.get(mas[1]).addElement(mas[2]);

						System.out.println("------\nDefinition Added\n------");												
						break;
					
					case "del_word":
						
						if (mas.length != 2){
							System.out.println("------\n=== Error In del_word ===\n------");
							break;
						}
						t=dict.get(mas[1]);						
						if (t==null){
							System.out.println("------\n=== This Word Is Not In The Dictionary ===\n------");
							break;							
						}
						dict.remove(mas[1]);		
						System.out.println("------\nDeleted\n------");						
						break;

					case "del_def":

						if (mas.length != 3){
							System.out.println("------\n=== Error In del_def ===\n------");
							break;
						}
						t=dict.get(mas[1]);
						if (t==null){
							System.out.println("------\nThis Word Is Not In The Dictionary\n------");
							break;						
						}

						if (!(t.contains(mas[2]))){
							System.out.println("------\nThe Word Does Not Contain This Definition\n------");
							break;						
						}
						dict.get(mas[1]).remove(mas[2]);
						System.out.println("------\nDeleted\n------");						
						break;

					default:
						System.out.println("------\n=== Wrong Input ===\n------");
						break;						
				}
				//second endless cycle
				scan = in.nextLine();
				mas = scan.split(" ");
			}

			in.close();
			System.out.println("===GoodBye===");
		}	
}