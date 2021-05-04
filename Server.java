package Text_Based_Application;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Server implements ActionListener{
		// all delecration(Varibale) gobal hogi kyuki sbhi jagaye acess (kar paeyege)hogi
	JPanel p1;																		
	JTextField t1;
	JButton b1;
	static JPanel a1;
	static Box vertical=Box.createVerticalBox();
	static JFrame f1=new JFrame();
	static Socket s;
	static ServerSocket skt;
	static DataInputStream din;
	static DataOutputStream dout;
	 Boolean typing;							//by default intinal value false hothi hai

	 Server()					//Constructer hai or frame ki shabhi codeing Constructer me hogi (kyoki class ke call hone per constructer bhi call hoga)
	 {
			
			f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			p1=new JPanel();		//Object
			p1.setLayout(null);
			p1.setBackground(new Color(17,94,84));		//last two digit use color(Green)
			p1.setBounds(0, 0, 450, 70);
			f1.add(p1);
			
			
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("3.png"));		//image ke lia or ClassLoader is a class or is class ka method(Static) hai getSystemResourse
		//(kisi bhi image ko directly frame me send nhi kar sakthe ho  is liya label me dalo		
			 Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT); 		//(Image class AWT me hothi hai)
			 //i2 Label me direct mhi ja saktha hai islia dobhara ise imageIcon ke object me send karo
			 ImageIcon i3=new ImageIcon(i2);		//
			 JLabel l1=new JLabel(i3);		
			 l1.setBounds(8, 20, 25, 25);
			 p1.add(l1);									//thiki image harame frame me ho
			 
			 
			 
			 l1.addMouseListener(new MouseAdapter()						// MouseEvent lagaya kyoki hum arrow me click kare close ho jaye frame
					 //ye hotha hai Action Listner (Interface) me hothi hai 
			 {
				 public void mouseClicked(MouseEvent ae)
				 {
					 System.exit(0);
				 }
			 });
			 
			 
			 
				ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("emp.png"));
				 Image i5=i4.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
				 ImageIcon i6=new ImageIcon(i5);
				 JLabel l2=new JLabel(i6);
				 l2.setBounds(40, 5, 60, 60);		//har bhar dek kar digit do
				 p1.add(l2);	//
			 
				 
				 
					ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("Video.png"));
					 Image i8=i7.getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT);
					 ImageIcon i9=new ImageIcon(i8);
					 JLabel l5=new JLabel(i9);
					 l5.setBounds(230, 5, 60, 60);					//har bhar dek kar digit do
					 p1.add(l5);
					 
					 
					 
						ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("phone.png"));
						 Image i11=i10.getImage().getScaledInstance(34, 60, Image.SCALE_DEFAULT);
						 ImageIcon i12=new ImageIcon(i11);
						 JLabel l6=new JLabel(i12);
						 l6.setBounds(300, 5, 60, 60);				//har bhar dek kar digit do
						 p1.add(l6);
						 
							ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("3icon.png"));
							 Image i14=i13.getImage().getScaledInstance(30, 60, Image.SCALE_DEFAULT);
							 ImageIcon i15=new ImageIcon(i14);
							 JLabel l7=new JLabel(i15);
							 l7.setBounds(370, 5, 60, 60);				//har bhar dek kar digit do
							 p1.add(l7);
							 
							 
				 JLabel l3=new JLabel("	Server ");						// show name label me
				 l3.setFont(new Font("SAN_SERIF",Font.BOLD,18));		//Object font ka or label me name or size ko set karega
				 l3.setForeground(Color.white);
				 l3.setBounds(110, 10, 100, 20);
				 p1.add(l3);												//	p1(Pannel) me add karne per aye ga varna nhi 
			 
				 JLabel l4=new JLabel("Active Now");					// show name label me
				 l4.setFont(new Font("SAN_SERIF",Font.PLAIN,14));			//Object font ka or label me name or size ko set karega
				 l4.setForeground(Color.white);
				 l4.setBounds(110, 40, 100, 20);
				 p1.add(l4);												//	p1(Pannel) me add karne per aye ga varna nhi 
				 
				 
				 Timer t=new Timer(1,new ActionListener()				//Action Listner Interface ko Override kiya
						 
						 {
					 public void actionPerformed(ActionEvent ae)			//Overeride kiya kyoki Interface ka use kiya hai
					 {
							 if(!typing)										//type na karne per
							 {
								 l4.setText("Active Now");
							
							 }
					 }
						 });
				 t.setInitialDelay(2000);											//type se active now ane per 2 mintues ka delay hoa
						 
				
				 
				 
				 a1=new JPanel();
				
				 a1.setFont(new  Font("SAN_SERIF",Font.PLAIN,16));
				
				
				
				JScrollPane sp=new JScrollPane(a1);				//Scrool ke lia ,jisme scroll bar lagana hai uske object ko use kathe hai
				sp.setBounds(30, 75, 400, 300);
				sp.setBorder(BorderFactory.createEmptyBorder());
				f1.add(sp);
			 
				ScrollBarUI ui=new BasicScrollBarUI(){			//abstract class hai  ,BasicScrollBarUI extend karthi haiScrollBarUi ko
				
					protected JButton createDecreaseButton(int orientation)					//lower(createDecreaseButton) button hai
				{
					JButton button=super.createDecreaseButton(orientation);
					button.setBackground(new Color(7,94,84));
					this.thumbColor=new Color(7,94,84);
					button.setBackground(Color.white);
					return button;
				}
				protected JButton createIncreaseButton(int orientation)
				{
					JButton button=super.createIncreaseButton(orientation);
					button.setBackground(new Color(7,94,84));
					button.setForeground(Color.white);
					this.thumbColor=new Color(7,94,84);
					return button;
				}
				};
				
				sp.getVerticalScrollBar().setUI(ui);
				f1.add(sp);
				 
				t1=new JTextField();			//use kiya bok banane me jisne hame message type karna hai
					t1.setBounds(30, 400, 300, 30);				
					t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
					
					f1.add(t1);
					
			
					

					  t1.addKeyListener(new KeyAdapter(){				//keyListener interface me two method ko Override kana padega or Override Method me KeyEvent ka Objet hoga
				           public void keyPressed(KeyEvent ke){		//Override or iska use typing kane per show karaga typing
				               l4.setText("typing...");
				               
				               t.stop();
				               
				               typing = true;
				           }
				           
				           public void keyReleased(KeyEvent ke){		//Override or iska use type na karne per show karega  Active Now
				               typing = false;
				               
				               if(!t.isRunning()){
				                   t.start();
				               }
				           }
				       });
					  
					b1=new JButton("Send");			//Button 
					b1.setBounds(350, 400, 80, 30);				//x-axis ,y-axis, rigth,left(number TxtField se dekh kar do{(Txt(x-axis+rigth=button)}acording}
					b1.setBackground(new Color(17,94,84));				
					b1.setForeground(Color.white);
					b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
					b1.addActionListener(this);					//
					f1.add(b1);								// add function use kyoki  element esi se add hoge pannel me
					f1.getContentPane().setBackground(Color.white);		//Color set background but show image(getContentPane use kiya tho complete background)
			 
					f1.setLayout(null);				// by default Layout border layout hotha hai but NULL use kane per hum apne layout use kar sakthe hai
					f1.setSize(450,950);						//length ke lia use kiya e or ye function JFrame class me hotha hai or JFrame swing pacakge me hotha hai
					f1.setLocation(200,250);					//location di frame ki x-axis and y-axis 
					f1.setUndecorated(true);						// isse cross,minimize (Header) delete ho gaye ga but to use setVisible after 											////////////
					f1.setVisible(true);						//by default false hothe hai isliya true kiya
	 }
	 
	 
	 public void actionPerformed(ActionEvent e) {		//Override kiya kyoki  Interface ka use kiya hai
			try
			{
		String out=t1.getText();				//message(Value) ko nekale ga
	sendTextToFiel(out);		// function hai jo  ki message ko file me send kare ga

						JPanel p2=	formatLabel(out);						
						a1.setLayout(new BorderLayout());   		//pannel ke layout ko change karke BorderLayout diya 
						JPanel right=new JPanel(new BorderLayout());				//is panel se message right me jayega
						right.add(p2,BorderLayout.LINE_END);				//add karaya kyoki message side(Ending ) me show kare
						vertical.add(right);
						vertical.add(Box.createVerticalStrut(15));
						a1.add(vertical,BorderLayout.PAGE_START);
						//a1.add(p2);
		dout.writeUTF(out);
	
		t1.setText("");					//jo message  Box  me  write karage   send hone ke bath  box me show nhi kare aga balki textField me show karega
			}
			catch(Exception e1)
			{
				System.out.println(e);
			}
		
			
		}
	 

	 
	 public void sendTextToFiel(String message) throws FileNotFoundException
	 {
		 try
		 
			 (FileWriter f=new FileWriter("chat2 .txt");						//file banaye ga
			 PrintWriter p=new PrintWriter(new BufferedWriter(f));)				//character ko file me dalne ke lia (kyoki String ko dal nhi kar sakthe hai)
			 {
			 p.println("Server :"+message);								//Character ko har bar next line me append karega
			 }
			 
		 
		 catch(Exception e)
		 {
			e.printStackTrace(); 
		 } 
	 }

