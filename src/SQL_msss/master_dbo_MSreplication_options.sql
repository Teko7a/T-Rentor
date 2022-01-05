create table MSreplication_options
(
    optname          sysname not null,
    value            bit     not null,
    major_version    int     not null,
    minor_version    int     not null,
    revision         int     not null,
    install_failures int     not null
)
go

INSERT INTO master.dbo.MSreplication_options (optname, value, major_version, minor_version, revision, install_failures) VALUES (N'transactional', 1, 90, 0, 0, 0);
INSERT INTO master.dbo.MSreplication_options (optname, value, major_version, minor_version, revision, install_failures) VALUES (N'merge', 1, 90, 0, 0, 0);
INSERT INTO master.dbo.MSreplication_options (optname, value, major_version, minor_version, revision, install_failures) VALUES (N'security_model', 1, 90, 0, 0, 0);
