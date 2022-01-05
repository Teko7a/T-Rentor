create view sys.sysmembers as
-- missing source code
go

grant select on sys.sysmembers to [public]
go

INSERT INTO sys.sysmembers (memberuid, groupuid) VALUES (1, 16384);
