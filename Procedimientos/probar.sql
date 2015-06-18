SET serveroutput on;
DECLARE
BEGIN
   insertarproducto('garbanzos','las mejores',900,'diana','granitos',12,6);
   
END;

select * from categoria


SET serveroutput on;
declare
   result number;
begin
   -- Call the function
   result := buscarBODEGA('LUIS SE LA COME TODA');
   DBMS_OUTPUT.put_line(result);
end;