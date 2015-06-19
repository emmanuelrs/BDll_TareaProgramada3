CREATE OR REPLACE PROCEDURE insertarVenta(PuntoVenta varchar2, total number, idFactura number)
iS
  dia date;
  varIdVenta NUMBER(10);
  varIdPuntoDeVenta number(10);
  totalxdia number(10);  
BEGIN
  dia := TO_DATE(SYSDATE,'DD-MM-YYYY');
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(PuntoVenta);
  select id_venta into varIdVenta from venta where id_puntodeventa = varIdPuntoDeVenta and fechaventa = dia;
  INSERT INTO control_de_venta(id_venta, id_Factura)
  VALUES(varIdVenta, idFactura );
  select totalventaxdia into totalxdia from venta where id_venta = varIdVenta;
  totalxdia := totalxdia + total;
  Update venta set totalventaxdia = totalxdia where id_Venta = varIdVenta;
  commit;
  
  EXCEPTION
  WHEN no_data_found THEN
  varIdVenta := S_VENTA.nextval;
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(PuntoVenta);
  insert into venta(id_venta, id_puntodeventa, fechaventa, totalventaxdia)
  values (varIdVenta, varIdPuntoDeVenta, TO_DATE(SYSDATE,'DD-MM-YYYY'), 0);
  INSERT INTO control_de_venta(id_venta, id_Factura)
  VALUES(varIdVenta, idFactura );
  select totalventaxdia into totalxdia from venta where id_venta = varIdVenta;
  totalxdia := totalxdia + total;
  Update venta set totalventaxdia = totalxdia where id_Venta = varIdVenta;
  commit;

END;