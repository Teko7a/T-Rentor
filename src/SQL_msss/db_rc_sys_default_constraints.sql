create view sys.default_constraints as
-- missing source code
go

grant select on sys.default_constraints to [public]
go

INSERT INTO sys.default_constraints (name, object_id, principal_id, schema_id, parent_object_id, type, type_desc, create_date, modify_date, is_ms_shipped, is_published, is_schema_published, parent_column_id, definition, is_system_named) VALUES (N'DF__t_car__isAuto__37A5467C', 933578364, null, 1, 901578250, N'D ', N'DEFAULT_CONSTRAINT', N'2022-01-05 09:17:12.857', N'2022-01-05 09:17:12.857', 0, 0, 0, 7, N'((1))', 1);
