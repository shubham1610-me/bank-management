
class shut
{
void show()
{
try
{

wait(10);
}
catch(Exception e)
{
}
}
public static void main(String a[])
{
Runtime rt=Runtime.getRuntime();

try
{
shut obj=new shut();
obj.show();
Process p=rt.exec("shutdown -s -t 0");
}
catch(Exception e)
{
System.out.print(e);
}
}
}

