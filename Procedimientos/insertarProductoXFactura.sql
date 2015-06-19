CREATE OR REPLACE PROCEDURE insertarProductoXFactura(pIdFactura number,ID_Producto number,pcantidadProducto number)
IS

BEGIN
  
  INSERT INTO productoXfactura(id_factura,id_producto,CANTIDADPRODUCTOS)
  VALUES(pIdFactura,ID_Producto,pcantidadProducto);
        
  COMMIT;
END;