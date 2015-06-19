SET serveroutput on;
DECLARE
BEGIN
   insertarVenta('LA PULPE', 1800, 32);
   
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