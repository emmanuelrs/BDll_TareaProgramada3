create or replace 
PROCEDURE insertarPivot(id_product number,cant NUMBER)
IS
BEGIN
  INSERT INTO pivot(ID_pivot, ID_producto,cantidad)
  VALUES(s_pivot.nextval, id_product,cant);     
  COMMIT;
END;