create or replace function insertarMarca(pmarca varchar2)
return number
as
varIdMarca number(10);

begin    
  -- Marca
  varIdMarca := 0;
  select id_Marca into varIdMarca
  from Marca
  where Marca = UPPER(pmarca);
  return varIdMarca;

  
  EXCEPTION
  WHEN no_data_found THEN
    varIdMarca := S_MARCA.nextval;
    insert into Marca(id_marca,marca) 
    values(varIdMarca,UPPER(pmarca));
    commit;
    return varIdMarca;
  
end;

