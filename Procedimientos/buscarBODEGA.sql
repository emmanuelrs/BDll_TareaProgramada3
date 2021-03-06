CREATE OR REPLACE FUNCTION buscarBODEGA(pNOMBRE_BODEGA VARCHAR2) RETURN NUMBER
IS
  VARID_BODEGA NUMBER(10);
BEGIN
  SELECT ID_BODEGA INTO VARID_BODEGA
  FROM BODEGA
  WHERE NOMBREBODEGA = pNOMBRE_BODEGA;
  RETURN VARID_BODEGA;
  
  EXCEPTION
  WHEN no_data_found THEN
    VARID_BODEGA := -1;
  RETURN VARID_BODEGA;

END;