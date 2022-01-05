create view sys.database_role_members as
-- missing source code
go

grant select on sys.database_role_members to [public]
go

INSERT INTO sys.database_role_members (role_principal_id, member_principal_id) VALUES (16384, 1);
