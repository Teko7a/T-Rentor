create view sys.assembly_types as
-- missing source code
go

grant select on sys.assembly_types to [public]
go

INSERT INTO sys.assembly_types (name, system_type_id, user_type_id, schema_id, principal_id, max_length, precision, scale, collation_name, is_nullable, is_user_defined, is_assembly_type, default_object_id, rule_object_id, assembly_id, assembly_class, is_binary_ordered, is_fixed_length, prog_id, assembly_qualified_name, is_table_type) VALUES (N'hierarchyid', 240, 128, 4, null, 892, 0, 0, null, 1, 0, 1, 0, 0, 1, N'Microsoft.SqlServer.Types.SqlHierarchyId', 1, 0, null, N'Microsoft.SqlServer.Types.SqlHierarchyId, Microsoft.SqlServer.Types, Version=11.0.0.0, Culture=neutral, PublicKeyToken=89845dcd8080cc91', 0);
INSERT INTO sys.assembly_types (name, system_type_id, user_type_id, schema_id, principal_id, max_length, precision, scale, collation_name, is_nullable, is_user_defined, is_assembly_type, default_object_id, rule_object_id, assembly_id, assembly_class, is_binary_ordered, is_fixed_length, prog_id, assembly_qualified_name, is_table_type) VALUES (N'geometry', 240, 129, 4, null, -1, 0, 0, null, 1, 0, 1, 0, 0, 1, N'Microsoft.SqlServer.Types.SqlGeometry', 0, 0, null, N'Microsoft.SqlServer.Types.SqlGeometry, Microsoft.SqlServer.Types, Version=11.0.0.0, Culture=neutral, PublicKeyToken=89845dcd8080cc91', 0);
INSERT INTO sys.assembly_types (name, system_type_id, user_type_id, schema_id, principal_id, max_length, precision, scale, collation_name, is_nullable, is_user_defined, is_assembly_type, default_object_id, rule_object_id, assembly_id, assembly_class, is_binary_ordered, is_fixed_length, prog_id, assembly_qualified_name, is_table_type) VALUES (N'geography', 240, 130, 4, null, -1, 0, 0, null, 1, 0, 1, 0, 0, 1, N'Microsoft.SqlServer.Types.SqlGeography', 0, 0, null, N'Microsoft.SqlServer.Types.SqlGeography, Microsoft.SqlServer.Types, Version=11.0.0.0, Culture=neutral, PublicKeyToken=89845dcd8080cc91', 0);
