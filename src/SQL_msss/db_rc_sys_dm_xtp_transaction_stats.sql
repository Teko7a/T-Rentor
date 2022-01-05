create view sys.dm_xtp_transaction_stats as
-- missing source code
go

INSERT INTO sys.dm_xtp_transaction_stats (total_count, read_only_count, total_aborts, system_aborts, validation_failures, dependencies_taken, dependencies_failed, savepoint_create, savepoint_rollbacks, savepoint_refreshes, log_bytes_written, log_IO_count, phantom_scans_started, phantom_scans_retries, phantom_rows_touched, phantom_rows_expiring, phantom_rows_expired, phantom_rows_expired_removed, scans_started, scans_retried, rows_returned, rows_touched, rows_expiring, rows_expired, rows_expired_removed, row_insert_attempts, row_update_attempts, row_delete_attempts, write_conflicts, unique_constraint_violations, drop_table_memory_attempts, drop_table_memory_failures) VALUES (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
