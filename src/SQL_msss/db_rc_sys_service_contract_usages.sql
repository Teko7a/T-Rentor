create view sys.service_contract_usages as
-- missing source code
go

grant select on sys.service_contract_usages to [public]
go

INSERT INTO sys.service_contract_usages (service_id, service_contract_id) VALUES (3, 4);
INSERT INTO sys.service_contract_usages (service_id, service_contract_id) VALUES (3, 5);
