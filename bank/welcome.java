import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
class welcome extends JFrame implements ActionListener
{
JButton loginmanager,loginclerk;
JLabel welcome,created,name,image;
welcome()
{
ImageIcon ii=new ImageIcon("1.jpg");
image=new JLabel(ii);
setTitle("WELCOME");
setLayout(null);
setSize(1000,700);
image.setBounds(0,0,1000,700);
loginmanager=new JButton("Login Manager");
loginclerk=new JButton("Login Clerk");
welcome=new JLabel("Automatic Banking System"); 
created=new JLabel("Created By:");
name=new JLabel("Shubham Mehta");
created.setBounds(800,590,200,20);
name.setBounds(800,610,200,20);
loginmanager.setBounds(250,250,200,30);
loginclerk.setBounds(460,250,200,30);
add(loginmanager);
add(loginclerk);
add(created);
add(name);
add(image);
loginmanager.addActionListener(this);
loginclerk.addActionListener(this);
setVisible(true);

}


public static void main(String a[])
{
new welcome();
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==loginmanager)
{
loginform obj=new loginform("Manager");
dispose();
}
if(ae.getSource()==loginclerk)
{
loginform obj1=new loginform("Clerk");
dispose();
}
}
}