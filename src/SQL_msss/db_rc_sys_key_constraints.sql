create view sys.key_constraints as
-- missing source code
go

grant select on sys.key_constraints to [public]
go

INSERT INTO sys.key_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, unique_index_id, is_system_named, is_enforced) VALUES (N'PK__t_usr__3213E83F67A1B7B9', 597577167, null, 1, 581577110, N'PK', N'PRIMARY_KEY_CONSTRAINT', N'2022-01-05 09:08:10.800', N'2022-01-05 09:08:10.800', 0, 0, 0, 1, 1, 1);
INSERT INTO sys.key_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, unique_index_id, is_system_named, is_enforced) VALUES (N'PK__t_car__3213E83F32068265', 917578307, null, 1, 901578250, N'PK', N'PRIMARY_KEY_CONSTRAINT', N'2022-01-05 09:17:12.857', N'2022-01-05 09:17:12.857', 0, 0, 0, 1, 1, 1);
INSERT INTO sys.key_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, unique_index_id, is_system_named, is_enforced) VALUES (N'PK__t_rented__3213E83FD2B202F6', 965578478, null, 1, 949578421, N'PK', N'PRIMARY_KEY_CONSTRAINT', N'2022-01-05 09:19:05.667', N'2022-01-05 09:19:05.667', 0, 0, 0, 1, 1, 1);
INSERT INTO sys.key_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, unique_index_id, is_system_named, is_enforced) VALUES (N'PK__t_mainta__3213E83FBF210321', 1029578706, null, 1, 1013578649, N'PK', N'PRIMARY_KEY_CONSTRAINT', N'2022-01-05 09:19:58.533', N'2022-01-05 09:19:58.533', 0, 0, 0, 1, 1, 1);
INSERT INTO sys.key_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, unique_index_id, is_system_named, is_enforced) VALUES (N'PK__t_admin__3213E83F410C283D', 1061578820, null, 1, 1045578763, N'PK', N'PRIMARY_KEY_CONSTRAINT', N'2022-01-05 09:20:31.250', N'2022-01-05 09:20:31.250', 0, 0, 0, 1, 1, 1);
