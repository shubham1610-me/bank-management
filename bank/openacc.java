import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
class openacc extends JInternalFrame implements ActionListener,ItemListener
{
JLabel accountnumber,opendate,accounttype,firstname,lastname,nomineename,relation,dob,gender,address,city,state,phone,adhar,pan,mindeposit; 
JTextField accountnumber1,firstname1,lastname1,nomineename1,relation1,dob1,address1,city1,phone1,adhar1,pan1,mindeposit1,opendate1;
JComboBox state1,day2,month2,year2;
JRadioButton saving,current,male,female;
JButton create;
Connection con;
Statement st;
ButtonGroup b1,b2;
SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
java.util.Date d1=new java.util.Date();
openacc()
{
super("open account",true,true,true,true);
setTitle("Open Account");
setSize(1000,750);
setLayout(null);
b1=new ButtonGroup();
b2=new ButtonGroup();
create=new JButton("Create");
accountnumber=new JLabel("Account Number");
opendate1=new JTextField();


day2=new JComboBox();
day2.addItem("dd");
for(int i=1;i<=31;i++)
{
day2.addItem(String.valueOf(i));
}
month2=new JComboBox();
month2.addItem("MM");
month2.addItem("Jan");
month2.addItem("feb");
month2.addItem("Mar");
month2.addItem("Apr");
month2.addItem("May");
month2.addItem("Jun");
month2.addItem("Jul");
month2.addItem("Aug");
month2.addItem("Sep");
month2.addItem("Oct");
month2.addItem("Nov");
month2.addItem("Dec");
year2=new JComboBox();
year2.addItem("yyyy");
for(int j=1900;j<=2018;j++)
{
 year2.addItem(String.valueOf(j));
}




accounttype=new JLabel("Account Type");
firstname=new JLabel("First Name");
lastname=new JLabel("Last Name");
nomineename=new JLabel("Nominee Name");
relation=new JLabel("Relation");
dob=new JLabel("Date Of Birth");
gender=new JLabel("Gender");
address=new JLabel("Address");
city=new JLabel("City");
state=new JLabel("State");
phone=new JLabel("Phone Number");
adhar=new JLabel("Adhar No.");
pan=new JLabel("Pan Card Number");
mindeposit=new JLabel("Deposit");
opendate=new JLabel("Open Date");
accountnumber1=new JTextField();

saving=new JRadioButton("Saving");
current=new JRadioButton("Current");
b1.add(saving);
b1.add(current);
firstname1=new JTextField();
lastname1=new JTextField();
nomineename1=new JTextField();
relation1=new JTextField();

male=new JRadioButton("Male");
female=new JRadioButton("Female");
address1=new JTextField();
city1=new JTextField();
state1=new JComboBox();
state1.addItem("Select Option");
state1.addItem("Haryana");
state1.addItem("Punjab");
state1.addItem("Himachal Pardesh");
state1.addItem("Utter Pardesh");
phone1=new JTextField();
adhar1=new JTextField();
pan1=new JTextField();
mindeposit1=new JTextField();

accountnumber.setBounds(50,30,200,30);
opendate.setBounds(470,30,200,30);
accounttype.setBounds(50,70,200,30);
firstname.setBounds(50,110,200,30);
lastname.setBounds(470,110,200,30);
nomineename.setBounds(50,150,200,30);
relation.setBounds(470,150,200,30);
dob.setBounds(50,190,200,30);
gender.setBounds(470,190,100,30);
male.setBounds(580,190,70,30);
female.setBounds(660,190,70,30);
address.setBounds(50,230,200,30);
city.setBounds(50,310,200,30);
state.setBounds(50,350,200,30);
phone.setBounds(50,390,200,30);
adhar.setBounds(50,430,200,30);
pan.setBounds(50,470,200,30);
mindeposit.setBounds(50,510,200,30);
 
accountnumber1.setBounds(210,30,200,30);
accountnumber1.setEditable(false);
opendate1.setEditable(false);
opendate1.setBounds(580,30,200,30);


firstname1.setBounds(210,110,200,30);
lastname1.setBounds(680,110,200,30);
nomineename1.setBounds(210,150,200,30);
relation1.setBounds(680,150,200,30);
day2.setBounds(210,190,70,30);
month2.setBounds(280,190,70,30);
year2.setBounds(350,190,70,30);
address1.setBounds(210,230,200,60);
city1.setBounds(210,310,200,30);
phone1.setBounds(210,390,200,30);
adhar1.setBounds(210,430,200,30);
pan1.setBounds(210,470,200,30);
mindeposit1.setBounds(210,510,200,30);

saving.setBounds(210,70,100,30);
current.setBounds(320,70,100,30);
state1.setBounds(210,350,200,30);
create.setBounds(400,590,200,30);
add(accountnumber);
add(opendate);
add(accounttype);
add(firstname);
add(lastname);
add(nomineename);
add(relation);
add(dob);
add(gender);
add(address);
add(city);
add(state);
add(phone);
add(adhar);
add(pan);
add(mindeposit);

add(accountnumber1);
add(saving);
add(current);
add(firstname1);
add(lastname1);
add(nomineename1);
add(relation1);
add(day2);
add(month2);
add(year2);

add(male);
add(female);
add(address1);
add(city1);
add(state1);
add(phone1);
add(adhar1);
add(pan1);
add(mindeposit1);
add(create);
add(opendate1);
setVisible(true);

create.addActionListener(this);
try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/abc","root","");
st=con.createStatement();
ResultSet rs=st.executeQuery("Select count(*) from openacc");
int adno=0;
if(rs.next())
{
adno=rs.getInt(1);
adno++;


opendate1.setText(sdf.format(d1));
accountnumber1.setText(String.valueOf(adno));

}
}
catch(Exception e)
{
e.getStackTrace();
}
}
public static void main(String a[])
{
new openacc();
}
public void actionPerformed(ActionEvent ae)
{
try
{

if(ae.getSource()==create)
{
boolean na=Validation.checkString(firstname1.getText());
boolean la=Validation.checkString(lastname1.getText());
boolean phn=Validation.checkPhone(phone1.getText());
boolean acc=Validation.checkaccno(accountnumber1.getText());
boolean adh=Validation.checkaccno(adhar1.getText());
boolean deposit=Validation.checkaccno(mindeposit1.getText());
if(na||la)
JOptionPane.showMessageDialog(this,"either invalid first or last name ");
else if(phn)
JOptionPane.showMessageDialog(this,"invalid phone no.");
else if(acc)
JOptionPane.showMessageDialog(this,"invalid no. ");
else if(adh)
JOptionPane.showMessageDialog(this,"Invalid adhar");
else if(deposit||Integer.parseInt(mindeposit1.getText())<6000)
JOptionPane.showMessageDialog(this,"invalid deposit(either invalid or less than 6000)");
else if(address1.getText()==null||address1.getText()=="")
JOptionPane.showMessageDialog(this,"invalid address");
 else
{
String g=""+day2.getSelectedItem()+"/"+month2.getSelectedItem()+"/"+year2.getSelectedItem()+"";
System.out.print("ssss");
String type="";
String gen="";
if(current.isSelected())
type="Current";
else if(saving.isSelected())
type="Saving";

if(male.isSelected())
gen="Male";
else if(female.isSelected())
gen="Female";

String s="insert into openacc values('"+accountnumber1.getText()+"','"+sdf.format(d1)+"','"+type+"','"+firstname1.getText()+"','"+lastname1.getText()+"','"+nomineename1.getText()+"','"+relation1.getText()+"','"+g+"','"+gen+"','"+address1.getText()+"','"+city1.getText()+"','"+state1.getSelectedItem()+"','"+phone1.getText()+"','"+adhar1.getText()+"','"+pan1.getText()+"',"+Integer.parseInt(mindeposit1.getText())+")";
System.out.println(s);

st.executeUpdate(s);
st.executeUpdate("insert into detail values('d','"+accountnumber1.getText()+"',0,"+Integer.parseInt(mindeposit1.getText())+","+Integer.parseInt(mindeposit1.getText())+",'"+sdf.format(d1)+"',1)");

JOptionPane.showMessageDialog(this,"Account Created");
ResultSet rs=st.executeQuery("Select count(*) from openacc");
int adno=0;
if(rs.next())
{
adno=rs.getInt(1);
adno++;
accountnumber1.setText(String.valueOf(adno));
}

firstname1.setText("");
lastname1.setText("");
nomineename1.setText("");
relation1.setText("");
address1.setText("");
city1.setText("");
phone1.setText("");
adhar1.setText("");
pan1.setText("");
mindeposit1.setText("");
day2.setSelectedIndex(0);
month2.setSelectedIndex(0);
year2.setSelectedIndex(0);


}
}
}
catch(Exception es)
{
//es.getStackTrace();
System.out.print(es);
es.printStackTrace();
}

}
public void itemStateChanged(ItemEvent ie)
{

}
}