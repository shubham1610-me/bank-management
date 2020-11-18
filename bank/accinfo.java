import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class accinfo extends JInternalFrame implements ActionListener 
{
JLabel acctype;
JRadioButton saving,current;
JButton show;
JTable jb;
Connection con;
Statement st;
ButtonGroup b1;

accinfo()
{
super("account information",true,true,true,true);
setSize(1000,700);

setLayout(null);
acctype=new JLabel("Account Type");
saving=new JRadioButton("Saving");
current=new JRadioButton("Current");
b1=new ButtonGroup();
b1.add(saving);
b1.add(current);
show=new JButton("Show");


acctype.setBounds(30,30,200,30);
saving.setBounds(240,30,200,30);
current.setBounds(450,30,200,30);
show.setBounds(430,80,200,30);
add(acctype);
add(saving);
add(current);
add(show);
setVisible(true);
show.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();

}
catch(Exception e)
{

System.out.println(e);
}
}
public static void main(String a[])
{
new accinfo();
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==show)
{
String s1="";
if(saving.isSelected())
{
s1=" where acc_type='saving'";
}
else if(current.isSelected())
{
s1=" where acc_type='current'";
}
else
{
s1="";
}
int n=0;
ResultSet rs=st.executeQuery("Select count(*) from openacc");
if(rs.next())
{
 n=rs.getInt(1);
}
Object obj[][]=new Object[n][10];
int i=0;
int j=0;
int k=1;
String col[]={"Acc. no.","Opening  Date","Type","First Name","Address","City","phone no.","Adhar no.","Pan number","Balance"};
ResultSet rp=st.executeQuery("select acc_no,open_date,acc_type,first_name,address,city,pno,adharno,pancard,deposit from openacc"+s1);
while(rp.next())
{
for(j=0,k=1;k<=10;j++,k++)
{
obj[i][j]=rp.getString(k);

}
i++;
}
jb=new JTable(obj,col);
JScrollPane jp=new JScrollPane(jb);
jp.setBounds(0,130,1000,800);
add(jp);

}
}
catch(Exception e)
{
System.out.print(e);
}
}
}




