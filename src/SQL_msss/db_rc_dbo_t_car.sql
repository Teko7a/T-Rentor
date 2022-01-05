create table t_car
(
    id      int not null
        primary key,
    type    varchar(30),
    license varchar(10),
    brand   varchar(20),
    size    varchar(20),
    seatNum int,
    isAuto  int default 1,
    tons    varchar(20),
    color   varchar(20),
    cost    int,
    status  int
)
go

INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (3, N'经济型', N'川A87E3A', N'大众', N'途观L2015', 5, 1, N'2.0T', N'白色', 300, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (4, N'舒适型', N'川A6DD15', N'丰田', N'凯美瑞2018', 5, 1, N'1.8T', N'黑色', 300, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (5, N'SUV', N'川AAN116', N'宝马', N'X6', 5, 1, N'3.0T', N'红色', 500, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (6, N'商务型', N'川AC0967', N'别克', N'GLB', 5, 1, N'2.0T', N'白色', 700, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (8, N'电动型', N'川AAN116', N'特斯拉', N'MODEL3', 5, 1, N'2.0T', N'黑色', 400, 0);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (9, N'高端车', N'川AC0967', N'保时捷', N'卡宴', 5, 1, N'3.0T', N'红色', 800, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (10, N'SUV', N'冀N45AJ7', N'Bench', N'xxx', 5, 1, N'5.0T', N'灰色', 200, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (11, N'舒适型', N'晋T45A53', N'BMW', N'yy', 5, 0, N'5.0T', N'蓝色', 400, 1);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (12, N'电动型', N'沪Q478AQ', N'Ferrari', N'b', 5, 1, N'5.0T', N'白色', 700, 0);
INSERT INTO db_rc.dbo.t_car (id, type, license, brand, size, seatNum, isAuto, tons, color, cost, status) VALUES (13, N'高端车', N'新A45W45', N'Spyker', N'a', 5, 0, N'5.0T', N'白色', 1000, 1);
