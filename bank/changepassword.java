import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class changepassword extends JInternalFrame implements ActionListener
{
JLabel newpassword1,newpassword2,oldpassword1;
JPasswordField newpassword11,newpassword21;
JTextField oldpassword11;
JButton change,cancel;
Connection con;
Statement st;
String userid;
changepassword(String str)
{

super("Change password",true,true,true,true);
userid=str;
setSize(700,500);
setTitle("Change Password"); 
setLayout(null);
newpassword11=new JPasswordField();
newpassword21=new JPasswordField();
change=new JButton("Change");
cancel=new JButton("Cancel");
oldpassword1=new JLabel("old password");
oldpassword11=new JTextField();


newpassword1=new JLabel("New Password");
newpassword2=new JLabel("Confirm Password");

newpassword1.setBounds(70,120,200,30);
newpassword2.setBounds(70,170,200,30);

newpassword11.setBounds(280,120,200,30);
newpassword21.setBounds(280,170,200,30);

change.setBounds(90,230,200,30);
cancel.setBounds(310,230,200,30);
oldpassword1.setBounds(70,90,200,30);
oldpassword11.setBounds(280,90,200,30);

add(newpassword11);
add(newpassword21);

add(newpassword1);
add(newpassword2);
add(oldpassword1);
add(oldpassword11);
add(change);
add(cancel);
change.addActionListener(this);
cancel.addActionListener(this);


setVisible(true);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
}
catch(Exception err1)
{
err1.printStackTrace();
}
}


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==change)
{
String re="select password1 from signin where userid='"+userid+"'";
JOptionPane.showMessageDialog(this,re); 

try
{ 
ResultSet rs=st.executeQuery(re);
if(rs.next())
{
System.out.print(rs.getString(1));
 if(rs.getString(1).equals(oldpassword11.getText()))
 {
      if(newpassword11.getText().equals(newpassword21.getText()))
       {


      String sw="update signin set password1='"+newpassword11.getText()+"' where userid='"+userid+"'";
      JOptionPane.showMessageDialog(this,sw);
      st.executeUpdate(sw);
      JOptionPane.showMessageDialog(this,"password Changed");
       }
      
 



     else
     {
     JOptionPane.showMessageDialog(this,"both password are not same");
      }
 }

    else
   {
   JOptionPane.showMessageDialog(this,"Old password is not correct");
   }
   }
   }
catch(Exception ew)
{
System.out.print(ew);
ew.printStackTrace();
}
}
if(ae.getSource()==cancel)
{
dispose();
}
}
}