CREATE OR REPLACE PROCEDURE insertarControlDeVenta(pIdVenta number,pIdFactura number)
IS

BEGIN

  INSERT INTO control_de_venta(id_venta,id_factura)
  VALUES(pIdVenta,pIdFactura );
  COMMIT;
  
END;