import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class adminact extends JFrame implements ActionListener
{
JMenuItem createuser,dropuser,changep,masterform,accopenform,withdrawl,deposit,accinfo,mini,exit;
JMenu user,account,transection,report;
JMenuBar mb;

JDesktopPane pane=new JDesktopPane();
String userid="";


adminact(String str)
{
userid=str;
setTitle("Admin Activity Form");
setSize(1280,800);
setLayout(null); 
mb=new JMenuBar();
createuser=new JMenuItem("Create User");
dropuser=new JMenuItem("Drop User");
changep=new JMenuItem("Change Password");
masterform=new JMenuItem("Master Form");
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

setContentPane(pane);

user.add(createuser);
user.add(dropuser);
user.add(changep);
user.add(exit);


account.add(masterform);
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


createuser.addActionListener(this);
dropuser.addActionListener(this);
changep.addActionListener(this);
masterform.addActionListener(this);
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
if(ae.getSource()==createuser)
{
create obj1=new create();
pane.add(obj1);
try
{
obj1.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}
}
if(ae.getSource()==dropuser)
{
drop obj2=new drop();
pane.add(obj2);
try
{
obj2.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}

if(ae.getSource()==changep)
{
changepassword obj3=new changepassword(userid);

pane.add(obj3);
try
{
obj3.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}


if(ae.getSource()==masterform)
{
master obj4=new master();
pane.add(obj4);
try
{
obj4.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}


if(ae.getSource()==accopenform)
{
openacc obj5=new openacc();
pane.add(obj5);
try
{
obj5.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}
if(ae.getSource()==withdrawl)
{
withdrawlamount obj6=new withdrawlamount();
pane.add(obj6);
try
{
obj6.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}


if(ae.getSource()==deposit)
{
depositamount obj7=new depositamount();
pane.add(obj7);
try
{
obj7.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}

if(ae.getSource()==accinfo)
{
accinfo obj8=new accinfo();
pane.add(obj8);
try
{
obj8.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}

if(ae.getSource()==mini)
{
meminfo obj9=new meminfo();
pane.add(obj9);
try
{
obj9.setMaximum(true);
}
catch(Exception err)
{
err.printStackTrace();
}

}


if(ae.getSource()==exit)
{
System.exit(0);
}


}
}