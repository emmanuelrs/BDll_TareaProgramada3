create or replace procedure insertarProducto(pproducto varchar2,pdescripcion varchar2,pprecio number,pmarca varchar2,pcategoria varchar2,pcantidad number,pminimo number, pNOMBRE_BODEGA VARCHAR2, cedula number)
is
varIdMarca number(10);
varIdCategoria number(10);
varIdProducto number(10);
varIDBodega number(10);
begin
  varIdMarca := insertarmarca(pmarca);
  varIdCategoria := insertarCategoria(pcategoria);
  varIdBodega := buscarBodega(pNOMBRE_BODEGA);
  IF varIdBodega = -1 THEN
  DBMS_OUTPUT.put_line('no existe la bodega');
  end if;
  -- insert producto con lo que recuperamos de marca y categoria
  varIdProducto := S_PRODUCTO.nextval;
  INSERT INTO producto (id_producto,producto,descripcion,preciounitario,idmarca,idcategoria,cantidad,minimo,persona)
  VALUES (varIdProducto,upper(pproducto),upper(pdescripcion),pprecio,varIdMarca,varIdCategoria,pcantidad,pminimo,cedula);
  INSERT INTO INVENTARIO(ID_PRODUCTO,ID_BODEGA)
  VALUES(varIdProducto,varIdBodega);
  commit;
end;
