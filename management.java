import javax.swing.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
class management extends JFrame implements ActionListener{
	JButton jb1,jb3,jb5,jb6;
	public management(String s){
		super(s);
		setLayout(null);
		jb1=new JButton("Student");
		jb3=new JButton("Company");
		jb5=new JButton("Search");
		jb1.setBounds(100,100,200,30);
		jb3.setBounds(100,200,200,30);
		jb5.setBounds(100,300,200,30);
		add(jb1);
		add(jb3);
		add(jb5);
		jb1.addActionListener(this);
		jb3.addActionListener(this);
		jb5.addActionListener(this);
	}
	public void actionPerformed(ActionEvent et){
		if(et.getSource()==jb1){
		student a = new student("student");
		a.setSize(500,500);
		a.setVisible(true);
		this.setVisible(false);
		}
		else if(et.getSource()==jb3){
		company ac = new company("company");
		ac.setSize(500,500);
		ac.setVisible(true);
		this.setVisible(false);
		}
		else if(et.getSource()==jb5){
		/*search l= new search("search");
		l.setSize(500,500);
		l.setVisible(true);
		this.setVisible(false);*/
		}
	}
}
