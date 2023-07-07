package MavenProject.SpringFirstProject;

 
public class App 
{
    public static void main( String[] args )
    {
    	FileSystemResource res=new FileSystemResource(“…/applicationContext.xml”);

        XmlBeanFactory factory= new XmlBeanFactory(res);
//
//          Object object= factory.getBean(“wmg”); // getting Spring bean class obj
//
//          Object.generateWishMessage(“raja”);

          WishMessageGenerator generator=(WishMessageGenerator)object; //type casting

          String result=generator.generateWishMessage(“raja”);

          System.out.println(result);
    }
}
