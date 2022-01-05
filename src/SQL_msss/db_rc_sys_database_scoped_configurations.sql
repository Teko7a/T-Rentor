create view sys.database_scoped_configurations as
-- missing source code
go

grant select on sys.database_scoped_configurations to [public]
go

INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (1, N'MAXDOP', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (2, N'LEGACY_CARDINALITY_ESTIMATION', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (3, N'PARAMETER_SNIFFING', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (4, N'QUERY_OPTIMIZER_HOTFIXES', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (6, N'IDENTITY_CACHE', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (7, N'INTERLEAVED_EXECUTION_TVF', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (8, N'BATCH_MODE_MEMORY_GRANT_FEEDBACK', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (9, N'BATCH_MODE_ADAPTIVE_JOINS', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (10, N'TSQL_SCALAR_UDF_INLINING', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (11, N'ELEVATE_ONLINE', N'OFF', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (12, N'ELEVATE_RESUMABLE', N'OFF', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (13, N'OPTIMIZE_FOR_AD_HOC_WORKLOADS', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (14, N'XTP_PROCEDURE_EXECUTION_STATISTICS', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (15, N'XTP_QUERY_EXECUTION_STATISTICS', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (16, N'ROW_MODE_MEMORY_GRANT_FEEDBACK', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (17, N'ISOLATE_SECURITY_POLICY_CARDINALITY', N'0', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (18, N'BATCH_MODE_ON_ROWSTORE', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (19, N'DEFERRED_COMPILATION_TV', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (20, N'ACCELERATED_PLAN_FORCING', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (21, N'GLOBAL_TEMPORARY_TABLE_AUTO_DROP', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (22, N'LIGHTWEIGHT_QUERY_PROFILING', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (23, N'VERBOSE_TRUNCATION_WARNINGS', N'1', null, 1);
INSERT INTO sys.database_scoped_configurations (configuration_id, name, value, value_for_secondary, is_value_default) VALUES (24, N'LAST_QUERY_PLAN_STATS', N'0', null, 1);
