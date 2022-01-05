create view sys.master_files as
-- missing source code
go

INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (1, 1, null, 0, N'ROWS', 1, N'master', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\master.mdf', 0, N'ONLINE', 688, -1, 10, 0, 0, 0, 1, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (1, 2, null, 1, N'LOG', 0, N'mastlog', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\mastlog.ldf', 0, N'ONLINE', 256, -1, 10, 0, 0, 0, 1, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (2, 1, null, 0, N'ROWS', 1, N'tempdev', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\tempdb.mdf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (2, 2, null, 1, N'LOG', 0, N'templog', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\templog.ldf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (3, 1, null, 0, N'ROWS', 1, N'modeldev', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\model.mdf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (3, 2, null, 1, N'LOG', 0, N'modellog', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\modellog.ldf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (4, 1, N'1724388F-1111-4540-967D-B860C15B92EA', 0, N'ROWS', 1, N'MSDBData', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MSDBData.mdf', 0, N'ONLINE', 2080, -1, 10, 0, 0, 0, 1, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (4, 2, N'5400110E-42A7-479A-99E1-52DD70A61A23', 1, N'LOG', 0, N'MSDBLog', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\MSDBLog.ldf', 0, N'ONLINE', 648, 268435456, 10, 0, 0, 0, 1, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (5, 1, N'3C7ACFA9-A797-4122-A224-BC2BCECF5456', 0, N'ROWS', 1, N'db_rc', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc.mdf', 0, N'ONLINE', 1024, -1, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO sys.master_files (database_id, file_id, file_guid, type, type_desc, data_space_id, name, physical_name, state, state_desc, size, max_size, growth, is_media_read_only, is_read_only, is_sparse, is_percent_growth, is_name_reserved, is_persistent_log_buffer, create_lsn, drop_lsn, read_only_lsn, read_write_lsn, differential_base_lsn, differential_base_guid, differential_base_time, redo_start_lsn, redo_start_fork_guid, redo_target_lsn, redo_target_fork_guid, backup_lsn, credential_id) VALUES (5, 2, N'63689303-72A8-45B7-B03D-7FFBAC9E9369', 1, N'LOG', 0, N'db_rc_log', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc_log.ldf', 0, N'ONLINE', 1024, 268435456, 8192, 0, 0, 0, 0, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null);