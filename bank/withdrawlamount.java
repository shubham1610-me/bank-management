import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
class withdrawlamount extends JInternalFrame implements ActionListener
{
JLabel date,accno,acctype,accname,dopen,prevbal,lasttrans,withamount,interest,netbal,minbal,val;
JTextField acctype1,accno1,accname1,dopen1,prevbal1,lasttrans1,withamount1,interest1,netbal1,minbal1,date1;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");

java.util.Date d1=new java.util.Date();

JButton withdrawl,display;
Connection con;
Statement st;
int as=0,intercurr,intersave,inter;
withdrawlamount()
{
super("withdrawl amount",true,true,true,true);
setTitle("WITHDRAWl AMOUNT");
setSize(1000,800);
setLayout(null);
date=new JLabel("Date");
accno=new JLabel("Account no.");
acctype=new JLabel("Account Type");
accname=new JLabel("Account Holder Name");
dopen=new JLabel("Date Of Acc. open ");
prevbal=new JLabel("Previous Balance");
lasttrans=new JLabel("Last Transection");
withamount=new JLabel("withdrawl Amount");
interest=new JLabel("Interest");
netbal=new JLabel("NET BALANCE");
minbal=new JLabel("Min. Balance required");
val=new JLabel("dd/MM/yyyy");



accno1=new JTextField();
accname1=new JTextField();
dopen1=new JTextField();
prevbal1=new JTextField();
lasttrans1=new JTextField();
withamount1=new JTextField();
interest1=new JTextField();
netbal1=new JTextField();
minbal1=new JTextField();
minbal1.setEditable(false);
date1=new JTextField();
date1.setText(sdf.format(d1));
acctype1=new JTextField();

withdrawl=new JButton("Withdrawl Amount");
display=new JButton("Display");


date.setBounds(50,30,200,30);
val.setBounds(470,30,150,30);
accno.setBounds(50,70,200,30);
acctype.setBounds(50,110,200,30);
accname.setBounds(50,150,200,30);
dopen.setBounds(50,190,200,30);
prevbal.setBounds(50,230,200,30);
lasttrans.setBounds(50,270,200,30);
interest.setBounds(50,310,200,30);
minbal.setBounds(470,310,200,30);
netbal.setBounds(50,350,200,30);
withamount.setBounds(50,390,200,30);

date1.setBounds(260,30,200,30);
date1.setEditable(false);
accno1.setBounds(260,70,200,30);
display.setBounds(470,70,200,30);
acctype1.setBounds(260,110,200,30);
accname1.setBounds(260,150,200,30);
dopen1.setBounds(260,190,200,30);
prevbal1.setBounds(260,230,200,30);
lasttrans1.setBounds(260,270,200,30);
interest1.setBounds(260,310,200,30);
minbal1.setBounds(680,310,200,30);
netbal1.setBounds(260,350,200,30);
withamount1.setBounds(260,390,200,30);
withdrawl.setBounds(250,490,200,30);

add(date);
add(accno);
add(acctype);
add(accname);
add(dopen);
add(prevbal);
add(lasttrans);
add(withamount);
add(interest);
add(netbal);
add(minbal);

add(date1);
add(accno1);
add(acctype1);
add(accname1);
add(dopen1);
add(prevbal1);
add(lasttrans1);
add(withamount1);
add(interest1);
add(netbal1);
add(minbal1);
add(withdrawl);
add(display);
setVisible(true);
add(val);

acctype1.setEditable(false);
accname1.setEditable(false);
dopen1.setEditable(false);
prevbal1.setEditable(false);
lasttrans1.setEditable(false);
display.addActionListener(this);
withdrawl.addActionListener(this);
interest1.setEditable(false);
netbal1.setEditable(false);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
ResultSet rs1=st.executeQuery("Select * from master");
if(rs1.next())
{
minbal1.setText(rs1.getString(3));
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
new withdrawlamount();
}
public void actionPerformed(ActionEvent ae)
{
try
{



   if(ae.getSource()==display)
   {
   ResultSet rs=st.executeQuery("select * from openacc where acc_no="+accno1.getText());
      if(rs.next())
      {
      acctype1.setText(rs.getString(3));
      accname1.setText(rs.getString(4)+rs.getString(5));
       dopen1.setText(rs.getString(2));
prevbal1.setText(rs.getString(16));
      rs=st.executeQuery("select * from detail where accno="+accno1.getText());

         while(rs.next())
          {
         
         lasttrans1.setText(rs.getString(6));



         }

while(rs.next())
{
as=rs.getInt(7);
}
System.out.print("as="+as);
System.out.print(acctype1.getText());

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
  }

   if(ae.getSource()==withdrawl)
        {


int n=Integer.parseInt(netbal1.getText())-Integer.parseInt(withamount1.getText());
System.out.print(n);
if(n>=Integer.parseInt(minbal1.getText()))
           {
String q="insert into detail values('w','"+accno1.getText()+"',"+prevbal1.getText()+","+withamount1.getText()+","+n+",'"+sdf.format(d1)+"',"+(++as)+")";

st.executeUpdate(q);
String d="update openacc set deposit="+n+" where acc_no="+accno1.getText();

st.executeUpdate(d);
JOptionPane.showMessageDialog(this,"current bal is    "+String.valueOf(n));
JOptionPane.showMessageDialog(this,"Amount withdrawl");

accno1.setText("");
prevbal1.setText("");
withamount1.setText("");
accname1.setText("");
dopen1.setText("");
lasttrans1.setText("");
acctype1.setText("");
netbal1.setText("");
interest1.setText("");

          }
else
          {
JOptionPane.showMessageDialog(this,"you can only withdraw "+(Integer.parseInt(netbal1.getText())-Integer.parseInt(minbal1.getText())));
          
}
        }

}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}
}
}