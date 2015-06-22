-- TODOS LOS PROCEDIMIENTOS EN UN MISMO SQL
-- EJECUTAR UNO POR UNO PARA QUE NO DE ERROR

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

----
CREATE OR REPLACE PROCEDURE insertarBODEGA(pNOMBRE_BODEGA VARCHAR2,pPAIS VARCHAR2,
pPROVINCIA VARCHAR2,pCANTON VARCHAR2,pDIRECCION_EXACTA VARCHAR2, pNUMERO VARCHAR2)

IS
  VARID_DIRECCION NUMBER(10);
  VARID_TELEFONO NUMBER(10);
BEGIN
  VARID_DIRECCION := insertarDIRECCION(pPAIS,pPROVINCIA,pCANTON,pDIRECCION_EXACTA);
  VARID_TELEFONO := insertarTELEFONO(pNUMERO);
  INSERT INTO BODEGA(ID_BODEGA,ID_DIRECCION,ID_TELEFONO,NOMBREBODEGA)
  VALUES(S_BODEGA.NEXTVAL,VARID_DIRECCION,VARID_TELEFONO,upper(pNOMBRE_BODEGA));
  COMMIT;
END;

---------

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

---

CREATE OR REPLACE FUNCTION insertarDIRECCION(pPAIS VARCHAR2,pPROVINCIA VARCHAR2,
                      pCANTON VARCHAR2,pDIRECCION_EXACTA VARCHAR2) RETURN NUMBER
AS
  VARID_DIRECCION NUMBER(10);
BEGIN
  VARID_DIRECCION := 0;
  SELECT ID_DIRECCION INTO VARID_DIRECCION
  FROM DIRECCION
  WHERE DIRECCION_EXACTA = upper(pDIRECCION_EXACTA);
  RETURN VARID_DIRECCION;
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    VARID_DIRECCION := S_DIRECCION.NEXTVAL;
    INSERT INTO DIRECCION(ID_DIRECCION,PAIS,PROVINCIA,CANTON,DIRECCION_EXACTA)
    VALUES(VARID_DIRECCION,upper(pPAIS),upper(pPROVINCIA),upper(pCANTON),upper(pDIRECCION_EXACTA));
    COMMIT;
    RETURN VARID_DIRECCION;
END;


---
CREATE OR REPLACE FUNCTION insertarFactura(pPuntoDeVenta varchar2,descuento number, cedula number)return number
AS
  varIdFactura NUMBER(10);
  varIdPuntoDeVenta NUMBER(10);
BEGIN
  varIdFactura := S_FACTURA.nextval;
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(pPuntoDeVenta);
  
  INSERT INTO Factura(id_factura, persona, id_puntodeventa,fechacompra,descuento,total)
  VALUES(varIdFactura, cedula, varIdPuntoDeVenta,TO_DATE(SYSDATE,'yyyy/mm/dd hh24:mi:ss'),descuento,0);
  COMMIT;
  return varIdFactura;
END;

----
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

---

CREATE OR REPLACE PROCEDURE insertarPERSONA(pNOMBRE VARCHAR2,pCedula NUMBER,pAPELLIDO VARCHAR2,
pPAIS VARCHAR2,pPROVINCIA VARCHAR2,pCANTON VARCHAR2, pDIRECCION_EXACTA VARCHAR2,
pEMAIL VARCHAR2, pNUMERO VARCHAR2, pTIPO VARCHAR2)
IS
  VARID_DIRECCION NUMBER(10);
  VARID_TELEFONO NUMBER(10);
BEGIN
  VARID_DIRECCION := insertarDIRECCION(pPAIS,pPROVINCIA,pCANTON,pDIRECCION_EXACTA);
  VARID_TELEFONO := insertarTELEFONO(pNUMERO);
  
  INSERT INTO PERSONA(cedula, ID_DIRECCION,ID_TELEFONO,NOMBRE_PERSONA,APELLIDO_PERSONA, EMAIL_PERSONA,TIPO_PERSONA)
  VALUES(pCedula, VARID_DIRECCION,VARID_TELEFONO,upper(pNOMBRE),upper(pAPELLIDO),upper(pEMAIL),upper(pTIPO));   
  COMMIT;
END;

-----

create or replace 
PROCEDURE insertarPivot(id_product number,cant NUMBER)
IS
BEGIN
  INSERT INTO pivot(ID_pivot, ID_producto,cantidad)
  VALUES(s_pivot.nextval, id_product,cant);     
  COMMIT;
