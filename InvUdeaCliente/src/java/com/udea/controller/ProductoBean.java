/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.cliente.ws.Producto;
import com.udea.cliente.ws.ProductoWS_Service;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author galonso.gomez
 */
public class ProductoBean {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/ProveedorWS/ProductoWS.wsdl")
    private ProductoWS_Service service;
    private int codigo;
    private String nombre;
    private double precio;
    private int stock;
    private String descripcion;
    /**
     * Creates a new instance of ProductoBean
     */
    public ProductoBean() {
        
    }
    //Metodo para las acciones del boton
    public String guardarProd()
    {
        String msj= ingresarProducto(nombre, precio, stock, descripcion);
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpiarForm();
        return "result"; //llamo la vista result.xhtml
    }
    
    public String buscarProd()
    {
        String msj=buscarProducto(codigo);
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,msj,"...");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        limpiarForm();
        return "index"; //llamo la vista index.xhtml
    }
    
    public List<Producto> getListaProd()
    {
        List<Producto> lista=consultarProducto();
        return lista;
    }
    
    public void limpiarForm()
    {
        this.codigo=0;
        this.nombre="";
        this.precio=0.0;
        this.stock=0;
        this.descripcion="";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    private String buscarProducto(int codigo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.cliente.ws.ProductoWS port = service.getProductoWSPort();
        return port.buscarProducto(codigo);
    }

    private java.util.List<com.udea.cliente.ws.Producto> consultarProducto() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.cliente.ws.ProductoWS port = service.getProductoWSPort();
        return port.consultarProducto();
    }

    private String ingresarProducto(java.lang.String nombre, double precio, int stock, java.lang.String descripcion) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.udea.cliente.ws.ProductoWS port = service.getProductoWSPort();
        return port.ingresarProducto(nombre, precio, stock, descripcion);
    }
    
}
