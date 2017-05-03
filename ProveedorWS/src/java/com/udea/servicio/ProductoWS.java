/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.servicio;

import com.udea.dao.ProductoDAO;
import com.udea.modelo.Producto;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author galonso.gomez
 */
@WebService(serviceName = "ProductoWS")
public class ProductoWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "IngresarProducto")
    public String IngresarProducto(@WebParam(name = "nombre") String nombre, @WebParam(name = "precio") double precio, @WebParam(name = "stock") int stock, @WebParam(name = "descripcion") String descripcion) {
        //TODO write your implementation code here:
        Producto p= new Producto(nombre,precio,stock,descripcion);
        ProductoDAO productoDAO = new ProductoDAO();
        productoDAO.ingresarProducto(p);
        return "Producto Ingresado";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "BuscarProducto")
    public String BuscarProducto(@WebParam(name = "codigo") int codigo) {
        //TODO write your implementation code here:
        ProductoDAO productoDAO = new ProductoDAO();
        return productoDAO.consultarProducto(codigo);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ConsultarProducto")
    public List<Producto> ConsultarProducto() {
        //TODO write your implementation code here:
        ProductoDAO productoDAO = new ProductoDAO();
        List<Producto> listaProductos=productoDAO.verProductos();
        
        return listaProductos;
    }

   
}
