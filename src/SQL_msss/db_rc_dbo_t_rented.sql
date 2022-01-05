create table t_rented
(
    id     int not null
        primary key,
    carID  int
        constraint t_rented_t_car_id_fk
            references t_car,
    usrID  int
        constraint t_rented_t_user_id_fk
            references t_usr,
    stDate varchar(20),
    edDate varchar(20),
    dates  int,
    cost   int
)
go

INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (15, 6, 1, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (16, 11, 1, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (17, 3, 1, N'21/09/05', N'22/01/04', -244, -73200);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (18, 11, 10, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (19, 9, 10, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (20, 9, 10, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (21, 5, 18, N'21/09/05', null, 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (22, 8, 13, N'21/09/05', null, 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (23, 11, 16, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (24, 12, 16, N'21/09/05', N'21/09/05', 0, 0);
INSERT INTO db_rc.dbo.t_rented (id, carID, usrID, stDate, edDate, dates, cost) VALUES (25, 12, 16, N'21/09/05', null, 0, 0);
