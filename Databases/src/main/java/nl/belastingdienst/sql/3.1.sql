use labs;

CREATE TABLE Orders(
    ordernr     int         not null,
    clientnr    varchar(6)  not null,
    orderdate   timestamp   not null);