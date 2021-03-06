
package com.udea.cliente.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProductoWS", targetNamespace = "http://servicio.udea.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ProductoWS {


    /**
     * 
     * @param codigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "BuscarProducto")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "BuscarProducto", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.BuscarProducto")
    @ResponseWrapper(localName = "BuscarProductoResponse", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.BuscarProductoResponse")
    @Action(input = "http://servicio.udea.com/ProductoWS/BuscarProductoRequest", output = "http://servicio.udea.com/ProductoWS/BuscarProductoResponse")
    public String buscarProducto(
        @WebParam(name = "codigo", targetNamespace = "")
        int codigo);

    /**
     * 
     * @return
     *     returns java.util.List<com.udea.cliente.ws.Producto>
     */
    @WebMethod(operationName = "ConsultarProducto")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ConsultarProducto", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.ConsultarProducto")
    @ResponseWrapper(localName = "ConsultarProductoResponse", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.ConsultarProductoResponse")
    @Action(input = "http://servicio.udea.com/ProductoWS/ConsultarProductoRequest", output = "http://servicio.udea.com/ProductoWS/ConsultarProductoResponse")
    public List<Producto> consultarProducto();

    /**
     * 
     * @param descripcion
     * @param precio
     * @param stock
     * @param nombre
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "IngresarProducto")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "IngresarProducto", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.IngresarProducto")
    @ResponseWrapper(localName = "IngresarProductoResponse", targetNamespace = "http://servicio.udea.com/", className = "com.udea.cliente.ws.IngresarProductoResponse")
    @Action(input = "http://servicio.udea.com/ProductoWS/IngresarProductoRequest", output = "http://servicio.udea.com/ProductoWS/IngresarProductoResponse")
    public String ingresarProducto(
        @WebParam(name = "nombre", targetNamespace = "")
        String nombre,
        @WebParam(name = "precio", targetNamespace = "")
        double precio,
        @WebParam(name = "stock", targetNamespace = "")
        int stock,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion);

}
