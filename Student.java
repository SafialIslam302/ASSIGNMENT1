
/**
 * This is a class to define the necessary attributes and methods to conceptualize a "Student"
 * The spepcific tasks are:
 * 1. Instiate 
 * 
 * @safial islam ayon (your name) 
 * @12/10/16 (a version number or a date)
 */
import java.io.PrintWriter;
import java.io.File;
import java.util.Scanner;
import java.io.*;


public class Student{
	
	Scanner input = new Scanner(System.in);
	// Declare the important attributes of a student. For example:
    //1.Id
    //2. Name
    //3. Department
    //4. University
    //5. GPAs in various terms (Multidimensional arrays)
    //6. subjects for Current terms
    //7. Credits and grades of Current Terms (Multidimmentional Array)
	
    int id;
    String name;
    String Department ;
    String University ;
    double[] GPA = new double[8];
    double[][][] CnG = new double[8][5][5];
    double CGPA;
    double gpa =0;
    
    /**
     * Define a constructor that initilize the default properties of the Student
     */
    
    public Student(int Id,String Name,String department,String university)
    {
        id = Id;
        name = Name;
        Department = department;
        University = university ;
    }
    
    /**
     * Define a method to print the students details.
     */
    
    public void studentDetailsById(int id)
    {
        //write your code here
    	System.out.println("ID          : " + id);
    	System.out.println("Name        : " +name);
    	System.out.println("Department  : " + Department);
    	System.out.println("University  : " + University); 	
    }
    
    
    /**
     * Define a method to update information of students by ID
     * Use as many arguments as required.
     */
    
    public void updateStudentById(int id)
    {
        //Write your code here
    	System.out.println("Do you want to update (write true/false) :");
    	boolean choice = input.nextBoolean();
    	if(choice == true )
    	{
	    	name = input.nextLine();
    		System.out.println("Enter Name : ");
	    	name = input.nextLine();
	    	System.out.println("Enter Department : ");
	    	Department = input.nextLine();
	    	System.out.println("Enter University : ");
	    	University = input.nextLine();
	    	System.out.println("Updated Name   :  " +name+ "\nDepartment   :     " +Department+ "\nUniversity   :     " +University);
    	}	
    } 
    
    /**
     * Define a method to compute the CGPA from the Given term GPA for a particular student.
     * se as many arguments as required.
     */
    
    public double computeCGPAByID()
    {
        // Write your code here
    	double cgpa = 0;
    	for(int i=0;i<8;i++)
    	{
    		System.out.println("\nEnter GPA of Sem " + (i+1) +" :  ");
    		GPA[i]=input.nextDouble();
    	}
    	for(int i=0;i<8;i++)
    	{
    		cgpa+=GPA[i];
    	}
    	cgpa/=8;
    	CGPA = cgpa;
    	
    	return cgpa;
    }
     
    /**
     * After performing required operations on each student, save the information to a file. Use File and PrintWriter Class. 
     * use as many arguments as required.
     * 
     */
    
    public void saveStudent() throws IOException
    {
    	FileWriter outputFile = new FileWriter("output.txt",true);
    	BufferedWriter bw =new BufferedWriter(outputFile);
    	PrintWriter writer = new PrintWriter(bw);
    	
    	writer.println("");
        writer.println("Name  : "+name);
        writer.println("ID  : " + id);
        writer.println("Department  : " + Department);
        writer.println("University  : " + University);
        writer.printf("Current CGPA  : %.3f\n",CGPA); 
        writer.println("");
        writer.println("");
        
        writer.close();
    }
    
    /**
     * Define a method to compute the GPA from the given Credits and Grades of all the subjects
     */

    public void computeGPAById() throws IOException
    {
    	FileWriter outputFile = new FileWriter("output.txt",true);
    	BufferedWriter bw =new BufferedWriter(outputFile);
    	PrintWriter writer = new PrintWriter(bw);
    	double total = 0;
    	for(int i=0;i<8;i++)    //i for every Semester
    	{
    		System.out.println("Enter First Credit & Then GRADE(Per Subject) to  semester: "+(i+1));
    		for(int j=0,k=0;j<=4;j++,k++)    // j for every Credit & k for every Grade
    		{
    			CnG[i][j][0]=input.nextDouble();
    			CnG[i][0][k]=input.nextDouble();	
    		}
    	} 
    	for(int i=0;i<=7;i++)
    	{
    		gpa=0;
    		total=0;
    		for(int j=0,k=0;j<=4;j++,k++)
    		{
    			gpa+=CnG[i][j][0]*CnG[i][0][k];
    			total += CnG[i][j][0];	
    		}
    		
    		gpa = gpa / total;
    		writer.println("\nResult trem  : "+(i+1)+ " :  "+gpa);
    	}
    	writer.close();
    } 
    
    
    /**
     * Create a dummy files with infromations to describe the properties of a Student object and load the data files using Java File and Scanner class.
     * use as many arguments as required.
     */
    
//    public void loadStudents() throws IOException
//    {
//        //Write your code here
//        //Student[] students = new Student[50];
//        File inputFile = new File("input.txt");
//		Scanner in = new Scanner(inputFile);
//		for(int i=0; in.hasNextLine() ; i++)
//		{
//			int r=in.nextInt();
//			String n=in.next();
//			String d=in.next();
//			String u=in.next();
//			students[i] = new Student(r,n,d,u);
//			students[i].studentDetailsById(r);
//			students[i].updateStudentById(r);
//		}
//		in.close();
//    }
      
    /**
     * The tasks to be carried out here:
     * 1. Create an Arrays of students using Student Class. Initlize them and perfom all the above defined operation to evualuate your code.
     * use as many arguments as required.
     */
    
    public static void main(String[] args) throws IOException
    {   
    	Student[] students = new Student[50];
    	File inputFile = new File("input.txt");
		Scanner in = new Scanner(inputFile);
		for(int i=0; in.hasNextLine() ; i++)
		{
			int r=in.nextInt();
			String n=in.next();
			String d=in.next();
			String u=in.next();
			students[i] = new Student(r,n,d,u);
			//students[i].loadStudents();
			students[i].studentDetailsById(r);
			students[i].updateStudentById(r);
			students[i].computeCGPAByID();
			students[i].saveStudent();
			students[i].computeGPAById();
		} 
		in.close();
    }
}