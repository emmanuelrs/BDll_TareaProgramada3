create or replace function retornarIdProducto(pProducto varchar2)
return number
as
  varIdProducto number(10);

begin    
  select id_producto into varIdProducto
  from producto
  where producto = UPPER(pProducto);
  return varIdProducto;
  
  EXCEPTION
  WHEN no_data_found THEN
    return -1;
    -- el -1 es que el producto no esta entonces se capta el error en la base de datos
end;