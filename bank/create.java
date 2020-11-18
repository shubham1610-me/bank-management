import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
class create extends JInternalFrame implements ActionListener,ItemListener
{
  JLabel fullname,userid,password1,password2,address,phone,city,gender,usertype;
JTextField fullname1,userid1,address1,phone1,city1,gender1,usertype1;
JRadioButton manager,clerk,male,female;
ButtonGroup b1,b2;
JPasswordField password11,password21;
JButton createid,cancel;
Connection con;
Statement st;


create()
{
super("create user",true,true,true,true);
setSize(800,700);
setTitle("Sign in page");
setLayout(null);
usertype=new JLabel("Usertype");
fullname=new JLabel("Full Name:");
userid=new JLabel("User Id");
password1=new JLabel("Enter Password");
password2=new JLabel("Re-Enter Password");
address=new JLabel("Address");
phone=new JLabel("Phone Number");
city=new JLabel("City");
gender=new JLabel("Gender");

fullname1=new JTextField();
userid1=new JTextField();
password11=new JPasswordField();
password21=new JPasswordField();
address1=new JTextField();
phone1=new JTextField();
city1=new JTextField();
gender1=new JTextField();
usertype1=new JTextField();

manager=new JRadioButton("Manager");
clerk=new JRadioButton("Clerk");
male=new JRadioButton("Male");
female=new JRadioButton("Female");

b1=new ButtonGroup();
b1.add(manager);
b1.add(clerk);

b2=new ButtonGroup();
b2.add(male);
b2.add(female);


createid=new JButton("Create");
cancel=new JButton("Cancel");

usertype.setBounds(50,50,100,30);
fullname.setBounds(50,90,200,30);
userid.setBounds(50,130,200,30);
password1.setBounds(50,170,200,30);
password2.setBounds(50,210,200,30);
address.setBounds(50,250,200,30);
phone.setBounds(50,290,200,30);
city.setBounds(50,330,200,30);
gender.setBounds(50,370,100,30);

manager.setBounds(160,50,100,30);
clerk.setBounds(270,50,100,30);
fullname1.setBounds(260,90,200,30);
userid1.setBounds(260,130,200,30);
password11.setBounds(260,170,200,30);
password21.setBounds(260,210,200,30);
address1.setBounds(260,250,200,30);
phone1.setBounds(260,290,200,30);
city1.setBounds(260,330,200,30);
male.setBounds(160,370,100,30);
female.setBounds(270,370,100,30);

createid.setBounds(150,450,200,30);
cancel.setBounds(360,450,200,30);

add(fullname);
add(userid);
add(password1);
add(password2);
add(address);
add(phone);
add(city);
add(gender);
add(usertype);

add(fullname1);
add(userid1);
add(password11);
add(password21);
add(address1);
add(phone1);
add(city1);
add(male);
add(female);
add(manager);
add(clerk);
add(createid);
add(cancel);
manager.setSelected(true);
male.setSelected(true);
setVisible(true);

createid.addActionListener(this);
cancel.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
}
catch(Exception e)
{
System.out.print("Exception occured"+e);
}
}

public static void main(String a[])
{
new create();
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==createid)
 {
boolean check=Validation.checkString(fullname1.getText());
boolean ph=Validation.checkPhone(phone1.getText()); 
boolean id=Validation.checkId(userid1.getText());
if(check)
   {
JOptionPane.showMessageDialog(this,"Enter Valid Name");  
   }
else if(ph)
   {
JOptionPane.showMessageDialog(this,"enter Valid Number");
   }
else if(id)
   {
JOptionPane.showMessageDialog(this,"enter valid Id(No spaces are allowed)");
   }
else if(!(password11.getText().equals(password21.getText())))
   {
JOptionPane.showMessageDialog(this,"two passwords are not same"+password11.getText()+"  "+password21.getText()); 
   }
   else
   {
  String post="";
   String gen="";
   if(manager.isSelected())
    post="Manager";
    else if(clerk.isSelected())
    post="clerk";

    if(male.isSelected())
    gen="Male";
    else if(female.isSelected())
    gen="Female";


String ad="insert into signin values('"+post+"','"+fullname1.getText()+"','"+userid1.getText()+"','"+password11.getText()+"','"+address1.getText()+"','"+phone1.getText()+"','"+city1.getText()+"','"+gen+"')";                     
JOptionPane.showMessageDialog(this,""+ad);   
st.executeUpdate(ad);
JOptionPane.showMessageDialog(this,"New Id created");
     }

 }
}
      catch(Exception e)
       {
     System.out.print("exception Occured");
       e.getStackTrace();

        }
   }
public void itemStateChanged(ItemEvent ie)
{
}
}