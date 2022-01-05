create view sys.assemblies as
-- missing source code
go

grant select on sys.assemblies to [public]
go

INSERT INTO sys.assemblies (name, principal_id, assembly_id, clr_name, permission_set, permission_set_desc, is_visible, create_date, modify_date, is_user_defined) VALUES (N'Microsoft.SqlServer.Types', 4, 1, N'microsoft.sqlserver.types, version=15.0.0.0, culture=neutral, publickeytoken=89845dcd8080cc91, processorarchitecture=msil', 3, N'UNSAFE_ACCESS', 1, N'2019-09-24 14:19:54.240', N'2019-09-24 14:19:54.393', 0);
