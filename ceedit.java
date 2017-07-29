import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class ceedit extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3;
	JTextField jt1,jt2,jt3,jt4,jt5,jt6;
	JLabel jl,jl1,jl2,jl3,jl4,jl5,jl6,jl7;
	JComboBox jc;
	String a1,a2,a3,a4;
	String s2[]={"civil","cse","ece","electrical","Mechanical","it"};
	public ceedit(String a1,String a2,String a3,String a4){
		//super(s);
		setLayout(null);
		jc=new JComboBox(s2);
		jb1=new JButton("Submit");
		jb2=new JButton("Back");
		jt1=new JTextField(100);
		jt2=new JTextField(100);
		jt3=new JTextField(100);
		jt4=new JTextField(200);
		jl1=new JLabel("Company-Id");
		jl2=new JLabel("CName");
		jl3=new JLabel("Email-Id");
		jl4=new JLabel("Contact");
		jc.setBounds(150,410,100,30);
		jt1.setBounds(170,170,100,30);
		jt2.setBounds(170,230,100,30);
		jt3.setBounds(170,290,100,30);
		jt4.setBounds(170,350,100,30);
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
		add(jb1);
		add(jb2);
		add(jl1);
		add(jl2);
		add(jl3);
		add(jl4);
		add(jl5);
		add(jc);
		jc.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jt1.setText(a1);
		jt2.setText(a2);
		jt3.setText(a3);
		jt4.setText(a4);
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==jb1){
			int flag=0;
			String id=jt1.getText();
			String cn1=jt2.getText();
			String con=jt4.getText();
			String em=jt3.getText();
			String br=(String)jc.getSelectedItem();
				try{
				Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
				Connection cn=DriverManager.getConnection("jdbc:odbc:dsn");
				Statement st=cn.createStatement();
				st.execute("update company set cname='"+cn1+"', email='"+em+"',contact='"+con+"' where company_id='"+id+"'");
				flag=1;
				if(flag==1){
					  management mg=new management("management");
				      mg.setSize(500,500);
				      mg.setVisible(true);
				      this.setVisible(false);
				}
				cn.close();
	    }
			catch(Exception et){
				System.out.println(et.getMessage());
	    }
			
			
	 }
		  else if(e.getSource()==jb2){
			          coedit se=new coedit("coedit");
				      se.setSize(500,500);
				      se.setVisible(true);
				      this.setVisible(false);
			
	 }
   }
}