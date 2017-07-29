import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class stedit extends JFrame implements ActionListener{
	JButton jb1,jb2;
	JTextField jt;
	JLabel jl,jl1;
	String br,gn,a1,a2,a3,a4,a5,a6,a7;
	public stedit(String s){
		super(s);
		setLayout(null);
		jl1=new JLabel("Student-id");
		jb1=new JButton("submit");
		jt=new JTextField(20);
		jb2=new JButton("back");
		jl1.setBounds(50,100,100,40);
		jt.setBounds(300,100,150,40);
		jb1.setBounds(300,200,100,40);
		jb2.setBounds(450,200,100,40);
		add(jt);
		add(jb2);
		add(jb1);
		add(jl1);		
		jb1.addActionListener(this);
		jb2.addActionListener(this);
	}
	public void actionPerformed(ActionEvent e1){
		if(e1.getSource()==jb2){
			         student mg=new student("student");
				      mg.setSize(600,600);
				      mg.setVisible(true);
				      this.setVisible(false);
			
      }
		else if(e1.getSource()==jb1){
			String id=jt.getText();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				  ResultSet rs=st.executeQuery("select * from student where Student_Id='" + id + "'");
			  if(rs.next()){
				 a1=rs.getString(1);
				 a2=rs.getString(2);
				 a3=rs.getString(3);
				 a4=rs.getString(4);
				 a5=rs.getString(5);
				 a6=rs.getString(6);
				 a7=rs.getString(7);
				 
			  }
          	     cn.close();
	      }
		catch(SQLException e){
                       JOptionPane.showMessageDialog(null,e.getMessage());
		 }
		catch(ClassNotFoundException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
		}
					seedit mg=new seedit(a1,a2,a3,a4,a5,a6,a7);
				      mg.setSize(500,500);
				      mg.setVisible(true);
				      this.setVisible(false);
		
		}
	}
				      	
	
}