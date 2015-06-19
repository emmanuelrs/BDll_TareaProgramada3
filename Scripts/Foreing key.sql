ALTER TABLE PRODUCTO
ADD CONSTRAINT PRODUCTO_FK1 FOREIGN KEY(IDMARCA)
REFERENCES MARCA(ID_MARCA)
ENABLE;

ALTER TABLE PRODUCTO
ADD CONSTRAINT PRODUCTO_FK2 FOREIGN KEY
(
  IDCATEGORIA 
)
REFERENCES CATEGORIA
(
  ID_CATEGORIA 
)
ENABLE;


ALTER TABLE INVENTARIO
ADD CONSTRAINT INVENTARIO_FK1 FOREIGN KEY
(
  ID_PRODUCTO 
)
REFERENCES PRODUCTO
(
  ID_PRODUCTO 
)
ENABLE;

ALTER TABLE INVENTARIO
ADD CONSTRAINT INVENTARIO_FK3 FOREIGN KEY
(
  ID_BODEGA 
)
REFERENCES BODEGA
(
  ID_BODEGA 
)
ENABLE;
ALTER TABLE BODEGA
ADD CONSTRAINT BODEGA_FK1 FOREIGN KEY
(
  ID_TELEFONO 
)
REFERENCES TELEFONO
(
  ID_TELEFONO 
)
ENABLE;

ALTER TABLE BODEGA
ADD CONSTRAINT BODEGA_FK2 FOREIGN KEY
(
  ID_DIRECCION 
)
REFERENCES DIRECCION
(
  ID_DIRECCION 
)
ENABLE;

ALTER TABLE PUNTODEVENTA
ADD CONSTRAINT PUNTODEVENTA_FK1 FOREIGN KEY
(
  ID_DIRECCION 
)
REFERENCES DIRECCION
(
  ID_DIRECCION 
)
ENABLE;

ALTER TABLE PUNTODEVENTA
ADD CONSTRAINT PUNTODEVENTA_FK2 FOREIGN KEY
(
  ID_TELEFONO 
)
REFERENCES TELEFONO
(
  ID_TELEFONO 
)
ENABLE;

ALTER TABLE VENTA
ADD CONSTRAINT VENTA_FK1 FOREIGN KEY
(
  ID_PRODUCTO 
)
REFERENCES PRODUCTO
(
  ID_PRODUCTO 
)
ENABLE;

ALTER TABLE VENTA
ADD CONSTRAINT VENTA_FK2 FOREIGN KEY
(
  ID_PUNTODEVENTA 
)
REFERENCES PUNTODEVENTA
(
  ID_PUNTODEVENTA 
)
ENABLE;
ALTER TABLE FACTURA
ADD CONSTRAINT FACTURA_FK1 FOREIGN KEY
(
  ID_PUNTODEVENTA 
)
REFERENCES PUNTODEVENTA
(
  ID_PUNTODEVENTA 
)
ENABLE;
ALTER TABLE PRODUCTOXFACTURA
ADD CONSTRAINT PRODUCTOXFACTURA_FK1 FOREIGN KEY
(
  ID_FACTURA 
)
REFERENCES FACTURA
(
  ID_FACTURA 
)
ENABLE;

ALTER TABLE PRODUCTOXFACTURA
ADD CONSTRAINT PRODUCTOXFACTURA_FK2 FOREIGN KEY
(
  ID_PRODUCTO 
)
REFERENCES PRODUCTO
(
  ID_PRODUCTO 
)
ENABLE;
ALTER TABLE CONTROL_DE_VENTA
ADD CONSTRAINT CONTROL_DE_VENTA_FK1 FOREIGN KEY
(
  ID_VENTA 
)
REFERENCES VENTA
(
  ID_VENTA 
)
ENABLE;

ALTER TABLE CONTROL_DE_VENTA
ADD CONSTRAINT CONTROL_DE_VENTA_FK2 FOREIGN KEY
(
  ID_FACTURA 
)
REFERENCES FACTURA
(
  ID_FACTURA 
)
ENABLE;
ALTER TABLE HISTORIAL_DE_COMPRAS
ADD CONSTRAINT HISTORIAL_DE_COMPRAS_FK1 FOREIGN KEY
(
  ID_PERSONA 
)
REFERENCES PERSONA
(
  ID_PERSONA 
)
ENABLE;

ALTER TABLE HISTORIAL_DE_COMPRAS
ADD CONSTRAINT HISTORIAL_DE_COMPRAS_FK2 FOREIGN KEY
(
  ID_PRODUCTO 
)
REFERENCES PRODUCTO
(
  ID_PRODUCTO 
)
ENABLE;
ALTER TABLE PERSONA
ADD CONSTRAINT PERSONA_FK1 FOREIGN KEY
(
  ID_DIRECCION 
)
REFERENCES DIRECCION
(
  ID_DIRECCION 
)
ENABLE;

ALTER TABLE PERSONA
ADD CONSTRAINT PERSONA_FK2 FOREIGN KEY
(
  ID_TELEFONO 
)
REFERENCES TELEFONO
(
  ID_TELEFONO 
)
ENABLE;