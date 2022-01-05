create view sys.sysfiles as
-- missing source code
go

grant select on sys.sysfiles to [public]
go

INSERT INTO sys.sysfiles (fileid, groupid, size, maxsize, growth, status, perf, name, filename) VALUES (1, 1, 1024, -1, 8192, 2, 0, N'db_rc', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc.mdf');
INSERT INTO sys.sysfiles (fileid, groupid, size, maxsize, growth, status, perf, name, filename) VALUES (2, 0, 1024, 268435456, 8192, 66, 0, N'db_rc_log', N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\db_rc_log.ldf');
