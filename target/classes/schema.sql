create table cars(
     make varchar(30),
     model varchar(30),
     regNo varchar(10) primary key,
     year int,
     available varchar(10)
);

create table users(
    uid int AUTO_INCREMENT,
    username varchar(100),
    password varchar(100),

    constraint primary key (uid)
);

--
-- create table reservations(
--     id  foreign key references people(id),
--     regNo foreign key references cars(regNo)
-- );

alter carsdb
add url varchar(100);


insert into cars (make, model, regNo, year, available)
values ( 'Mercedes Benz', 'C43AMG', 'B420BAE', 2020, 'Y' ),
       ( 'Toyota', 'Camry', 'B123BAA', 2015, 'N' );

update cars
set url='./src/main/resources/images/audi-A3.jpg'
where regno = 'B189BNM';

update cars
set url='./src/main/resources/images/BMW-335i.jpg'
where regno = 'B678BUH';

update cars
set url='./src/main/resources/images/BMW-M3.jpg'
where regno = 'B289BEN';

update cars
set url='./src/main/resources/images/BMW-M6.png'
where regno = 'B289ANJ';

update cars
set url='./src/main/resources/images/BMW-Z3Coupe.jpg'
where regno = 'B289ANH';

update cars
set url='./src/main/resources/images/Chevrolet-Spark.jpg'
where regno = 'B289ANG';

update cars
set url='./src/main/resources/images/chrysler-voyager.jpg'
where regno = 'B189BNN';

update cars
set url='./src/main/resources/images/Ford-F-250.jpg'
where regno = 'B289BAM';

update cars
set url='./src/main/resources/images/Ford-Fiesta_.jpg'
where regno = 'B289BDN';

update cars
set url='./src/main/resources/images/ford-mustang.jpg'
where regno = 'B289BOL';

update cars
set url='./src/main/resources/images/ford-ranger.jpg'
where regno = 'B289BKL';

update cars
set url='./src/main/resources/images/Honda-Civic-Sedan.png'
where regno = 'B889BQA';

update cars
set url='./src/main/resources/images/honda-fit.jpg'
where regno = 'B107BAC';

update cars
set url='./src/main/resources/images/hyundai-accent.jpg'
where regno = 'B129ACD';

update cars
set url='./src/main/resources/images/jeep-cherokee.jpg'
where regno = 'B189BAD';

update cars
set url='./src/main/resources/images/Kia-Sportage.jpg'
where regno = 'B189BAB';

update cars
set url='./src/main/resources/images/land-rover-discovery.jpg'
where regno = 'B543BNW';

update cars
set url='./src/main/resources/images/lexus-is.jpg'
where regno = 'B189BAF';

update cars
set url='./src/main/resources/images/lexus-is-250-c.jpg'
where regno = 'B172BQW';

update cars
set url='./src/main/resources/images/mercedes-benz-c43amg.jpg'
where regno = 'B420BAE';

update cars
set url='./src/main/resources/images/mercedes-cla45.jpg'
where regno = 'B555ABC';

update cars
set url='./src/main/resources/images/Mercedes-G-Wagon.jpg'
where regno = 'B456BNW';

update cars
set url='./src/main/resources/images/nissan-pathfinder.jpg'
where regno = 'B289BVM';

update cars
set url='./src/main/resources/images/nissan-qashqai.jpg'
where regno = 'B289BTW';

update cars
set url='./src/main/resources/images/peugeot-407-sw.jpg'
where regno = 'B289BBM';

update cars
set url='./src/main/resources/images/renault-clio-grandtour.jpg'
where regno = 'B789BQA';

update cars
set url='./src/main/resources/images/rover-620.jpg'
where regno = 'B189BAG';

update cars
set url='./src/main/resources/images/suzuki-jimny.jpg'
where regno = 'B189BAG';

update cars
set url='./src/main/resources/images/toyota-camry.jpg'
where regno = 'B123BAA';

select * from  cars;