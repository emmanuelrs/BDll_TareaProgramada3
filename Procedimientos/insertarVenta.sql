CREATE OR REPLACE PROCEDURE insertarVenta(pProducto varchar2,pPuntoDeVenta varchar2)
iS
  varIdVenta NUMBER(10);
  varIdProducto Number(10);
  varIdPuntoDeVenta number(10);
  
BEGIN
  varIdProducto := retornarIdProducto(pProducto);
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(pPuntoDeVenta);
  varIdVenta := S_VENTA.nextval;
  
  insert into venta(id_venta,id_producto,id_puntoDeVenta,fechaVenta,totalventaXdia)
  values (varIdVenta,varIdProducto,varIdPuntoDeVenta,sysdate,0);
  
END;