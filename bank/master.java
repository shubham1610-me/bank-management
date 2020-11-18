import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class master extends JInternalFrame implements ActionListener
{
int p=0;
JLabel Savingacc,currentcharge,minbal;
JTextField Savingacc1,currentcharge1,minbal1;
Connection con;
Statement st;
JButton update;
master()
{
super("master from",true,true,true,true);
setTitle("Master Form"); 
setSize(800,800);
setLayout(null);
Savingacc=new  JLabel("Saving Account Interest");
currentcharge=new  JLabel("Current Account Charges");
minbal=new  JLabel("Minimum Balance Required");

Savingacc1=new JTextField();
currentcharge1=new JTextField();
minbal1=new JTextField();

update=new JButton("Update");

Savingacc.setBounds(50,30,200,30);
currentcharge.setBounds(50,70,200,30);
minbal.setBounds(50,110,200,30);


Savingacc1.setBounds(260,30,200,30);
currentcharge1.setBounds(260,70,200,30);
minbal1.setBounds(260,110,200,30);

update.setBounds(250,160,200,30);
add(Savingacc);
add(currentcharge);
add(minbal);

add(Savingacc1);
add(currentcharge1);
add(minbal1);

add(update);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
ResultSet rs=st.executeQuery("select saveint,currentcharge,minbal from master");
if(rs.next())
{
Savingacc1.setText(rs.getString(1));
currentcharge1.setText(rs.getString(2));
minbal1.setText(rs.getString(3));

} 
}
catch(Exception e)
{

System.out.println(e);
e.getStackTrace();
}

setVisible(true);
update.addActionListener(this);
}

public static void main(String a[])
{
new master();
}
public void actionPerformed(ActionEvent ae)
{

try
{
if(ae.getSource()==update)
{
if(p==0)
{
Savingacc1.setEditable(true);
currentcharge1.setEditable(true);
minbal1.setEditable(true);

p++;
}
else
{
Savingacc1.setEditable(true);
currentcharge1.setEditable(true);
minbal1.setEditable(true);
String s1="update master set saveint="+Integer.parseInt(Savingacc1.getText())+",currentcharge="+Integer.parseInt(currentcharge1.getText())+",minbal="+Integer.parseInt(minbal1.getText());
//JOptionPane.showMessageDialog(this,s1);
st.executeUpdate(s1);
JOptionPane.showMessageDialog(this,"Information Updated");
Savingacc1.setEditable(false);
currentcharge1.setEditable(false);
minbal1.setEditable(false);
p--;
}
}
}
catch(Exception e)
{
System.out.print(e);
e.getStackTrace();
}
}
}
