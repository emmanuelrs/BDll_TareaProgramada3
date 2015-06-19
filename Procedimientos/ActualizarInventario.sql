CREATE OR REPLACE PROCEDURE actualizarInventario(idProducto number,cantidad number)
IS
  valorActual NUMBER(10);
  varlor NUMBER(10);
BEGIN
  Select cantidad into valorActual from producto where id_producto = idProducto;
  valorActual := valorActual - cantidad;
  Update Producto set cantidad = valorActual where id_producto = idProducto;
  COMMIT;
END;