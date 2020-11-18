import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class drop extends JInternalFrame implements ActionListener,ItemListener
{
JComboBox userlist1;
JLabel userlist,name,phone;
JTextField name1,phone1;
JButton dropuser,cancel;
Connection con;
Statement st;

drop()
{
super(" drop user",true,true,true,true);
setTitle("Drop User");
setLayout(null);
setSize(800,600);
userlist1=new JComboBox();
userlist=new JLabel("User List");
name=new JLabel("Name");
phone=new JLabel("Phone No.");

name1=new JTextField();
phone1=new JTextField();

dropuser=new JButton("Drop User");
cancel=new JButton("Cancel");

userlist.setBounds(70,70,200,30);
name.setBounds(70,120,200,30);
phone.setBounds(70,170,200,30);

userlist1.setBounds(280,70,200,30);
userlist1.addItem("Select Option");
name1.setBounds(280,120,200,30);
phone1.setBounds(280,170,200,30);

dropuser.setBounds(90,230,200,30);
cancel.setBounds(300,230,200,30);

add(userlist);
add(name);
add(phone);

add(userlist1);
add(name1);
add(phone1);

add(dropuser);
add(cancel);

setVisible(true);

dropuser.addActionListener(this);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
ResultSet rs=st.executeQuery("Select userid from signin");
while(rs.next())
{
userlist1.addItem(rs.getString(1));
}
}

catch(Exception e)
{
System.out.print("Exception Occured"+e);
}

userlist1.addItemListener(this);


}
public static void main(String a[])
{
new drop();
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==dropuser)
{
String s1="delete from signin where userid='"+userlist1.getSelectedItem()+"'";
st.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"User Droped");

}
}
catch(Exception e)
{
System.out.print("Exception Occurred"+e);
e.getStackTrace();
}
}

public void itemStateChanged(ItemEvent ie)
{
if(userlist1.getSelectedIndex()!=0 && ie.getSource()==userlist1)
{
  try
  {
ResultSet rs=st.executeQuery("Select fullname,phone from signin where userid='"+userlist1.getSelectedItem()+"'");
if(rs.next())
{
System.out.println("sdfsd");
name1.setText(rs.getString(1));
phone1.setText(rs.getString(2));
}
  }
   catch(Exception e)
  {
System.out.print("Exception Occured"+e);
e.getStackTrace();
  }

}

}
}