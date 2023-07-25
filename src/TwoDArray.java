import javax.swing.*;

public class TwoDArray 
{
	private static String input;
	private static String[] b;
	private static int[][] array, c, d;
	static int low, high, key, cell;
	private static int minimum = Integer.MAX_VALUE, maximum = Integer.MIN_VALUE, sum = 0;
	private static double average = 0.0, standardDeviation0 = 0.0, standardDeviation1 = 0.0;
	private static TwoDArray originalArray;
	
	public TwoDArray(int r, int c, int l, int h)
	{
		array = new int[r][c];
		for (int i=0; i<r; i++)
		{
			for (int j=0; j<c; j++)
			{
				array[i][j] = l + (int)((h-l+1)*Math.random());
			}
		}
	}

	public TwoDArray()
	{
		low = 1;
		high = 100;
		array = new int[10][10];
		for (int i=0; i<10; i++)
		{
			for (int j=0; j<10; j++)
			{
				array[i][j] = low + (int)((high-low+1)*Math.random());
			}
		}
	}
	
	public int[][] getArray() {return array;}
	public static int getLow() {return low;}
	public static int getHigh() {return high;}
	
	public void createArray()
	{
		String input = JOptionPane.showInputDialog(null, "Please enter an integer < 50:",
			"# Rows of Two-Dimensional Array", JOptionPane.QUESTION_MESSAGE);
		int r = Integer.parseInt(input);
    
		input = JOptionPane.showInputDialog(null, "Please enter an integer < 50:",
			"# Columns of Two-Dimensional Array", JOptionPane.QUESTION_MESSAGE);
		int c = Integer.parseInt(input);
    
		array = new int[r][c];
		input = JOptionPane.showInputDialog(null, "Please enter an integer > 0:",
			"Lowest Value in the Array", JOptionPane.QUESTION_MESSAGE);
		low = Integer.parseInt(input);
		
		input = JOptionPane.showInputDialog(null, "Please enter an integer < 1000:",
			"Highest Value in the Array", JOptionPane.QUESTION_MESSAGE);
		high = Integer.parseInt(input);
   
		for (int i=0; i<array.length; i++)
			for (int j=0; j<array[i].length; j++)
				array[i][j] = low + (int)((high-low+1)*Math.random());
	}

	public static int[][] initializeArray(int[][] a, String command)
	{
		if(command == "Create Array")
		{
			originalArray = new TwoDArray();
			originalArray.createArray();
			a = originalArray.getArray();
		}
		
		else if(a != null && (command == "Array Minimum" || command == "Array Maximum" ||
							  command == "Array Average" || command == "Array Standard Deviation" ||
							  command == "Array Search"))
		{
		}
			
		else if(a == null && (command == "Array Minimum" || command == "Array Maximum" ||
							  command == "Array Average" || command == "Array Standard Deviation" ||
							  command == "Array Search"))
		{
			originalArray = new TwoDArray();
			originalArray.createArray();
			a = originalArray.getArray();	
		}
		
		else
		{
			originalArray = new TwoDArray();
			originalArray.createArray();
			a = originalArray.getArray();
		}
		return a;
	}
				
	public static int getMin(int[][] a)
	{
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				if (a[row][col] < minimum)
				{
					minimum = a[row][col];
				}
			}
		}
		return minimum;
	}
	
	public static int getMax(int[][] a)
	{
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				if (a[row][col] > maximum)
				{
					maximum = a[row][col];
				}
			}
		}
		return maximum;
	}
	
	public static double getAvg(int[][] a)
	{
		sum = 0;
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				sum += a[row][col];
				System.out.println(sum);
			}
		}
		average = sum/(double)(a.length * a[0].length);
		return roundDigits(average, 3);
	}
	
	public static double getSD(int[][] a)
	{
		standardDeviation1 = 0.0;
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				standardDeviation0 += Math.pow(a[row][col] - getAvg(a), 2);
			}
		}
		standardDeviation1 = Math.pow((standardDeviation0/(a.length * a[0].length)), 0.5);
		return roundDigits(standardDeviation1, 3);
	}
	
	public static String[] searchArray(int[][] a)
	{
		input = JOptionPane.showInputDialog(null, "Please enter search key.", "Enter Search Key", JOptionPane.QUESTION_MESSAGE);
		key = Integer.parseInt(input);
		b = new String[4];
		b[0] = "false";
		b[1] = Integer.toString(key);
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				if (a[row][col] == key)
				{
					b[0] = "true";
					b[2] = Integer.toString(row);
					b[3] = Integer.toString(col); 
				}	
			}
		}
		return b;	
	}

	public static int[][] addArray(int[][] a, int[][] b)
	{
		c = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				c[row][col] = a[row][col] + b[row][col];
			}
		}
		return c;
	}
	
	public static int[][] subtractArray(int[][] a, int[][] b)
	{
		c = new int[a.length][a[0].length];
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				c[row][col] = a[row][col] - b[row][col];
			}
		}
		return c;
	}
	
	public static int[][] multiplyArray(int[][] a, int[][] b)
	{
		d = new int[a.length][b[0].length];
		for (int row = 0; row < a.length; row++)
		{
			for (int col = 0; col < a[row].length; col++)
			{
				d[row][col] = multiplyArrayCell(a, b, row, col);
			}
		}
		return d;
	}
	
	public static int multiplyArrayCell(int[][] a, int[][] b, int row, int col)
	{
		cell = 0;
		for (int i = 0; i < b.length; i++)
		{
			cell += a[row][i] * b[i][col];
		}
		return cell;
	}
	
	public static int getNumberOfDigits(int n) //Approximately 29 times faster than using .length() ;)
	{
		int p = 0;
		if (n == 1000)
		{
			p = 4;
		}
		
		else if (n >= 100 && n < 1000)
		{
			p = 3;
	    }
		
		else if (n >= 10 && n < 100)
		{
			p = 2;
		}
		
		return p;
	}
	
	public static double roundDigits(double x, int d)
	{
		return (Math.round(x*Math.pow(10, d))/Math.pow(10,d));
	}
}