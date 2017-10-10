
package com.zooper.ws.datatype;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.zooper.ws.datatype package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddStudent_QNAME = new QName("http://dataType.ws.zooper.com/", "addStudent");
    private final static QName _AddStudentResponse_QNAME = new QName("http://dataType.ws.zooper.com/", "addStudentResponse");
    private final static QName _GetAllStudentsMap_QNAME = new QName("http://dataType.ws.zooper.com/", "getAllStudentsMap");
    private final static QName _GetAllStudentsMapResponse_QNAME = new QName("http://dataType.ws.zooper.com/", "getAllStudentsMapResponse");
    private final static QName _GetStudentById_QNAME = new QName("http://dataType.ws.zooper.com/", "getStudentById");
    private final static QName _GetStudentByIdResponse_QNAME = new QName("http://dataType.ws.zooper.com/", "getStudentByIdResponse");
    private final static QName _GetStudentBySex_QNAME = new QName("http://dataType.ws.zooper.com/", "getStudentBySex");
    private final static QName _GetStudentBySexResponse_QNAME = new QName("http://dataType.ws.zooper.com/", "getStudentBySexResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.zooper.ws.datatype
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse }
     * 
     */
    public GetAllStudentsMapResponse createGetAllStudentsMapResponse() {
        return new GetAllStudentsMapResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse.Return }
     * 
     */
    public GetAllStudentsMapResponse.Return createGetAllStudentsMapResponseReturn() {
        return new GetAllStudentsMapResponse.Return();
    }

    /**
     * Create an instance of {@link AddStudent }
     * 
     */
    public AddStudent createAddStudent() {
        return new AddStudent();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link GetAllStudentsMap }
     * 
     */
    public GetAllStudentsMap createGetAllStudentsMap() {
        return new GetAllStudentsMap();
    }

    /**
     * Create an instance of {@link GetStudentById }
     * 
     */
    public GetStudentById createGetStudentById() {
        return new GetStudentById();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link GetStudentBySex }
     * 
     */
    public GetStudentBySex createGetStudentBySex() {
        return new GetStudentBySex();
    }

    /**
     * Create an instance of {@link GetStudentBySexResponse }
     * 
     */
    public GetStudentBySexResponse createGetStudentBySexResponse() {
        return new GetStudentBySexResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetAllStudentsMapResponse.Return.Entry }
     * 
     */
    public GetAllStudentsMapResponse.Return.Entry createGetAllStudentsMapResponseReturnEntry() {
        return new GetAllStudentsMapResponse.Return.Entry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudent }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "addStudent")
    public JAXBElement<AddStudent> createAddStudent(AddStudent value) {
        return new JAXBElement<AddStudent>(_AddStudent_QNAME, AddStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddStudentResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "addStudentResponse")
    public JAXBElement<AddStudentResponse> createAddStudentResponse(AddStudentResponse value) {
        return new JAXBElement<AddStudentResponse>(_AddStudentResponse_QNAME, AddStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsMap }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getAllStudentsMap")
    public JAXBElement<GetAllStudentsMap> createGetAllStudentsMap(GetAllStudentsMap value) {
        return new JAXBElement<GetAllStudentsMap>(_GetAllStudentsMap_QNAME, GetAllStudentsMap.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllStudentsMapResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getAllStudentsMapResponse")
    public JAXBElement<GetAllStudentsMapResponse> createGetAllStudentsMapResponse(GetAllStudentsMapResponse value) {
        return new JAXBElement<GetAllStudentsMapResponse>(_GetAllStudentsMapResponse_QNAME, GetAllStudentsMapResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getStudentById")
    public JAXBElement<GetStudentById> createGetStudentById(GetStudentById value) {
        return new JAXBElement<GetStudentById>(_GetStudentById_QNAME, GetStudentById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getStudentByIdResponse")
    public JAXBElement<GetStudentByIdResponse> createGetStudentByIdResponse(GetStudentByIdResponse value) {
        return new JAXBElement<GetStudentByIdResponse>(_GetStudentByIdResponse_QNAME, GetStudentByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentBySex }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getStudentBySex")
    public JAXBElement<GetStudentBySex> createGetStudentBySex(GetStudentBySex value) {
        return new JAXBElement<GetStudentBySex>(_GetStudentBySex_QNAME, GetStudentBySex.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetStudentBySexResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://dataType.ws.zooper.com/", name = "getStudentBySexResponse")
    public JAXBElement<GetStudentBySexResponse> createGetStudentBySexResponse(GetStudentBySexResponse value) {
        return new JAXBElement<GetStudentBySexResponse>(_GetStudentBySexResponse_QNAME, GetStudentBySexResponse.class, null, value);
    }

}
