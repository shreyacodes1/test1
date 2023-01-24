package p1;
import java.util.*;
import java.io.*;
public class Test01 {
	public static void main (String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
		int i;
		System.out.println("WELCOME TO \n VIRTUAL REPOSITORY\n By Shreya.M");
		do{
			String mainmenu=("Select your option:\n"
					+ "1.List all the files\n"
					+ "2.Add,Delete or Search a file\n"
					+ "3.Exit");
			System.out.println(mainmenu);
			i=sc.nextInt();
			while(i<1|| i>3) 
			{
				System.out.println("Invalid choice!");
				System.out.println(mainmenu);
				i=sc.nextInt();
			}
			switch(i)
			{
			case 1:
				File fileDir = new File("C:\\Users\\shrey\\OneDrive\\Desktop\\myfiles1");
				if(fileDir.isDirectory())
		        {
					List<String> listFile = Arrays.asList(fileDir.list());
					Collections.sort(listFile);
					for(String s:listFile)
		            {
						System.out.println(s);
					}
		        }
		     break;
		     
			case 2:
				System.out.println("Enter your option:\n"
						+ "A.Add a file\n"
						+ "B.Delete a file\n"
						+ "C.Search a file");
			    char j=sc.next().charAt(0);
			    
			    if (j=='A'||j=='a')
			    {
			    	boolean result;
			    	System.out.print("Enter the file name:\n ");  
			        String name=sc.nextLine();              //variable name to store the file name 
			        String path1 = "C:\\Users\\shrey\\OneDrive\\Desktop\\myfiles1";    
			        File file1= new File(path1 + "\\" + name + ".txt"); // Creating File Object called file1  
			        result=file1.createNewFile();// Method createNewFile() method creates blank
			        if(result)
			        {System.out.println("file created successfully");
			         FileWriter fw=new FileWriter(file1);
			        PrintWriter pw= new PrintWriter(fw);
			        System.out.print("Enter file content: ");         
			        String str=sc.nextLine()+"\n";      //str stores the string which we have entered  
			        pw.println(str); 
			        pw.close();
			        System.out.println("file saved at"+ path1);  
			        } 
			        else
			        {System.out.println("file already exists");
			        }
			    }
			    
			    else if(j=='B'||j=='b')
			    {
			    	System.out.println("enter the filename to be deleted:");
				    String fname= sc.nextLine();
				    String path3="C:\\Users\\shrey\\OneDrive\\Desktop\\myfiles1"+"\\"+fname;
				     File f=new File(path3);
			         boolean result1=f.delete();
			         if (result1) {
			        	 System.out.println("file is deleted!");
			         } 
			         else {
			             System.out.println("File not found");
			         }
			    }
			    
			    else if (j=='C'||j=='c')
			    {
			    	File directory = new File("C:\\Users\\shrey\\OneDrive\\Desktop\\myfiles1");
			    	String[] flist = directory.list();// store all names with same name
			        int flag = 0;
			        System.out.println("Enter file name to be searched with its extention");
			        String fname=sc.nextLine();
			        if (flist == null) 
			        {
			        System.out.println("Empty directory.");
			        }
			        else {
			        // Linear search in the array
			        for (int k = 0; k < flist.length; k++) {
			            String filename = flist[k];
			            if (filename.equalsIgnoreCase(fname)) {
			                System.out.println(filename + " found");
			                flag = 1;
			            }}}
			        if (flag == 0) {
			        System.out.println("File Not Found");}
			    }
			    else {
			    	System.out.println("Invalid option!Enter valid option");
			    }
			    break;
			    
			    
			case 3:
				System.exit(0);
			}
	}while(i!=3);

}}
