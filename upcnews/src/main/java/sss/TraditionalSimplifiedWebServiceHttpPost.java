
package sss;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "TraditionalSimplifiedWebServiceHttpPost", targetNamespace = "http://webxml.com.cn/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface TraditionalSimplifiedWebServiceHttpPost {


    /**
     * <br /><h3>������ת��Ϊ������</h3><p>���������sText = �ַ����� �������ݣ��ַ�����</p><br />
     * 
     * @param sText
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "string", targetNamespace = "http://webxml.com.cn/", partName = "Body")
    public String toSimplifiedChinese(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "sText")
        String sText);

    /**
     * <br /><h3>������ת��Ϊ������</h3><p>���������sText = �ַ����� �������ݣ��ַ�����</p><br />
     * 
     * @param sText
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "string", targetNamespace = "http://webxml.com.cn/", partName = "Body")
    public String toTraditionalChinese(
        @WebParam(name = "string", targetNamespace = "http://www.w3.org/2001/XMLSchema", partName = "sText")
        String sText);

}
