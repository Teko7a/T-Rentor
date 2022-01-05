create view sys.database_recovery_status as
-- missing source code
go

INSERT INTO sys.database_recovery_status (database_id, database_guid, family_guid, last_log_backup_lsn, recovery_fork_guid, first_recovery_fork_guid, fork_point_lsn) VALUES (1, N'234C3F4C-53AC-45F2-8329-615C2F5DDABA', N'0A962BE5-A1A2-432D-8CF6-B2F72A75F3B2', null, N'89B51B99-FCC8-4A24-AC6B-D1BDA81B4427', null, null);
INSERT INTO sys.database_recovery_status (database_id, database_guid, family_guid, last_log_backup_lsn, recovery_fork_guid, first_recovery_fork_guid, fork_point_lsn) VALUES (2, N'2C0A5351-AB60-11D2-896A-00C04FD9374A', N'7E11756E-ABE9-11D2-896A-00C04FD9374A', null, N'7E11756E-ABE9-11D2-896A-00C04FD9374A', null, null);
INSERT INTO sys.database_recovery_status (database_id, database_guid, family_guid, last_log_backup_lsn, recovery_fork_guid, first_recovery_fork_guid, fork_point_lsn) VALUES (3, N'EBD0FE66-F91F-43F1-99C3-B52D803BB136', N'EBD0FE66-F91F-43F1-99C3-B52D803BB136', null, N'90D16058-F1D1-4E96-8EC6-8D7BFDA42F15', null, null);
INSERT INTO sys.database_recovery_status (database_id, database_guid, family_guid, last_log_backup_lsn, recovery_fork_guid, first_recovery_fork_guid, fork_point_lsn) VALUES (4, N'9460B735-2296-4C4F-A38A-7BC6FF89CACD', N'2776CB1B-2746-4928-89FA-FFC10FB1C781', null, N'2776CB1B-2746-4928-89FA-FFC10FB1C781', null, null);
INSERT INTO sys.database_recovery_status (database_id, database_guid, family_guid, last_log_backup_lsn, recovery_fork_guid, first_recovery_fork_guid, fork_point_lsn) VALUES (5, N'223929BF-A291-43BF-9BA1-D5E9EFD41DD3', N'EBEAD52E-56D8-4B48-8FA0-9E173864094F', null, N'EBEAD52E-56D8-4B48-8FA0-9E173864094F', null, null);
