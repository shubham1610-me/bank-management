import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class meminfo extends JInternalFrame implements ActionListener
{
JLabel account_no,account_holder,dob;
JTextField account_no1;
JButton show;
JTable jb;

Connection con;
Statement st;
meminfo()
{
super("member info",true,true,true,true);
setSize(1000,800);
setTitle("Member Info");
setLayout(null);
account_no=new JLabel("Account Number");
account_no1=new JTextField();


show =new JButton("Show");
account_no.setBounds(50,50,200,30);
account_no1.setBounds(210,50,200,30);
show.setBounds(190,100,200,30);
add(account_no);
add(account_no1);
add(show);

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
setVisible(true);
}
public static void main(String a[])
{
new meminfo();
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==show)
{
ResultSet r=st.executeQuery("Select first_name,dob from openacc where acc_no='"+account_no1.getText()+"'");

if(r.next())
{
String args=r.getString(1);
System.out.print(args);
account_holder=new JLabel("account holder name= "+r.getString(1));
dob=new JLabel("account holder name= "+r.getString(2));
System.out.print("hmm");
}

account_holder.setBounds(50,150,300,30);
dob.setBounds(380,150,300,30);
add(account_holder);
add(show);


int n=0;
ResultSet rp=st.executeQuery("Select count(*) from detail where accno='"+account_no1.getText()+"'");
if(rp.next())
{
 n=rp.getInt(1);
System.out.print(n);
}
Object obj[][]=new Object[n][5];
int i=0;
int j=0;
int k=1;


ResultSet rs=st.executeQuery("Select type,prebal,amount,netbal,date from detail where accno='"+account_no1.getText()+"'");
String col[]={"type","previous balance","amount ","net balance","Date"};

while(rs.next())
{

for(j=0,k=1;k<=5;j++,k++)
{
obj[i][j]=rs.getString(k);
}
i++;
}
jb=new JTable(obj,col);
JScrollPane jp=new JScrollPane(jb);
jp.setBounds(0,200,1000,800);
add(jp);
}
}
catch(Exception e)
{
System.out.println(e);
e.printStackTrace();
}
}
}

