create view sys.external_language_files as
-- missing source code
go

grant select on sys.external_language_files to [public]
go

INSERT INTO sys.external_language_files (external_language_id, content, file_name, platform, platform_desc, parameters, environment_variables) VALUES (1, null, N'RLauncher.dll', 1, N'WINDOWS', null, null);
INSERT INTO sys.external_language_files (external_language_id, content, file_name, platform, platform_desc, parameters, environment_variables) VALUES (1, null, N'RLauncher.so', 2, N'LINUX', null, null);
INSERT INTO sys.external_language_files (external_language_id, content, file_name, platform, platform_desc, parameters, environment_variables) VALUES (2, null, N'PythonLauncher.dll', 1, N'WINDOWS', null, null);
INSERT INTO sys.external_language_files (external_language_id, content, file_name, platform, platform_desc, parameters, environment_variables) VALUES (2, null, N'PythonLauncher.so', 2, N'LINUX', null, null);