END;

-----

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

----

CREATE OR REPLACE PROCEDURE insertarProductoXFactura(pIdFactura number,ID_Producto number,pcantidadProducto number)
IS

BEGIN
  
  INSERT INTO productoXfactura(id_factura,id_producto,CANTIDADPRODUCTOS)
  VALUES(pIdFactura,ID_Producto,pcantidadProducto);
        
  COMMIT;
END;


----


create or replace procedure insertarPuntoDeVenta(pnombre varchar2,pPAIS VARCHAR2,pPROVINCIA VARCHAR2,pCANTON VARCHAR2, pDIRECCION_EXACTA VARCHAR2,ptelefono varchar2)
as
  varIdPuntoDeVenta number(10);
  VARID_DIRECCION NUMBER(10);
  VARID_TELEFONO NUMBER(10);

begin    
  VARID_DIRECCION := insertarDIRECCION(pPAIS,pPROVINCIA,pCANTON,pDIRECCION_EXACTA);
  VARID_TELEFONO := insertarTELEFONO(ptelefono);
  varIdPuntoDeVenta := S_PUNTO_DE_VENTA.nextval;
  insert into puntodeventa(id_puntodeventa,nombrepuntodeventa,id_direccion,id_telefono,cantidadventadia) 
  values(varIdPuntoDeVenta,UPPER(pnombre),VARID_DIRECCION,VARID_TELEFONO,0);
  Commit;

end;

----

CREATE OR REPLACE FUNCTION insertarTELEFONO(pNUMERO VARCHAR2) RETURN NUMBER
AS
  VARID_TELEFONO NUMBER(10);
BEGIN
  VARID_TELEFONO := 0;
  SELECT ID_TELEFONO INTO VARID_TELEFONO
  FROM TELEFONO
  WHERE NUMTELEFONO = pNUMERO;
  RETURN VARID_TELEFONO;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  VARID_TELEFONO := S_TELEFONO.NEXTVAL;
  INSERT INTO TELEFONO(ID_TELEFONO,NUMTELEFONO)
  VALUES(VARID_TELEFONO,pNUMERO);
  COMMIT;
  RETURN VARID_TELEFONO;
END;

-----

CREATE OR REPLACE PROCEDURE insertarVenta(PuntoVenta varchar2, total number, idFactura number)
iS
  dia date;
  varIdVenta NUMBER(10);
  varIdPuntoDeVenta number(10);
  totalxdia number(10);  
BEGIN
  dia := TO_DATE(SYSDATE,'DD-MM-YYYY');
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(PuntoVenta);
  select id_venta into varIdVenta from venta where id_puntodeventa = varIdPuntoDeVenta and fechaventa = dia;
  INSERT INTO control_de_venta(id_venta, id_Factura)
  VALUES(varIdVenta, idFactura );
  select totalventaxdia into totalxdia from venta where id_venta = varIdVenta;
  totalxdia := totalxdia + total;
  Update venta set totalventaxdia = totalxdia where id_Venta = varIdVenta;
  commit;
  
  EXCEPTION
  WHEN no_data_found THEN
  varIdVenta := S_VENTA.nextval;
  varIdPuntoDeVenta := retornaIdPuntoDeVenta(PuntoVenta);
  insert into venta(id_venta, id_puntodeventa, fechaventa, totalventaxdia)
  values (varIdVenta, varIdPuntoDeVenta, TO_DATE(SYSDATE,'DD-MM-YYYY'), 0);
  INSERT INTO control_de_venta(id_venta, id_Factura)
  VALUES(varIdVenta, idFactura );
  select totalventaxdia into totalxdia from venta where id_venta = varIdVenta;
  totalxdia := totalxdia + total;
  Update venta set totalventaxdia = totalxdia where id_Venta = varIdVenta;
  commit;

END;

--------


create or replace 
PROCEDURE insertarUsuario(cedula number, contra varchar2, tipo varchar2, usrName varchar2)
IS
VARID_CEDULA_VERIFICADA NUMBER(10);

BEGIN
  VARID_CEDULA_VERIFICADA := retornaIDPERSONAXCEDULA(cedula);
  IF VARID_CEDULA_VERIFICADA = cedula THEN
    INSERT INTO usuario(cedula, contraseña, tipo, username)
    VALUES(cedula, contra, upper(tipo), usrName);     
    COMMIT;
  END IF;
END;


-----

