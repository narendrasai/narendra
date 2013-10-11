//program with coding standards-Array operation
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class ArrayOperation  
{
	public static void main(String[] args) throws IOException
	{	
		int arr[]={1,2,10,12,25,100,45,3,4,5,6,7,8,9}; //creating array with values
		//creating two integer variables i.e 1.position(to store the position given by user) and 2.value(to store the value given by user)
			

		//printing array elements before performing any operation
		System.out.println("array elements before doing any operation are "); 
		for(int i=0; i<arr.length; i++)
		{	
			if (i==0)
			{
				System.out.print("[");
			}//if end
			System.out.print(arr[i]);
			if(!(i==(arr.length-1)))
			{
			System.out.print(",");
			}//if end
			if(i==(arr.length-1))
			{
			System.out.println("]");
			}//if end

		}//for end

		ArrayOperation arrop =new ArrayOperation();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("\nThis Program inserts values into array, searches and deletes the values from the array\n press \"1\" if you want to insert value into the array \n press \"2\" if you want to search any value in the array  \n press \"3\" if you want to delete any value from the array");
		int option=Integer.parseInt(br.readLine());
		switch (option)
		{
		case 1 : 

			System.out.println("please enter value to be inserted");
			int value=Integer.parseInt(br.readLine());
			System.out.println("please enter position, where you want to insert number "+value);
			int position=(Integer.parseInt(br.readLine())-1);

		
		int num[]=arrop.insertIntoArray(position,arr,value);
		for(int i=0; i<num.length; i++)
		{	
			if (i==0)
			{
				System.out.print("[");
			}
			System.out.print(num[i]);
			if(!(i==(num.length-1)))
			{
			System.out.print(",");
			}
			if(i==(num.length-1))
			{
			System.out.println("]");
			}

		}
		break;
		
		case 2: 
			System.out.println("Please enter a number to search");
			int svalue=Integer.parseInt(br.readLine());
			int sposition = searchArray(arr, svalue)+1;
			if(sposition==0)
			{
				System.out.println("value "+svalue+" does not found in the array");	
			}
			else
			{
				System.out.println("value "+svalue+" found at position number "+sposition);
			
			}
			break;
		
		case 3:
			System.out.println("please enter a number to delete");
			int dvalue=Integer.parseInt(br.readLine());
			int dposition = searchArray(arr, dvalue);
			if(dposition==-1)
				{
					System.out.println("value "+dvalue+" does not found in the array");	
				}
				else
				{	int pos = dposition+1;
					System.out.println("value "+dvalue+" found at position number "+pos);
					arr=deleteFromArray(pos,arr,dvalue);
					System.out.println("value is deleted\n the resultant array is shown below");
					for(int i=0; i<arr.length; i++)
					{	
						if (i==0)
						{
							System.out.print("[");
						}
						System.out.print(arr[i]);
						if(!(i==(arr.length-1)))
						{
						System.out.print(",");
						}
						if(i==(arr.length-1))
						{
						System.out.println("]");
						}

					}


				}
			break;


		default : System.out.println("You entered wrong option"); 
		}//switch end
	}

	//Method for insertion 
	public static int[] insertIntoArray(int index, int[] arr, int value)
	{
		int[] newArray = new int[arr.length+1];
		System.arraycopy(arr,0,newArray,0,index);
		newArray[index]=value;
		System.arraycopy(arr,index,newArray,index+1,arr.length-index);
		arr = newArray;
		return arr;
		
		
	}

    //Method for search
	public static int searchArray(int[] arr, int value )
	{	int pos=-1;
		for(int i=0; i<arr.length;i++)
		{
			if(arr[i]==value)
			{
				pos=i;
			}
		}
		return pos;
	}

	//Method for deletion
	public static int[] deleteFromArray(int index, int[] arr, int value)
	{
		int[] newArray = new int[arr.length-1];
		System.arraycopy(arr,0,newArray,0,index-1);
		System.arraycopy(arr,index,newArray,index-1,arr.length-index);
		arr = newArray;
		return arr;
		
		
	}

}
