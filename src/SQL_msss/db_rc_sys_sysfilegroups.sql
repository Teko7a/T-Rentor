create view sys.sysfilegroups as
-- missing source code
go

grant select on sys.sysfilegroups to [public]
go

INSERT INTO sys.sysfilegroups (groupid, allocpolicy, status, groupname) VALUES (1, 0, 16, N'PRIMARY');