CREATE OR REPLACE FUNCTION retornaIDPERSONA(pNOMBRE VARCHAR2,pAPELLIDO VARCHAR2)
RETURN NUMBER
AS
  VARID_PERSONA NUMBER(10);
BEGIN
  VARID_PERSONA := 0;
  SELECT cedula INTO VARID_PERSONA
  FROM PERSONA
  WHERE NOMBRE_PERSONA = upper(pNOMBRE) AND APELLIDO_PERSONA = upper(pAPELLIDO);
  RETURN VARID_PERSONA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  VARID_PERSONA := 0;
  RETURN VARID_PERSONA;
-- si retorna 0 es porque la persona no esta ingresada ese error lo captan ya en java 
END;


----

CREATE OR REPLACE FUNCTION ULTIMO_ID_FACTURA RETURN NUMBER AS
VAR_ID_FACTURA NUMBER(10);
BEGIN
VAR_ID_FACTURA := -1;
SELECT MAX(ID_FACTURA) INTO VAR_ID_FACTURA FROM FACTURA;

RETURN VAR_ID_FACTURA;
END;

---

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

-----
CREATE OR REPLACE FUNCTION retornaIdPuntoDeVenta(pPuntoDeVenta VARCHAR2)
RETURN NUMBER
AS
  varIdPuntoDeVenta number(10);
BEGIN
  varIdPuntoDeVenta := 0;
  SELECT ID_Puntodeventa INTO varIdPuntoDeVenta
  FROM Puntodeventa
  WHERE NOMBREpuntodeventa = upper(pPuntodeventa);
  RETURN varIdPuntoDeVenta;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  varIdPuntoDeVenta := -1;
  RETURN varIdPuntoDeVenta;
-- si retorna -1 es porque el punto de venta no esta ingresada ese error lo captan ya en java 
END;

---
create or replace 
PROCEDURE actualizarFactura(idFactura number,Total number)
IS
  valorActual NUMBER(10);
  descuento number(10,5);
BEGIN
  select DESCUENTO into descuento from factura where id_factura = idFactura;
  valorActual := (Total - Total * (descuento / 100));
  Update Factura set Total = valoractual where id_factura = idFactura;
  COMMIT;
END;

---

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

----

CREATE OR REPLACE FUNCTION buscarBODEGA(pNOMBRE_BODEGA VARCHAR2) RETURN NUMBER
IS
  VARID_BODEGA NUMBER(10);
BEGIN
  SELECT ID_BODEGA INTO VARID_BODEGA
  FROM BODEGA
  WHERE NOMBREBODEGA = pNOMBRE_BODEGA;
  RETURN VARID_BODEGA;
  
  EXCEPTION
  WHEN no_data_found THEN
    VARID_BODEGA := -1;
  RETURN VARID_BODEGA;

END;

create or replace FUNCTION retornaIDPERSONAXCEDULA(pCEDULA NUMBER)
RETURN NUMBER
AS
  VARID_PERSONA NUMBER(10);
BEGIN
  VARID_PERSONA := 0;
  SELECT cedula INTO VARID_PERSONA
  FROM PERSONA
  WHERE CEDULA = pCEDULA;
  RETURN VARID_PERSONA;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
  VARID_PERSONA := 0;
  RETURN VARID_PERSONA;
-- si retorna 0 es porque la persona no esta ingresada ese error lo captan ya en java 
END;

create or replace FUNCTION LOGIN(pUSER VARCHAR2, pPASS VARCHAR2) RETURN NUMBER
AS
VAR_CED_USER NUMBER(10);
VAR_CED_PASS NUMBER(10);
VAR_RESULTADO NUMBER(10);
BEGIN
  VAR_RESULTADO := 0;
  VAR_CED_USER := -1;
  VAR_CED_PASS := -2;
  
  SELECT CEDULA INTO VAR_CED_USER
  FROM USUARIO
  WHERE USERNAME = pUSER;
  
  SELECT CEDULA INTO VAR_CED_PASS
  FROM USUARIO
  WHERE CONTRASEÑA = pPASS;
  
  IF (VAR_CED_USER = VAR_CED_PASS) THEN
      VAR_RESULTADO := 1;
  END IF;
  RETURN VAR_RESULTADO;
  
  EXCEPTION
  WHEN no_data_found THEN
    VAR_RESULTADO := 0;
    RETURN VAR_RESULTADO;
