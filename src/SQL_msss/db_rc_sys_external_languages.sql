create view sys.external_languages as
-- missing source code
go

grant select on sys.external_languages to [public]
go

INSERT INTO sys.external_languages (external_language_id, language, create_date, principal_id) VALUES (1, N'R', N'2021-12-31 08:39:56.400', 4);
INSERT INTO sys.external_languages (external_language_id, language, create_date, principal_id) VALUES (2, N'Python', N'2021-12-31 08:39:56.400', 4);
