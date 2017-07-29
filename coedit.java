import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class coedit extends JFrame implements ActionListener{
	JButton jb1,jb2;
	JTextField jt;
	JLabel jl1;
	String a1,a2,a3,a4;
	public coedit(String s){
		super(s);
		setLayout(null);
		jl1=new JLabel("Company-id");
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
	public void actionPerformed(ActionEvent et){
		if(et.getSource()==jb2){
			company ac=new company("company");
			ac.setSize(600,600);
			ac.setVisible(true);
			this.setVisible(false);
		}
		else if(et.getSource()==jb1){
			String id=jt.getText();
			try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				 ResultSet rs=st.executeQuery("select * from company where company_id='" + id + "'");
			  while(rs.next()){
				 a1=rs.getString(3);
				 a2=rs.getString(1);
				 a3=rs.getString(2);
				 a4=rs.getString(4);
				 
			 }
          	     cn.close();
	     }
		catch(SQLException e){
                       JOptionPane.showMessageDialog(null,e.getMessage());
		 }
		catch(ClassNotFoundException e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
		}	
			ceedit cee=new ceedit(a1,a2,a3,a4);
			cee.setSize(600,600);
			cee.setVisible(true);
			this.setVisible(false);
		}

	}
}