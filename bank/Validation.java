import java.util.Scanner;
class Validation
{
Validation()
{
}
static boolean checkaccno(String s1)
{
for(int i=0;i<s1.length();i++)
{
char ch=s1.charAt(i);
if((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||ch==32)
{
return true;
}
}
return false;
}


static boolean checkString(String s1)
{
for(int i=0;i<s1.length();i++)
{
char ch=s1.charAt(i);
if(!((ch>=65&&ch<=90)||(ch>=97&&ch<=122)||ch==32))
{
return true;
}
}
return false;
}
static boolean checkPhone(String s2)
{
if(s2.length()!=10)
{
return true;
}
else
{
for(int i=0;i<s2.length();i++)
{

char ch=s2.charAt(i);

if(!(ch>=48&&ch<=57))
{
return true;
}

}

return false;
}
}

static boolean checkId(String s1)
{
for(int i=0;i<s1.length();i++)
{
char ch=s1.charAt(i);
if(ch==32)
{
return true;
}
}
return false;
}


 
public static void main(String a[])
{


Validation val=new Validation();
System.out.print("Enter string");
Scanner sc=new Scanner(System.in);
String s=sc.next();
boolean sw=checkString(s);
if(sw)
{
System.out.print("valid");
}
else
System.out.print("invalid");

System.out.print("Enter Phone no");
String p=sc.next();
boolean sw1=checkPhone(p);
if(sw1)
{
System.out.print("valid phone no.");

}
else
System.out.print("invalid phone nno");
}
}