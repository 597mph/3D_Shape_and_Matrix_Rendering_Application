import java.awt.*;
import java.awt.event.*;

public class Project07 extends Frame implements ActionListener
{
	//***** Hi professor, I wanted to disclaim here that the multiply array methods
	// will sometimes throw a NullPointerException for reasons unknown to me.
	// I tried for hours to figure out why but unfortunately I was unable to solve the mystery.
	// When the multiply array methods do work, however, I believe the resulting array is accurate.
	// Hopefully I don't lose too many points because of this. I am otherwise very proud of this project
	// and I hope you enjoy :)
	
	static final long serialVersionUID = Integer.MAX_VALUE;
	String command = "About", found, row, col, key;
	static Font f0 = new Font("SansSerif", Font.BOLD, 12);
	static Font f1 = new Font("SansSerif", Font.BOLD, 16);
	static Font f2 = new Font("SansSerif", Font.BOLD, 20);
	static Font f3 = new Font("SansSerif", Font.BOLD, 24);

	private static int currentY;
	private int minimum;
	private int maximum;
	private double average, SD;
	private int[][] a = null, b = null, c = null;
	private String[] d = new String[4];
	
	public static void main(String[] args)
	{
		Frame frame = new Project07();	
		frame.setResizable(true);
		frame.setSize(1000,800);
		frame.setVisible(true);
	}
	
	public Project07()
	{
		setTitle("CSC 229 - Project 7 - 2D Arrays");
		
	  //Create Menu
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		Menu actionMenu = new Menu("Two Dimensional Array");
		mb.add(actionMenu);
		
		MenuItem miCreate2D = new MenuItem("Create New Array");
		miCreate2D.addActionListener(this);
		actionMenu.add(miCreate2D);
		
		Menu statsMenu2D = new Menu("Statistics");
		actionMenu.add(statsMenu2D);
		
		MenuItem miArrayMin = new MenuItem("Array Minimum");
		miArrayMin.addActionListener(this);
		statsMenu2D.add(miArrayMin);

		MenuItem miArrayMax = new MenuItem("Array Maximum");
		miArrayMax.addActionListener(this);
		statsMenu2D.add(miArrayMax);
		
		MenuItem miArrayAvg = new MenuItem("Array Average");
		miArrayAvg.addActionListener(this);
		statsMenu2D.add(miArrayAvg);
		
		MenuItem miArraySD = new MenuItem("Array Standard Deviation");
		miArraySD.addActionListener(this);
		statsMenu2D.add(miArraySD);
		
	  //Array operations
		Menu opsMenu = new Menu("Operations");
		actionMenu.add(opsMenu);
		
		MenuItem miArraySearch = new MenuItem("Array Search");
		miArraySearch.addActionListener(this);
		opsMenu.add(miArraySearch);
		
		MenuItem miAdd = new MenuItem("Array Add");
		miAdd.addActionListener(this);
		opsMenu.add(miAdd);
		
		MenuItem miSubtract = new MenuItem("Array Subtract");
		miSubtract.addActionListener(this);
		opsMenu.add(miSubtract);
	
		MenuItem miMultiply = new MenuItem("Array Multiply");
		miMultiply.addActionListener(this);
		opsMenu.add(miMultiply);
		
		Menu threeDArray = new Menu("Three Dimensional Array");
		mb.add(threeDArray);
		
		MenuItem miNew3DArray = new MenuItem("Create New 3D Array");
		miNew3DArray.addActionListener(this);
		threeDArray.add(miNew3DArray);

		Menu threeDOps = new Menu("3D Array Operations");
		threeDArray.add(threeDOps);

		MenuItem mi3DArrayMin = new Menu("Array Minimum");
		mi3DArrayMin.addActionListener(this);
		threeDOps.add(mi3DArrayMin);
		
		WindowListener l = new WindowAdapter()
		{					
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
        		repaint();           
    		}
		};
		
	  //Register listeners	
		this.addWindowListener(l);
		this.addComponentListener(k);
	}
	
