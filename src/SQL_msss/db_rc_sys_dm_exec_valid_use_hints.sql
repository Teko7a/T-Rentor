create view sys.dm_exec_valid_use_hints as
-- missing source code
go

INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_OPTIMIZED_NESTED_LOOP');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'FORCE_LEGACY_CARDINALITY_ESTIMATION');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'ENABLE_QUERY_OPTIMIZER_HOTFIXES');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_PARAMETER_SNIFFING');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'ASSUME_MIN_SELECTIVITY_FOR_FILTER_ESTIMATES');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'ASSUME_JOIN_PREDICATE_DEPENDS_ON_FILTERS');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'ENABLE_HIST_AMENDMENT_FOR_ASC_KEYS');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_OPTIMIZER_ROWGOAL');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'FORCE_DEFAULT_CARDINALITY_ESTIMATION');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISALLOW_BATCH_MODE');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_PLAN_PROFILE');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_INTERLEAVED_EXECUTION_TVF');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_BATCH_MODE_MEMORY_GRANT_FEEDBACK');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_BATCH_MODE_ADAPTIVE_JOINS');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_ROW_MODE_MEMORY_GRANT_FEEDBACK');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_DEFERRED_COMPILATION_TV');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'DISABLE_TSQL_SCALAR_UDF_INLINING');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_100');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_110');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_120');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_130');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_140');
INSERT INTO sys.dm_exec_valid_use_hints (name) VALUES (N'QUERY_OPTIMIZER_COMPATIBILITY_LEVEL_150');
