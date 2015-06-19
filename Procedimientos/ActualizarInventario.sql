CREATE OR REPLACE PROCEDURE actualizarInventario(idProduct number,cantidad number)
IS
  valorActual NUMBER(10);
  varlor NUMBER(10);
BEGIN
  Select cantidad into valorActual from producto where id_producto = idProducto;
  valor := valorActual - cantidad;
  Update Producto set cantidad = valor where id_producto = idProducto;
  COMMIT;
END;