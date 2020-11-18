import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class act extends JFrame implements ActionListener
{
JMenuItem changep,accopenform,withdrawl,deposit,accinfo,mini,exit;
JMenu user,account,transection,report;
JMenuBar mb;
String userid="";
act(String str)
{
str=userid;
setTitle(" Activity Form");
setSize(1000,500);
setLayout(null); 
mb=new JMenuBar();
changep=new JMenuItem("Change Password");
accopenform=new JMenuItem("Account Opening Form");
withdrawl=new JMenuItem("Withdrawl");
deposit=new JMenuItem("Deposit");
accinfo=new JMenuItem("Account Information");
mini=new JMenuItem("Mini Statement");
exit=new JMenuItem("Exit");

user=new JMenu("User");
account=new JMenu("Account");
transection=new JMenu("Transection");
report=new JMenu("Report");



user.add(changep);
user.add(exit);



account.add(accopenform);

transection.add(withdrawl);
transection.add(deposit);

report.add(accinfo);
report.add(mini);

mb.add(user);
mb.add(account);
mb.add(transection);
mb.add(report);


setJMenuBar(mb);
add(mb);

changep.addActionListener(this);
accopenform.addActionListener(this);
withdrawl.addActionListener(this);
deposit.addActionListener(this);
accinfo.addActionListener(this);
mini.addActionListener(this);
exit.addActionListener(this);
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{

if(ae.getSource()==changep)
{
new changepassword(userid);
}




if(ae.getSource()==accopenform)
{
new openacc();

}
if(ae.getSource()==withdrawl)
{
new withdrawlamount();
}


if(ae.getSource()==deposit)
{
new depositamount();
}

if(ae.getSource()==accinfo)
{
new accinfo();
}

if(ae.getSource()==mini)
{
new meminfo();
}


if(ae.getSource()==exit)
{

}


}
}