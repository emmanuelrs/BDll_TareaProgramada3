create or replace function  insertarCategoria(pcategoria varchar2)
return number
as
varIdCategoria number(10);

begin    
  varIdCategoria := 0;
 -- Categoria
  select id_Categoria into varIdCategoria
  from Categoria
  where Categoria = UPPER(pcategoria);
  return varIdCategoria;
  
  EXCEPTION
  WHEN no_data_found THEN
    varIdCategoria := S_CATEGORIA.nextval;
    insert into Categoria(id_categoria,categoria) 
    values(varIdCategoria,UPPER(pcategoria));
    return varIdCategoria;
    
end;