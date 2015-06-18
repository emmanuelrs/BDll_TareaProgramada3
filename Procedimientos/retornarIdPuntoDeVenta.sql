CREATE OR REPLACE FUNCTION retornaIdPuntoDeVenta(pPuntoDeVenta VARCHAR2)
RETURN NUMBER
AS
  varIdPuntoDeVenta number(10);
BEGIN
  varIdPuntoDeVenta := 0;
  SELECT ID_Puntodeventa INTO varIdPuntoDeVenta
  FROM Puntodeventa
  WHERE NOMBREpuntodeventa = upper(pPuntodeventa);
  RETURN varIdPuntoDeVenta;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  varIdPuntoDeVenta := -1;
  RETURN varIdPuntoDeVenta;
-- si retorna -1 es porque el punto de venta no esta ingresada ese error lo captan ya en java 
END;