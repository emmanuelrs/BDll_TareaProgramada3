create or replace 
function retornarPrecio(IdProducto number)
return number
as
  precio number(10);

begin    
  select preciounitario into precio
  from producto
  where Id_producto = IdProducto;
  return precio;
  
  EXCEPTION
  WHEN no_data_found THEN
    return -1;
    -- el -1 es que el producto no esta entonces se capta el error en la base de datos
end;