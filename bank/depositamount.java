import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
class depositamount extends JInternalFrame implements ActionListener
{
JLabel date,accno,acctype,accname,dopen,prevbal,lasttrans,depamount,interest,netbal;
JTextField date1,accno1,accname1,dopen1,prevbal1,lasttrans1,depamount1,interest1,netbal1,acctype1;
JButton deposit,display;
Connection con;
Statement st;
int n=0;
int as=0,intercurr,intersave,inter;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date d1=new java.util.Date();

depositamount()
{
super("deposit amount",true,true,true,true);
setTitle("DEPOSIT AMOUNT");
setSize(800,800);
setLayout(null);
date=new JLabel("Date");
accno=new JLabel("Account no.");
acctype=new JLabel("Account Type");
accname=new JLabel("Account Holder Name");
dopen=new JLabel("Date Of Acc. open ");
prevbal=new JLabel("Previous Balance");
lasttrans=new JLabel("Last Transection");
depamount=new JLabel("deposit Amount");
interest=new JLabel("Interest");
netbal=new JLabel("NET BALANCE");
display=new JButton("Display");


date1=new JTextField();
date1.setText(sdf.format(d1));
date1.setEditable(false);
accno1=new JTextField();
accname1=new JTextField();
dopen1=new JTextField();
prevbal1=new JTextField();
lasttrans1=new JTextField();
depamount1=new JTextField();
interest1=new JTextField();
netbal1=new JTextField();

acctype1=new JTextField();

deposit=new JButton("Deposit Amount");

date.setBounds(50,30,200,30);
accno.setBounds(50,70,200,30);
acctype.setBounds(50,110,200,30);
accname.setBounds(50,150,200,30);
dopen.setBounds(50,190,200,30);
prevbal.setBounds(50,230,200,30);
lasttrans.setBounds(50,270,200,30);
interest.setBounds(50,310,200,30);
netbal.setBounds(50,350,200,30);
depamount.setBounds(50,390,200,30);

date1.setBounds(260,30,200,30);
accno1.setBounds(260,70,200,30);
acctype1.setBounds(260,110,200,30);
display.setBounds(470,70,200,30);
accname1.setBounds(260,150,200,30);
dopen1.setBounds(260,190,200,30);
prevbal1.setBounds(260,230,200,30);
lasttrans1.setBounds(260,270,200,30);
interest1.setBounds(260,310,200,30);
netbal1.setBounds(260,350,200,30);
depamount1.setBounds(260,390,200,30);
deposit.setBounds(250,450,200,30);

add(date);
add(accno);
add(acctype);
add(accname);
add(dopen);
add(prevbal);
add(lasttrans);
add(depamount);
add(interest);
add(netbal);

add(date1);
add(accno1);
add(acctype1);

add(accname1);
accname1.setEditable(false);
add(dopen1);
dopen1.setEditable(false);
add(prevbal1);
prevbal1.setEditable(false);
add(lasttrans1);
lasttrans1.setEditable(false);
acctype1.setEditable(false);
add(depamount1);
add(interest1);
add(netbal1);
interest1.setEditable(false);
netbal1.setEditable(false);

add(deposit);
deposit.addActionListener(this);
display.addActionListener(this);
setVisible(true);
add(display);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
ResultSet rs1=st.executeQuery("Select * from master");
if(rs1.next())
{

 intersave=rs1.getInt(1);
 intercurr=rs1.getInt(2);
System.out.println(intersave+"  "+intercurr);


}





}
catch(Exception e)
{

System.out.println(e);
}



}
public static void main(String a[])
{
new depositamount();
}
public void actionPerformed(ActionEvent ae)
{
 try
 {

  if(ae.getSource()==deposit)
  {
  String s1="update openacc set deposit="+(Integer.parseInt(depamount1.getText())+Integer.parseInt(netbal1.getText()))+" where acc_no='"+accno1.getText()+"'";
  JOptionPane.showMessageDialog(this,s1); 
 st.executeUpdate(s1);
 JOptionPane.showMessageDialog(this,"amount deposited");

 
int d=0;
ResultSet rd=st.executeQuery("select * from detail where accno="+accno1.getText());
while(rd.next())
{
d=rd.getInt(7);
d++;
}


String s2="insert into detail values('d','"+accno1.getText()+"',"+n+","+Integer.parseInt(depamount1.getText())+","+(n+Integer.parseInt(depamount1.getText()))+",'"+date1.getText()+"',"+d+")";
System.out.println(s2);

st.executeUpdate(s2);
}
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();

}

  if(ae.getSource()==display)
  {
    try
     {

 












     ResultSet rs=st.executeQuery("select * from openacc where acc_no="+accno1.getText());
   if(rs.next())
   {
   accname1.setText(rs.getString(4)+" "+rs.getString(5));
   acctype1.setText(rs.getString(3));
   dopen1.setText(rs.getString(2));
    prevbal1.setText(rs.getString(16));
   n=Integer.parseInt(rs.getString(16)); 
  System.out.println(n);

  }
  int c=0;
  String s2="select * from detail where accno='"+accno1.getText()+"'"; 


  ResultSet re=st.executeQuery(s2);
 while(re.next())
 {

  c=re.getInt(7);
 c++;
  }
String s1="select * from detail where accno='"+accno1.getText()+"' and cal="+(--c);
ResultSet rt=st.executeQuery(s1);
while(rt.next())
{
lasttrans1.setText(rt.getString(6));
 
}

java.util.Date d2=sdf.parse(lasttrans1.getText());
  long ms=d1.getTime()-d2.getTime();
 int days=(int)(((ms/1000)/60)/60)/24;
 System.out.print(days);


if(acctype1.getText().equals("Saving"))
{
inter=(int)Integer.parseInt(prevbal1.getText())*intersave/100*days/365;

interest1.setText(String.valueOf(inter));
netbal1.setText(String.valueOf(Integer.parseInt(prevbal1.getText())+inter));

}
else if(acctype1.getText().equals("Current"))
{
inter=(int)Integer.parseInt(prevbal1.getText())*intercurr/100*days/365;

}







}



catch(Exception e)
{
System.out.println(e);
e.printStackTrace();
}

}

}

}





