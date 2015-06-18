CREATE OR REPLACE PROCEDURE insertarProductoXFactura(pIdFactura number,pProducto varchar2,pcantidadProducto number)
IS
  varIdProducto NUMBER(10);
BEGIN
  varIdProducto := retornarIdProducto(pProducto);
  
  INSERT INTO productoXfactura(id_factura,id_producto,CANTIDADPRODUCTOS)
  VALUES(pIdFactura,varIdProducto,pcantidadProducto);
        
  COMMIT;
END;