END;
CREATE OR REPLACE FUNCTION CANTIDAD_MINIMO(pID_PRODUCTO NUMBER) RETURN NUMBER
AS 
VAR_CANTIDAD NUMBER(10);
VAR_MINIMO NUMBER(10);
BEGIN
  VAR_CANTIDAD := 0;
  VAR_MINIMO :=0;
  
  SELECT CANTIDAD INTO VAR_CANTIDAD
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  SELECT MINIMO INTO VAR_MINIMO
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  IF VAR_CANTIDAD <= VAR_MINIMO THEN
     RETURN 1;
  ELSE RETURN 0;
  END IF;
END;

CREATE OR REPLACE procedure TotalXdia(tota NUMBER)IS 
dia date;
tot number(10);
BEGIN
  dia := TO_DATE(SYSDATE,'DD-MM-YYYY');
  
  SELECT total INTO tot
  FROM total_puntoventa
  WHERE fecha = dia;
  
  update total_puntoventa set total = tot + tota where fecha = dia;
  commit;  
  
  EXCEPTION
  WHEN no_data_found THEN
  insert into total_puntoventa(fecha, total)
  values(TO_DATE(SYSDATE,'DD-MM-YYYY'), tota);
  commit;
END;
     
create or replace PROCEDURE RESTOCK_MANUAL(pID_PRODUCTO NUMBER,pCANTIDAD NUMBER,pTRANSACCION VARCHAR2)
IS

VAR_CED_PERSONA NUMBER(10);
VAR_CANT_PRODUCTO NUMBER(10);
VAR_CANTIDAD NUMBER(10);
VAR_CANTIDAD_ACTUAL NUMBER(10);

BEGIN
  VAR_CED_PERSONA := -1;
  VAR_CANT_PRODUCTO := -1;
  VAR_CANTIDAD := -1;
  VAR_CANTIDAD_ACTUAL := -1;

  SELECT PERSONA INTO VAR_CED_PERSONA
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  SELECT PRECIOUNITARIO INTO VAR_CANT_PRODUCTO
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  VAR_CANTIDAD := (VAR_CANT_PRODUCTO * pCANTIDAD);
   
  INSERT INTO HISTORIAL_DE_COMPRAS(ID_HISTORIAL_DE_COMPRAS,ID_PERSONA,ID_PRODUCTO,CANTIDADPRODUCTOS,MONTO,TIPO_TRANSACCION)
  VALUES(S_HISTORIAL_DE_COMPRAS.NEXTVAL,VAR_CED_PERSONA,pID_PRODUCTO,pCANTIDAD,VAR_CANTIDAD,pTRANSACCION);
  
  SELECT CANTIDAD INTO VAR_CANTIDAD_ACTUAL
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  UPDATE PRODUCTO
  SET CANTIDAD = VAR_CANTIDAD_ACTUAL + pCANTIDAD
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
END;

create or replace PROCEDURE RESTOCK(pID_PRODUCTO NUMBER,pCANTIDAD NUMBER)
IS

VAR_CED_PERSONA NUMBER(10);
VAR_CANT_PRODUCTO NUMBER(10);
VAR_CANTIDAD NUMBER(10);
VAR_CANTIDAD_ACTUAL NUMBER(10);

BEGIN
  VAR_CED_PERSONA := -1;
  VAR_CANT_PRODUCTO := -1;
  VAR_CANTIDAD := -1;
  VAR_CANTIDAD_ACTUAL := -1;

  SELECT PERSONA INTO VAR_CED_PERSONA
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  SELECT PRECIOUNITARIO INTO VAR_CANT_PRODUCTO
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  VAR_CANTIDAD := (VAR_CANT_PRODUCTO * pCANTIDAD);
   
  INSERT INTO HISTORIAL_DE_COMPRAS(ID_HISTORIAL_DE_COMPRAS,ID_PERSONA,ID_PRODUCTO,CANTIDADPRODUCTOS,MONTO,TIPO_TRANSACCION)
  VALUES(S_HISTORIAL_DE_COMPRAS.NEXTVAL,VAR_CED_PERSONA,pID_PRODUCTO,pCANTIDAD,VAR_CANTIDAD,'DEBITO');
  
  SELECT CANTIDAD INTO VAR_CANTIDAD_ACTUAL
  FROM PRODUCTO
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  
  UPDATE PRODUCTO
  SET CANTIDAD = VAR_CANTIDAD_ACTUAL + 500
  WHERE ID_PRODUCTO = pID_PRODUCTO;
  

END;
