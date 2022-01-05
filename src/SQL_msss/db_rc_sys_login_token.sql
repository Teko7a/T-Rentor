create view sys.login_token as
-- missing source code
go

INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (259, 0x0105000000000005150000007B576CCBAA18D214AF69F9DDE9030000, N'NOBUG\ttnow', N'WINDOWS LOGIN', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (2, 0x02, N'public', N'SERVER ROLE', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (3, 0x03, N'sysadmin', N'SERVER ROLE', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (263, 0x01020000000000052000000021020000, N'BUILTIN\Users', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000100000000, N'\Everyone', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000572000000, N'NT AUTHORITY\本地帐户和管理员组成员', N'WINDOWS GROUP', N'DENY ONLY    ');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x01020000000000052000000020020000, N'BUILTIN\Administrators', N'WINDOWS GROUP', N'DENY ONLY    ');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (263, 0x01020000000000052000000021020000, N'BUILTIN\Users', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000504000000, N'NT AUTHORITY\INTERACTIVE', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000201000000, N'\CONSOLE LOGON', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x01010000000000050B000000, N'NT AUTHORITY\Authenticated Users', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x01010000000000050F000000, N'NT AUTHORITY\This Organization', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010B00000000000B600000008F88F9D7FCE30000B04900005BA8A69E4F2A395FEFDDCC2FA54126050EF44CE8A215D4EAE93D9160, N'MicrosoftAccount\ttnowokk@outlook.com', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000571000000, N'NT AUTHORITY\本地帐户', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x010100000000000200000000, N'\LOCAL', N'WINDOWS GROUP', N'GRANT OR DENY');
INSERT INTO sys.login_token (principal_id, sid, name, type, usage) VALUES (0, 0x01020000000000054000000024000000, N'NT AUTHORITY\云帐户身份验证', N'WINDOWS GROUP', N'GRANT OR DENY');
