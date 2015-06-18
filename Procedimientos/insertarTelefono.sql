CREATE OR REPLACE FUNCTION insertarTELEFONO(pNUMERO VARCHAR2) RETURN NUMBER
AS
  VARID_TELEFONO NUMBER(10);
BEGIN
  VARID_TELEFONO := 0;
  SELECT ID_TELEFONO INTO VARID_TELEFONO
  FROM TELEFONO
  WHERE NUMTELEFONO = pNUMERO;
  RETURN VARID_TELEFONO;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  VARID_TELEFONO := S_TELEFONO.NEXTVAL;
  INSERT INTO TELEFONO(ID_TELEFONO,NUMTELEFONO)
  VALUES(VARID_TELEFONO,pNUMERO);
  COMMIT;
  RETURN VARID_TELEFONO;
END;