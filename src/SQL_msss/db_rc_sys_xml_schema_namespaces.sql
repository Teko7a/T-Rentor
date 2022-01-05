create view sys.xml_schema_namespaces as
-- missing source code
go

grant select on sys.xml_schema_namespaces to [public]
go

INSERT INTO sys.xml_schema_namespaces (xml_collection_id, name, xml_namespace_id) VALUES (1, N'http://www.w3.org/2001/XMLSchema', 1);
INSERT INTO sys.xml_schema_namespaces (xml_collection_id, name, xml_namespace_id) VALUES (1, N'http://schemas.microsoft.com/sqlserver/2004/sqltypes', 2);
INSERT INTO sys.xml_schema_namespaces (xml_collection_id, name, xml_namespace_id) VALUES (1, N'http://www.w3.org/XML/1998/namespace', 3);
