create view sys.xml_schema_wildcards as
-- missing source code
go

grant select on sys.xml_schema_wildcards to [public]
go

INSERT INTO sys.xml_schema_wildcards (xml_component_id, xml_collection_id, xml_namespace_id, is_qualified, name, symbol_space, symbol_space_desc, kind, kind_desc, derivation, derivation_desc, base_xml_component_id, scoping_xml_component_id, process_content, process_content_desc, disallow_namespaces) VALUES (381, 1, 2, 0, null, N'N', N'NONE', N'W', N'ELEMENT_WILDCARD', N'N', N'NONE', null, 380, N'P', N'SKIP_VALIDATION', 1);