//******************************************************************************
// Called by windows manager whenever the application window performs an action
// (select a menu item, close, resize, etc.
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
	{//Figure out which command was issued. Take action accordingly.
		
		command = ev.getActionCommand();
			
		switch(command)
		{
			case "About":
			{
				repaint();
				break;
			}
			
			case "Exit":
			{
				System.exit(0);
			}
			
			case "Create New Array":
			{
				a = TwoDArray.initializeArray(a, command);		
				repaint();
				break;
			}
			
			case "Array Minimum":
			{	
				a = TwoDArray.initializeArray(a, command);
				minimum = TwoDArray.getMin(a);
				repaint();
				break;
			}
			
			case "Array Maximum":
			{
				a = TwoDArray.initializeArray(a, command);
				maximum = TwoDArray.getMax(a);
				repaint();
				break;
			}
		
			case "Array Average":
			{
				a = TwoDArray.initializeArray(a, command);
				average = TwoDArray.getAvg(a);
				repaint();
				break;
			}
			
			case "Array Standard Deviation":
			{
				a = TwoDArray.initializeArray(a, command);	
				SD = TwoDArray.getSD(a);
				repaint();
				break;
			}
			
			case "Array Search":
			{
				a = TwoDArray.initializeArray(a, command);	
				d = TwoDArray.searchArray(a);
				found = d[0];
				key = d[1];
				row = d[2];
				col = d[3];
				repaint();
				break;
			}
			
			case "Array Add":
			{
				if (a == null)
				{
					a = TwoDArray.initializeArray(a, command);
					b = TwoDArray.initializeArray(b, command);
					c = TwoDArray.addArray(a, b);
				}
				
				else
				{
					b = TwoDArray.initializeArray(b, command);
					c = TwoDArray.addArray(a, b);	
				}
				repaint();
				break;
			}
			
			case "Array Subtract":
			{
				if (a == null)
				{
					a = TwoDArray.initializeArray(a, command);
					b = TwoDArray.initializeArray(b, command);
					c = TwoDArray.subtractArray(a, b);
				}
				
				else
				{
					b = TwoDArray.initializeArray(b, command);
					c = TwoDArray.subtractArray(a, b);	
				}
				repaint();
				break;
			}
			
			case "Array Multiply":
			{
				a = TwoDArray.initializeArray(a, command);
				b = TwoDArray.initializeArray(b, command);
				c = TwoDArray.multiplyArray(a, b);
				repaint();
				break;
			}
		} //Switch
	} //Method
	
