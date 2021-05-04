package Text_Based_Application;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
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
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class Client extends JFrame implements ActionListener{

	JPanel p1;
	JTextField t1;
	JButton b1;
	static  JPanel a1;
	static Box vertical=Box.createVerticalBox();
	static JFrame f1=new JFrame();
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;
	 Boolean typing;
		Client()
		{
			
			f1.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			p1=new JPanel();
			p1.setLayout(null);
			p1.setBackground(new Color(17,94,84));
			p1.setBounds(0, 0, 450, 70);
			f1.add(p1);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("3.png"));
			 Image i2=i1.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
			 ImageIcon i3=new ImageIcon(i2);
			 JLabel l1=new JLabel(i3);
			 l1.setBounds(8, 20, 25, 25);
			 p1.add(l1);
			 
			 l1.addMouseListener(new MouseAdapter()				
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
				 l2.setBounds(40, 5, 60, 60);
				 p1.add(l2);
			 
					ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("Video.png"));
					 Image i8=i7.getImage().getScaledInstance(40, 60, Image.SCALE_DEFAULT);
					 ImageIcon i9=new ImageIcon(i8);
					 JLabel l5=new JLabel(i9);
					 l5.setBounds(230, 5, 60, 60);
					 p1.add(l5);
					 
					 
					 
						ImageIcon i10=new ImageIcon(ClassLoader.getSystemResource("phone.png"));
						 Image i11=i10.getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT);
						 ImageIcon i12=new ImageIcon(i11);
						 JLabel l6=new JLabel(i12);
						 l6.setBounds(300, 5, 60, 60);
						 p1.add(l6);
						 
						 
							ImageIcon i13=new ImageIcon(ClassLoader.getSystemResource("3icon.png"));
							 Image i14=i13.getImage().getScaledInstance(30, 60, Image.SCALE_DEFAULT);
							 ImageIcon i15=new ImageIcon(i14);
							 JLabel l7=new JLabel(i15);
							 l7.setBounds(370, 5, 60, 60);
							 p1.add(l7);
							 
							 
				 JLabel l3=new JLabel(" Client ");
				 l3.setFont(new Font("SAN_SERIF",Font.BOLD,15));
				 l3.setForeground(Color.white);
				 l3.setBounds(110, 10, 100, 20);
				 p1.add(l3);
			 
				 JLabel l4=new JLabel("Active Now");
				 l4.setFont(new Font("SAN_SERIF",Font.PLAIN,20));
				 l4.setForeground(Color.white);
				 l4.setBounds(110, 40, 100, 20);
				 p1.add(l4);
				 
				 
				 Timer t=new Timer(1,new ActionListener()
						 {
					 public void actionPerformed(ActionEvent ae)
					 {
							 if(!typing)
							 {
								 l4.setText("Active Now");
							
							 }
					 }
						 });
				 t.setInitialDelay(2000);
		 
				 
				 a1=new JPanel();
				// a1.setBounds(30, 75, 400, 300);
				 a1.setFont(new  Font("SAN_SERIF",Font.PLAIN,16));

				
			//f1. add(a1);
				 
				 JScrollPane sp=new JScrollPane(a1);
					sp.setBounds(30, 75, 400, 300);
					sp.setBorder(BorderFactory.createEmptyBorder());
					f1.add(sp);
				 
					ScrollBarUI ui=new BasicScrollBarUI(){
					protected JButton createDecreaseButton(int orientation)
					{
						JButton button=super.createDecreaseButton(orientation);
						button.setBackground(new Color(7,94,84));
						this.thumbColor=new Color(7,94,84);
						button.setForeground(Color.white);
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
					 
			 
				 
				t1=new JTextField();
					t1.setBounds(30, 400, 300, 30);
					t1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
					f1.add(t1);
					
					
			
					  t1.addKeyListener(new KeyAdapter(){
				           public void keyPressed(KeyEvent ke){
				               l4.setText("typing...");
				               
				               t.stop();
				               
				               typing = true;
				           }
				           
				           public void keyReleased(KeyEvent ke){
				               typing = false;
				               
				               if(!t.isRunning()){
				                   t.start();
				               }
				           }
				       });
					
		
					b1=new JButton("Send");
					b1.setBounds(350, 400, 80, 30);
					b1.setBackground(new Color(17,94,84));
					b1.setForeground(Color.white);
					b1.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
					b1.addActionListener(this);
					f1.add(b1);
			f1.getContentPane().setBackground(Color.white);				
			
			f1.setLayout(null);	
			f1.setSize(450,650);
			f1.setLocation(800,250);
			f1.setUndecorated(true);											
			f1.setVisible(true);
			
		
			
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			try
			{
		String out=t1.getText();
							sendTextToFiel(out);				
		JPanel p2=	formatLabel(out);
		a1.setLayout(new BorderLayout());
		JPanel right=new JPanel(new BorderLayout());
		right.add(p2,BorderLayout.LINE_END);
		vertical.add(right);
		vertical.add(Box.createVerticalStrut(10));
		a1.add(vertical,BorderLayout.PAGE_START);
		
		dout.writeUTF(out);
	
		t1.setText("");
			}
			catch(Exception e1)
			{
				System.out.println(e)
;			}
		}
		
		
		
		 public void sendTextToFiel(String message) throws FileNotFoundException
		 {
			 try
			 
				 (FileWriter f=new FileWriter("chat1.txt");				
				 PrintWriter p=new PrintWriter(new BufferedWriter(f));)			
				 {
				 p.println("Client  :"+message);
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
			
			
			
			JLabel l1=new JLabel(out);
			l1.setFont(new Font("Tahoma",Font.PLAIN,16));
			l1.setBackground(new Color(37,211,102));
			l1.setOpaque(true);
			l1.setBorder(new EmptyBorder(15,15,15,50));
			
			Calendar cal=Calendar.getInstance();
			  SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			  JLabel l2=new JLabel();
			  l2.setText(sdf.format(cal.getTime()));
			p3.add(l1);
			p3.add(l2);
			return p3;
		}
		
		
	
		public static void main(String []a)
		{
			new Client().f1.setVisible(true);
			
			try
			{
				s=new Socket("127.0.0.1",01);
				
				din=new DataInputStream(s.getInputStream());
				dout=new DataOutputStream(s.getOutputStream());
				String msginput="";
				while(true)
				{
					a1.setLayout(new BorderLayout());
				msginput=din.readUTF();
										
				JPanel p2=formatLabel(msginput);
				
				JPanel left=new JPanel(new BorderLayout());
				left.add(p2,BorderLayout.LINE_START);
				vertical.add(left);
				vertical.add(Box.createVerticalStrut(15));
				a1.add(vertical,BorderLayout.PAGE_START);
				f1.validate();
			
			}
			}
			catch(Exception e)
			{
				
			}
		}

		

}
