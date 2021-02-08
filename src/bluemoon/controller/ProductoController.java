/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bluemoon.controller;

import bluemoon.dao.ProductoDAO;
import bluemoon.model.Producto;


public class ProductoController {
    ProductoDAO prodDao;
    
    public void InsertarProducto(Producto prod){
        
        prodDao.insert(prod);
    }
}
