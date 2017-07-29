import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class seedit extends JFrame implements ActionListener{
	JButton jb1,jb2;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6,jt7;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	public seedit(String a1,String a2,String a3,String a4,String a5,String a6,String a7){
		setLayout(null);
		//buttons
		jb1=new JButton("Submit");
		jb2=new JButton("Back");
		//Text fields
		jt1=new JTextField(100);
		jt2=new JTextField(100);
		jt3=new JTextField(100);
		jt4=new JTextField(100);
		jt5=new JTextField(100);
		jt6=new JTextField(100);
		jt7=new JTextField(100);
		//Labels
		jl1=new JLabel("FName");
		jl2=new JLabel("LName");
		jl3=new JLabel("Student-Id");
		jl4=new JLabel("Mobile No.");
		jl5=new JLabel("Email-Id");
		jl6=new JLabel("gender");
		jl7=new JLabel("branch");
		
		jt1.setBounds(170,170,100,30);
		jt2.setBounds(170,230,100,30);
		jt3.setBounds(170,290,100,30);
		jt4.setBounds(170,350,100,30);
		jt5.setBounds(170,410,100,30);
		jt6.setBounds(150,460,100,30);
		jt7.setBounds(150,510,100,30);
		
		jb1.setBounds(150,100,100,40);
		jb2.setBounds(450,100,100,40);
		
		jl1.setBounds(40,170,100,30);
		jl2.setBounds(40,230,100,30);
		jl3.setBounds(40,290,100,30);
		jl4.setBounds(40,350,100,30);
		jl5.setBounds(40,410,100,30);

		add(jt1);
		add(jt2);
		add(jt3);
		add(jt4);
		add(jt5);
		add(jt6);
		add(jt7);
	
		add(jb1);
		add(jb2);
		
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jt1.setText(a1);
		jt2.setText(a2);
		jt3.setText(a3);
		jt4.setText(a4);
		jt5.setText(a5);
		jt6.setText(a6);
		jt7.setText(a7);
	}
	public void actionPerformed(ActionEvent e1){
		if(e1.getSource()==jb1){
			int flag=0;
			String id=jt3.getText();
			String fn=jt1.getText();
			String ln=jt2.getText();
			String mob=jt4.getText();
			String em=jt5.getText();
			String gen=jt6.getText();
            String br=jt7.getText();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				st.execute("update student set fname='"+fn+"', lname='"+ln+"', email='"+em+"',branch='"+br+"',gender='"+gen+"' where Student_Id='"+id+"'");
				flag=1;
				if(flag==1){
					  management mg=new management("management");
				      mg.setSize(500,500);
				      mg.setVisible(true);
				      this.setVisible(false);
			}
				
			     cn.close();
		}
			catch(Exception e){
				System.out.println(e.getMessage());
		   	}
			
			
	}
		else if(e1.getSource()==jb2){
			          stedit se=new stedit("stedit");
				      se.setSize(500,500);
				      se.setVisible(true);
				      this.setVisible(false);
			
		}
	}
}