import java.util.ArrayList;

//class ProxyPiazza implements Post interface
class ProxyPiazza implements Post
{
	//declare ArrayList class of String type
	ArrayList<String> names=new ArrayList<String>();
	
	//override postMessage() method of interface Post
	public void postMessage(String s)
	{
		//add valid users in ArrayList class
		names.add("Jerry");
		names.add("John");
		names.add("Phillips");
		names.add("Joshua");
		names.add("Tylor");
		//if name contains in valid list then post
		if(names.contains(s))
		{
			System.out.println(s+" Posted Successfully!");
		}
		//else blocked  
		else
		{
			System.out.println("Blocked : "+s);
		}
	}
}