//********************************************************
// Called by repaint() to redraw the screen
//********************************************************
		
	public void paint(Graphics g)
	{//Check command issued. Take action accordingly.
		int ww = this.getWidth();
		switch(command)
		{
			case "About":
			{
				g.setFont(f3);
				g.drawString("2D Arrays.",(int)(ww/6), 50);
				g.drawString("This program supports the input of various 2D arrays and", (int)(ww/6), 75);
				g.drawString("Calculates/displays various array properties/statistics.", (int)(ww/6), 100);
				
				g.drawLine(0, 125, (int)(ww), 125);
				g.drawLine(0, 126, (int)(ww), 126);
				g.drawLine(0, 127, (int)(ww), 127);
				g.drawLine(0, 128, (int)(ww), 128);
				g.drawLine(0, 129, (int)(ww), 129);
				g.drawLine(0, 139, (int)(ww), 139);
				g.drawLine(0, 140, (int)(ww), 140);
				g.drawLine(0, 141, (int)(ww), 141);
				g.drawLine(0, 142, (int)(ww), 142);
				g.drawLine(0, 143, (int)(ww), 143);
				
				g.setFont(f2);
				g.drawString("Supported array statistics:", (int)(ww/6), 175);
				g.setFont(f1);
				g.drawString(" 1.      Find array minimum", (int)(ww/6), 195);
				g.drawString(" 2.      Find array maximum", (int)(ww/6), 215);
				g.drawString(" 3.      Find array average", (int)(ww/6), 235);
				g.drawString(" 4.      Find array standard deviation", (int)(ww/6), 255);
				g.setFont(f2);
				g.drawString("Supported array operations:", (int)(ww/6), 305);
				g.setFont(f1);
				g.drawString(" 1.      Array search", (int)(ww/6), 325);
				g.drawString(" 2.      Add arrays", (int)(ww/6), 345);
				g.drawString(" 3.      Subtract arrays", (int)(ww/6), 365);
				g.drawString(" 4.      Multiply arrays", (int)(ww/6), 385);
				break;
			}
		
			case "Create New Array":
			{	
				displayOriginalArray(g, ww);
				displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
				break;
			}
			
			case "Array Minimum":
			{
				displayOriginalArray(g, ww);
				currentY = displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
	
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Array Minimum: " + minimum, ww/2 - 85, currentY + 25);
				break;
			}
			
			case "Array Maximum":
			{
				displayOriginalArray(g, ww);
				currentY = displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
				
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Array Maximum: " + maximum, ww/2 - 85, currentY + 25);
				break;
			}
			
			case "Array Average":
			{
				displayOriginalArray(g, ww);			
				currentY = displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
	
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Array Average: " + average, ww/2 - 85, currentY + 25);
				break;				
			}
			
			case "Array Standard Deviation":
			{
				displayOriginalArray(g, ww);
				currentY = displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
	
				g.setFont(f1);
				g.setColor(Color.RED);
				g.drawString("Array Deviation: " + SD, ww/2 - 85, currentY + 25);
				break;				
			}
			
			case "Array Search":
			{
				displayOriginalArray(g, ww);
				currentY = displaySingleArray(g, a, ww/2 - (10 * TwoDArray.getNumberOfDigits(TwoDArray.getHigh()) * a[0].length/2), 100);
				
				g.setFont(f1);
				g.setColor(Color.RED);
				
				if (found == "true")
				{
					g.drawString("Key " + key + " found at [" + row + "][" + col + "]", ww/2 - 85, currentY + 25);
				}
				else
				{
					g.drawString("Key " + key + " not found.", ww/2 - 85, currentY + 25);
				}
				break;		
			}
			
			case "Array Add":
			{
				currentY = displayMultipleArrays(g, a, b, c, ww);
				g.drawString("+", ww/2 - 10, currentY - (20 * a.length/2));
				break;
			}
				
			case "Array Subtract":
			{
				currentY = displayMultipleArrays(g, a, b, c, ww);
				g.drawString("-", ww/2 - 10, currentY - (20 * a.length/2));
				break;
			}
			
			case "Array Multiply":
			{
				currentY = displayMultipleArrays(g, a, b, c, ww);
				g.drawString("*", ww/2 - 10, currentY - (20 * a.length/2));
				break;
			}
			
		}
	}
	
	public static void displayOriginalArray(Graphics g, int ww)
	{
		g.setFont(f3);
		g.setColor(Color.RED);
		g.drawString("Original Array", ww/2 - 90, 60);
		
		g.setFont(f0);
		g.setColor(Color.BLACK);
	}
	
	public static int displayMultipleArrays(Graphics g, int[][] a, int[][] b, int[][] c, int ww)
	{
		g.setFont(f0);
		g.setColor(Color.BLACK);
		currentY = displaySingleArray(g, a, ww/4 - (25 * a[0].length/2), 100);
				   displaySingleArray(g, b, 3*ww/4 - (25 * b[0].length/2), 100);
				   displaySingleArray(g, c, ww/2 - (25 * c[0].length/2), currentY + 50);	
		
		g.setFont(f3);
		g.setColor(Color.RED);
		g.drawString("A", ww/4 - 10, 80);
		g.drawString("B", 3*ww/4 - 10, 80);
		g.drawString("C", ww/2 - 10, currentY + 30);
		return currentY;
	}
	
	public static int displaySingleArray(Graphics g, int[][] a, int x, int y)
	{
		displayGrid(g, a, x, y);
		int x1 = x;
		for (int row = 0; row < a.length; row++)
		{
			x = x1;
			for (int col = 0; col < a[row].length; col++)
			{
				g.drawString(Integer.toString(a[row][col]), x, y);
				x += 30;
			}
			y+=20;
		}
		return y;
	}
	
	public static void displayGrid(Graphics g, int[][] a, int x, int y)
	{
		int y1 = y;
		for (int row = 0; row < a.length + 1; row++)
		{
			g.drawLine(x - 3, y - 15, (x - 3) + (30 * a[0].length), y - 15);
			y+=20;
		}
		
		y = y1;
		for (int col = 0; col < a[0].length + 1; col++)
		{
			g.drawLine(x - 3, y - 15, x - 3, (y - 15) + (20 * a.length));
			x += 30;
		}
	}
}