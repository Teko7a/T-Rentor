create view sys.database_files as
-- missing source code
go

grant select on sys.database_files to [public]
go

INSERT INTO sys.database_files (file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn) VALUES (1, N'3C7ACFA9-A797-4122-A224-BC2BCECF5456', 0, N'ROWS', 1, N'db_rc', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc.mdf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.database_files (file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn) VALUES (2, N'63689303-72A8-45B7-B03D-7FFBAC9E9369', 1, N'LOG', 0, N'db_rc_log', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc_log.ldf', 0, N'ONLINE', 1024, 268435456, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null);
