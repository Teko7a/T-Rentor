create view sys.schemas as
-- missing source code
go

grant select on sys.schemas to [public]
go

INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'dbo', 1, 1);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'guest', 2, 2);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'INFORMATION_SCHEMA', 3, 3);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'sys', 4, 4);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_owner', 16384, 16384);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_accessadmin', 16385, 16385);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_securityadmin', 16386, 16386);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_ddladmin', 16387, 16387);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_backupoperator', 16389, 16389);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_datareader', 16390, 16390);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_datawriter', 16391, 16391);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_denydatareader', 16392, 16392);
INSERT INTO sys.schemas (name, schema_id, principal_id) VALUES (N'db_denydatawriter', 16393, 16393);
