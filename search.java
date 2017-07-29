import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
public class search extends JFrame implements ActionListener{
	JButton jb1,jb2,jb3,jb4;
	JTextField jt;
	JPasswordField jp;
	public search(String s){
		super(s);
		setLayout(null);
		jb1=new JButton("submit");
		jt=new JTextField(20);
		jp=new JPasswordField(20);
		jt.setBounds(20,50,40,40);
		jp.setBounds(20,100,40,40);
		jb1.setBounds(20,200,100,40);
		add(jt);
		add(jp);
		add(jb1);
	}
}