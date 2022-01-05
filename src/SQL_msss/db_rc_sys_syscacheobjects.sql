create view sys.syscacheobjects as
-- missing source code
go

INSERT INTO sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads, lastwrites, sqlbytes, sql) VALUES (86, N'Parse Tree', N'View', null, null, null, null, 1, 1, 4, null, null, null, null, 0, 0, 0, 0, 0, null, null);
INSERT INTO sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads, lastwrites, sqlbytes, sql) VALUES (526, N'Parse Tree', N'View', -245973352, 32767, 1, 4, 1, 2, 4, 251, 30, 3, 1024, 0, 0, 0, 0, 0, 278, N'CREATE FUNCTION sys.dm_exec_sql_text(@handle varbinary(64))
RETURNS TABLE
AS
	RETURN SELECT * FROM OPENROWSET(TABLE FNGETSQL, @handle)
');
INSERT INTO sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads, lastwrites, sqlbytes, sql) VALUES (1977, N'Parse Tree', N'View', null, null, null, null, 1, 1, 8, null, null, null, null, 0, 0, 0, 0, 0, null, null);
INSERT INTO sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads, lastwrites, sqlbytes, sql) VALUES (3373, N'Parse Tree', N'View', -193, 32767, 5, 4, 1, 2, 20, 251, 30, 3, 1024, 0, 0, 0, 0, 0, 2412, N'
CREATE VIEW sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, 
		usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads,
		lastwrites, sqlbytes, sql) AS
	SELECT 	pvt.bucketid, pvt.cacheobjtype, pvt.objtype, 
			CONVERT(int, pvt.objectid), CONVERT(smallint, pvt.dbid),
			CONVERT(smallint, pvt.dbid_execute), CONVERT(smallint, pvt.user_id),
			pvt.refcounts, pvt.usecounts, pvt.size_in_bytes / 8192,
			CONVERT(int, pvt.set_options), CONVERT(smallint, pvt.language_id),
			CONVERT(smallint, pvt.date_format), CONVERT(int, pvt.status),
			CONVERT(bigint, 0), CONVERT(bigint, 0), CONVERT(bigint, 0), CONVERT(bigint, 0), CONVERT(bigint, 0), 
			CONVERT(int, LEN(CONVERT(nvarchar(max), fgs.text)) * 2), CONVERT(nvarchar(3900), fgs.text)
	FROM (SELECT ecp.*, epa.attribute, epa.value
		FROM sys.dm_exec_cached_plans ecp OUTER APPLY sys.dm_exec_plan_attributes(ecp.plan_handle) epa) as ecpa
	PIVOT (MAX(ecpa.value) for ecpa.attribute IN ("set_options", "objectid", "dbid", "dbid_execute", "user_id", "language_id", "date_format", "status")) as pvt
	OUTER APPLY sys.dm_exec_sql_text(pvt.plan_handle) fgs
');
INSERT INTO sys.syscacheobjects (bucketid, cacheobjtype, objtype, objid, dbid, dbidexec, uid, refcounts, usecounts, pagesused, setopts, langid, dateformat, status, lasttime, maxexectime, avgexectime, lastreads, lastwrites, sqlbytes, sql) VALUES (16893, N'Compiled Plan', N'Adhoc', 461051091, 5, 0, -2, 2, 1, 39, 251, 30, 3, 1024, 0, 0, 0, 0, 0, 74, N'SELECT t.* FROM sys.syscacheobjects t');
