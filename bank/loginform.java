import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class loginform extends JFrame implements ActionListener
{
JLabel userid,password1;
JTextField userid1;
JPasswordField password11;
JButton login,cancel;
Connection con;
Statement st;
String user="";
loginform(String str)
{
user=str;
setSize(700,500);
setTitle(str+"Login Form");
setLayout(null);
userid=new JLabel("User Id");
password1=new JLabel("Password");
login=new JButton("Login");
cancel=new JButton("Cancel");
userid1=new JTextField();
password11=new JPasswordField();
add(userid);
userid.setBounds(50,50,200,30);
password1.setBounds(50,90,200,30);

userid1.setBounds(260,50,200,30);
password11.setBounds(260,90,200,30);

login.setBounds(70,160,150,30);
cancel.setBounds(310,160,150,30);




add(password1);
add(userid1);
add(password11);
setVisible(true);

add(login);
add(cancel);
login.addActionListener(this);
cancel.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
}
catch(Exception e)
{
System.out.print("Exception Occured");
}


}



public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==login)
{
ResultSet rs=st.executeQuery("select usertype,userid,password1 from signin where userid='"+userid1.getText()+"' and password1='"+password11.getText()+"'");
int p=0;
   if(rs.next())
  {
   if(rs.getString(2).equals(userid1.getText()) && rs.getString(3).equals(password11.getText()))
    {
    JOptionPane.showMessageDialog(this,"Login Successful");
    p=1; 
System.out.print(rs.getString(1)); 
   if(user=="Manager")
    {
   new adminact(userid1.getText());
   dispose();

     }
    else
     {
     new act(userid1.getText());
     dispose();
     }

    
    }
  }

    if(p==0)
    {
    JOptionPane.showMessageDialog(this,"Wrong userid or password ");
     }

}
if(ae.getSource()==cancel)
{
dispose();
new welcome();

}
}
catch(Exception e)
{
System.out.print("Exception Occured:"+e);
e.printStackTrace();
}
}
}