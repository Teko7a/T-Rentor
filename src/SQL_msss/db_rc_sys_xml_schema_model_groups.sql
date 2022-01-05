create view sys.xml_schema_model_groups as
-- missing source code
go

grant select on sys.xml_schema_model_groups to [public]
go

INSERT INTO sys.xml_schema_model_groups (xml_component_id, xml_collection_id, xml_namespace_id, is_qualified, name, symbol_space, symbol_space_desc, kind, kind_desc, derivation, derivation_desc, base_xml_component_id, scoping_xml_component_id, compositor, compositor_desc) VALUES (380, 1, 2, 0, null, N'M', N'MODEL_GROUP', N'M', N'MODEL_GROUP', N'N', N'NONE', null, 329, N'S', N'XSD_SEQUENCE_GROUP');
