create table sys.trace_xe_action_map
(
    trace_column_id smallint     not null,
    package_name    nvarchar(60) not null,
    xe_action_name  nvarchar(60) not null
)
go

INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (3, N'sqlserver', N'database_id');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (4, N'sqlserver', N'transaction_id');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (5, N'sqlserver', N'tsql_frame');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (6, N'sqlserver', N'nt_username');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (7, N'sqlserver', N'nt_username');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (8, N'sqlserver', N'client_hostname');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (9, N'sqlserver', N'client_pid');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (10, N'sqlserver', N'client_app_name');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (11, N'sqlserver', N'server_principal_name');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (12, N'sqlserver', N'session_id');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (26, N'sqlserver', N'server_instance_name');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (35, N'sqlserver', N'database_name');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (41, N'sqlserver', N'server_principal_sid');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (49, N'sqlserver', N'request_id');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (50, N'sqlserver', N'transaction_sequence');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (51, N'package0', N'event_sequence');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (60, N'sqlserver', N'is_system');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (61, N'sqlserver', N'tsql_frame');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (63, N'sqlserver', N'tsql_frame');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (64, N'sqlserver', N'session_server_principal_name');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (65, N'sqlserver', N'plan_handle');
INSERT INTO db_rc.sys.trace_xe_action_map (trace_column_id, package_name, xe_action_name) VALUES (66, N'sqlserver', N'session_resource_group_id');
