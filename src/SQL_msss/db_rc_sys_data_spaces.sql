create view sys.data_spaces as
-- missing source code
go

grant select on sys.data_spaces to [public]
go

INSERT INTO sys.data_spaces (name, data_space_id, type, type_desc, is_default, is_system) VALUES (N'PRIMARY', 1, N'FG', N'ROWS_FILEGROUP', 1, 0);
