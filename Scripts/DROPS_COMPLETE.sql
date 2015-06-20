drop table bodega;
drop table categoria;
drop table control_de_venta;
drop table direccion;
drop table factura;
drop table historial_de_compras;
drop table inventario;
drop table marca;
drop table persona;
drop table producto;
drop table productoxfactura;
drop table puntodeventa;
drop table telefono;
drop table total_puntoventa;
drop table venta;
drop table pivot;

drop procedure "GESTOREMPRESARIAL"."ACTUALIZARFACTURA";
drop procedure "GESTOREMPRESARIAL"."ACTUALIZARINVENTARIO";
drop procedure "GESTOREMPRESARIAL"."INSERTARBODEGA";
drop procedure "GESTOREMPRESARIAL"."INSERTARPERSONA";
drop procedure "GESTOREMPRESARIAL"."INSERTARPIVOT";
drop procedure "GESTOREMPRESARIAL"."INSERTARPRODUCTO";
drop procedure "GESTOREMPRESARIAL"."INSERTARPRODUCTOXFACTURA";
drop procedure "GESTOREMPRESARIAL"."INSERTARPUNTODEVENTA";
drop procedure "GESTOREMPRESARIAL"."INSERTARVENTA";

drop function "GESTOREMPRESARIAL"."BUSCARBODEGA";
drop function "GESTOREMPRESARIAL"."INSERTARCATEGORIA";
drop function "GESTOREMPRESARIAL"."INSERTARDIRECCION";
drop function "GESTOREMPRESARIAL"."INSERTARFACTURA";
drop function "GESTOREMPRESARIAL"."INSERTARMARCA";
drop function "GESTOREMPRESARIAL"."INSERTARTELEFONO";
drop function "GESTOREMPRESARIAL"."RETORNAIDPERSONA";
drop function "GESTOREMPRESARIAL"."RETORNAIDPUNTODEVENTA";
drop function "GESTOREMPRESARIAL"."RETORNARIDPRODUCTO";
drop function "GESTOREMPRESARIAL"."RETORNARPRECIO";
drop function "GESTOREMPRESARIAL"."ULTIMO_ID_FACTURA";


drop sequence "GESTOREMPRESARIAL"."S_BODEGA";
drop sequence "GESTOREMPRESARIAL"."S_CATEGORIA";
drop sequence "GESTOREMPRESARIAL"."S_DIRECCION";
drop sequence "GESTOREMPRESARIAL"."S_FACTURA";
drop sequence "GESTOREMPRESARIAL"."S_HISTORIAL_DE_COMPRAS";
drop sequence "GESTOREMPRESARIAL"."S_MARCA";
drop sequence "GESTOREMPRESARIAL"."S_PIVOT";
drop sequence "GESTOREMPRESARIAL"."S_PRODUCTO";
drop sequence "GESTOREMPRESARIAL"."S_PUNTO_DE_VENTA";
drop sequence "GESTOREMPRESARIAL"."S_TELEFONO";
drop sequence "GESTOREMPRESARIAL"."S_VENTA";

