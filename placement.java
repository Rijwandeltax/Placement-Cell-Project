import java.lang.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class placement extends JFrame implements ActionListener{
	JButton jb;
	JLabel jl1,jl2;
	JTextField jt;
	JPasswordField jp;
	public placement(String s){
		super(s);
		setLayout(null);
		jb=new JButton("submit");
		jt=new JTextField(50);
		jp=new JPasswordField(50);
		jl1=new JLabel("username");
		jl2=new JLabel("password");
		jl1.setBounds(10,50,200,40);
		jl2.setBounds(10,100,200,40);
		jt.setBounds(150,50,200,40);
		jp.setBounds(150,100,200,40);
		jb.setBounds(150,200,200,40);
		jb.addActionListener(this);
		jp.setEchoChar('*');
		add(jt);
		add(jp);
		add(jb);
		add(jl1);
		add(jl2);
	}
public void actionPerformed(ActionEvent e1){
	String s=jt.getText();
	String p=jp.getText();
    int flag=0;	
	try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection cn = DriverManager.getConnection("jdbc:odbc:dsn");
			Statement st = cn.createStatement();
			//st.execute("insert into student values(1,'rizwan',88)");
              //st.execute("delete from student where sn=1");
			 ResultSet rs=st.executeQuery("select * from Login where email='" + s + "' AND password='" + p + "'");
			  while(rs.next()){
				  flag=1;
			  }
			  if(flag==1){
				 management mg=new management("management");
				  mg.setSize(500,500);
				  mg.setVisible(true);
				  this.setVisible(false);
			  }
			  else{
				  System.out.println("Invalid Id/password");
			  }
			  cn.close();
			  }
			  catch(Exception e){
				  System.out.println(e.getMessage());
			  }
		   
	}
	public static void main(String[]arrs){
		placement d=new placement("Login password");
		d.setSize(500,500);
		d.setVisible(true);
	}
	
}