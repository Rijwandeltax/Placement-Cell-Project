import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class company extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JComboBox jc;
	String s2[]={"civil","cse","ece","electrical","Mechanical","it"};
	public company(String s){
		super(s);
		setLayout(null);
		//combo box
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
		
		//Labels
		jl1=new JLabel("Company-Id");
		jl2=new JLabel("CName");
		jl3=new JLabel("Contact");
		jl4=new JLabel("Email-Id");
		jl5=new JLabel("Branch");
		
		jc.setBounds(170,410,100,30);
		jt1.setBounds(170,170,100,30);
		jt2.setBounds(170,230,100,30);
		jt3.setBounds(170,290,100,30);
		jt4.setBounds(170,350,100,30);
		
		jb1.setBounds(170,500,100,40);
		jb2.setBounds(290,500,100,40);
		jb3.setBounds(410,500,100,40);
		
		jl1.setBounds(40,170,100,30);
		jl2.setBounds(40,230,100,30);
		jl3.setBounds(40,290,100,30);
		jl4.setBounds(40,350,100,30);
		jl5.setBounds(40,410,100,30);

		add(jt1);
		add(jt2);
		add(jt3);
		add(jt4);
	
		add(jb1);
		add(jb2);
		add(jb3);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jc);
		jc.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jb3.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e1){
		if(e1.getSource()==jb1){
			int flag=0;
			String id=jt1.getText();
			String cn1=jt2.getText();
			String con=jt3.getText();
			String em=jt4.getText();
			String br=(String)jc.getSelectedItem();
				try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				st.execute("insert into company values('"+id+"','"+cn1+"','"+em+"','"+con+"','"+br+"')");
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
				coedit se=new coedit("Edit");
				se.setSize(600,600);
				se.setVisible(true);
				this.setVisible(false);
		}
	}
}