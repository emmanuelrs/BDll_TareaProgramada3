CREATE OR REPLACE FUNCTION insertarFactura(pPuntoDeVenta varchar2,descuento number)return number
AS
  varIdFactura NUMBER(10);
  varIdPuntoDeVenta NUMBER(10);
BEGIN
  varIdFactura := S_FACTURA.nextval;
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(pPuntoDeVenta);
  
  INSERT INTO Factura(id_factura,id_puntodeventa,fechacompra,descuento,total)
  VALUES(varIdFactura,varIdPuntoDeVenta,sysdate,descuento,0);
  COMMIT;
  return varIdFactura;
END;