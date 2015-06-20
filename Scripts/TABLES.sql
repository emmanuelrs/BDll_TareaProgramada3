CREATE TABLE TELEFONO(
          ID_TELEFONO NUMBER(10)
                CONSTRAINT TL_ID_TELEFONO_NN NOT NULL,
          NUMTELEFONO NUMBER(10)
                CONSTRAINT TL_NUMTEL_NN NOT NULL,
          CONSTRAINT PK_TELEFONO
          PRIMARY KEY(ID_TELEFONO)
          USING INDEX 
          TABLESPACE GE_IDX PCTFREE 20
          STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0)
)
TABLESPACE GE_TBL
STORAGE(INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

COMMENT ON TABLE TELEFONO IS 'TABLA ENCARGADA PARA ALMACENAR LOS NÚMEROS DE TELÉFONO';

---
CREATE TABLE PERSONA(
       cedula NUMBER(15)
            CONSTRAINT PRS_cedula_NN NOT NULL,
       ID_DIRECCION NUMBER(10)
            CONSTRAINT PRS_ID_DIRECCION_NN NOT NULL,
       ID_TELEFONO NUMBER(10)
            CONSTRAINT PRS_ID_TELEFONO_NN NOT NULL,
       NOMBRE_PERSONA VARCHAR(100)
            CONSTRAINT PRS_NOMBRE_PERSONA_NN NOT NULL,
       APELLIDO_PERSONA VARCHAR(100)
            CONSTRAINT PRS_APELLIDO_PERSONA_NN NOT NULL,
       EMAIL_PERSONA VARCHAR(100)
            CONSTRAINT EMAIL_PERSONA_NN NOT NULL,
       TIPO_PERSONA VARCHAR(100)
            CONSTRAINT TIPO_PERSONA_NN NOT NULL,
       CONSTRAINT PK_PERSONA
                  PRIMARY KEY(cedula)
                  USING INDEX 
                  TABLESPACE GE_IDX PCTFREE 20
                  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0)
)
TABLESPACE GE_TBL
STORAGE(INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

COMMENT ON TABLE PERSONA IS 'TABLA ENCARGADA PARA ALMACENAR LOS DATOS DE LAS PERSONAS';

CREATE TABLE DIRECCION(
       ID_DIRECCION NUMBER(10)
          CONSTRAINT DIR_ID_DIRECCION_NN NOT NULL,
       PAIS VARCHAR(100)
          CONSTRAINT DIR_PAIS_NN NOT NULL,
       PROVINCIA VARCHAR(100)
          CONSTRAINT DIR_PROVINCIA_NN NOT NULL,
       CANTON VARCHAR(100)
          CONSTRAINT DIR_CANTON_NN NOT NULL,
       DIRECCION_EXACTA VARCHAR(100)
          CONSTRAINT DIR_DIRECCION_EXACTA_NN NOT NULL,
      CONSTRAINT PK_DIRECCION
                  PRIMARY KEY(ID_DIRECCION)
                  USING INDEX 
                  TABLESPACE GE_IDX PCTFREE 20
                  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0)
)
TABLESPACE GE_TBL
STORAGE(INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

CREATE TABLE HISTORIAL_DE_COMPRAS(
      ID_HISTORIAL_DE_COMPRAS NUMBER(10)
                CONSTRAINT HDC_ID_HISTORIAL_NN NOT NULL,
      ID_PERSONA NUMBER(10)
                CONSTRAINT HDC_ID_PERSONA_NN NOT NULL,
      ID_PRODUCTO NUMBER(10)
                CONSTRAINT HDC_ID_PRODUCTO_NN NOT NULL,
      CantidadProductos number(10)
                CONSTRAINT HDC_CantidadProductos_NN NOT NULL,
      MONTO NUMBER(10)
                CONSTRAINT HDC_MONTO_NN NOT NULL,
      TIPO_TRANSACCION VARCHAR(100)
                CONSTRAINT HDC_TIPO_TRANSACCION_NN NOT NULL,

      CONSTRAINT PK_HISTORIAL_DE_COMPRAS
                  PRIMARY KEY(ID_HISTORIAL_DE_COMPRAS)
                  USING INDEX 
                  TABLESPACE GE_IDX PCTFREE 20
                  STORAGE (INITIAL 10K NEXT 10K PCTINCREASE 0)
)
TABLESPACE GE_TBL
STORAGE(INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);
COMMENT ON TABLE HISTORIAL_DE_COMPRAS IS 'TABLA ENCARGADA DE ALMACENAR LAS COMPRAS QUE SE REALICEN';

CREATE TABLE CONTROL_DE_VENTA(
              ID_VENTA NUMBER(10)
                  CONSTRAINT CDV_ID_VENTA_NN NOT NULL,
              ID_FACTURA NUMBER(10)
                  CONSTRAINT CDV_ID_FACTURA_NN NOT NULL
)
TABLESPACE GE_TBL
STORAGE(INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

COMMENT ON TABLE CONTROL_DE_VENTA IS 'TABLA ENCARGADA DE ALMACENAR LAS VENTAS QUE SE REALICEN';

CREATE TABLE Factura(
       Id_Factura NUMBER(10)
              CONSTRAINT FAC_Id_Factura_NN NOT NULL,
       persona number(10),
       Id_PuntoDeVenta NUMBER(10)
              CONSTRAINT FAC_Id_PuntoDeVenta_NN NOT NULL,
       FechaCompra Date,
       Descuento number(10),
       Total number(10),
            
       CONSTRAINT PK_FACTURA
       primary key (Id_Factura)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Factura is 'Tabla para la facturacion de los productos vendidos';

--////////////////////////////////////////////////////////////////////////////

CREATE TABLE ProductoXFactura(
       Id_Factura NUMBER(10)
              CONSTRAINT PXF_Id_Factura_NN NOT NULL,
       Id_Producto NUMBER(10)
              CONSTRAINT PXF_Id_Producto_NN NOT NULL,
       CantidadProductos NUMBER(10),
       CONSTRAINT PK_PRODUCTOXFACTURA
       primary key (Id_Factura)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table ProductoXFactura is 'tabla encargada de almacenar los productos que tendra cada factura';

--//////////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Venta(
       Id_Venta NUMBER(10)
              CONSTRAINT VEN_Id_Venta_NN NOT NULL,
       Id_PuntoDeVenta number(10),
       FechaVenta Date, 
       TotalVentaXDia number(10),
        
       CONSTRAINT PK_VENTA
       primary key (Id_Venta)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

Comment on table Venta is 'tabla encargada del registro de ventas';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE PuntoDeVenta(
       Id_PuntoDeVenta NUMBER(10)
              CONSTRAINT PDV_Id_PuntoDeVenta_NN NOT NULL,
       NombrePuntoDeVenta Varchar2(100),
       Id_Direccion NUMBER(10)
              CONSTRAINT PDV_Id_Direccion_NN NOT NULL,
       Id_Telefono NUMBER(10)
              CONSTRAINT PDV_Id_Telefono_NN NOT NULL,
       CantidadVentaDia Number(10),
        
       CONSTRAINT PK_PuntoDeVenta
       primary key (Id_PuntoDeVenta)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

Comment on table PuntoDeVenta is 'tabla encargada del registro de los puntos de venta';

--///////////////////////////////////////////////////////////////////////////////////////////////
CREATE TABLE Total_PuntoVenta(
       Fecha date,
       Total number(10),
              
       CONSTRAINT PK_Total_PuntoVenta
       primary key (Fecha)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);

Comment on table Total_PuntoVenta is 'tabla encargada del control del total de ventas';

CREATE TABLE Marca(
       Id_Marca NUMBER(10)
              CONSTRAINT Mar_Id_Marca_NN NOT NULL,
       Marca Varchar2(100)
              CONSTRAINT Mar_Marca_NN NOT NULL,
       CONSTRAINT PK_Mar_id_Marca
       primary key (Id_Marca)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Marca is 'tabla encargada de guardar todas las marcas de los productos';


CREATE TABLE Categoria(
       Id_Categoria NUMBER(10)
              CONSTRAINT Cat_Id_Categoria_NN NOT NULL,
       Categoria Varchar2(100)
              CONSTRAINT Cat_Categoria_NN NOT NULL,
       
       CONSTRAINT PK_Categoria
       primary key (Id_Categoria)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Categoria is 'tabla encargada de guardar todas las categorias de los productos';


CREATE TABLE Producto(
       Id_Producto NUMBER(10)
              CONSTRAINT Pro_Id_producto_NN NOT NULL,
       Producto Varchar2(100)
              CONSTRAINT Pro_Producto_NN NOT NULL,
       Descripcion Varchar2(100)
              CONSTRAINT INV_Descripcion_NN NOT NULL,
       PrecioUnitario number(10)
              CONSTRAINT INV_PrecioUnitario_NN NOT NULL,
       IdMarca number(10),
       IDCategoria number(10),
       Cantidad NUMBER(10),
       Minimo NUMBER(10),  
       persona number(10),           

       CONSTRAINT PK_Pro_ID_Producto
       primary key (Id_Producto)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Producto is 'tabla encargada de guardar todas los productos';


CREATE TABLE Inventario(
       Id_Producto NUMBER(10)
              CONSTRAINT INV_Id_producto_NN NOT NULL,
       Id_Bodega NUMBER(10)
              CONSTRAINT INV_Id_Bodega_NN NOT NULL,
       Consumo_Mensual NUMBER(8),             

       CONSTRAINT PK_INVENTARIO
       primary key (Id_Producto)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Inventario is 'tabla encargada de guardar todo el inventario de los productos';

CREATE TABLE Bodega(
       Id_Bodega NUMBER(10)
              CONSTRAINT Bod_Id_Bodega_NN NOT NULL,
       Id_Direccion NUMBER(10)
              CONSTRAINT Bod_Id_Direccion_NN NOT NULL,
       Id_Telefono NUMBER(10)
              CONSTRAINT INV_Id_Telefono_NN NOT NULL,
       NombreBodega VARCHAR2(100),
                   
       CONSTRAINT PK_Bodega
       primary key (Id_Bodega)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

Comment on table Bodega is 'tabla encargada de guardar todo los productos en la bodega';

CREATE TABLE pivot(
       Id_pivot NUMBER(10)
              CONSTRAINT Bod_Id_pivot_NN NOT NULL,
       Id_Producto Number(10),
       Cantidad NUMBER(10),
                   
       CONSTRAINT PK_pivot
       primary key (Id_pivot)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
); 

CREATE TABLE Usuario(
       cedula NUMBER(15)
              CONSTRAINT Usr_cedula_NN NOT NULL,
       contraseña Varchar2(35),
       tipo Varchar2(35),
       UserName Varchar2(35),            
       CONSTRAINT PK_usuario
       primary key (cedula)
       using index
       tablespace GE_IDX pctfree 20
       storage (initial 10k next 10k pctincrease 0)
)
TABLESPACE GE_TBL
STORAGE (INITIAL 6144
        NEXT 6144
        MINEXTENTS 1
        MAXEXTENTS 5
);
