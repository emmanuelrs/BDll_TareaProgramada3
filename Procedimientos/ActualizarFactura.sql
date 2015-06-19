create or replace 
PROCEDURE actualizarFactura(idFactura number,Total number)
IS
  valorActual NUMBER(10);
  descuento number(10,5);
BEGIN
  select DESCUENTO into descuento from factura where id_factura = idFactura;
  valorActual := (Total - Total * (descuento / 100));
  Update Factura set Total = valoractual where id_factura = idFactura;
  COMMIT;
END;