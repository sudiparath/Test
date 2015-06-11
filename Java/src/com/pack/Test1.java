package com.pack;

    class Test1 
    {
	void run()
	{
		System.out.println("Test1 is running");
	}
    }
    
	 class Emp extends Test1
	{
		/*void run()
		{
			System.out.println("Test2 is running");
		}*/
	
	
	public static void main(String[] args) 
	{
		Test1 gt= new Emp();
		    gt.run();
		    
		Test1 t2=new Test1();
		t2.run();
		
		Emp t3= new Emp();
		t3.run();
		
		
	}
	
	}
    
		
	

	

      
      
