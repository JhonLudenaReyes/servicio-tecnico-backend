select * from personas;
select * from personas as p, localidades as l where p.id_localidad = l.id_localidad and p.id_persona = 6;

select * from clientes;
select * from clientes as cli, personas as per where cli.id_persona = per.id_persona and cli.estado = "A";

/*QUERIES ROLES*/
select id_rol, rol from roles where estado = 'A';

/*Queries ROLES PERMISOS*/
SELECT * FROM roles as rol, roles_permisos as rol_perm, permisos as perm WHERE roles.id_rol = rol_perm.id_rol AND rol_perm.id_permiso = permisos.id_permiso AND permisos.estado = "A";

/*Queries permisos*/

select per.nombres, per.apellidos, usu.usuario, rol.rol, perm.permiso from personas as per, usuarios as usu, usuarios_roles as usu_rol, roles as rol, roles_permisos as rol_perm, permisos as perm where per.id_persona = usu.id_persona and usu.id_usuario = usu_rol.id_usuario and usu_rol.id_rol = rol.id_rol and rol.id_rol = rol_perm.id_rol and rol_perm.id_permiso = permisos.id_permiso and usu.usuario="ADMIN" and usu.contrasenia="ADMIN";

select * from personas as per, usuarios as usu where per.id_persona = usu.id_persona and usu.estado="A";