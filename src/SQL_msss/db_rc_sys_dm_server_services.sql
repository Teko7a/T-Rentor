create view sys.dm_server_services as
-- missing source code
go

INSERT INTO sys.dm_server_services (servicename, startup_type, startup_type_desc, status, status_desc, process_id, last_startup_time, service_account, filename, is_clustered, cluster_nodename, instant_file_initialization_enabled) VALUES (N'SQL Server (SQLEXPRESS)', 3, N'Manual', 4, N'Running', 8768, N'2022-01-05 08:55:47.0189015 +08:00', N'NT Service\MSSQL$SQLEXPRESS', N'"C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\Binn\sqlservr.exe" -sSQLEXPRESS', N'N', null, N'Y');
INSERT INTO sys.dm_server_services (servicename, startup_type, startup_type_desc, status, status_desc, process_id, last_startup_time, service_account, filename, is_clustered, cluster_nodename, instant_file_initialization_enabled) VALUES (N'SQL Server 代理 (SQLEXPRESS)', 4, N'Disabled', 1, N'Stopped', null, null, N'NT AUTHORITY\NETWORKSERVICE', N'"C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\Binn\SQLAGENT.EXE" -i SQLEXPRESS', N'N', null, N'N');
INSERT INTO sys.dm_server_services (servicename, startup_type, startup_type_desc, status, status_desc, process_id, last_startup_time, service_account, filename, is_clustered, cluster_nodename, instant_file_initialization_enabled) VALUES (N'SQL Full-text Filter Daemon Launcher (SQLEXPRESS)', 3, N'Manual', 4, N'Running', 14704, null, N'NT Service\MSSQLFDLauncher$SQLEXPRESS', N'"C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\Binn\fdlauncher.exe" -s MSSQL15.SQLEXPRESS', N'N', null, N'N');