create or replace 
PROCEDURE insertarUsuario(cedula number, contra varchar2, tipo varchar2, usrName varchar2)
IS
BEGIN
  INSERT INTO usuario(cedula, contraseña, tipo, username)
  VALUES(cedula, contra, upper(tipo), usrName);     
  COMMIT;
END;