public static JPanel formatLabel(String out)
{
	JPanel p3=new JPanel();
	p3.setLayout(new BoxLayout(p3,BoxLayout.Y_AXIS));			
	
	
	//JLabel l1=new JLabel("<html><p style=\"width :100px\">"+out+"</p></html>");
	JLabel l1=new JLabel(out);									//message ko panel me dala
	l1.setFont(new Font("Tahoma",Font.PLAIN,16));			
	l1.setBackground(new Color(37,211,102));
	l1.setOpaque(true);
	l1.setBorder(new EmptyBorder(15,15,15,50));						//use message ko color kane ke lia
	
	Calendar cal=Calendar.getInstance();						//Calender class hai iski help se Current time message ke sath show  karage
	  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");			//isse time ka formate milga
	  JLabel l2=new JLabel();
	  l2.setText(sdf.format(cal.getTime()));			
	p3.add(l1);
	p3.add(l2);
	return p3;
}
	 

public static void main(String []a)				//main Method 
{
	new Server().f1.setVisible(true);		//object 
	String msginput="";
	try
	{
	skt=new ServerSocket(01);			//ServerSocket Object  or portnumber diya	
	while(true) {
	s=skt.accept();						//method (Accept karega message ko)
	
	din=new DataInputStream(s.getInputStream());			//data dege
	dout=new DataOutputStream(s.getOutputStream());			//file create  (lege)
	//(Dono case me data ayaga or jaye ga socket se isliya socket ka object diya)
	while(true)
	{
		
	
	msginput=din.readUTF();					//data read karega
	JPanel p2=formatLabel(msginput);
	
	JPanel left=new JPanel(new BorderLayout());
	left.add(p2,BorderLayout.LINE_START);
	vertical.add(left);
	
	f1.validate();
	}
	}}
	catch(Exception e)
	{	}
		
	
}


}