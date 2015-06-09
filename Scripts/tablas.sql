CREATE TABLE Inventario(
       Id_Producto NUMBER(8)
              CONSTRAINT INV_Id_producto_NN NOT NULL,
       Id_Proveedor NUMBER(8)
              CONSTRAINT INV_Id_proveedor_NN NOT NULL,
       Id_Bodega NUMBER(8)
              CONSTRAINT INV_Id_Bodega_NN NOT NULL,
       Nombre VARCHAR2(35),
       Descripcion VARCHAR2(100),
       Marca VARCHAR2(35),
       Categoria VARCHAR2(35),
       Cantidad NUMBER(8),
       Minimo NUMBER(8)
              CONSTRAINT INV_Minimo_NN Not Null,
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

Comment on table Inventario is 'tabla encargada del control de inventario de las bodegas';

--////////////////////////////////////////////////////////////////////////////

CREATE TABLE Historial(
       Id_Historial NUMBER(8)
              CONSTRAINT HIS_Id_Historial_NN NOT NULL,
       Id_Proveedor NUMBER(8)
              CONSTRAINT HIS_Id_proveedor_NN NOT NULL,
       Id_Producto NUMBER(8)
              CONSTRAINT HIS_Id_Producto_NN NOT NULL,
       Tipo_Transaccion VARCHAR2(35),
       Monto Number(10)
              CONSTRAINT HIS_Monto_NN Not Null,          

       CONSTRAINT PK_HISTORIAL
       primary key (Id_Historial)
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

Comment on table Historial is 'tabla encargada del control la entrada y salida de productos de las bodegas';

--//////////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Proveedor(
       Id_Proveedor NUMBER(8)
              CONSTRAINT PRO_Id_Proveedor_NN NOT NULL,
       Id_Telefono NUMBER(8)
              CONSTRAINT PRO_Id_Telefono_NN NOT NULL,
       Id_Direccion NUMBER(8)
              CONSTRAINT PRO_Id_Direccion_NN NOT NULL,
       Email VARCHAR2(35),
       Encargado VARCHAR2(35),
        
       CONSTRAINT PK_Proveedor
       primary key (Id_Proveedor)
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

Comment on table Proveedor is 'tabla encargada del registro de proveedores de la bodegas';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Bodega(
       Id_Bodega NUMBER(8)
              CONSTRAINT BOD_Id_Bodega_NN NOT NULL,
       Id_Direccion NUMBER(8)
              CONSTRAINT BOD_Id_Direccion_NN NOT NULL,
       Id_Telefono NUMBER(8)
              CONSTRAINT BOD_Id_Telefono_NN NOT NULL,
       Nombre VARCHAR2(35),
       Encargado VARCHAR2(35),
        
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

Comment on table Bodega is 'tabla encargada del registro de proveedores de la bodegas';

--///////////////////////////////////////////////////////////////////////////////////////////////
CREATE TABLE Telefono(
       Id_Telefono NUMBER(8)
              CONSTRAINT TEL_Id_TELEFONO_NN NOT NULL,
       Numero_Tel Varchar2(30)
              CONSTRAINT TEL_Numero_Tel_NN NOT NULL,

       CONSTRAINT PK_Telefono
       primary key (Id_Telefono)
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

Comment on table Telefono is 'tabla normalizada para el almacenamiento de los numeros telefonicos de la aplicacion';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Direccion(
       Id_Direccion NUMBER(8)
              CONSTRAINT DIR_Id_Direccion_NN NOT NULL,
       Pais VARCHAR2(35),
       Provincia VARCHAR2(35),
       Canton VARCHAR2(35),
       Direccion_Exacta VARCHAR2(35),
        
       CONSTRAINT PK_Direccion
       primary key (Id_Direccion)
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

Comment on table Direccion is 'tabla normalizada para el almacenamiento de las direcciones';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Cliente(
       Id_Cliente NUMBER(8)
              CONSTRAINT CLI_Id_Cliente_NN NOT NULL,
       Id_Direccion NUMBER(8)
              CONSTRAINT CLI_Id_Direccion_NN NOT NULL,
       Id_telefono NUMBER(8)
              CONSTRAINT CLI_Id_Telefono_NN NOT NULL,
       Nombre VARCHAR2(35),
 
       CONSTRAINT PK_Cliente
       primary key (Id_Cliente)
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

Comment on table Cliente is 'tabla normalizada para el almacenamiento de las direcciones';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Punto_venta(
       Id_Punto_Venta NUMBER(8)
              CONSTRAINT PV_Id_Punto_Venta_NN NOT NULL,
       Id_Direccion NUMBER(8)
              CONSTRAINT PV_Id_Direccion_NN NOT NULL,
       Id_Telefono NUMBER(8)
              CONSTRAINT PV_Id_Telefono_NN NOT NULL,
       Gerente VARCHAR2(35),
        
       CONSTRAINT PK_Punto_Venta
       primary key (Id_Punto_Venta)
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

Comment on table Bodega is 'tabla encargada del almacenamiento de los diferentes puntos de venta';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Control_Venta(
       Id_Control NUMBER(8)
              CONSTRAINT CTR_Id_Control_NN NOT NULL,
       Id_Factura NUMBER(8)
              CONSTRAINT CTR_Id_Factura_NN NOT NULL,
       Id_Punto_Venta NUMBER(8)
              CONSTRAINT CTR_Id_Punto_Venta_NN NOT NULL,
       Total Number(12),
        
       CONSTRAINT PK_Control_Venta
       primary key (Id_Control)
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

Comment on table Control_Venta is 'tabla encargada del registro de actividad de los puntos de venta';

--///////////////////////////////////////////////////////////////////////////////////////////////

CREATE TABLE Factura(
       Id_Factura NUMBER(8)
              CONSTRAINT FAC_Id_Factura_NN NOT NULL,
       Id_Producto NUMBER(8)
              CONSTRAINT FAC_Id_Producto_NN NOT NULL,
       Id_Punto_Venta NUMBER(8)
              CONSTRAINT FAC_Punto_Venta_NN NOT NULL,
       Cantidad Number(10),
       Fecha date,
       Descuento VARCHAR2(35),

        
       CONSTRAINT PK_Factura
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

Comment on table Factura is 'control de facturas emitidas';

--///////////////////////////////////////////////////////////////////////////////////////////////

