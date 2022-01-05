create view sys.filegroups as
-- missing source code
go

grant select on sys.filegroups to [public]
go

INSERT INTO sys.filegroups (name, data_space_id, type, type_desc, is_default, is_system, filegroup_guid, log_filegroup_id, is_read_only, is_autogrow_all_files) VALUES (N'PRIMARY', 1, N'FG', N'ROWS_FILEGROUP', 1, 0, null, null, 0, 0);
