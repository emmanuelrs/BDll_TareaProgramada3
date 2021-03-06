CREATE OR REPLACE FUNCTION insertarDIRECCION(pPAIS VARCHAR2,pPROVINCIA VARCHAR2,
                      pCANTON VARCHAR2,pDIRECCION_EXACTA VARCHAR2) RETURN NUMBER
AS
  VARID_DIRECCION NUMBER(10);
BEGIN
  VARID_DIRECCION := 0;
  SELECT ID_DIRECCION INTO VARID_DIRECCION
  FROM DIRECCION
  WHERE DIRECCION_EXACTA = upper(pDIRECCION_EXACTA);
  RETURN VARID_DIRECCION;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    VARID_DIRECCION := S_DIRECCION.NEXTVAL;
    INSERT INTO DIRECCION(ID_DIRECCION,PAIS,PROVINCIA,CANTON,DIRECCION_EXACTA)
    VALUES(VARID_DIRECCION,upper(pPAIS),upper(pPROVINCIA),upper(pCANTON),upper(pDIRECCION_EXACTA));
    COMMIT;
    RETURN VARID_DIRECCION;
END;