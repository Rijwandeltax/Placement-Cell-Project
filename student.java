import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class student extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JComboBox jc,jc1;
	String br,gn;
	String s2[]={"civil","cse","ece","electrical","Mechanical","it"};
	String s1[]={"Male","Female"};
	public student(String s){
		super(s);
		setLayout(null);
		//combo box
		jc1=new JComboBox(s1);
		jc=new JComboBox(s2);
		//buttons
		jb1=new JButton("Submit");
		jb2=new JButton("Back");
		jb3=new JButton("Edit");
		//Text fields
		jt1=new JTextField(100);
		jt2=new JTextField(100);
		jt3=new JTextField(100);
		jt4=new JTextField(200);
		jt5=new JTextField(100);
		//Labels
		jl1=new JLabel("Student-Id");
		jl2=new JLabel("FName");
		jl3=new JLabel("LName");
		jl4=new JLabel("Mobile No.");
		jl5=new JLabel("Email-Id");
		jl6=new JLabel("Gender");
		jl7=new JLabel("Branch");
		
		jc1.setBounds(170,470,70,30);
		jc.setBounds(170,530,70,30);
		jt1.setBounds(170,170,100,30);
		jt2.setBounds(170,230,100,30);
		jt3.setBounds(170,290,100,30);
		jt4.setBounds(170,350,100,30);
		jt5.setBounds(170,410,100,30);
		
		jb1.setBounds(170,600,100,40);
		jb2.setBounds(320,600,100,40);
		jb3.setBounds(470,600,100,40);
		
		jl1.setBounds(40,170,100,30);
		jl2.setBounds(40,230,100,30);
		jl3.setBounds(40,290,100,30);
		jl4.setBounds(40,350,100,30);
		jl5.setBounds(40,410,100,30);
		jl6.setBounds(40,470,100,30);
		jl7.setBounds(40,530,100,30);

		add(jt1);
		add(jt2);
		add(jt3);
		add(jt4);
		add(jt5);
	
		add(jb1);
		add(jb2);
		add(jb3);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		//add(jl6);
		//add(jl7);
		
		add(jc1);
		add(jc);
		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
		jc.addActionListener(this);
		jc1.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e1){
		if(e1.getSource()==jb1){
			int flag=0;
			String id=jt1.getText();
			String fn=jt2.getText();
			String ln=jt3.getText();
			String mob=jt4.getText();
			String em=jt5.getText();
			br=(String)jc.getSelectedItem();
			gn=(String)jc1.getSelectedItem();
				try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				st.execute("insert into student values('"+fn+"','"+ln+"','"+id+"','"+mob+"','"+em+"','"+gn+"','"+br+"')");
				JOptionPane.showMessageDialog(null,"Record successfully Inserted");
          	     cn.close();
		}
		catch(SQLException e){
                       JOptionPane.showMessageDialog(null,e.getMessage());
		}
		catch(ClassNotFoundException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
		}
			
			
		}
		else if(e1.getSource()==jb2){
			         management mg=new management("management");
				      mg.setSize(500,500);
				      mg.setVisible(true);
				      this.setVisible(false);
			
		}
		else if(e1.getSource()==jb3){
				stedit se=new stedit("Edit");
				se.setSize(600,600);
				se.setVisible(true);
				this.setVisible(false);
		}
	}
				      	
	
}