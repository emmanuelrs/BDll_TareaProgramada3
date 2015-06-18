create or replace function insertarPuntoDeVenta(pnombre varchar2,pPAIS VARCHAR2,pPROVINCIA VARCHAR2,pCANTON VARCHAR2, pDIRECCION_EXACTA VARCHAR2,ptelefono varchar2)
return number
as
  varIdPuntoDeVenta number(10);
  VARID_DIRECCION NUMBER(10);
  VARID_TELEFONO NUMBER(10);

begin    
  select id_puntodeventa into varIdPuntoDeVenta
  from puntodeventa
  where nombrepuntodeventa = UPPER(pnombre);
  return -1;
  
  EXCEPTION
  WHEN no_data_found THEN
    VARID_DIRECCION := insertarDIRECCION(pPAIS,pPROVINCIA,pCANTON,pDIRECCION_EXACTA);
    VARID_TELEFONO := insertarTELEFONO(ptelefono);
    varIdPuntoDeVenta := S_PUNTO_DE_VENTA.nextval;
    insert into puntodeventa(id_puntodeventa,nombrepuntodeventa,id_direccion,id_telefono,cantidadventadia) 
    values(varIdPuntoDeVenta,UPPER(pnombre),VARID_DIRECCION,VARID_TELEFONO,0);
    return varIdPuntoDeVenta;
end;