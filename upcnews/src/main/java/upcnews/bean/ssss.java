package upcnews.bean;
public class ssss{
  public static void main(String[] argv) {
    sss.TraditionalSimplifiedWebService service = new sss.TraditionalSimplifiedWebService();
    //invoke business method
    sss.TraditionalSimplifiedWebServiceSoap sv =service.getTraditionalSimplifiedWebServiceSoap();
    System.out.println(sv.toTraditionalChinese("简体变繁体"));
  }

public String tran(String s)
{

  sss.TraditionalSimplifiedWebService service = new sss.TraditionalSimplifiedWebService();
  //invoke business method
  sss.TraditionalSimplifiedWebServiceSoap sv =service.getTraditionalSimplifiedWebServiceSoap();
  return  sv.toTraditionalChinese("s");

}

}